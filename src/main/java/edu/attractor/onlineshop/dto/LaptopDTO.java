package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Laptop;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class LaptopDTO {
    private Long id;
    private String name;
    private String image;
    private Integer quantity;
    private String description;
    private Float price;
    private String gadgetType;

    public static LaptopDTO from(Laptop laptop) {
        return builder()
                .id(laptop.getId())
                .name(laptop.getName())
                .image(laptop.getImage())
                .quantity(laptop.getQuantity())
                .description(laptop.getDescription())
                .price(laptop.getPrice())
                .gadgetType((GadgetType.LAPTOP).toString())
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public String getGadgetType() {
        return gadgetType;
    }
}
