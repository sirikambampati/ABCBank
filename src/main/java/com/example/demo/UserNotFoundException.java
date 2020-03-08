package com.example.demo;

public class UserNotFoundException extends Exception {
    private int id;

    public UserNotFoundException(String id) {
        super(String.format("User not found: %s", id));
    }
}

