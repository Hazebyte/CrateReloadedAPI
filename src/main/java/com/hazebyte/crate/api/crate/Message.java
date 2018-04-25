package com.hazebyte.crate.api.crate;

import org.bukkit.entity.Player;

import java.util.List;

public interface Message {

    /**
     * Sets the list of messages;
     * @param messages the list of messages.
     */
    void set(List<String> messages);

    /**
     * Returns the list of messages;
     * @return the list of messages.
     */
    List<String> get();

    /**
     * Returns the list of messages formatted for the player.
     * @param player The player to format the message for.
     * @param objects List of objects that may be passed.
     * @return the list of messages.
     */
    List<String> get(Player player, Object... objects);

    /**
     * Adds a string to the message.
     * @param message The message string to add.
     * @return true if the message is appended.
     */
    boolean add(String message);

    /**
     * Removes a string from the message.
     * @param message The message string to remove.
     * @return true if the message is removed.
     */
    boolean remove(String message);

    String remove(int index);

    /**
     * Runs the message for the given player.
     * @param player the player who receives the message
     * @param objects pass the objects to format.
     * @return true if the player received a message.
     */
    boolean run(Player player, Object... objects);

    String serialize();
}
