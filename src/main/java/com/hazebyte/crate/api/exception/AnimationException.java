package com.hazebyte.crate.api.exception;

public class AnimationException extends Exception {

    public AnimationException(String msg) {
        super(msg);
    }

    public AnimationException() {
        super("Invalid Animation executed");
    }

}
