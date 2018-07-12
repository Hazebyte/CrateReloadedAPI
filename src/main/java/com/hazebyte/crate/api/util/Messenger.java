package com.hazebyte.crate.api.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Messenger {

    public static String prefix = "[Crate] ";
    private static final String consolePrefix = "[CrateReloaded] ";
    private static Logger logger = Logger.getLogger("CrateReloaded");
    private static Logger debugger;
    private static boolean DEBUG = false;

    public static void setPrefix(String prefix) {
        Messenger.prefix = prefix;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setupDebug(boolean debug) {
        DEBUG = debug;

        debugger = Logger.getLogger("CrateReloadedDebugger");
    }

    public static boolean tell(CommandSender s, String msg) {
        if ((s == null) || msg == null || msg.equals("")) {
            return false;
        }

        if(msg.contains(Messages.MESSAGE_NOT_FOUND)) {
            info(msg);
            return false;
        }

        if(s instanceof Player) {
            msg = Replacer.replace(msg, (Player) s);
        }

        msg = Replacer.replace(msg);

        String[] parts = msg.split("\\\\n+");
        if(parts.length > 0) for(String str: parts)
            s.sendMessage(str);
        else s.sendMessage(msg);
        return true;
    }

    public static boolean tell(CommandSender player, Object msg) {
        return tell(player, msg.toString());
    }

    public static boolean tell(Player player, Object msg) {
        return tell((CommandSender) player, msg.toString());
    }

    public static boolean tell(Player player, String msg) {
        return tell((CommandSender) player, msg);
    }

    public static boolean broadcast(String msg) {
        if ((msg.equals("") || msg == null)) {
            return false;
        }

        msg = Replacer.replace(msg);
        for(Player p: Players.getOnlinePlayers()) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        }
        return true;
    }

    public static boolean broadcast(Object msg) {
        return broadcast(msg.toString());
    }

    public static void error(Object msg, StackTraceElement ele) {
        logger.severe(msg + ": " + ele.getClassName() + "/" + ele.getMethodName() + ":" + ele.getLineNumber());
    }

    public static void info(Object msg) {
        if (msg == null) {
            return;
        }
        String formatted = Replacer.replace(msg.toString());
        if(!formatted.contains(consolePrefix)) {
            formatted = consolePrefix + formatted;
        }
        logger.info(formatted);
    }

    public static void warning(Object msg) {
        if (msg == null) {
            return;
        }
        String formatted = Replacer.replace(msg.toString());
        if(!formatted.contains(consolePrefix)) {
            formatted = consolePrefix + formatted;
        }
        logger.warning(formatted);
    }

    public static void severe(Object msg) {
        if (msg == null) {
            return;
        }
        String formatted = Replacer.replace(msg.toString());
        if(!formatted.contains(consolePrefix)) {
            formatted = consolePrefix + formatted;
        }

        logger.severe(formatted);
    }

    public static String[] trim(String[] strings) {
        String[] newStrings = new String[strings.length];
        int counter = 0;
        for(String str: strings) {
            newStrings[counter++] = str.trim();
        }
        return newStrings;
    }

    public static void debug(Object msg) {
        if(isDebugging()) {
            debugger.log(Level.INFO, msg.toString());
        }
    }

    public static boolean isDebugging() {
        return DEBUG;
    }
}
