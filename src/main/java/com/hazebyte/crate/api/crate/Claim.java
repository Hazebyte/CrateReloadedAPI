package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.CrateAPI;
import com.hazebyte.crate.api.crate.reward.Reward;

import java.util.*;

public class Claim {
    private List<Reward> rewards;
    private UUID uuid;
    private long timestamp;

    public Claim(UUID uuid, List<Reward> rewards) {
        this.uuid = uuid;
        this.rewards = rewards;
        this.timestamp = System.currentTimeMillis();
    }

    public Claim(UUID uuid, Reward... rewards) {
        this.uuid = uuid;
        this.rewards = Arrays.asList(rewards);
        this.timestamp = System.currentTimeMillis();
    }

    public Claim(UUID uuid, long timestamp, List<Reward> rewards) {
        this.uuid = uuid;
        this.rewards = rewards;
        this.timestamp = timestamp;
    }

    public Claim(UUID uuid, long timestamp, Reward... rewards) {
        this.uuid = uuid;
        this.rewards = Arrays.asList(rewards);
        this.timestamp = timestamp;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward getFirstReward() {
        if (this.hasRewards()) {
            return rewards.get(0);
        }
        return null;
    }

    public boolean hasRewards() {
        return (rewards != null) && rewards.size() > 0;
    }

    public UUID getUUID() {
        return uuid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<String> serialize() {
        List<String> rewardsAsString = new LinkedList<>();
        this.rewards.forEach(reward -> {
            rewardsAsString.add(reward.serialize());
        });
        return rewardsAsString;
    }

    public static Claim parse(UUID uuid, String timestamp, List<String> rewardLines) {
        List<Reward> rewards = new ArrayList<>();
        for (String string: rewardLines) {
            Reward reward = CrateAPI.getCrateRegistrar().createReward(string);
            rewards.add(reward);
        }

        Claim claim = new Claim(uuid, Long.valueOf(timestamp), rewards);
        return claim;
    }
}
