package com.hazebyte.crate.api.claim;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.OfflinePlayer;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/**
 * A Claim represents a set of instructions that the player may execute
 * any given later time.
 */
public interface Claim {

    UUID getId();

    List<Reward> getRewards();

    OfflinePlayer getOwner();

    Long getTimestamp();

    boolean execute();

    void setExecutor(Function<Claim, Boolean> executor);

}
