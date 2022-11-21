package com.hazebyte.crate.api.response;

import com.hazebyte.crate.api.crate.reward.Reward;
import com.hazebyte.crate.api.result.RewardOpenResult;

import java.util.Collections;
import java.util.Set;

public class RewardOpenResponse {

  private final Reward reward;

  private final Set<RewardOpenResult> executorResult;

  public RewardOpenResponse(Reward reward, Set<RewardOpenResult> executorResult) {
    this.reward = reward;
    this.executorResult = Collections.unmodifiableSet(executorResult);
  }


  public Reward getReward() {
    return reward;
  }

  public Set<RewardOpenResult> getExecutorResult() {
    return executorResult;
  }
}
