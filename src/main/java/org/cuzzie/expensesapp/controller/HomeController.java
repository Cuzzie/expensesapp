package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.model.UserBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Cuzzie on 6/16/2017.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("isRegister");
        model.addAttribute("user", new UserBuilder().createUser());
        return "addnewuser";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
