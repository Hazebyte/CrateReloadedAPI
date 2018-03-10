package com.hazebyte.crate.api.crate;

import java.util.Arrays;

/**
 * Contain states which determine the type of animation that activates.
 */
public enum EndAnimationType {
    BLANK(0),
    RANDOM(1),
    ;

    private static EndAnimationType[] byId = new EndAnimationType[4];
    private final int id;
    EndAnimationType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static EndAnimationType getType(int id) {
        if( id < byId.length && id >= 0) {
            return byId[id];
        }
        return null;
    }

    static {
        for (EndAnimationType type : values()) {
            if (byId.length > type.id) {
                byId[type.id] = type;
            } else {
                byId = Arrays.copyOfRange(byId, 0, type.id + 2);
                byId[type.id] = type;
            }
        }
    }
}
