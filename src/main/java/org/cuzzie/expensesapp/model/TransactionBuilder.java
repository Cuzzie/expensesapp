package org.cuzzie.expensesapp.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionBuilder {
    private int id;
    private String createdBy;
    private Date createdDt;
    private String updatedBy;
    private Date updatedDt;
    private Category category;
    private BigDecimal amount;
    private Date date;
    private String description;

    public TransactionBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TransactionBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public TransactionBuilder setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
        return this;
    }

    public TransactionBuilder setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public TransactionBuilder setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
        return this;
    }

    public TransactionBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    public TransactionBuilder setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public TransactionBuilder setDate(Date date) {
        this.date = date;
        return this;
    }

    public TransactionBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transaction createTransaction() {
        return new Transaction(category, amount, date, description);
    }
}