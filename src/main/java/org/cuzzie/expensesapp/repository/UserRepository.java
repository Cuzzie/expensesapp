package org.cuzzie.expensesapp.repository;

import org.cuzzie.expensesapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Cuzzie on 6/15/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
