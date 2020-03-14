package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UserAccount")
public class UserAccount {

    @Id
    private String accountId;
    @NotBlank
    private int userId;


    public UserAccount() {
        super();
    }

    public UserAccount(int userId, String accountId) {
        super();
        this.accountId = accountId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
