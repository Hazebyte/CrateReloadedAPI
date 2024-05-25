package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;
import com.hazebyte.crate.api.effect.Category;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.Consumer;

/**
 * Represents a crate
 */
public interface Crate extends ConfigurationSerializable {

    /**
     * Returns the name of the crate. <br>
     * This is the first order key of the crate configuration.
     *
     * @return the name of the crate
     */
    String getCrateName();

    /*
     * Returns the concatenation of the crate name and the type.
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
     * Checks whether this crate has a display name.
     *
     * @return true if the display name is not null, false otherwise.
     */
    boolean hasDisplayName();

    /**
     * Checks whether this crate has a display item.
     *
     * @return true if the display item is not null, false otherwise.
     */
    boolean hasDisplayItem();

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

    EndAnimationType getEndAnimationType();

    /**
     * Adds a reward to the prize list.
     * Calls {@link Reward#setParent(Crate)}, and sets the parent to this crate.
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
     * Returns the list of rewards that will be given to the player no matter what.
     * If there are no rewards, it returns the empty list.
     *
     * @return List of {@link Reward}
     */
    List<Reward> getConstantRewards();

    /**
     * Returns the user-set attribute used to generate prizes.
     * If the minimum is greater than the maximum, it'll return
     * the maximum.
     *
     * @return minimum number of rewards.
     */
    int getMinimumRewards();

    /**
     * Returns the user-set attribute used to generate prizes.
     * If the maximum is less than the minimum, it'll return
     * the minimum.
     *
     * @return maximum number of rewards.
     */
    int getMaximumRewards();

    /**
     * Returns the number of rows in a preview menu.
     *
     * @return the number of rows.
     */
    int getPreviewRows();

    /**
     * Returns the number of slots in a preview menu.
     *
     * @return the number of slots.
     */
    int getPreviewSlots();

    /**
     * Sets the display name. If the name is null, it'll be set to the empty string.
     *
     * @param name the name used to format.
     */
    void setDisplayName(String name) throws IllegalArgumentException;

    /**
     * Sets the animation to a {@link AnimationType}
     *
     * @param type the type of animation
     */
    void setAnimationType(AnimationType type);

    void setEndAnimationType(EndAnimationType type);

    /**
     * Sets the display item which is displayed in virtual menus.
     *
     * @param item the {@link ItemStack}
     */
    void setDisplayItem(ItemStack item);

    /**
     * Sets the item which is given to a player.
     *
     * @param item the {@link ItemStack}
     */
    void setItem(ItemStack item);

    /**
     * Checks if an {@link ItemStack} equals this crate's item.<br>
     * The matching scheme is based on a configuration setting in the config.yml.<br>
     * The strictest setting will match with NBT. The lightest setting will compare
     * the item's meta.
     *
     * @param item the {@link ItemStack} to compare
     * @return true if the item matches, false otherwise.
     */
    boolean is(ItemStack item);

    /**
     * Returns whether this crate is for sale.
     *
     * @return true if the crate is for sale, false otherwise.
     */
    boolean isBuyable();

    /**
     * Returns whether this crate is previewable.
     *
     * @return true if the crate is previewable, false otherwise.
     */
    boolean isPreviewable();

    /**
     * Returns whether the crate has an confirmation toggle.
     *
     * @return true if there is an confirmation toggle, false otherwise.
     */
    boolean hasConfirmationToggle();

    /**
     * Sets the toggle that enables or disables the confirmation menu.
     *
     * @param bool the toggle.
     */
    void setConfirmationToggle(boolean bool);

    void setAcceptButton(ItemStack acceptButton);

    ItemStack getAcceptButton();

    void setDeclineButton(ItemStack declineButton);

    ItemStack getDeclineButton();

    /**
     * Returns the set of strings used in an holographic.
     *
     * @return a list of strings, otherwise the empty list.
     */
    List<String> getHolographicText();

    /**
     * Sets the holographic text. This may be set to null to represent an
     * empty holographic display.
     *
     * @param texts a list of strings. This may be set to null.
     */
    void setHolographicText(List<String> texts);

    void runEffect(Location location, Category category);

    /**
     * Starts all effects with the given {@link Category} at the given location.
     * If the effect category is PERSISTENT, the effect will not run if there is
     * a previous set of effects already running at that location.
     * If a player is specified, the effect will only be shown for the target player.
     *
     * @param location the location at which the effects start.
     * @param category the category that triggers the effect.
     * @param player the player to show the effects to.
     */
    void runEffect(Location location, Category category, Player player);

    /**
     * Called whenever a player triggers a win for this crate.
     *
     * @param player the player who activated the crate.
     * @param rewards the set of rewards that was generated.
     */
    void onRewards(Player player, List<Reward> rewards);

    void onRewards(Player player, List<Reward> rewards, Location location);

    void onRewards(Player player, List<Reward> rewards, Location location, Consumer consumer);

    List<String> getOpenMessage();

    void setOpenMessage(List<String> openMessage);

    List<String> getBroadcastMessage();

    void setBroadcastMessage(List<String> broadcast);

    /**
     * Returns whether the crate is a placeable item.
     *
     * @return true if the item is placeable, false otherwise.
     */
    boolean isPlaceable();
}
