package org.cuzzie.expensesapp.service;

import org.cuzzie.expensesapp.model.Transaction;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
public interface TransactionService {

    List<Transaction> findAllTransactions();

    Transaction findTransactionById(int transactionId);

    List<Transaction> findByUserIdAndDateBetweenOrderByDateDesc(int userId, Date startDate, Date endDate);

    List<Transaction> filterTransactionsByMonth(String filterDateStr) throws ParseException;

    List<Transaction> filterIncomeByMonth(String filterDateStr) throws ParseException;

    List<Transaction> filterExpensesByMonth(String filterDateStr) throws ParseException;

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(int transactionId);
}
