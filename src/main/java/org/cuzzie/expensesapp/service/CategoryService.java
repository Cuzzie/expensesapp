package org.cuzzie.expensesapp.service;

import org.cuzzie.expensesapp.model.Category;

import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
public interface CategoryService {

    List<Category> findAllCategories();

    Category findCategoryById(int categoryId);

    void saveCategory(Category category);

    void deleteCategory(int categoryId);
}
