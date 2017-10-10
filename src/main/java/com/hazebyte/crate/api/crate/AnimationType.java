package com.hazebyte.crate.api.crate;

import java.util.Arrays;

public enum AnimationType {
    ROULETTE(0),
    CSGO(1),
    CSGO_REVERSE(2);

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
