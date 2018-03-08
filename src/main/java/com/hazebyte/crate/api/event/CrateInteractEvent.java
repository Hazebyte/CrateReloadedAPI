package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.CrateAction;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;

/**
 * Called when a player interacts with a crate.
 */
public class CrateInteractEvent extends Event implements Cancellable {
    
    private static HandlerList handlers = new HandlerList();
    protected Player player;
    protected Crate crate;
    protected Location location;
    protected CrateAction action;
    protected Action rootAction;
    private boolean cancelled;

    public CrateInteractEvent(Crate crate, Player player, CrateAction action, Action rootAction) {
        this.crate = crate;
        this.player = player;
        this.location = player.getLocation();
        this.action = action;
        this.rootAction = rootAction;
    }

    public CrateInteractEvent(Crate crate, Player player, Location location, CrateAction action, Action rootAction) {
        this.crate = crate;
        this.player = player;
        this.location = location;
        this.action = action;
        this.rootAction = rootAction;
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
    
    public CrateAction getAction() {
        return action;
    }

    public Action getRootAction() {
        return rootAction;
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
