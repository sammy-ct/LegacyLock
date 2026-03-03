package com.legacylock.manager;

import com.legacylock.model.VaultOwner;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VaultManager {

   
    private List<VaultOwner> owners;

    public VaultManager() {
        owners = new CopyOnWriteArrayList<>();
    }

    public void registerOwner(VaultOwner owner) {
        owners.add(owner);
        System.out.println("VaultOwner registered.");
    }

    public VaultOwner findOwner(String username) {
        for (VaultOwner owner : owners) {
            if (owner.getUsername().equals(username)) {
                return owner;
            }
        }
        return null;
    }

    public List<VaultOwner> getAllOwners() {
        return owners;
    }
}