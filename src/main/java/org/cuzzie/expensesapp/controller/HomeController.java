package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.model.Transaction;
import org.cuzzie.expensesapp.model.UserBuilder;
import org.cuzzie.expensesapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by Cuzzie on 6/16/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private TransactionService transactionService;

    @ModelAttribute("recentTransactions")
    public List<Transaction> recentTransactions() {
        List<Transaction> recentTransactions = transactionService.findTop10Transactions();
        return recentTransactions;
    }

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
