package com.hazebyte.crate.api.crate.reward;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.inventory.ItemStack;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Reward {

  @NonNull @Builder.Default Optional<ItemStack> displayItem = Optional.empty();
  @Builder.Default double chance = 0.0;
  @NonNull @Builder.Default List<ItemStack> items = Collections.emptyList();
  @NonNull @Builder.Default List<String> commands = Collections.emptyList();
  @NonNull @Builder.Default List<String> exclusivePermissions = Collections.emptyList();
  @NonNull @Builder.Default List<String> inclusivePermissions = Collections.emptyList();
  @NonNull @Builder.Default List<String> broadcastMessage = Collections.emptyList();
  @NonNull @Builder.Default List<String> openMessage = Collections.emptyList();
  @Builder.Default boolean constant = false;
  @Builder.Default boolean unique = false;
}
