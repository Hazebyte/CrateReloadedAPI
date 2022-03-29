package com.hazebyte.crate.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.util.Vector;

public class CratePushbackEvent extends Event implements Cancellable {

    private Player target;
    private Vector vector;
    private boolean cancelled;
    private static HandlerList handlers = new HandlerList();

    public CratePushbackEvent(Player target, Vector vector) {
        this.target = target;
        this.vector = vector;
    }

    public Player getTarget() {
        return target;
    }

    public Vector getVector() {
        return vector;
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
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
