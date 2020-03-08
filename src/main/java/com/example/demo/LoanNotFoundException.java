package com.example.demo;

public class LoanNotFoundException extends Exception {
    private String id;

    public LoanNotFoundException(String id) {
        super(String.format("Loan not found: %s", id));
    }
}
