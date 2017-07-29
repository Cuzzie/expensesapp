package org.cuzzie.expensesapp.service.impl;

import org.cuzzie.expensesapp.Constant;
import org.cuzzie.expensesapp.model.Category;
import org.cuzzie.expensesapp.repository.CategoryRepository;
import org.cuzzie.expensesapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllIncomeCategories() {
        return categoryRepository.findByType(Constant.CategoryType.INCOME.getValue());
    }

    @Override
    public List<Category> findAllExpenseCategories() {
        return categoryRepository.findByType(Constant.CategoryType.EXPENSE.getValue());
    }

    @Override
    public Category findCategoryById(int categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.delete(categoryId);
    }
}
