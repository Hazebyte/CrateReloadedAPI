package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.crate.Crate;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Represents an event that is called when a user gives a crate to a player.
 */
public class CrateGiveEvent extends Event implements Cancellable {

    private CommandSender sender;
    private OfflinePlayer target;
    private Crate crate;
    private int amount;
    private boolean sendAll;
    private boolean cancelled;

    private static HandlerList handlerList = new HandlerList();

    public CrateGiveEvent(CommandSender sender, OfflinePlayer player, Crate crate, int amount, boolean sendAll) {
        this.sender = sender;
        this.target = player;
        this.crate = crate;
        this.amount = amount;
        this.sendAll = sendAll;
    }

    public CommandSender getSender() {
        return sender;
    }

    public OfflinePlayer getTarget() {
        return target;
    }

    public Crate getCrate() {
        return crate;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isSentToAll() {
        return sendAll;
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