package com.example.demo;

public class BillPayeeNotFoundException extends Exception {
    private String id;

    public BillPayeeNotFoundException(String id) {
        super(String.format("Bill Payee not found: %s", id));
    }
}
