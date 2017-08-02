package org.cuzzie.expensesapp.service.impl;

import org.cuzzie.expensesapp.model.Transaction;
import org.cuzzie.expensesapp.repository.TransactionRepository;
import org.cuzzie.expensesapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Cuzzie on 6/18/2017.
 */
@Service("transactionService")
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
    public List<Transaction> findTop10ByOrderByDateDesc() {
        return transactionRepository.findTop10ByOrderByDateDesc();
    }

    @Override
    public List<Transaction> findTop10ByCategoryTypeOrderByDateDesc(String type) {
        return transactionRepository.findTop10ByCategoryTypeOrderByDateDesc(type);
    }

    @Override
    public List<Transaction> findByDateBetweenOrderByDateDesc(Date startDate, Date endDate) {
        return transactionRepository.findByDateBetweenOrderByDateDesc(startDate, endDate);
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
