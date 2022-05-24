package edu.attractor.onlineshop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128, name = "gadget_name")
    private String gadgetName;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128, name = "gadget_type")
    private String gadgetType;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
