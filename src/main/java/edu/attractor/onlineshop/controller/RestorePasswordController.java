package edu.attractor.onlineshop.controller;

import edu.attractor.onlineshop.service.RestorePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class RestorePasswordController {
    private final RestorePasswordService restorePasswordService;

    @GetMapping("/restore-password")
    public String getIndex(){
        return "restore_password";
    }

    @PostMapping("/restore-password")
    public String getNewPair(Model model, @RequestParam(name = "email") String email){
        String newPassword = restorePasswordService.restorePassword(email);
        model.addAttribute("identity", newPassword);
        // processing errors

        return "login-restore";
    }

    @PostMapping("/restore-password/new-password")
    public String showFormNewPassword(@RequestParam(name = "hash") String hash, HttpServletRequest req){
        restorePasswordService.updatePassword(req, hash);
        return "redirect:/";
    }

}
