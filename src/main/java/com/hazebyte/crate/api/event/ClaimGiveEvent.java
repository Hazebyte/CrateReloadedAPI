package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.claim.Claim;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Represents an event that is called when a claim is given to a player. This specifically represents an event where
 * a player is given a claim via a command.
 *
 * This ignores the following...
 * - A player has run out of inventory space and the plugin automatically gives the player a claim
 * - A player has left midway through an animation cycle
 * - Any other additional handling that is not explicit.
 */
public class ClaimGiveEvent extends Event implements Cancellable {

    private Claim claim;
    private boolean cancelled;

    private static HandlerList handlerList = new HandlerList();

    public ClaimGiveEvent(Claim claim) {
        this.claim = claim;
    }

    public Claim getClaim() {
        return claim;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
