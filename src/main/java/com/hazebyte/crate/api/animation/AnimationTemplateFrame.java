package com.hazebyte.crate.api.animation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimationTemplateFrame {

  private long duration; // in ticks per second. 20 ticks = 1 second.

  private AnimationFrameChanger frameChanger;

}
