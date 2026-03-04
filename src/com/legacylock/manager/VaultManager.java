package com.legacylock.manager;

import java.util.ArrayList;
import java.util.List;
import com.legacylock.model.Vault;

public class VaultManager {

    private List<Vault> vaults;

    public VaultManager() {
        vaults = new ArrayList<>();
    }

    public void addVault(Vault vault) {
        vaults.add(vault);
    }

    public List<Vault> getVaults() {
        return vaults;
    }
}