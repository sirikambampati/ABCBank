package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    private String loanId;
    @NotBlank
    private String userId;
    @NotBlank
    private String accountId;
    @NotBlank
    private String loanType;
    @NotBlank
    private String loanAmount;
    @NotBlank
    private String loanStatus;
    @NotBlank
    private String loanTerm;
    private String loanOpenDate;

    public Loan() {
        super();
    }

    public Loan(String loanId, String userId, String accountId, String loanType, String loanAmount, String loanStatus, String loanTerm, String loanOpenDate) {
        super();
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.accountId = accountId;
        this.userId = userId;
        this.loanOpenDate = loanOpenDate;
        this.loanStatus = loanStatus;
        this.loanTerm = loanTerm;
        this.loanType = loanType;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanOpenDate() {
        return loanOpenDate;
    }

    public void setLoanOpenDate(String loanOpenDate) {
        this.loanOpenDate = loanOpenDate;
    }
}
