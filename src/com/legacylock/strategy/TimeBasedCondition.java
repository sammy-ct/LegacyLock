package com.legacylock.strategy;

import java.time.LocalDateTime;

public class TimeBasedCondition implements ReleaseCondition {

    private LocalDateTime releaseTime;

    public TimeBasedCondition(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public boolean shouldRelease() {
        return LocalDateTime.now().isAfter(releaseTime);
    }

    @Override
    public String getConditionType() {
        return "TimeBasedCondition";
    }
}