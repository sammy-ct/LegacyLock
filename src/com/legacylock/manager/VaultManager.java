package com.legacylock.manager;

import com.legacylock.model.User;
import com.legacylock.model.VaultOwner;
import com.legacylock.exception.AuthenticationException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VaultManager {

    private List<User> users;

    public VaultManager() {
        users = new CopyOnWriteArrayList<>();
    }

    public void registerUser(User user) {

        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                System.out.println("Username already exists.");
                return;
            }
        }

        users.add(user);
        System.out.println("User registered successfully.");
    }

    public User login(String username, String password) throws AuthenticationException {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.authenticate(password)) {
                    return user;
                } else {
                    throw new AuthenticationException("Invalid password.");
                }
            }
        }

        throw new AuthenticationException("User not found.");
    }

    public List<User> getAllUsers() {
        return users;
    }
}