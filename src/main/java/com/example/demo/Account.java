package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    private String accountId;
    @NotBlank
    private String accountName;
    @NotBlank
    private String accountAddress;
    @NotBlank
    private String emailId;
    @NotBlank
    private String mobileNumber;
    @NotBlank
    private String accountType;
    @NotBlank
    private String accountStatus;
    private String dateOpen;
    private String dateClosed;

    public Account() {
        super();
    }

    public Account(String accountId, String accountName, String accountAddress, String emailId, String mobileNumber, String accountType, String accountStatus, String dateOpen, String dateClosed) {
        super();
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountAddress = accountAddress;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.dateOpen = dateOpen;
        this.dateClosed = dateClosed;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }
}
