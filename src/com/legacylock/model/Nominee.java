package com.legacylock.model;

public class Nominee extends User {

    public Nominee(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "Nominee";
    }
}