package com.hazebyte.crate.api.util;

import com.hazebyte.crate.api.ServerVersion;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Wool;

import java.lang.reflect.Method;
import java.util.*;

public class ItemBuilder {

	private static final Map<String, Method> methodCache = new HashMap<>();

	static {
		if (ServerVersion.getVersion().gte(ServerVersion.v1_14_R1)) {
			try {
				methodCache.put("setCustomModelData", ItemMeta.class.getMethod("setCustomModelData", Integer.class));
			} catch (NoSuchMethodException e) { /* ignored */ }
		}
	}

	private final ItemStack itemStack;

	public ItemBuilder(Material type) {
		itemStack = new ItemStack(type);
	}

	public ItemBuilder(Material type, int amount) {
		itemStack = new ItemStack(type, amount);
	}

	public ItemBuilder(Material type, int amount, short durability) {
		itemStack = new ItemStack(type, amount, durability);
	}

	public ItemBuilder(Material type, int amount, short durability, String displayName) {
		itemStack = new ItemStack(type, amount, durability);
		this.displayName(displayName);
	}

	public ItemBuilder(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	public static ItemBuilder clone(ItemStack itemStack) {
		return of(itemStack.clone());
	}

	public static ItemBuilder of(ItemStack itemStack) {
		Optional<ItemStack> optional = Optional.ofNullable(itemStack);

		return optional.map(ItemBuilder::new).orElse(null);
	}

	public ItemBuilder type(Material type) {
		this.itemStack.setType(type);
		return this;
	}

	public ItemBuilder amount(int amount) {
		this.itemStack.setAmount(amount);
		return this;
	}

	public ItemBuilder durability(short durability) {
		this.itemStack.setDurability(durability);
		return this;
	}

	public ItemBuilder displayName(String displayName) {
		ItemMeta meta = this.itemStack.getItemMeta();
		meta.setDisplayName(Replacer.replace(displayName));
		itemStack.setItemMeta(meta);
		return this;
	}

	public ItemBuilder lore(String... lines) {
		this.lore(Arrays.asList(lines));
		return this;
	}

	public ItemBuilder lore(List<String> lore) {
		ItemMeta meta = this.itemStack.getItemMeta();
		meta.setLore(Replacer.replace(lore));
		itemStack.setItemMeta(meta);
		return this;
	}

	public ItemBuilder append(String... lines) {
		return append(Arrays.asList(lines));
	}

	public ItemBuilder append(List<String> lines) {
		ItemMeta meta = this.itemStack.getItemMeta();
		Optional<List<String>> optional = Optional.ofNullable(meta.getLore());

		List<String> lore = optional.orElse(new ArrayList<>());
		lore.addAll(lines);
		lore(lore);
		return this;
	}

	public ItemBuilder enchants(Map<Enchantment, Integer> enchants) {
		ItemMeta meta = itemStack.getItemMeta();
		for(Map.Entry<Enchantment, Integer> entry: enchants.entrySet()) {
			meta.addEnchant(entry.getKey(), entry.getValue(), true);
		}
		itemStack.setItemMeta(meta);
		return this;
	}

	public ItemBuilder unsafeEnchants(Map<Enchantment, Integer> enchants) {
		for(Map.Entry<Enchantment, Integer> entry: enchants.entrySet()) {
			itemStack.addUnsafeEnchantment(entry.getKey(), entry.getValue());
		}
		return this;
	}

	public ItemBuilder enchant(Enchantment enchantment, int level) {
		ItemMeta meta = itemStack.getItemMeta();
		meta.addEnchant(enchantment, level, false);
		itemStack.setItemMeta(meta);
		return this;
	}

	public ItemBuilder unsafeEnchant(Enchantment enchantment, int level) {
		itemStack.addUnsafeEnchantment(enchantment, level);
		return this;
	}

	public ItemBuilder removeEnchants() {
		ItemMeta meta = itemStack.getItemMeta();
		Map<Enchantment, Integer> enchantments = meta.getEnchants();
		enchantments.keySet().forEach(enchantments::remove);
		this.itemStack.setItemMeta(meta);
		return this;
	}

	public ItemBuilder flags(ItemFlag... flags) {
		ItemMeta meta = itemStack.getItemMeta();
		meta.addItemFlags(flags);
		this.itemStack.setItemMeta(meta);
		return this;
	}

	public ItemBuilder flag(ItemFlag flag) {
		this.flags(flag);
		return this;
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder unbreakable(boolean unbreakable) {
		ItemMeta meta = itemStack.getItemMeta();
		if (ServerVersion.getVersion().lt(ServerVersion.v1_9_R1)) {
			// Support for 1.8 spigot
			meta.spigot().setUnbreakable(true);
		} else {
			meta.setUnbreakable(unbreakable);
		}
		this.itemStack.setItemMeta(meta);
		return this;
	}

	public ItemBuilder hideAll(boolean hide) {
		return flag(ItemFlag.HIDE_ENCHANTS)
				.flag(ItemFlag.HIDE_ATTRIBUTES)
				.flag(ItemFlag.HIDE_UNBREAKABLE)
				.flag(ItemFlag.HIDE_POTION_EFFECTS)
				.flag(ItemFlag.HIDE_DESTROYS);
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder woolColor(DyeColor color) {
		if (itemStack != null && itemStack.getType() == Material.WOOL) {
			Wool wool = new Wool(color);
			itemStack.setDurability(wool.toItemStack().getDurability());
		}
		return this;
	}

	public ItemBuilder skull(SkullMeta meta) {
		if (itemStack != null && itemStack.getType() == Material.SKULL) {
			itemStack.setItemMeta(meta);
		}
		return this;
	}

	public ItemBuilder setCustomModelData(Integer data) {
		String key = "setCustomModelData";
		if (methodCache.containsKey(key)) {
			ItemMeta meta = itemStack.getItemMeta();
			Method method = methodCache.get(key);
			try {
				method.invoke(meta, data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.itemStack.setItemMeta(meta);
		}
		return this;
	}

	public ItemBuilder setGlowing(boolean glowing) {
		if (glowing) {
			unsafeEnchant(itemStack.getType() != Material.BOW ? Enchantment.ARROW_INFINITE : Enchantment.LUCK, 10);
			flag(ItemFlag.HIDE_ENCHANTS);
		}
		return this;
	}

	public enum DataType {
		FLOAT, DOUBLE, STRING, BYTEARRAY, INTARRAY, BOOLEAN
	}

	public ItemStack asItemStack() {
		return this.itemStack;
	}

}