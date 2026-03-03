package com.legacylock.main;

import com.legacylock.model.*;
import com.legacylock.manager.VaultManager;

public class MainApp {

    public static void main(String[] args) {

        VaultManager manager = new VaultManager();

        VaultOwner owner = new VaultOwner("Alice", "pass123");
        Nominee nominee = new Nominee("Bob", "nominee123");

        Vault vault = new Vault("FamilyVault", nominee);

        VaultItem item = new VaultItem("SecretDoc", "Document", "Confidential Data");
        vault.addItem(item);

        owner.addVault(vault);

        manager.registerOwner(owner);

        System.out.println("Owner: " + owner.getUsername());
        System.out.println("Vault: " + vault.getVaultName());
        System.out.println("Nominee: " + nominee.getUsername());
        System.out.println("Items: " + vault.getItems());
    }
}