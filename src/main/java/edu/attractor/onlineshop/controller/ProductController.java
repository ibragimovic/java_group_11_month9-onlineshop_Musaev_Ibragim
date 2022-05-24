package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.entity.Cart;
import edu.attractor.onlineshop.service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class ProductController {
    private final LaptopService laptopService;
    private final PhoneService phoneService;
    private final TabletService tabletService;
    private final CartService cartService;
    private final OrderService orderService;

    private final PropertiesService propertiesService;

    @GetMapping
    public String products(Model model) {
        model.addAttribute("images", "images");
        return "products";
    }

    @GetMapping("/laptops")
    public String getLaptops(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var uri = uriBuilder.getRequestURI();
        var laptops = laptopService.showVarietyOfLaptops(pageable);
        constructPageable(laptops, propertiesService.getDefaultPageSize(), model, uri);
        return "gadgets";
    }

    @GetMapping("/tablets")
    public String getTablets(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var uri = uriBuilder.getRequestURI();
        var tablets = tabletService.showVarietyOfTablets(pageable);
        constructPageable(tablets, propertiesService.getDefaultPageSize(), model, uri);
        return "gadgets";
    }

    @GetMapping("/phones")
    public String getPhones(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var uri = uriBuilder.getRequestURI();
        var phones = phoneService.showVarietyOfPhones(pageable);
        constructPageable(phones, propertiesService.getDefaultPageSize(), model, uri);
        return "gadgets";
    }

    @GetMapping("/cart")
    public String cart(Model model,
                       @SessionAttribute(name = Constant.CART_ID, required = false) List<String> cart,
                       Authentication authentication,
                       Pageable pageable,
                       HttpServletRequest uriBuilder) {
        if (cart != null) {
            model.addAttribute("cartItems", cart);

        }
        Cart cartFromDB = cartService.findCartByCustomerEmail(authentication.getName());
        if (orderService.isCartHasOrdersByCartId(cartFromDB.getId())) {
            var cartsItems = orderService.getOrdersByCartId(cartFromDB.getId(), pageable);
            var uri = uriBuilder.getRequestURI();
            constructPageable(cartsItems, propertiesService.getDefaultPageSize(), model, uri);
        }

        return "cart";
    }

    private static  <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink",
                    constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("PrevPageLink",
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
