package org.cuzzie.expensesapp.controller;

import org.cuzzie.expensesapp.model.Category;
import org.cuzzie.expensesapp.model.CategoryBuilder;
import org.cuzzie.expensesapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model) {
        List<Category> allCategories = categoryService.findAllCategories();
        model.addAttribute("allCategories", allCategories);
        return "categories";
    }

    @GetMapping("/addnewcategory")
    public String addNewCategory(Model model) {
        model.addAttribute("category", new CategoryBuilder().createCategory());
        return "addnewcategory";
    }

    @PostMapping("/addnewcategory")
    public String addNewCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addnewcategory";
        }
        categoryService.saveCategory(category);
        return "redirect:/admin/categories?success_add=true";
    }

    @GetMapping("/editcategory/{categoryId}")
    public String editCategory(@PathVariable int categoryId, Model model) {
        Category category = categoryService.findCategoryById(categoryId);
        model.addAttribute("category", category);
        return "editcategory";
    }

    @PostMapping("/editcategory")
    public String editCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editcategory";
        }
        categoryService.saveCategory(category);
        return "redirect:/admin/categories?success_update=true";
    }

    @PostMapping("/deletecategory/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/admin/categories?success_delete=true";
    }

}
