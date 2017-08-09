package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.model.User;
import org.cuzzie.expensesapp.model.UserBuilder;
import org.cuzzie.expensesapp.service.UserService;
import org.cuzzie.expensesapp.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Cuzzie on 6/14/2017.
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute("allCountries")
    public List<String> allCountries() {
        String[] countryCodes = Locale.getISOCountries();
        List<String> allCountries = Arrays.stream(countryCodes)
                .map(countryCode -> new Locale("", countryCode))
                .map(Locale::getDisplayCountry)
                .sorted()
                .collect(Collectors.toList());
        return allCountries;
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "admin/users";
    }

    @GetMapping("/addnewuser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new UserBuilder().createUser());
        return "addnewuser";
    }

    @PostMapping("/addnewuser")
    public String addNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error(AppUtil.compileError(bindingResult));
            return "addnewuser";
        }
        userService.saveUser(user);
        return "redirect:/admin/users?success_add=true";
    }

    @GetMapping("/edituser/{userId}")
    public String editUser(@PathVariable int userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "admin/edituser";
    }

    @PostMapping("/edituser")
    public String editUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error(AppUtil.compileError(bindingResult));
            return "admin/edituser";
        }
        userService.saveUser(user);
        return "redirect:/admin/users?success_update=true";
    }

    @PostMapping("/deleteuser/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/users?success_delete=true";
    }

}
