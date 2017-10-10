package com.hazebyte.crate.api.util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemHelper {

    // todo Fix newLine.

    public static String getName(ItemStack item) {
        if(item != null && item.hasItemMeta()) {
            return item.getItemMeta().getDisplayName();
        }

        return String.format("%sItem is invalid", ChatColor.RED);
    }

    public static List<String> getLore(ItemStack item) {
        if(item != null && item.hasItemMeta() && item.getItemMeta().hasLore()) {
            return item.getItemMeta().getLore();
        }
        return new ArrayList<>();
    }

    public static ItemStack setName(ItemStack item, String name) {
        if(item == null || name == null || name.equals("")) {
            return item;
        }

        name = Replacer.replace(name);
        return ItemBuilder.of(item).displayName(name).asItemStack();
    }

    public static ItemStack setLore(ItemStack item, List<String> lore) {
        if(item == null || lore == null || lore.size() <= 0) {
            return item;
        }

        lore = Replacer.replace(lore);
        return ItemBuilder.of(item).lore(lore).asItemStack();
    }

    public static ItemStack setNameAndLore(ItemStack item, String name, List<String> lore) {
        if(item == null) {
            return null;
        }

        item = setName(item, name);
        item = setLore(item, lore);
        return item;
    }
}
