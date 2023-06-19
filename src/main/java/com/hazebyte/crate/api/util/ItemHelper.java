package com.hazebyte.crate.api.util;

import com.google.common.base.Strings;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemHelper {

  public static boolean hasName(ItemStack item) {
    return (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName());
  }

  public static boolean hasLore(ItemStack item) {
    return (item != null && item.hasItemMeta() && item.getItemMeta().hasLore());
  }

  public static String getName(ItemStack item) {
    if (!hasName(item)) {
      return null;
    }

    return item.getItemMeta().getDisplayName();
  }

  public static List<String> getLore(ItemStack item) {
    if (!hasLore(item)) {
      return null;
    }

    return item.getItemMeta().getLore();
  }

  public static ItemStack setName(ItemStack item, String name) {
    if (item == null || Strings.isNullOrEmpty(name)) {
      return item;
    }

    return ItemBuilder.of(item).displayName(name).asItemStack();
  }

  public static ItemStack setLore(ItemStack item, List<String> lore) {
    if (item == null || lore == null || lore.isEmpty()) {
      return item;
    }

    return ItemBuilder.of(item).lore(lore).asItemStack();
  }

  public static ItemStack setNameAndLore(ItemStack item, String name, List<String> lore) {
    if (item == null) {
      return null;
    }

    item = setName(item, name);
    item = setLore(item, lore);
    return item;
  }
}
