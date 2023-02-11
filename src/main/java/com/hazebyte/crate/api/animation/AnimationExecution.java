package com.hazebyte.crate.api.animation;

import com.hazebyte.crate.api.crate.Crate;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Data
@Builder
public class AnimationExecution {

  @NonNull private final AnimationTemplate template;

  @NonNull private final Crate crate;

  @NonNull private final Player player;

  @Builder.Default private AnimationExecutionState state = AnimationExecutionState.START;

  @Builder.Default private Long timeLapsed = 0L;

  @Builder.Default private int iteration = 0;

  private List<ItemStack> displayItems; // generated when animation starts
}
