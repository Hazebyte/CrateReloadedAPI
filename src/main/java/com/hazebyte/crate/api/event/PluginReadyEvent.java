package com.hazebyte.crate.api.event;

import com.hazebyte.crate.api.CratePlugin;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called when the plugin finishes loading.
 */
public class PluginReadyEvent extends Event {

    private CratePlugin plugin;
    private static HandlerList handlerList = new HandlerList();

    public PluginReadyEvent(CratePlugin plugin) {
        this.plugin = plugin;
    }

    public CratePlugin getPlugin() {
        return plugin;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
