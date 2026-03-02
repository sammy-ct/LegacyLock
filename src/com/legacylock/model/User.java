package com.legacylock.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<VaultItem> vaultItems;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.vaultItems = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<VaultItem> getVaultItems() { return vaultItems; }

    public void addItem(VaultItem item) { vaultItems.add(item); }
    public void removeItem(VaultItem item) { vaultItems.remove(item); }
}