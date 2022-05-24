package edu.attractor.onlineshop.exception;

import edu.attractor.onlineshop.controller.Constant;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class CartAdvice {

    @ModelAttribute(Constant.CART_ID)
    public List<String> getCartModel(HttpSession session) {
        var list = session.getAttribute(Constant.CART_ID);
        if (list == null) {
            session.setAttribute(Constant.CART_ID, new ArrayList<>());
        }
        return Stream.of(session.getAttribute(Constant.CART_ID)).map(Object::toString).collect(Collectors.toList());
    }
}
