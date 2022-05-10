package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Customer;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class CustomerDTO {
    private Long id;
    private String email;
    private String fullName;

    public static CustomerDTO from(Customer customer) {
        return builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .fullName(customer.getFullName())
                .build();
    }
}
