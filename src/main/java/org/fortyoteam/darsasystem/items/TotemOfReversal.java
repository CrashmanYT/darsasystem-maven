package org.fortyoteam.darsasystem.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class TotemOfReversal {


    public static void setEvent(PlayerDeathEvent e) {
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',ItemConfig.get().getString("totemofreversal.DisplayName")));
        item.setItemMeta(meta);

    }
}
