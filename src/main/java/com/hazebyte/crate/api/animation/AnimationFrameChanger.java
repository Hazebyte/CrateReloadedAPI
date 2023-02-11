package com.hazebyte.crate.api.animation;

public interface AnimationFrameChanger<T extends AnimationDisplay> {

  void execute(AnimationExecution execution, T t);
}
