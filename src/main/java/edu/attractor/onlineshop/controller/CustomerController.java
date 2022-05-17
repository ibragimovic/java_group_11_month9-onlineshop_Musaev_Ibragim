package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.dto.CustomerRegisterForm;
import edu.attractor.onlineshop.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import java.security.Principal;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal) {
        var customer = customerService.getByEmail(principal.getName());
        model.addAttribute("dto", customer);
        return "profile";
    }

    @GetMapping("/register")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new CustomerRegisterForm());
        }
        return "register";
    }

    /*
     @RequestMapping(value = "/accounts", method = RequestMethod.POST)
   public String handle(Account account, BindingResult result, RedirectAttributes redirectAttrs) {
     if (result.hasErrors()) {
       return "accounts/new";
     }
     // Save account ...
     redirectAttrs.addAttribute("id", account.getId()).addFlashAttribute("message", "Account created!");
     return "redirect:/accounts/{id}";
   }

     */

    @PostMapping("/register")
    public String registerPage(@Valid CustomerRegisterForm customerRegisterDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", customerRegisterDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "register";
        }

        customerService.register(customerRegisterDto);
        return "redirect:/profile";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @ExceptionHandler(BindException.class)
    private ResponseEntity<Object> handleBindExceptionResponseEntity(BindException ex) {
        var apiFieldErrors = ex.getFieldErrors()
                .stream()
                .map(fe -> String.format("%s -> %s", fe.getField(), fe.getDefaultMessage()))
                .collect(toList());
        return ResponseEntity.unprocessableEntity()
                .body(apiFieldErrors);
    }

}
