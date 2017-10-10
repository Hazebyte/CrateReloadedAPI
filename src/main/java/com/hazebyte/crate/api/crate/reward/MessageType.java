package com.hazebyte.crate.api.crate.reward;

public enum MessageType {

    NORMAL("onopen"),
    BROADCAST("broadcast"),
    BROADCAST_INLINE("inbroadcast");

    private String key;

    MessageType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
