package com.hazebyte.crate.api.claim;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * ClaimRegistrar is an API that manages claims.
 */
public interface ClaimRegistrar {

    CompletableFuture<Claim> addClaim(OfflinePlayer player, List<Reward> rewards);

    CompletableFuture<Claim> addClaim(OfflinePlayer player, Crate crate, int amount);

    CompletableFuture<Void> removeClaim(Claim claim) throws IOException;

    CompletableFuture<Optional<Claim>> getClaim(OfflinePlayer player, UUID uuid);

    CompletableFuture<Collection<Claim>> getClaim(OfflinePlayer player, long timestamp);

    CompletableFuture<Collection<Claim>> getClaims(OfflinePlayer player);

    void openInventory(Player player);

    void spoofInventory(OfflinePlayer player, Player viewer);

}
