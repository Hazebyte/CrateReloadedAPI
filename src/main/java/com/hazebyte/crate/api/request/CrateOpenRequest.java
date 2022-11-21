package com.hazebyte.crate.api.request;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class CrateOpenRequest {

  private final Player player;

  private final Location location;

  private final Crate crate;

  private final List<Reward> rewards;

  public CrateOpenRequest(Player player, Location location, Crate crate) {
    this(player, location, crate, crate.generatePrizes(player));
  }

  public CrateOpenRequest(Player player, Location location, Crate crate, List<Reward> rewards) {
    this.player = player;
    this.location = location;
    this.crate = crate;
    this.rewards = Collections.unmodifiableList(rewards);
  }

  public Player getPlayer() {
    return player;
  }

  public Location getLocation() {
    return location;
  }

  public Crate getCrate() {
    return crate;
  }

  public List<Reward> getRewards() {
    return rewards;
  }
}
