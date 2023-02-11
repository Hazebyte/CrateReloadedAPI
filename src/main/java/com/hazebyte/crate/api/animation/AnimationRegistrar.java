package com.hazebyte.crate.api.animation;

import org.bukkit.entity.Player;

import java.util.List;

public interface AnimationRegistrar {

  void add(String name, AnimationTemplate animation);

  List<AnimationTemplate> getAnimations();

  AnimationTemplate getAnimation(String name);

  AnimationExecution getAnimationExecution(Player player);

  void startAnimation(AnimationExecution execution, AnimationDisplay display);

  AnimationExecution stopAnimation(Player player);

}
