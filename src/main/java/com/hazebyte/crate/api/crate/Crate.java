package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;
import com.hazebyte.crate.api.effect.Category;
import de.slikey.effectlib.Effect;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;

public interface Crate {

    /**
     * Returns the name of the crate. <br>
     * This is the first order key of the crate configuration.
     *
     * @return the name of the crate
     */
    String getCrateName();

    /**
     * Returns the concatenation of the crate name and the type.
     *
     * @implNote This implementation may change.
     *
     * @return the unique identifier
     */
    String getUUID();

    /**
     * Returns the display name specified by the user.
     *
     * @return the user set name
     */
    String getDisplayName();

    /**
     * Returns the display item that is specified to be used <br>
     *     in virtual menus.
     *
     * @return the display item
     */
    ItemStack getDisplayItem();

    /**
     * Returns the type that determines the minecraft action <br>
     *     that activates the crate.
     *
     * @return {@link CrateType}
     */
    CrateType getType();

    /**
     * Returns the item that is given in-game to the player.
     *
     * @return the physical item
     */
    ItemStack getItem();

    /**
     * Returns the cost of a crate.
     * The amount is set to zero if the amount is less than zero.
     *
     * @return the cost
     */
    double getCost();

    /**
     * Sets the cost of the crate
     *
     * @param amount the cost of the crate.<br>
     *               This value must be greater than or equal to zero.
     *
     * @throws IllegalArgumentException If the cost is negative.
     */
    void setCost(double amount) throws IllegalArgumentException;

    /**
     * Returns the animation that open when the crate activation is triggered.
     *
     * @return {@link AnimationType}
     */
    AnimationType getAnimationType();

    /**
     * Adds a reward to the prize list.
     *
     * @param reward The reward to add
     */
    void addReward(Reward reward);

    /**
     * Removes a reward from the prize list.
     *
     * @param reward The reward to remove
     * @return true if reward was removed, false otherwise.
     */
    boolean removeReward(Reward reward);

    /**
     * Sets the list of rewards to a new list
     *
     * @param rewards The list to set
     */
    void setRewards(List<Reward> rewards);

    /**
     * Returns the list of rewards. If there are no rewards, it returns the empty list.
     *
     * @return List of {@link Reward}
     */
    List<Reward> getRewards();

    /**
     * Uses the built-in reward generator to pick a prize for a player.
     * The reward has to pass the permission check before it is put into
     * the list.
     *
     * @param player The player who should win this reward set.
     * @return
     */
    List<Reward> generatePrizes(Player player);

    /**
     * Opens a crate for a specific player.
     *
     * @param player The player who should open the crate.
     * @param args
     * @return true if the crate is successfully opened, false otherwise.
     */
    boolean open(Player player, Object... args);

    /**
     * Previews a crate for the player.
     *
     * @param player The player who should preview the crate.
     */
    void preview(Player player);

    /**
     * Sends a player <code>amount</code> of this crate and withdraws the cost of the crate.
     *
     * @param player The player who wants to purchase the crate.
     * @param amount The amount that the player wants to purchase.
     * @return true if the transaction is successful, otherwise false.
     */
    boolean purchase(Player player, int amount);

    /**
     * Gives a player <code>amount</code> of a crate.
     *
     * @param player The player to give the crate to.
     * @param amount The amount
     * @return true if this is successfully given, otherwise, false.
     */
    boolean giveTo(Player player, int amount);

    String getRewardString();

    int getRewardSize();
    
    int getMinimumRewards();
    
    int getMaximumRewards();
    
    double getGrossChance(List<Reward> rewards);

    /**
     * Returns the number of rows in a preview menu.
     *
     * @return the number of rows.
     */
    int getPreviewRows();

    /**
     * Sets the display name. If the name is null, it'll be set to the empty string.
     *
     * @param name
     */
    void setDisplayName(String name) throws IllegalArgumentException;

    /**
     * Sets the animation to a {@link AnimationType}
     *
     * @param type
     */
    void setAnimationType(AnimationType type);

    /**
     * Sets the display item which is displayed in virtual menus.
     *
     * @param item
     */
    void setDisplayItem(ItemStack item);

    /**
     * Sets the item which is given to a player.
     *
     * @param item
     */
    void setItem(ItemStack item);

    /**
     * Checks if an {@link ItemStack} equals this crate's item.<br>
     * The matching scheme is based on a configuration setting in the config.yml.<br>
     * The strictest setting will match with NBT. The lightest setting will compare
     * the item's meta.
     *
     * @param item
     * @return true if the item matches, false otherwise.
     */
    boolean is(ItemStack item);

    /**
     * Returns whether this crate is for sale.
     * @return true if the crate is for sale, false otherwise.
     */
    boolean isBuyable();

    /**
     * Returns whether this crate is previewable.
     * @return true if the crate is previewable, false otherwise.
     */
    boolean isPreviewable();

    List<String> getHolographicText();

    /**
     * Sets the holographic text.
     * @param text
     */
    void setHolographicText(List<String> text);

    /**
     * Updates all locations where hologrpahics have been set.
     */
    void reloadHolographic();

    void showHolographic(Location location);

    void hideHolographic(Location location);

    void addEffect(Category category, ConfigurationSection effect);

    void removeEffect(Category category, ConfigurationSection effect);

    Effect getEffect(Location location);

    Collection<ConfigurationSection> getEffect(Category category);

    void runEffect(Location location, Category category);

    /**
     * This method is called whenever an action triggers.
     * @param player
     * @param reward
     */
    void onReward(Player player, Reward reward);

    /**
     * This method is called whenever an action triggers.
     * @param player
     * @param rewards
     */
    void onRewards(Player player, List<Reward> rewards);
}
