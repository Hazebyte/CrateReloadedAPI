package com.hazebyte.crate.api.crate.reward;

import com.hazebyte.crate.api.crate.Crate;
import com.hazebyte.crate.api.crate.PluginSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public interface Reward extends PluginSerializable {

    Crate getParent();

    void setParent(Crate crate);

    RewardLine getLine();

    boolean hasPermission(Player player);

    void setPermissions(List<String> perms);

    List<String> getPermissions();

    int getSlot();

    void setSlot(int slot);

    double getChance();

    void setChance(double chance);

    ItemStack getDisplayItem();

    void setDisplayItem(ItemStack item);

    boolean hasDisplayItem();

    List<ItemStack> getItems();

    void setItems(List<ItemStack> items);

    List<String> getCommands();

    void setCommands(List<String> commands);

    Map<MessageType, String[]> getMessages();

    String[] getBroadcast();

    String[] getInlineBroadcast();

    String[] getOpenMessage();

    void setMessages(Tag tag, List<String> messages);

    void setMessages(Tag tag, String... messages);

    boolean hasNoDuplicate();

    void setNoDuplicate(boolean bool);

    void onWin(Player player);
}
