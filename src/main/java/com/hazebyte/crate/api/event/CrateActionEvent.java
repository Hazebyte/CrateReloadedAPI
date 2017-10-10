package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Crate;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CrateActionEvent extends Event implements Cancellable {

    private Crate crate;
    private Player player;
    private Location location;

    private static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    protected CrateActionEvent(Crate crate, Player player) {
        this.crate = crate;
        this.player = player;
        this.location = player.getLocation();
    }

    protected CrateActionEvent(Crate crate, Player player, Location location) {
        this.crate = crate;
        this.player = player;
        this.location = location;
    }

    public Crate getCrate() {
        return crate;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

}
