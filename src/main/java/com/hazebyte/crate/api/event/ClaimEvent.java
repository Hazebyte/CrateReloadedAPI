package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Claim;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Represents an event that is called when a player tries to claim a reward.
 * If this event is cancelled, it is not removed from the data store.
 */
public class ClaimEvent extends Event implements Cancellable {

    private Claim claim;
    private boolean cancelled;

    private static HandlerList handlerList = new HandlerList();

    public ClaimEvent(Claim claim) {
        this.claim = claim;
    }

    public Claim getClaim() {
        return claim;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
