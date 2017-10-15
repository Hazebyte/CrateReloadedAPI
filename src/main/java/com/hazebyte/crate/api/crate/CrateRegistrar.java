package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface CrateRegistrar {

    Crate createCrate(String name, CrateType type);

    Reward createReward();

    /**
     * Retrieves the specified {@link Crate} with a item.
     * @param item ItemStack
     * @return {@link Crate}
     */
    Crate getCrate(ItemStack item);

    /**
     * Retrieves the specified {@link Crate} given the crate identifier name.
     * @param str Crate Identifier
     * @return {@link Crate}
     */
    Crate getCrate(String str);

    /**
     * Retrieves the specified {@link Crate} given the display name.
     * @param str Display Name
     * @return {@link Crate}
     */
    List<Crate> getCrateFromDisplayName(String str);

    List<Crate> getCrates();

    boolean isCrate(ItemStack item);

    void add(Crate crate);

    void remove(Crate crate);

    boolean open(Crate crate, Player player);

    boolean open(Crate crate, Player player, Location location);

    boolean preview(Crate crate, Player player);

    void previewAll(List<Crate> crate, Player player);

    DefaultSettings getSettings();

    String getCrateString();

}
