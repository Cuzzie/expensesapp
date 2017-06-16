package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.model.User;
import org.cuzzie.expensesapp.model.UserBuilder;
import org.cuzzie.expensesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/addnewuser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new UserBuilder().createUser());
        return "addnewuser";
    }

    @PostMapping("/addnewuser")
    public String addNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addnewuser";
        }
        userService.createUser(user);
        return "redirect:/admin/users?success_add=true";
    }

    @PostMapping("/deleteuser/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/users?success_delete=true";
    }

}
