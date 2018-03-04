package com.hazebyte.crate.api.crate;

import java.util.Arrays;

/**
 * Contains states which determine the type of animation that activates.
 */
public enum AnimationType {
    /**
     * No animation
     */
    NONE(99),
    /**
     * Animation that specifically shifts around one center inventory slot.
     */
    ROULETTE(0),
    /**
     * Animation that specifically transitions from the right-most inventory slot
     * to the left-most slot.
     */
    CSGO(1),
    CSGO_REVERSE(2),
    /**
     * Animation that transitions in a circular motion around a rectangle path.
     */
    RECTANGLE(3),
    RECTANGLE_REVERSE(4)

    ;

    private static AnimationType[] byId = new AnimationType[4];
    private final int id;
    AnimationType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AnimationType getType(int id) {
        if( id < byId.length && id >= 0) {
            return byId[id];
        }
        return null;
    }

    static {
        for (AnimationType type : values()) {
            if (byId.length > type.id) {
                byId[type.id] = type;
            } else {
                byId = Arrays.copyOfRange(byId, 0, type.id + 2);
                byId[type.id] = type;
            }
        }
    }
}
