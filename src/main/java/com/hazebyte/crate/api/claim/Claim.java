package com.hazebyte.crate.api.claim;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.OfflinePlayer;

import java.util.UUID;
import java.util.function.Function;

/**
 * A Claim represents a set of instructions that the player may execute
 * any given later time.
 */
public interface Claim {

    /**
     * This returns the UUID of the claim.
     * @return the UUID of the claim.
     */
    UUID getUUID();

    Reward[] getRewards();

    OfflinePlayer getOwner();

    /**
     * This returns the timestamp at which this claim was given.
     * @return the timestamp of the claim.
     */
    long getTimestamp();

    boolean execute();

    void setExecutor(Function<Claim, Boolean> executor);

}
