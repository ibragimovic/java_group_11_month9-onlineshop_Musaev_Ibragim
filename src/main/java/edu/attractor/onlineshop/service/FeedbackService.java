package edu.attractor.onlineshop.service;

import edu.attractor.onlineshop.dto.FeedBackDTO;
import edu.attractor.onlineshop.entity.Customer;
import edu.attractor.onlineshop.entity.Feedback;
import edu.attractor.onlineshop.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final CustomerService customerService;

    public void addFeedback(FeedBackDTO feedBackDTO) {
        Customer customer = customerService.getByEmailCustomer(feedBackDTO.getEmail());
        Feedback feedback = Feedback.builder()
                .feedback(feedBackDTO.getFeedback())
                .customer(customer)
                .build();
        feedbackRepository.save(feedback);
    }

    public Page<FeedBackDTO> showAllFeedback(Pageable pageable) {
        return feedbackRepository.findAll(pageable)
                .map(FeedBackDTO::from);
    }

}
