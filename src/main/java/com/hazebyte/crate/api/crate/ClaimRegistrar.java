package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.CrateAPI;
import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ClaimRegistrar {

    /**
     * Adds a claim for a player
     * @param uuid UUID of the player
     * @param timestamp the timestamp at which the claim was given
     * @param rewards the list of claims
     * @return the claim that was added
     */
    Claim addClaim(UUID uuid, long timestamp, Reward... rewards);

    Claim addClaim(Claim claim);

    /**
     * Removes the claim for a player
     * @param uuid UUID of the player
     * @param timestamp the timestamp at which the claim was given
     * @return the claim that was removed
     */
    Claim removeClaim(UUID uuid, long timestamp);

    Claim removeClaim(Claim claim);

    /**
     * Returns the claim of the specific timestamp for the player.
     * @param uuid UUID of the player
     * @param timestamp the timestamp at which the claim was given
     * @return the claim of the specific timestamp, null otherwise.
     */
    Claim getClaim(UUID uuid, long timestamp);

    /**
     * Returns a list of claims. If there are no claims for the user, it will return an empty list.
     * @param uuid The UUID of the player
     * @return an array list of claims
     */
    List<Claim> getClaims(UUID uuid);

    /**
     * Opens the inventory with the list of claims for the player
     * @param player the player to open the inventory for
     */
    void openInventory(Player player);

    /**
     * Allows a spoofer to open another person's claim inventory
     * @param player The player who's claim menu to open
     * @param spoofer The user to open the inventory for
     */
    void openInventorySpoof(Player player, Player spoofer);

    static Claim parse(UUID uuid, String timestamp, List<String> lines) {
        List<Reward> rewards = new ArrayList<>();
        for (String line: lines) rewards.add(CrateAPI.getCrateRegistrar().createReward(line));
        return new Claim(uuid, Long.valueOf(timestamp), rewards);
    }
}
