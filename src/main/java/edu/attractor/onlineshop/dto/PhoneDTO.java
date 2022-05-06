package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Phone;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PhoneDTO {
    private Integer id;
    private String name;
    private String image;
    private Integer quantity;
    private String description;
    private Integer price;

    public static PhoneDTO from(Phone phone) {
        return builder()
                .id(phone.getId())
                .name(phone.getName())
                .image(phone.getImage())
                .quantity(phone.getQuantity())
                .description(phone.getDescription())
                .price(phone.getPrice())
                .build();
    }
}
