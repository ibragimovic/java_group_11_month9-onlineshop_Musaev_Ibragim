package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final OrderService orderService;

    @PostMapping("/cart/delete")
    public String deleteFromCart(@RequestParam("type") String type,
                                 @RequestParam("name") String name,
                                 Authentication authentication,
                                 HttpSession session) {
        orderService.deleteFromCart(type, name, authentication, session);
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
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constant.CART_ID);
        return "cart";
    }

}
