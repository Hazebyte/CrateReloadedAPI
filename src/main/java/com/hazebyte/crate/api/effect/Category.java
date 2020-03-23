package com.hazebyte.crate.api.effect;

/**
 * States which represent when an effect is activated.
 */
public enum Category {
    /**
     * State for when a player opens a crate.
     */
    OPEN,

    /**
     * State that represents a boundless course of action.
     */
    PERSISTENT,

    /**
     * State that represents when a player is inside an GUI animation.
     */
    ANIMATION,

    /**
     * State that represents when a player is pushed back.
     */
    PUSHBACK,

    /**
     * State that represents when a player left clicks a crate.
     */
    INSPECT,

    /**
     * State that represents when a player closes a GUI animation.
     */
    END,

    /**
     * State that represents when a player receives a reward.
     */
    REWARD
    ;
}
