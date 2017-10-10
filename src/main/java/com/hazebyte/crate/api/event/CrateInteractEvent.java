package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.CrateAction;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @deprecated as of CrateReloaded 2.0.0
 *
 * Use the following events ... {@link CrateActionEvent} {@link CrateLeftClickEvent} {@link CrateRightClickEvent}
 *                            {@link CrateOpenEvent} {@link CratePreviewEvent}
 */
@Deprecated
public class CrateInteractEvent extends Event implements Cancellable {
    
    private static HandlerList handlerList = new HandlerList();
    private Player player;
    private Crate crate;
    private Location location;
    private CrateAction action;
    private boolean cancelled;
    
    public CrateInteractEvent(Player player, Crate crate, Location location, CrateAction action) {
        this.player = player;
        this.crate = crate;
        this.location = location;
        this.action = action;
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
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
