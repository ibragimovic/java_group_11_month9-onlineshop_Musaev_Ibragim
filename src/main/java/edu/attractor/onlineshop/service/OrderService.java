package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.controller.Constant;
import edu.attractor.onlineshop.dto.OrderDTO;
import edu.attractor.onlineshop.entity.Cart;
import edu.attractor.onlineshop.entity.Order;
import edu.attractor.onlineshop.exception.ResourceNotFoundException;
import edu.attractor.onlineshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final PhoneService phoneService;
    private final LaptopService laptopService;
    private final TabletService tabletService;


    public void makeAnOrder(Model model, Authentication authentication, HttpSession session) {
        var cart = cartService.findCartByCustomerEmail(authentication.getName());
        List<Order> orders = orderRepository.findByCartId(cart.getId())
                .orElseThrow(() -> new ResourceNotFoundException("cart", cart.getId()));
        model.addAttribute("totalPrice", countTotalPrice(orders));
        orders.forEach(orderRepository::delete);

        session.setAttribute(Constant.CART_ID, new ArrayList<String>());
    }

    private Float countTotalPrice(List<Order> orders) {
        var totalPrice = orders.stream()
                .mapToDouble(this::findPriceFromOrder)
                .sum();
        return (float) totalPrice;
    }

    private Float findPriceFromOrder(Order order) {
        switch (order.getGadgetType()) {
            case "PHONE": return phoneService.getPhoneDTOByName(order.getGadgetName()).getPrice();
            case "LAPTOP": return laptopService.getLaptopDTOByName(order.getGadgetName()).getPrice();
            case "TABLET": return tabletService.getTabletDTOByName(order.getGadgetName()).getPrice();
        }
        return 0F;
    }

    public void addToCart(String type, String name, HttpSession session, Authentication authentication) {
        String customerEmail = authentication.getName();
        if (session != null) {
            var attr = session.getAttribute(Constant.CART_ID);
            if (attr == null) {
                session.setAttribute(Constant.CART_ID, new ArrayList<String>());
            }
            if (!cartService.isCustomerHasCart(customerEmail)) {
                cartService.createNewCart(customerEmail);
            }
            try {
                var orders = (ArrayList<String>)session.getAttribute(Constant.CART_ID);
                orders.add(name);
                saveOrder(customerEmail, type, name);
            } catch (ClassCastException ignored) {
            }
        }
    }

    public void deleteFromCart(String name, Authentication authentication, HttpSession session) {
        var cart = cartService.findCartByCustomerEmail(authentication.getName());
        List<Order> orders = orderRepository.findByCartId(cart.getId())
                .orElseThrow(() -> new ResourceNotFoundException("cart", cart.getId()));
        var order = orders.stream()
                .filter(v -> v.getGadgetName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("order", name));
        orderRepository.delete(order);
        if (session != null) {session.setAttribute(Constant.CART_ID,
                orderRepository.findByCartId(cart.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("cart", cart.getId()))
                        .stream().map(Order::getGadgetName)
                        .collect(Collectors.toList()));
        }
    }

    public void deleteAllFromCart(Authentication authentication, HttpSession session) {
        var cart = cartService.findCartByCustomerEmail(authentication.getName());
        var orders = orderRepository.findByCartId(cart.getId())
                .orElseThrow(() -> new ResourceNotFoundException("orders", cart.getId()));
        orders.forEach(orderRepository::delete);

        session.setAttribute(Constant.CART_ID, new ArrayList<String>());
    }

    public void saveOrder(String customerEmail, String type, String name) {
        Cart cart = cartService.findCartByCustomerEmail(customerEmail);
        Order order = Order.builder()
                .gadgetType(type)
                .gadgetName(name)
                .cart(cart)
                .build();
        orderRepository.save(order);
    }

    public Page<OrderDTO> getOrdersByCartId(Long cartId, Pageable pageable) {
        return orderRepository.getByCartId(cartId, pageable)
                .map(OrderDTO::from);
    }

    public boolean isCartHasOrdersByCartId(Long cartId) {
        return orderRepository.existsByCartId(cartId);
    }


}
