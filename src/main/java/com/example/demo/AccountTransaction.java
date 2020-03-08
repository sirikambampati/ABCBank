package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "AccountTransaction")
public class AccountTransaction{

    @Id
    private int transactionNo;
    @NotBlank
    private String accountId;
    private String transactionDate;
    @NotBlank
    private String transactionAmount;
    @NotBlank
    private String transactionType;
    @NotBlank
    private String accountBalance;
    private String payeeId;
    private String loanId;
    @NotBlank



    public AccountTransaction() {
        super();
    }

    public AccountTransaction(int transactionNo,String accountId, String transactionDate, String transactionType, String loanId, String payeeId) {
        super();
        this.accountId = accountId;
        this.transactionNo = transactionNo;
        this.loanId = loanId;
        this.payeeId = payeeId;
        this.transactionAmount = transactionDate;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
}
