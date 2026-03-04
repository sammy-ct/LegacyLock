package com.legacylock.strategy;

public interface ReleaseCondition {
    boolean shouldRelease();
    String getConditionType();
}