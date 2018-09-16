package com.hazebyte.crate.api.util;

public class MoreObjects {
    public static <T> T firstNonNull(T first, T second) {
        return first != null ? first : second;
    }
}
