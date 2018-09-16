package com.hazebyte.crate.api.util;

import com.sun.istack.internal.Nullable;

public class MoreObjects {
    public static <T> T firstNonNull(@Nullable T first, @Nullable T second) {
        return first != null ? first : second;
    }
}
