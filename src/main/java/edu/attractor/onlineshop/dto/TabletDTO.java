package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Tablet;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class TabletDTO {
    private Long id;
    private String name;
    private String image;
    private Integer quantity;
    private String description;
    private Float price;

    public static TabletDTO from(Tablet tablet) {
        return builder()
                .id(tablet.getId())
                .name(tablet.getName())
                .image(tablet.getImage())
                .quantity(tablet.getQuantity())
                .description(tablet.getDescription())
                .price(tablet.getPrice())
                .build();
    }
}
