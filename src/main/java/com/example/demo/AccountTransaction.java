package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AccountTransaction")
@IdClass(value = CustomerIdentity.class)
public class AccountTransaction {

    @Id
    @NotNull
    private int transactionNo;
    @Id
    @NotBlank
    private String accountId;
    private String transactionDate;
    @NotNull
    private int transactionAmount;
    @NotBlank
    private String transactionType;
    private float accountBalance;
    private int payeeId;
    private int loanId;

    public AccountTransaction() {
        super();
    }

    public AccountTransaction(int transactionNo, String accountId, String transactionDate, int transactionAmount, String transactionType, float accountBalance, int loanId, int payeeId) {
        super();
        this.transactionNo = transactionNo;
        this.accountId = accountId;
        this.loanId = loanId;
        this.payeeId = payeeId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.accountBalance = accountBalance;
    }

    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
}