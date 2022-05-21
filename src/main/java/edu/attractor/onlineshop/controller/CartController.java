package edu.attractor.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(Model model, @SessionAttribute(name = Constant.CART_ID, required = false)List<String> cart) {
        if (cart != null) {
            model.addAttribute("cartItems", cart);
        }
        return "cart";
    }

    @PostMapping("/cart")
    @ResponseBody
    public boolean addToListRest(@RequestParam String value, @SessionAttribute(name = Constant.CART_ID, required = false) List<String> cart) {
        if (cart != null) {
            cart.add(value);
        }
        return true;
    }

    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constant.CART_ID);
        return "cart";
    }

}
