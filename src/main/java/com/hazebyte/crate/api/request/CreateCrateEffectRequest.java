package com.hazebyte.crate.api.request;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.effect.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Data
@Builder
@AllArgsConstructor
public class CreateCrateEffectRequest implements Request {

  @NonNull Crate crate;
  @NonNull Location location;
  @NonNull Category category;
  @NonNull Player player;
}
