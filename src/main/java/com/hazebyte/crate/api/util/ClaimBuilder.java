package com.hazebyte.crate.api.util;

import com.hazebyte.crate.api.crate.Claim;
import com.hazebyte.crate.api.crate.reward.Reward;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClaimBuilder {

    private UUID uuid;
    private long timestamp;
    private List<Reward> rewards;

    public ClaimBuilder(UUID uuid) {
        this.uuid = uuid;
        this.timestamp = System.currentTimeMillis();
        this.rewards = new ArrayList<>();
    }

    public ClaimBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ClaimBuilder setRewards(List<Reward> rewards) {
        if (rewards == null)
            throw new IllegalArgumentException("The list of rewards may not be null.");

        this.rewards = rewards;
        return this;
    }

    public ClaimBuilder addReward(Reward reward) {
        if (reward == null)
            throw new IllegalArgumentException("The reward may not be null");

        rewards.add(reward);
        return this;
    }

    public ClaimBuilder removeReward(Reward reward) {
        rewards.remove(reward);
        return this;
    }

    public ClaimBuilder removeReward(int index) {
        rewards.remove(index);
        return this;
    }

    public Claim toClaim() {
        return new Claim(uuid, timestamp, rewards);
    }
}
