package org.cuzzie.expensesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cuzzie on 6/14/2017.
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @GetMapping("/user")
    public String getUser() {
        return "createuser";
    }

}
