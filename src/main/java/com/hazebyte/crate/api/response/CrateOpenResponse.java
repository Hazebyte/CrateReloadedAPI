package com.hazebyte.crate.api.response;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.reward.Reward;
import com.hazebyte.crate.api.result.CrateOpenResult;

import java.util.Map;
import java.util.Set;

public class CrateOpenResponse {

  private final Crate crate;

  private final Set<CrateOpenResult> crateResult;

  private final Map<Reward, RewardOpenResponse> rewardResult;


  public CrateOpenResponse(Crate crate,
                           Set<CrateOpenResult> crateResult,
                           Map<Reward, RewardOpenResponse> rewardResult) {
    this.crate = crate;
    this.crateResult = crateResult;
    this.rewardResult = rewardResult;
  }

  public Crate getCrate() {
    return crate;
  }

  public Set<CrateOpenResult> getCrateResult() {
    return crateResult;
  }

  public Map<Reward, RewardOpenResponse> getRewardResult() {
    return rewardResult;
  }
}
