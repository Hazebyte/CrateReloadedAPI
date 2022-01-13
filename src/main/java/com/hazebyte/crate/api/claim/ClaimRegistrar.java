package com.hazebyte.crate.api.claim;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Collection;

public interface ClaimRegistrar {

    Claim addClaim(OfflinePlayer player, Reward... rewards) throws IOException;

    void removeClaim(Claim claim) throws IOException;

    Claim getClaim(OfflinePlayer player, long timestamp);

    Collection<Claim> getClaims(OfflinePlayer player);

    void openInventory(Player player);

    void spoofInventory(OfflinePlayer player, Player viewer);

}
