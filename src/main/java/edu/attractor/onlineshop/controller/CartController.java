package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.service.CartService;
import edu.attractor.onlineshop.service.CustomerService;
import edu.attractor.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final OrderService orderService;

//    TODO show cart's contain
//    TODO cart's contain view
//    TODO delete gadget from the cart
//    TODO add possibility to change some gadget's quantity

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam String type,
                            @RequestParam String name,
                            HttpSession session,
                            Authentication authentication) {
        String customerEmail = authentication.getName();

        if (session != null) {
            var attr = session.getAttribute(Constant.CART_ID);

            if (attr == null) {
                session.setAttribute(Constant.CART_ID, new ArrayList<String>());
            }
            if (!cartService.isCustomerHasCart(customerEmail)) {
                cartService.createNewCart(customerEmail);
            }

            try {
                var orders = (ArrayList<String>)session.getAttribute(Constant.CART_ID);
                orders.add(name);
                orderService.saveOrder(customerEmail, type, name);

            } catch (ClassCastException ignored) {

            }
        }
        return "redirect:/";
    }

    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constant.CART_ID);
        return "cart";
    }

}
