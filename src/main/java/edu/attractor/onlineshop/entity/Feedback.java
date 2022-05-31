package edu.attractor.onlineshop.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feedback")
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "feedback")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Feedback(Customer customer) {
        this.customer = customer;
    }
}
