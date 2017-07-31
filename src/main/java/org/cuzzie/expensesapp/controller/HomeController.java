package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.Constant;
import org.cuzzie.expensesapp.model.Transaction;
import org.cuzzie.expensesapp.model.TransactionBuilder;
import org.cuzzie.expensesapp.model.UserBuilder;
import org.cuzzie.expensesapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cuzzie on 6/16/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private TransactionService transactionService;

    @ModelAttribute("recentTransactions")
    public List<Transaction> recentTransactions() {
        List<Transaction> recentTransactions = transactionService.findTop10ByOrderByDateDesc();
        return recentTransactions;
    }

    @ModelAttribute("recentIncome")
    public List<Transaction> recentIncome() {
        List<Transaction> recentIncome = transactionService.findTop10ByCategoryTypeOrderByDateDesc(Constant.CategoryType.INCOME.getValue());
        return recentIncome;
    }

    @ModelAttribute("recentExpenses")
    public List<Transaction> recentExpenses() {
        List<Transaction> recentExpenses = transactionService.findTop10ByCategoryTypeOrderByDateDesc(Constant.CategoryType.EXPENSE.getValue());
        return recentExpenses;
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

    @GetMapping("/addnewincome")
    public String addNewIncome(Model model) {
        model.addAttribute("isAddNewIncome", true);
        model.addAttribute("transaction", new TransactionBuilder().createTransaction());
        return "addnewtransaction";
    }

    @PostMapping("/addnewincome")
    public String addNewIncome(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addnewtransaction";
        }
        transactionService.saveTransaction(transaction);
        return "redirect:/?success_add=true";
    }

    @GetMapping("/addnewexpense")
    public String addNewExpense(Model model) {
        model.addAttribute("isAddNewIncome", false);
        model.addAttribute("transaction", new TransactionBuilder().createTransaction());
        return "addnewtransaction";
    }

    @PostMapping("/addnewexpense")
    public String addNewExpense(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addnewtransaction";
        }
        transactionService.saveTransaction(transaction);
        return "redirect:/?success_add=true";
    }

}
