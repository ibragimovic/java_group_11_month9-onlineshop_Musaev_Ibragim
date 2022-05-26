package edu.attractor.onlineshop.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDTO {
    private String address;
    private String phone;
    private String price;

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPrice() {
        return price;
    }
}
