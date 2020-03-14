package com.example.demo;


import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CustomerIdentity implements Serializable {

    private int transactionNo;
        private String accountId;

    public CustomerIdentity() {
        }

    public CustomerIdentity(int transactionNo, String accountId) {
            this.transactionNo = transactionNo;
            this.accountId = accountId;
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
}
