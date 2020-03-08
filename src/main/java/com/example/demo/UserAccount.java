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
    private String userId;


    public UserAccount() {
        super();
    }

    public UserAccount(String userId, String accountId) {
        super();
        this.accountId = accountId;
        this.userId = userId;
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
}
