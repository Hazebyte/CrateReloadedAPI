package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

/**
 * Called when a player opens a crate.
 */
public class RewardReceiveEvent extends Event implements Cancellable {

    private static HandlerList handlers = new HandlerList();
    private Player player;
    private Crate crate;
    private Location location;
    private List<Reward> rewards;

    private boolean cancelled;

    public RewardReceiveEvent(Crate crate, Player player, Location location, List<Reward> rewards) {
        this.crate = crate;
        this.player = player;
        this.location = location;
        this.rewards = rewards;
    }

    public Player getPlayer() {
        return player;
    }

    public Crate getCrate() {
        return crate;
    }

    public Location getLocation() {
        return location;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
