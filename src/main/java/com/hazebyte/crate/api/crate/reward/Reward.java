package com.hazebyte.crate.api.crate.reward;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.PluginSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

/**
 * Represents a reward.
 */
public interface Reward extends PluginSerializable {

    /**
     * Returns the crate that this reward belongs to.
     *
     * @return the parent of this reward. If the parent doesn't exist, this returns null.
     */
    Crate getParent();

    void setParent(Crate crate);

    /**
     * Returns the reward line that is config-compatible.
     *
     * @return the reward line
     */
    RewardLine getLine();

    /**
     * Checks if the player has any of the following permissions
     * specified by {@link Reward#getPermissions()}
     *
     * @param player the player to check
     * @return true if the player has any permission, false otherwise
     */
    boolean hasPermission(Player player);

    /**
     * Sets the list of permissions.
     *
     * @param perms the list of permissions to set
     */
    void setPermissions(List<String> perms);

    /**
     * Returns the set of permissions.
     *
     * @return the list of permissions, otherwise the empty list
     */
    List<String> getPermissions();

    int getSlot();

    void setSlot(int slot);

    /**
     * Returns the chance.
     *
     * @return chance
     */
    double getChance();

    /**
     * Sets the chance to a double representation.
     * The chance must be greater than or equal to zero.
     *
     * @param chance the chance to set.
     */
    void setChance(double chance);

    /**
     * Returns the display item.
     *
     * @return the display item if non-null, otherwise null.
     */
    ItemStack getDisplayItem();

    /**
     * Sets the display item.
     *
     * @param item the item to set.
     */
    void setDisplayItem(ItemStack item);

    /**
     * Checks whether this reward has an display item.
     *
     * @return true if the display item is non-null.
     */
    boolean hasDisplayItem();

    /**
     * Returns the list of items.
     *
     * @return the list of items, otherwise the empty list.
     */
    List<ItemStack> getItems();

    /**
     * Sets the list of items.
     *
     * @param items the list to set.
     */
    void setItems(List<ItemStack> items);

    /**
     * Adds an item to the reward.
     *
     * @param item the item to add.
     * @return true if the collection of items is changed.
     */
    boolean addItem(ItemStack item);

    /**
     * Removes a single instance of the specified element from the collection.
     *
     * @param item the item to remove
     * @return true if the instance is removed
     */
    boolean removeItem(ItemStack item);

    /**
     * Returns the list of commands.
     *
     * @return the list of commands, otherwise the empty list.
     */
    List<String> getCommands();

    /**
     * Sets the list of commands.
     *
     * @param commands the list to set.
     */
    void setCommands(List<String> commands);

    /**
     * Adds an command to the reward.
     *
     * @param command the command to add.
     * @return true if the collection of commands is changed.
     */
    boolean addCommand(String command);

    /**
     * Removes a single instance of the specified element from the collection.
     *
     * @param command the command to remove.
     * @return true if the instance is removed
     */
    boolean removeCommand(String command);

    Map<MessageType, String[]> getMessages();

    String[] getBroadcast();

    String[] getInlineBroadcast();

    String[] getOpenMessage();

    void setMessages(Tag tag, List<String> messages);

    void setMessages(Tag tag, String... messages);

    /**
     * Returns whether this is a constant reward -- meaning that this reward
     * will always be given to the player.
     *
     * @return true if the reward is constant, false otherwise.
     */
    boolean isConstant();

    /**
     * Set the constant property.
     *
     * @param bool the variable constant
     */
    void setConstant(boolean bool);

    /**
     * Returns whether this is a unique reward.
     *
     * @return true if unique, otherwise false.
     */
    boolean isUnique();

    /**
     * Sets the unique property.
     *
     * @param bool the boolean to set.
     */
    void setUnique(boolean bool);

    /**
     * Called when a player wins a reward.
     *
     * {@link com.hazebyte.crate.api.crate.CrateType#SUPPLY} do not trigger this.
     * @param player the player to give this reward to.
     */
    void onWin(Player player);

    boolean hasPostParsing();

    /**
     * https://www.artima.com/intv/bloch13.html
     * @return A copy of the reward.
     */
    Reward copy();
}
