package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * This represents a claim that is given to a player
 */
public class Claim {

    // The list of rewards to be given
    private List<Reward> rewards;

    // The UUID of the player that this claim belongs to
    private UUID uuid;

    // The time at which this claim was given
    // NOTE: Claims that belong to a player must have unique timestamps to be saved
    private long timestamp;

    public Claim(UUID uuid, Reward... rewards) {
        this(uuid, Arrays.asList(rewards));
    }

    public Claim(UUID uuid, List<Reward> rewards) {
        this(uuid, System.currentTimeMillis(), rewards);
    }

    public Claim(UUID uuid, long timestamp, Reward... rewards) {
        this(uuid, timestamp, Arrays.asList(rewards));
    }

    /**
     * Initializes a new claim.
     * The arguments may not be null and the timestamp may not be negative.
     */
    public Claim(UUID uuid, long timestamp, List<Reward> rewards) {
        if (uuid == null) throw new IllegalArgumentException("UUID of a claim may not be null");
        if (timestamp < 0) throw new IllegalArgumentException("Timestamp of a claim may not be negative");
        if (rewards == null) throw new IllegalArgumentException("List of rewards may not be null");
        this.uuid = uuid;
        this.rewards = rewards;
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + uuid.hashCode();
        hash = 31 * hash + Long.hashCode(timestamp);
        return hash;
    }

    /**
     * Claims are considered equal if they have the same UUID and timestamp.
     * This means that claims with different rewards are equal if they
     * belong to the same player and have the same timestamp.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Claim)) {
            return false;
        }
        Claim other = (Claim) obj;

        if (!this.uuid.equals(other.uuid)) {
            return false;
        }

        if (this.timestamp != other.timestamp) {
            return false;
        }
        return true;
    }

    /**
     * Returns the list of rewards.
     *
     * @return the list of rewards
     */
    public List<Reward> getRewards() {
        return rewards;
    }

    /**
     * Returns the first reward.
     *
     * @return the first reward
     */
    public Reward getFirstReward() {
        if (this.hasRewards()) {
            return rewards.get(0);
        }
        return null;
    }

    /**
     * Returns if this claim has rewards.
     *
     * @return true if the claim has rewards otherwise false
     */
    public boolean hasRewards() {
        return (rewards != null) && rewards.size() > 0;
    }

    /**
     * Get the UUID that this claim belongs to.
     *
     * @return the UUID of the player
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Returns the time at which this claim was given.
     *
     * @return timestamp at which this claim was given
     */
    public long getTimestamp() {
        return timestamp;
    }

    public List<String> serialize() {
        List<String> lines = new ArrayList<>();
        for (Reward reward: rewards) lines.add(reward.serialize());
        return lines;
    }

    /**
     * @Deprecated Use ClaimRegistrar#parse
     */
    @Deprecated
    public static Claim parse(UUID uuid, String timestamp, List<String> lines) {
        return ClaimRegistrar.parse(uuid, timestamp, lines);
    }
}
