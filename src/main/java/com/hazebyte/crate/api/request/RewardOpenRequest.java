package com.hazebyte.crate.api.request;

import com.hazebyte.crate.api.crate.reward.Reward;
import org.bukkit.entity.Player;

public class RewardOpenRequest {

  private final Reward reward;

  private final Player player;

  public RewardOpenRequest(Reward reward, Player player) {
    this.reward = reward;
    this.player = player;
  }

  public Reward getReward() {
    return reward;
  }

  public Player getPlayer() {
    return player;
  }
}
