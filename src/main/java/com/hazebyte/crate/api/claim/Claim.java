package com.hazebyte.crate.api.claim;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.OfflinePlayer;

import java.util.function.Function;

public interface Claim {

    Reward[] getRewards();

    OfflinePlayer getOwner();

    long getTimestamp();

    boolean execute();

    void setExecutor(Function<Claim, Boolean> executor);

}
