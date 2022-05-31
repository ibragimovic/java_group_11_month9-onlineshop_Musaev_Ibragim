package edu.attractor.onlineshop.dto;

import edu.attractor.onlineshop.entity.Feedback;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class FeedBackDTO {
    @NotBlank
    @Size(min = 1, max = 255)
    private String feedback;

    @NotBlank
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public static FeedBackDTO from (Feedback feedback) {
        return FeedBackDTO.builder()
                .feedback(feedback.getFeedback())
                .email(feedback.getCustomer().getEmail())
                .build();
    }
}
