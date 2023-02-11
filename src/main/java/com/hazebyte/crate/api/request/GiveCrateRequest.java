package com.hazebyte.crate.api.request;

import com.hazebyte.crate.api.crate.Crate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.entity.Player;

@Data
@Builder
@AllArgsConstructor
public class GiveCrateRequest implements Request {

  @NonNull Crate crate;

  @NonNull Player player;

  int amount;
}
