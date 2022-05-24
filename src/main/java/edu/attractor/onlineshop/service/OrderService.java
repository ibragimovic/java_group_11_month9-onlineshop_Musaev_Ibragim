package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.OrderDTO;
import edu.attractor.onlineshop.entity.Cart;
import edu.attractor.onlineshop.entity.Order;
import edu.attractor.onlineshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;



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
