package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.CrateAPI;
import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ClaimRegistrar {

    /**
     * Add a claim for a player
     *
     * @return The claim that was added to the player
     */
    Claim addClaim(Claim claim);

    /**
     * Removes the claim for a player
     *
     * @return The claim that was removed from the player. If no claim was removed, this returns null.
     */
    Claim removeClaim(Claim claim);

    /**
     * Returns the claim of the specific timestamp for the player.
     * @param uuid UUID of the player
     * @param timestamp the timestamp at which the claim was given
     * @return the claim of the specific timestamp, null otherwise.
     */
    Claim getClaim(UUID uuid, long timestamp);

    /**
     * Checks whether the claim is still valid.
     * @return true if the player has a claim and false otherwise>
     */
    boolean hasClaim(UUID uuid, long timestamp);

    /**
     * Returns a list of claims. If there are no claims for the user, it will return an empty list.
     * @param uuid The UUID of the player
     * @return an array list of claims
     */
    List<Claim> getClaims(UUID uuid);

    /**
     * Opens the inventory with the list of claims for the player.
     * @param player the player to open the inventory for
     */
    void openInventory(Player player);

    /**
     * Allows a spoofer to open another person's claim inventory.
     * @param player The player who's claim menu to open
     * @param spoofer The user to open the inventory for
     */
    void openInventorySpoof(Player player, Player spoofer);

    /**
     * This forces a write to disk.
     */
    void flush();

    static Claim parse(UUID uuid, String timestamp, List<String> lines) {
        List<Reward> rewards = new ArrayList<>();
        for (String line : lines) rewards.add(CrateAPI.getCrateRegistrar().createReward(line));
        return new Claim(uuid, Long.valueOf(timestamp), rewards);
    }
}
