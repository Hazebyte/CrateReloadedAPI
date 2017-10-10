package com.hazebyte.crate.api.util;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;
import java.util.Collection;

public class Players {

    /**
     * Retrieves all the players online in the server.
     *
     * @return Player[]
     */
    public static Player[] getOnlinePlayers() {
        try {
            Method method = ReflectionUtils.getMethod(Server.class, "getOnlinePlayers");
            Object object = method.invoke(Bukkit.getServer());
            if (object instanceof Collection) {
                Collection collection = ((Collection<? extends Player>) object);
                return (Player[]) collection.toArray(new Player[collection.size()]);
            } else if (object instanceof Player[]) {
                return (Player[]) object;
            }
        } catch (Exception ex) {
            Messenger.error("Unable to get online players", ex.getStackTrace()[0]);
        }
        return null;
    }
}
