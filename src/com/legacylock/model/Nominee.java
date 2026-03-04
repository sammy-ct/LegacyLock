package com.legacylock.model;

public class Nominee {

    private String name;
    private String email;

    public Nominee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {   
        return name;
    }

    public String getEmail() {
        return email;
    }
}