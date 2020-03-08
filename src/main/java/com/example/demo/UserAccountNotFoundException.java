package com.example.demo;

public class UserAccountNotFoundException extends Exception {
    private String id;

    public UserAccountNotFoundException(String id) {
        super(String.format("User Account not found: %s", id));
    }
}
