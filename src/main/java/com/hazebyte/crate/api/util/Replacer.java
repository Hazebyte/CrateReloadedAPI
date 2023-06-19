package com.hazebyte.crate.api.util;

import com.hazebyte.crate.api.CrateAPI;
import com.hazebyte.crate.api.ServerVersion;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Replacer {

  public static String replace(String string) {
    if (string == null || string.isEmpty()) {
      return null;
    }

    string = string.replace("{prefix}", Messenger.getPrefix())
        .replace("{p}", Messenger.getPrefix())
        .replace("{list}", CrateAPI.getCrateRegistrar() != null ?
            CrateAPI.getCrateRegistrar().getCrateString() : "");

    // Legacy Support
    string = string.replace("{aqua}", "&b")
        .replace("{black}", "&0")
        .replace("{blue}", "&9")
        .replace("{dark_aqua}", "&3")
        .replace("{dark_blue}", "&1")
        .replace("{dark_grey}", "&8")
        .replace("{dark_green}", "&2")
        .replace("{dark_purple}", "&5")
        .replace("{dark_red}", "&4")
        .replace("{gold}", "&6")
        .replace("{gray}", "&7")
        .replace("{green}", "&a")
        .replace("{light_purple}", "&d")
        .replace("{red}", "&c")
        .replace("{white}", "&f")
        .replace("{yellow}", "&e")
        .replace("{bold}", "&l")
        .replace("{italic}", "&o")
        .replace("{magic}", "&k")
        .replace("{reset}", "&r")
        .replace("{strike}", "&m")
        .replace("{strikethrough}", "&m")
        .replace("{underline}", "&n");
    string = replace(string, '&');

    // Hex Colors are 1.16+
    if (ServerVersion.getVersion().gte(ServerVersion.v1_16_R1)) {
      string = ColorUtil.of(string);
    }
    return string;
  }

  public static String replace(String string, Player player) {
    if (string == null || string.isEmpty()) {
      return null;
    }

    return string.replace("{player}", player.getName())
        .replace("{playerUUID}", player.getUniqueId().toString());
  }

  public static String replace(String string, char color) {
    if (string == null || string.isEmpty()) {
      return null;
    }

    return ChatColor.translateAlternateColorCodes(color, string);
  }

  public static List<String> replace(List<String> strings) {
    for (int i = 0; i < strings.size(); i++) {
      String string = strings.get(i);
      strings.set(i, replace(string));
    }
    return strings;
  }
}
