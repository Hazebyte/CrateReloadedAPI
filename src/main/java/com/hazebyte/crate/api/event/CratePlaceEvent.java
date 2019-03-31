package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Crate;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called when a player places a Supply Crate.
 * {@link com.hazebyte.crate.api.crate.CrateType#SUPPLY}
 */
public class CratePlaceEvent extends Event implements Cancellable {

    private Crate crate;
    private Player player;
    private Block block;

    private static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    public CratePlaceEvent(Crate crate, Player player, Block block) {
        this.crate = crate;
        this.player = player;
        this.block = block;
    }

    public Crate getCrate() {
        return crate;
    }

    public Player getPlayer() {
        return player;
    }

    public Block getBlock() {
        return block;
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
