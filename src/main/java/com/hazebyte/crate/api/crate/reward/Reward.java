package com.hazebyte.crate.api.crate.reward;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.PluginSerializable;
import com.hazebyte.crate.api.result.RewardExecutorResult;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

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

//    boolean verifyInclusivePermission(Player player);
//
//    void setInclusivePermissions(Set<String> permissions);
//
//    Set<String> getInclusivePermissions();
//
//    boolean verifyExclusivePermission(Player player);
//
//    void setExclusivePermissions(Set<String> permissions);
//
//    Set<String> getExclusivePermissions();


    /**
     * Checks if the player has any of the following permissions
     * specified by {@link Reward#getPermissions()}
     *
     * @param player the player to check
     * @return true if the player has any permission, false otherwise
     */
    @Deprecated
    boolean hasPermission(Player player);

    /**
     * Sets the list of permissions.
     *
     * @param perms the list of permissions to set
     */
    @Deprecated
    void setPermissions(List<String> perms);

    /**
     * Returns the set of permissions.
     *
     * @return the list of permissions, otherwise the empty list
     */
    @Deprecated
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
     * Returns the list of formatted items.
     *
     * @param player the player to format the items to.
     * @return the list of formatted items, otherwise the empty list.
     */
    List<ItemStack> getItems(Player player);

    /**
     * Returns whether the list has a set of items.
     * @return true if there are items, false otherwise.
     */
    boolean hasItems();

    /**
     * Sets the list of items.
     *
     * @param items the list to set.
     */
    void setItems(List<ItemStack> items);

    /**
     * Returns the list of commands.
     *
     * @return the list of commands, otherwise the empty list.
     */
    List<String> getCommands();

    /**
     * Returns the list of commands formatted for the player.
     *
     * @param player The player to format the string for.
     * @return the list of formatted commands, otherwise the empty list.
     */
    List<String> getCommands(Player player);

    /**
     * Sets the list of commands.
     *
     * @param commands the list to set.
     */
    void setCommands(List<String> commands);

    List<String> getBroadcastMessage();

    List<String> getOpenMessage();

    void setBroadcastMessage(List<String> broadcastMessage);

    void setOpenMessage(List<String> openMessage);

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

    Set<RewardExecutorResult> execute(Player player);

    void setExecutor(BiFunction<Reward, Player, Set<RewardExecutorResult>> executor);

    boolean hasPostParsing();

    /**
     * https://www.artima.com/intv/bloch13.html
     * @return A copy of the reward.
     */
    Reward copy();
}
