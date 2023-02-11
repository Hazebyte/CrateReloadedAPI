package com.hazebyte.crate.api.request;

import com.hazebyte.crate.api.crate.Crate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Data
@Builder
@AllArgsConstructor
public class OpenCrateRequest implements Request {
  @NonNull private Player player;
  @NonNull private Location location;
  @NonNull private Crate crate;
  @NonNull @Builder.Default private boolean confirmingUse = true;
  @NonNull @Builder.Default private boolean removingCrateItem = true;
}
