package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.service.PropertiesService;
import edu.attractor.onlineshop.service.LaptopService;
import edu.attractor.onlineshop.service.PhoneService;
import edu.attractor.onlineshop.service.TabletService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {
    private final LaptopService laptopService;
    private final PhoneService phoneService;
    private final TabletService tabletService;

    private final PropertiesService propertiesService;

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

//    @GetMapping
//    public String index(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
//        var laptops = laptopService.showVarietyOfLaptops(pageable).getBody().getContent();
//        var uri = uriBuilder.getRequestURI();
//        constructPageable(laptops, propertiesService.getDefaultPageSize(), model, uri);
//
//        return "index";
//    }
}
