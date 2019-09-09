package com.hazebyte.crate.api.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Messenger {
    
    public static String prefix = "[Crate] ";
    private static Logger logger = Logger.getLogger("CrateReloaded");
    private static Logger debugger;
    private static boolean DEBUG = false;
    
    public static void setup (Plugin plugin) {
        logger = plugin.getLogger();
    }
    
    public static void setupDebug (Plugin plugin, boolean status) {
        DEBUG = status;
        debugger = plugin.getLogger();
    }
    
    public static boolean validate () {
        return logger != null;
    }
    
    public static String getPrefix () {
        return prefix;
    }
    
    public static void setPrefix (String prefix) {
        Messenger.prefix = prefix;
    }
    
    public static boolean tell (CommandSender s, String msg) {
        if ((s == null) || msg == null || msg.equals("")) {
            return false;
        }
        
        if (msg.contains(Messages.MESSAGE_NOT_FOUND)) {
            info(msg);
            return false;
        }
        
        if (s instanceof Player) {
            msg = Replacer.replace(msg, (Player) s);
        }
        
        msg = Replacer.replace(msg);
        
        String[] parts = msg.split("\\\\n+");
        if (parts.length > 0) for (String str : parts)
            s.sendMessage(str);
        else s.sendMessage(msg);
        return true;
    }
    
    public static boolean tell (CommandSender player, Object msg) {
        return tell(player, msg.toString());
    }
    
    public static boolean tell (Player player, Object msg) {
        return tell((CommandSender) player, msg.toString());
    }
    
    public static boolean tell (Player player, String msg) {
        return tell((CommandSender) player, msg);
    }
    
    public static boolean tell (CommandSender sender, TextComponent msg) {
        if ((sender == null) || msg == null || msg.equals("")) {
            return false;
        }
        
        if (msg.getText().contains(Messages.MESSAGE_NOT_FOUND)) {
            info(msg);
            return false;
        }

        msg.setText(Replacer.replace(msg.getText()));

        if (sender instanceof Player) {
            Player player = (Player) sender;
            msg.setText(Replacer.replace(msg.getText(), player));

            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                msg.setText(PlaceholderAPI.setPlaceholders(player, msg.getText()));
            }

            String[] parts = msg.getText().split("\\\\n+");
            if (parts.length > 0) for (String str : parts) {
                TextComponent tc = new TextComponent(str);
                tc.setClickEvent(msg.getClickEvent());
                tc.setHoverEvent(msg.getHoverEvent());

                player.spigot().sendMessage(tc);
            } else {
                player.spigot().sendMessage(msg);
            }
        } else {
            sender.sendMessage(msg.getText());
        }
        return true;
    }
    
    public static boolean broadcast (TextComponent msg) {
        if (msg.getText().equals("")) {
            return false;
        }
        
        Arrays.stream(Players.getOnlinePlayers()).forEach((player) -> tell((CommandSender) player, msg));
        return true;
    }
    
    public static boolean broadcast (String msg) {
        if (msg.equals("")) {
            return false;
        }
        
        Arrays.stream(Players.getOnlinePlayers()).forEach((player) -> tell(player, msg));
        return true;
    }
    
    public static boolean broadcast (Object msg) {
        return broadcast(msg.toString());
    }
    
    public static void error (Object msg, StackTraceElement ele) {
        if (validate()) {
            logger.severe(msg + ": " + ele.getClassName() + "/" + ele.getMethodName() + ":" + ele.getLineNumber());
        }
    }
    
    public static void info (Object msg) {
        if (msg == null || !validate()) {
            return;
        }
        String formatted = Replacer.replace(msg.toString());
        logger.info(formatted);
    }
    
    public static void warning (Object msg) {
        if (msg == null || !validate()) {
            return;
        }
        String formatted = Replacer.replace(msg.toString());
        logger.warning(formatted);
    }
    
    public static void severe (Object msg) {
        if (msg == null || !validate()) {
            return;
        }
        String formatted = Replacer.replace(msg.toString());
        logger.severe(formatted);
    }
    
    public static String[] trim (String[] strings) {
        return Arrays.stream(strings).map(String::trim).toArray(String[]::new);
    }
    
    public static void debug (Object msg) {
        if (DEBUG) {
            debugger.log(Level.FINE, msg.toString());
        }
    }
}
