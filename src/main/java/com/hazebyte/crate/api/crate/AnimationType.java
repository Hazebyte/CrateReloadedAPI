package com.hazebyte.crate.api.crate;

/**
 * Contain states which determine the type of animation that activates.
 */
public enum AnimationType {
    /**
     * No animation
     */
    NONE,
    /**
     * Animation that specifically shifts around one center inventory slot.
     */
    ROULETTE,
    ROULETTE_V2,
    /**
     * Animation that specifically transitions from the right-most inventory slot
     * to the left-most slot.
     */
    CSGO,
    CSGO_V2,
    CSGO_REVERSE,
    /**
     * Animation that transitions in a circular motion around a rectangle path.
     */
    RECTANGLE,
    RECTANGLE_REVERSE,
    HEART,
    SPIN

}
