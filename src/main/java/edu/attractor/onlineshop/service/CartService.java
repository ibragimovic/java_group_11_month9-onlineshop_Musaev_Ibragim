package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.CartDTO;
import edu.attractor.onlineshop.dto.OrderDTO;
import edu.attractor.onlineshop.entity.Cart;
import edu.attractor.onlineshop.entity.Customer;
import edu.attractor.onlineshop.entity.Order;
import edu.attractor.onlineshop.exception.ResourceNotFoundException;
import edu.attractor.onlineshop.repository.CartRepository;
import edu.attractor.onlineshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final PhoneService phoneService;
    private final LaptopService laptopService;
    private final TabletService tabletService;
    private final CustomerService customerService;

    public Order updateCart(String customerEmail, String type, String name) {
        Cart cart = findCartByCustomerEmail(customerEmail);
        Order order = Order.builder()
                .gadgetType(type)
                .gadgetName(name)
                .cart(cart)
                .build();
        orderRepository.save(order);
        return order;
    }

    public Cart findCartByCustomerEmail(String customerEmail) {
        Customer customer = customerService.getByEmailCustomer(customerEmail);
        return cartRepository.findByCustomerId(customer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("cart by customer email", customerEmail));
    }

    public List<Order> findOrdersByCartId(Long cartId) {
        return orderRepository.findByCartId(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("orders by cart ID", cartId));
    }

    public void createNewCart(String customerEmail) {
        cartRepository.save(new Cart(customerService.getByEmailCustomer(customerEmail)));
    }

    public boolean isCustomerHasCart(String customerEmail) {
        return cartRepository.existsByCustomerId(
                customerService.getByEmailCustomer(customerEmail).getId()
        );
    }

    public void deleteCart(Long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new ResourceNotFoundException("cart", cartId);
        }
        cartRepository.deleteById(cartId);
    }

    private static Cart convertCartDTOToCart (CartDTO cartDTO) {
        return Cart.builder()
                .id(cartDTO.getId())
                .customer(cartDTO.getCustomer())
                .build();
    }

    private static Order convertOrderDTOToOrder (OrderDTO orderDTO) {
        return Order.builder()
                .id(orderDTO.getId())
                .gadgetName(orderDTO.getGadgetName())
                .gadgetType(orderDTO.getGadgetType())
                .build();
    }

    private Integer countGadgetQuantityFromDataBase(OrderDTO orderDTO) {
        switch (orderDTO.getGadgetType()) {
            case "PHONE": return phoneService.getPhoneDTOByName(orderDTO.getGadgetName()).getQuantity();
            case "LAPTOP": return laptopService.getLaptopDTOByName(orderDTO.getGadgetName()).getQuantity();
            case "TABLET": return tabletService.getTabletDTOByName(orderDTO.getGadgetName()).getQuantity();
        }
        return 0;
    }

}
