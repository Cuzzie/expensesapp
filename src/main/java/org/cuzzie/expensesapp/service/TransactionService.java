package org.cuzzie.expensesapp.service;

import org.cuzzie.expensesapp.model.Transaction;

import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
public interface TransactionService {

    List<Transaction> findAllTransactions();

    Transaction findTransactionById(int transactionId);

    List<Transaction> findTop10ByOrderByDateDesc();

    List<Transaction> findTop10ByCategoryTypeOrderByDateDesc(String type);

    void saveTransaction(Transaction transaction);

    void deleteTransaction(int transactionId);
}
