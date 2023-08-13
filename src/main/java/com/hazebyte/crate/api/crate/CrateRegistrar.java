package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

/**
 * Contains methods used to manipulate and retrieve a crate.
 */
public interface CrateRegistrar {

    /**
     * Returns a crate with the given name, and type.
     *
     * @param name The ID or name of the crate
     * @param type {@link CrateType}
     * @throws IllegalArgumentException when the name or type is null
     * @return {@link Crate}
     */
    Crate createCrate(String name, CrateType type) throws IllegalArgumentException;

    /**
     * Creates a default reward.
     *
     * @return {@link Reward}
     */
    Reward createReward();

    /**
     * Creates a reward using a reward line.
     *
     * @param line reward line
     * @return {@link Reward}
     */
    Reward createReward(String line);

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

    /**
     * Returns a list of crates
     * @return a list of crates
     */
    List<Crate> getCrates();

    /**
     * Checks if the item represents a crate.
     *
     * @param item {@link ItemStack}
     * @return true if the item is a crate, false otherwise.
     */
    boolean isCrate(ItemStack item);

    /**
     * Adds a crate to the plugin. This registers the crate and makes it available to use.
     *
     * @param crate The crate that you want to add
     */
    void add(Crate crate);

    /**
     * Removes a crate from the plugin. This unregisters the crate from the plugin. Actions
     * will no longer be handled by this crate if you do so.
     * @param crate The crate that you will remove
     */
    void remove(Crate crate);

    /**
     * Uses the built-in reward generator to pick a prize for a player.
     * The reward has to pass the permission check before it is put into
     * the list.
     *
     * @param player The player who should win this reward set.
     * @return List of {@link Reward} specifically for a {@link Player}
     */
    List<Reward> generateCrateRewards(Crate crate, Player player);

    void open(Crate crate, Player player, Location location);

    void open(Crate crate, Player player, Location location, Map<String, Object> settings);

    void openConfirmationPage(Crate crate, Player player, Location location);

    /**
     * Previews a crate in a built-in menu.
     * @param crate The crate that will be previewed
     * @param player The player who wants to see the crate
     */
    void preview(Crate crate, Player player);

    /**
     * Previews all crates in a built-in menu.
     * @param crates The list of crates to be viewed
     * @param player The player who wants to see the crate
     */
    void previewAll(List<Crate> crates, Player player);

    /**
     * Sends a player <code>amount</code> of this crate and withdraws the cost of the crate.
     *
     * @param player The player who wants to purchase the crate.
     * @param amount The amount that the player wants to purchase.
     * @return true if the transaction is successful, otherwise false.
     */
    boolean purchase(Crate crate, Player player, int amount);

    /**
     * Gives the specified player the specified amount of crates.
     *
     * @param player The player to give the crate to.
     * @param amount The amount to give
     * @return true if this is successfully given, otherwise, false.
     */
    void giveCrate(Crate crate, Player player, int amount);

    String getCrateString();

}
