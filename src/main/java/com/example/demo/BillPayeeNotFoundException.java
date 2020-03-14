package com.example.demo;

public class BillPayeeNotFoundException extends Exception {
    private int id;

    public BillPayeeNotFoundException(int id) {
        super(String.format("Bill Payee not found: %s", id));
    }
}
