package com.legacylock.strategy;

public class InactivityCondition implements ReleaseCondition {

    private long lastActiveTime;
    private long inactivityLimit; // milliseconds

    public InactivityCondition(long inactivityLimit) {
        this.inactivityLimit = inactivityLimit;
        this.lastActiveTime = System.currentTimeMillis();
    }

    public void updateActivity() {
        lastActiveTime = System.currentTimeMillis();
    }

    @Override
    public boolean shouldRelease() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - lastActiveTime) > inactivityLimit;
    }

    @Override
    public String getConditionType() {
        return "InactivityCondition";
    }
}