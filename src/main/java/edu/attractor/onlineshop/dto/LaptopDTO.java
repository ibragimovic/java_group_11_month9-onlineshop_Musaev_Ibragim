package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Laptop;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class LaptopDTO {
    private Integer id;
    private String name;
    private String image;
    private Integer quantity;
    private String description;
    private Integer price;

    public static LaptopDTO from(Laptop laptop) {
        return builder()
                .id(laptop.getId())
                .name(laptop.getName())
                .image(laptop.getImage())
                .quantity(laptop.getQuantity())
                .description(laptop.getDescription())
                .price(laptop.getPrice())
                .build();
    }
}
