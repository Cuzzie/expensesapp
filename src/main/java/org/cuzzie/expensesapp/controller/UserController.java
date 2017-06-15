package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.model.User;
import org.cuzzie.expensesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Cuzzie on 6/14/2017.
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }

    @GetMapping("/createuser")
    public String createUser() {
        return "createuser";
    }

}
