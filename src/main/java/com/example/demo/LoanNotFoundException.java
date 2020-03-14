package com.example.demo;

public class LoanNotFoundException extends Exception {
    private int id;

    public LoanNotFoundException(int id) {
        super(String.format("Loan not found: %s", id));
    }
}
