package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.Constant;
import org.cuzzie.expensesapp.model.Transaction;
import org.cuzzie.expensesapp.model.TransactionBuilder;
import org.cuzzie.expensesapp.service.TransactionService;
import org.cuzzie.expensesapp.util.AppUtil;
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
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class TransactionController {

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

    @GetMapping("/filtermonth/{filterdate}")
    public String filterMonth(Model model, @PathVariable("filterdate") String filterDateStr) {
        filterTransactionsByDate(model, filterDateStr);
        return "fragments/overviewbody :: overviewList";
    }

    private void filterTransactionsByDate(Model model, String filterDateStr) {
        try {
            Date filterStartDate, filterEndDate;
            if (!StringUtils.isEmpty(filterDateStr)) {
                filterStartDate = AppUtil.getStartOfMonth(filterDateStr);
                filterEndDate = AppUtil.getEndOfMonth(filterDateStr);
            } else {
                filterStartDate = AppUtil.getCurrentStartOfMonth();
                filterEndDate = AppUtil.getCurrentEndOfMonth();
            }
            List<Transaction> filteredTransactions = transactionService.findByDateBetweenOrderByDateDesc(filterStartDate, filterEndDate);
            model.addAttribute("allTransactions", filteredTransactions);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }

}
