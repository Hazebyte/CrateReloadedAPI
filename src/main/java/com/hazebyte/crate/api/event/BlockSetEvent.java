package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Crate;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Represents an event where a crate was set to a location.
 */
public class BlockSetEvent extends Event implements Cancellable{

    private Crate crate;
    private Location location;
    private boolean cancelled;

    private static HandlerList handlerList = new HandlerList();

    public BlockSetEvent(Crate crate, Location location) {
        this.crate = crate;
        this.location = location;
    }

    public Crate getCrate() {
        return crate;
    }

    public Location getLocation() {
        return location;
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
