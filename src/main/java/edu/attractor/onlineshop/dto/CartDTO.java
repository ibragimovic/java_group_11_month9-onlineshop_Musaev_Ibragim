package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Cart;
import edu.attractor.onlineshop.entity.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CartDTO {
    private Long id;
    private Customer customer;

    public static CartDTO from (Cart cart) {
        return builder()
                .id(cart.getId())
                .customer(cart.getCustomer())
                .build();
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }
}
