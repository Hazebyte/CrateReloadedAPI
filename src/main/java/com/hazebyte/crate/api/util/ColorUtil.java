package com.hazebyte.crate.api.util;

import com.hazebyte.crate.api.ServerVersion;
import net.md_5.bungee.api.ChatColor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {

    // Prefix (#) and matches any character A-F, a-f, 0-9 six times.
    private static final Pattern hexPattern = Pattern.compile("#([A-Fa-f0-9]{6})");

    // ex: {#000000}
    private static final Pattern bracketPattern = Pattern.compile("\\{#([A-Fa-f0-9]{6})\\}");

    // Chat messages are constantly called, we don't want to make reflection calls every single time.
    private static final Map<String, Method> methodCache = new HashMap<>();

    static {
        try {
            Class<ChatColor> clazz = ChatColor.class;
            Method method = clazz.getMethod("of", String.class);
            methodCache.put("ChatColor#of", method);
        } catch (Exception ex) { /* ignored */ }
    }

    public static String of(String message) {
        if (message == null || message.isEmpty()) {
            return null;
        }

        // Bracket pattern must be checked first
        message = ofPattern(message, bracketPattern);
        message = ofPattern(message, hexPattern);
        return message;
    }

    private static String ofPattern(String message, Pattern pattern) {
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String hexCode = matcher.group();
            hexCode = hexCode.replace("{", "").replace("}", "");
            ChatColor colorCode = getColor(hexCode);
            message = message.replaceAll(hexCode, colorCode.toString());
        }
        return message;
    }

    public static ChatColor getColor(String message) {
        if (ServerVersion.getVersion().lt(ServerVersion.v1_16_R1)) {
            throw new IllegalArgumentException("Your server version does not support RGB");
        }

        try {
            Method method = methodCache.get("ChatColor#of");
            Object chatColor = method.invoke(null, message);
            return (ChatColor) chatColor;
        } catch (Exception e) { /* Ignored */ }
        return null;
    }
}
