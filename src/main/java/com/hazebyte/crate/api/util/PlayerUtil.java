package com.hazebyte.crate.api.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.lang.reflect.Method;

public class PlayerUtil {
    /**
     * Removes a single item from the player's hand.
     *
     * @param p
     */
    public static void removeAnItemInHand(Player p) {
        if (p.getItemInHand().getAmount() != 1)
            p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
        else
            p.getInventory().removeItem(p.getItemInHand());
    }

    public static ItemStack getItemInMainHand(Player player) {
        try {
            Method method = ReflectionUtils.getMethod(PlayerInventory.class, "getItemInMainHand");
            Object object = method.invoke(player.getInventory());
            if (object instanceof ItemStack) {
                return (ItemStack) object;
            }
        } catch (Exception e) {
        }
        return player.getItemInHand();
    }
}
