package com.hazebyte.crate.api.request;

import com.hazebyte.crate.api.crate.Crate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.entity.Player;

@Data
@AllArgsConstructor
@Builder
public class PreviewCrateRequest implements Request {
  @NonNull List<Crate> crate;
  @NonNull Player player;
}
