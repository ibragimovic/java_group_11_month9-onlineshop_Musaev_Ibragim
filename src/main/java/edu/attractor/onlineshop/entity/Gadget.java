package edu.attractor.onlineshop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class Gadget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128, name = "name")
    private String name;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128, name = "image")
    private String image;

    @Column(name = "quantity")
    private Integer quantity;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128, name = "description")
    private String description;

    @Positive
    @Column(name = "price")
    private Float price;
}
