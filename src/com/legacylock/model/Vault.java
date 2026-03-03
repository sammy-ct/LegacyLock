package com.legacylock.model;

import java.util.ArrayList;
import java.util.List;

public class Vault {

    private String vaultName;
    private List<VaultItem> items;
    private Nominee nominee;

    public Vault(String vaultName, Nominee nominee) {
        this.vaultName = vaultName;
        this.nominee = nominee;
        this.items = new ArrayList<>();
    }

    public void addItem(VaultItem item) {
        items.add(item);
    }

    public String getVaultName() {
        return vaultName;
    }

    public List<VaultItem> getItems() {
        return items;
    }

    public Nominee getNominee() {
        return nominee;
    }
}