package edu.attractor.onlineshop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tablets")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tablet {
    @Id
    @Column
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;
}