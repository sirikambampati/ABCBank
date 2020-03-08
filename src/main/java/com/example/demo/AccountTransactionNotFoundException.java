package com.example.demo;

public class AccountTransactionNotFoundException extends Exception {
    private int id;

    public AccountTransactionNotFoundException(int id) {
        super(String.format("Transaction not found: %s", id));
    }
}
