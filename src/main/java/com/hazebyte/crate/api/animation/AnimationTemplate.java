package com.hazebyte.crate.api.animation;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AnimationTemplate {

  private List<AnimationTemplateFrame> frames = new ArrayList<>();

}
