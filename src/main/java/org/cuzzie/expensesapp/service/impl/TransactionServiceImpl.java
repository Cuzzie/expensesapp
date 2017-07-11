package org.cuzzie.expensesapp.service.impl;

import org.cuzzie.expensesapp.model.Transaction;
import org.cuzzie.expensesapp.repository.TransactionRepository;
import org.cuzzie.expensesapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public Transaction findTransactionById(int transactionId) {
        return transactionRepository.findOne(transactionId);
    }

    @Override
    public List<Transaction> findTop10Transactions() {
        return transactionRepository.findTop10OrderByDateDesc();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(int transactionId) {
        transactionRepository.delete(transactionId);
    }
}
