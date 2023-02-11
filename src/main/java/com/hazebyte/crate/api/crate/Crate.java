package com.hazebyte.crate.api.crate;

import com.hazebyte.crate.api.crate.reward.Reward;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

@Data
@Builder
@AllArgsConstructor
public class Crate {

  @NonNull String crateName;
  @NonNull CrateType type;
  @NonNull @Builder.Default UUID uuid = UUID.randomUUID();
  @NonNull @Builder.Default ItemStack item = new ItemStack(Material.CHEST);
  @NonNull @Builder.Default AnimationType animationType = AnimationType.NONE;
  @NonNull @Builder.Default EndAnimationType endAnimationType = EndAnimationType.BLANK;
  @NonNull @Builder.Default List<Reward> rewards = Collections.emptyList();
  @NonNull @Builder.Default int minimumRewards = 1;
  @NonNull @Builder.Default int maximumRewards = 1;
  @NonNull @Builder.Default List<String> holographicText = Collections.emptyList();
  @NonNull @Builder.Default List<String> openMessage = Collections.emptyList();
  @NonNull @Builder.Default List<String> broadcastMessage = Collections.emptyList();
  @NonNull @Builder.Default Optional<String> displayName = Optional.empty();
  @NonNull @Builder.Default Optional<ItemStack> displayItem = Optional.empty();

  // TODO: Menu settings
  @NonNull @Builder.Default boolean previewable = false;
  @NonNull @Builder.Default boolean confirmingBeforeUse = false;
  @NonNull @Builder.Default int previewRows = 3;
  @Nullable ItemStack acceptButton;
  @Nullable ItemStack declineButton;
}
