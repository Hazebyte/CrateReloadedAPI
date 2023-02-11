package com.hazebyte.crate.api.response;

import com.hazebyte.crate.api.crate.reward.Reward;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class GenerateCrateRewardResponse {

  List<Reward> rewards;
}
