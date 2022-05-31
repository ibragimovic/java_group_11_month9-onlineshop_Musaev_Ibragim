package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.dto.FeedBackDTO;
import edu.attractor.onlineshop.service.FeedbackService;
import edu.attractor.onlineshop.service.PropertiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final PropertiesService propertiesService;


    @PostMapping("/feedback")
    public String addFeedBack(@RequestParam("email") String email,
                              @RequestParam("feedback") String feedback){
        FeedBackDTO feedBackDTO = FeedBackDTO.builder()
                .feedback(feedback)
                .email(email)
                .build();
        feedbackService.addFeedback(feedBackDTO);
        return "redirect:/";
    }

    @GetMapping("/feedback")
    public String getPhones(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var uri = uriBuilder.getRequestURI();
        var feedbacks = feedbackService.showAllFeedback(pageable);
        constructPageable(feedbacks, propertiesService.getDefaultPageSize(), model, uri);
        return "feedback";
    }

    private static  <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink",
                    constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink",
                    constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("item", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }
}
