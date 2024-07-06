package com.webapp.BaronBoost;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {


    @GetMapping("/email-verification/{code}")
    public String emailVerification(@PathVariable(name = "code") String code, Model model) {
        model.addAttribute("message", "Email verification successful!");
        return "email-verification";
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Baron Boost API";
    }

}
