package com.legacylock.model;

import java.util.ArrayList;
import java.util.List;

public class VaultOwner extends User {

    private List<Vault> vaults;

    public VaultOwner(String username, String password) {
        super(username, password);
        vaults = new ArrayList<>();
    }

    public void addVault(Vault vault) {
        vaults.add(vault);
    }

    public List<Vault> getVaults() {
        return vaults;
    }

    @Override
    public String getRole() {
        return "VaultOwner";
    }
}