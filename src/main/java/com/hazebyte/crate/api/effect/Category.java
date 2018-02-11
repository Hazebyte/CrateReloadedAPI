package com.hazebyte.crate.api.effect;

public enum Category {
    /**
     * Called when a player opens a crate.
     */
    OPEN(),

    /**
     * Consistently runs at a block.
     */
    PERSISTENT(),

    /**
     * Consistently run when a player is undergoing an animation.
     */
    ANIMATION(),

    /**
     * Called when an animation ends.
     */
    END();
}
