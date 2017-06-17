package org.cuzzie.expensesapp.repository;

import org.cuzzie.expensesapp.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Cuzzie on 6/18/2017.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
