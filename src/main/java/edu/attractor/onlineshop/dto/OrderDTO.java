package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Cart;
import edu.attractor.onlineshop.entity.Order;
import lombok.*;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {
    private Long id;
    private String gadgetName;
    private String gadgetType;

    public static OrderDTO from (Order order) {
        return builder()
                .id(order.getId())
                .gadgetName(order.getGadgetName())
                .gadgetType(order.getGadgetType())
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getGadgetName() {
        return gadgetName;
    }

    public String getGadgetType() {
        return gadgetType;
    }

}
