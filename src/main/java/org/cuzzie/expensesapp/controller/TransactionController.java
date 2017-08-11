package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.Constant;
import org.cuzzie.expensesapp.model.Transaction;
import org.cuzzie.expensesapp.model.TransactionBuilder;
import org.cuzzie.expensesapp.service.TransactionService;
import org.cuzzie.expensesapp.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TransactionController {

    private final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/addnewincome")
    public String addNewIncome(Model model) {
        model.addAttribute("isAddNewIncome", true);
        model.addAttribute("transaction", new TransactionBuilder().createTransaction());
        return "addnewtransaction";
    }

    @PostMapping("/addnewincome")
    public String addNewIncome(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error(AppUtil.compileError(bindingResult));
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
            logger.error(AppUtil.compileError(bindingResult));
            return "addnewtransaction";
        }
        transactionService.saveTransaction(transaction);
        return "redirect:/?success_add=true";
    }

    @GetMapping("/filtermonth/{filterdate}")
    public String filterMonth(Model model, @PathVariable("filterdate") String filterDateStr) {
        try {
            List<Transaction> filteredTransactions = transactionService.filterTransactionsByMonth(filterDateStr);
            model.addAttribute("filteredTransactions", filteredTransactions);
            List<Transaction> filteredIncome = transactionService.filterIncomeByMonth(filterDateStr);
            model.addAttribute("filteredIncome", filteredIncome);
            List<Transaction> filteredExpenses = transactionService.filterExpensesByMonth(filterDateStr);
            model.addAttribute("filteredExpenses", filteredExpenses);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return "fragments/overviewbody :: overviewList";
    }

}
