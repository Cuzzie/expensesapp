package org.cuzzie.expensesapp.service.impl;

import org.cuzzie.expensesapp.Constant;
import org.cuzzie.expensesapp.model.Transaction;
import org.cuzzie.expensesapp.repository.TransactionRepository;
import org.cuzzie.expensesapp.service.TransactionService;
import org.cuzzie.expensesapp.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Transaction> findByUserIdAndDateBetweenOrderByDateDesc(int userId, Date startDate, Date endDate) {
        return transactionRepository.findByUserIdAndDateBetweenOrderByDateDesc(userId, startDate, endDate);
    }

    @Override
    public List<Transaction> filterTransactionsByMonth(String filterDateStr) throws ParseException {
        Date filterStartDate, filterEndDate;
        if (!StringUtils.isEmpty(filterDateStr)) {
            filterStartDate = AppUtil.getStartOfMonth(filterDateStr);
            filterEndDate = AppUtil.getEndOfMonth(filterDateStr);
        } else {
            filterStartDate = AppUtil.getCurrentStartOfMonth();
            filterEndDate = AppUtil.getCurrentEndOfMonth();
        }
        return findByUserIdAndDateBetweenOrderByDateDesc(AppUtil.getCurrentUserId(), filterStartDate, filterEndDate);
    }

    @Override
    public List<Transaction> filterIncomeByMonth(String filterDateStr) throws ParseException {
        List<Transaction> transactions = filterTransactionsByMonth(filterDateStr);
        return transactions.stream()
                .filter(tx -> Constant.CategoryType.INCOME.getValue().equals(tx.getCategory().getType()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> filterExpensesByMonth(String filterDateStr) throws ParseException {
        List<Transaction> transactions = filterTransactionsByMonth(filterDateStr);
        return transactions.stream()
                .filter(tx -> Constant.CategoryType.EXPENSE.getValue().equals(tx.getCategory().getType()))
                .collect(Collectors.toList());
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
