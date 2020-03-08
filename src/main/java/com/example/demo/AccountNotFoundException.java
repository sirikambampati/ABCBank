package com.example.demo;

public class AccountNotFoundException extends Exception {
    private String id;
    public AccountNotFoundException(String id) {
        super(String.format("Account not found: %s", id));
    }
}
