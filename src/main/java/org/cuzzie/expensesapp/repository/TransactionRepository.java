package org.cuzzie.expensesapp.repository;

import org.cuzzie.expensesapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    List<Transaction> findTop10OrderByDateDesc();

}
