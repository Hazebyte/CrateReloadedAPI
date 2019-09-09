package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;
import com.hazebyte.crate.api.effect.Category;
import de.slikey.effectlib.Effect;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
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

    /**
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
     * Returns a reward that gives the user this crate.
     *
     * @param name The player's name to give the reward to.
     * @param amount The amount to give.
     * @return A reward with this crate as a reward.
     */
    Reward asReward(String name, int amount);

    /**
     * Uses the built-in reward generator to pick a prize for a player.
     * The reward has to pass the permission check before it is put into
     * the list.
     *
     * @param player The player who should win this reward set.
     * @return List of {@link Reward} specifically for a {@link Player}
     */
    List<Reward> generatePrizes(Player player);

    /**
     * Opens a crate for a specific player.
     *
     * @param player The player who should open the crate.
     * @param args The argument specific for a crate.
     *             This varies depending on the type of crate.
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
     * @param amount The amount to give
     * @return true if this is successfully given, otherwise, false.
     */
    boolean giveTo(Player player, int amount);

    /**
     * Returns a string representation of all the rewards.
     *
     * @return a formatted string of rewards
     */
    String getRewardString();

    /**
     * Returns the number of rewards.
     *
     * @return the number of rewards
     */
    int getRewardSize();

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

    /**
     * Update the strings of holographics.
     */
    void reloadHolographic();

    /**
     * Toggles a holographic display to be shown.
     *
     * @param location the location at which the holographic is at.
     */
    void showHolographic(Location location);

    /**
     * Toggles a holographic display to be hidden.
     * @param location the location at which the holographic is at.
     */
    void hideHolographic(Location location);

    /**
     * Adds an effect to an crate. This will update all crates with the
     * state {@link Category} persistent.
     *
     * @see <a href="https://github.com/Slikey/EffectLib/blob/master/src/main/java/de/slikey/effectlib/EffectManager.java">EffectLib</a>
     *
     * @param category type of {@link Category} which will trigger this effect.
     * @param effect see {@link ConfigurationSection}
     */
    void addEffect(Category category, ConfigurationSection effect);

    /**
     * Removes an effect from an crate. This will update all crates with the
     * state {@link Category} persistent.
     *
     * @param category Type of {@link Category} which will trigger this effect.
     * @param effect see {@link ConfigurationSection}
     *
     * @return true if the specified effect is removed, false otherwise.
     */
    boolean removeEffect(Category category, ConfigurationSection effect);

    /**
     * Restarts all effects.
     */
    void reloadEffects();

    /**
     * Returns the effect at a location.
     *
     * @param location the location where the effect is at.
     * @return the effect at that location
     */
    Effect getEffect(Location location);

    /**
     * Returns the set of effects within an category.
     *
     * @param category see {@link Category}
     * @return the set of effects represented as {@link ConfigurationSection}
     * within a category, otherwise if the category has no effects, null.
     */
    Collection<ConfigurationSection> getEffect(Category category);

    /**
     * Starts all effects with the given {@link Category} at the given location.
     * If the effect category is PERSISTENT, the effect will not run if there is
     * a previous set of effects already running at that location.
     *
     * @param location the location at which the effects start
     * @param category the category that triggers the effect.
     */
    void runEffect(Location location, Category category);

    void runEffect(Location location, Category category, Player player);

    /**
     * Stops all effects with the {@link Category#PERSISTENT} at the given location.
     *
     * @param location the location at which the effects are to be stopped.
     */
    void stopEffect(Location location);

    boolean hasEffect(Location location);

    /**
     * Called whenever a player triggers a win for this crate..
     * Calls {@link Reward#onWin(Player)}
     *
     * @param player the player who activated the crate
     * @param reward the reward that was generated
     */
    void onReward(Player player, Reward reward);

    /**
     * Called whenever a player triggers a win for this crate.
     *
     * @param player the player who activated the crate.
     * @param rewards the set of rewards that was generated.
     */
    void onRewards(Player player, List<Reward> rewards);

    void onRewards(Player player, List<Reward> rewards, Location location);

    void onRewards(Player player, List<Reward> rewards, Location location, Consumer consumer);

    /**
     * Returns the message wrapper. This message wrapper holds
     * the set of messages individually sent to the player.
     *
     * @return {@link Message}
     */
    Message getOpenMessage();

    /**
     * Returns the message wrapper. This message wrapper holds
     * the set of messages sent to every player.
     *
     * @return {@link Message}
     */
    Message getBroadcast();

    /**
     * Returns whether the crate is a placeable item.
     *
     * @return true if the item is placeable, false otherwise.
     */
    boolean isPlaceable();
}
