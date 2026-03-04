package com.legacylock.model;

import java.util.ArrayList;
import java.util.List;
import com.legacylock.strategy.ReleaseCondition;

public class Vault {

    private String vaultName;
    private Nominee nominee;
    private List<VaultItem> items;   // ✅ FIXED
    private ReleaseCondition releaseCondition;

    public Vault(String vaultName, Nominee nominee, ReleaseCondition releaseCondition) {
        this.vaultName = vaultName;
        this.nominee = nominee;
        this.items = new ArrayList<>();
        this.releaseCondition = releaseCondition;
    }

    public String getVaultName() {
        return vaultName;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public List<VaultItem> getItems() {   
        return items;
    }

    public void addItem(VaultItem item) {   
        items.add(item);
    }

    public ReleaseCondition getReleaseCondition() {
        return releaseCondition;
    }

    public boolean checkRelease() {
        if (releaseCondition != null) {
            return releaseCondition.shouldRelease();
        }
        return false;
    }
}