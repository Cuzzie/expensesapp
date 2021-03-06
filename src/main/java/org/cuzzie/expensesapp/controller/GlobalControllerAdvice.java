package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.model.Category;
import org.cuzzie.expensesapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("allCategories")
    public List<Category> allCategories() {
        List<Category> allCategories = categoryService.findAllCategories();
        return allCategories;
    }

    @ModelAttribute("allIncomeCategories")
    public List<Category> allIncomeCategories() {
        List<Category> allIncomeCategories = categoryService.findAllIncomeCategories();
        return allIncomeCategories;
    }

    @ModelAttribute("allExpenseCategories")
    public List<Category> allExpenseCategories() {
        List<Category> allExpenseCategories = categoryService.findAllExpenseCategories();
        return allExpenseCategories;
    }

}
