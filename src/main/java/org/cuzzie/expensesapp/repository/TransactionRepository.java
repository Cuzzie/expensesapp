package org.cuzzie.expensesapp.repository;

import org.cuzzie.expensesapp.model.Transaction;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    List<Transaction> findByUserIdAndDateBetweenOrderByDateDesc(int userId, @Temporal(TemporalType.DATE) Date startDate, @Temporal(TemporalType.DATE) Date endDate);

}
