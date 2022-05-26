package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.dto.ContactDTO;
import edu.attractor.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final OrderService orderService;

    @PostMapping("/cart/delete")
    public String deleteFromCart(@RequestParam("name") String name,
                                 Authentication authentication,
                                 HttpSession session) {
        orderService.deleteFromCart(name, authentication, session);
        return "redirect:/";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam String type,
                            @RequestParam String name,
                            HttpSession session,
                            Authentication authentication) {
        orderService.addToCart(type, name, session, authentication);
        return "redirect:/";
    }

    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session, Authentication authentication) {
        orderService.deleteAllFromCart(authentication, session);
        return "redirect:/";
    }

    @PostMapping("/cart/make-order")
    public String makeOrder(Model model, HttpSession session, Authentication authentication) {
        orderService.makeAnOrder(model, authentication, session);
        return "making_order";
    }

    @PostMapping("/cart/order-success")
    public String confirmOrder(@RequestParam("price") String price,
                               @RequestParam("address") String address,
                               @RequestParam("phone") String phone,
                               Model model) {
        ContactDTO contactDTO = ContactDTO.builder()
                .address(address)
                .price(price)
                .phone(phone)
                .build();
        model.addAttribute("contact", contactDTO);
        return "order_success";
    }
}
