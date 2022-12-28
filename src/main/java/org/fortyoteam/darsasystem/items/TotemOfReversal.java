package org.fortyoteam.darsasystem.items;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.config.DarsaConfig;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class TotemOfReversal {
    public TotemOfReversal(EntityResurrectEvent e) {
        if (!(e.getEntity() instanceof Player)) return;

        Player player = (Player) e.getEntity();
        EquipmentSlot mainHand = EquipmentSlot.HAND;
        EquipmentSlot offHand = EquipmentSlot.OFF_HAND;
        ItemStack totemStack = player.getEquipment().getItem(mainHand);

        String totemName = ChatColor.translateAlternateColorCodes('&', ItemConfig.get().getString("totemofreversal.DisplayName"));

        // check player hand
        if (totemStack == null || !totemStack.getItemMeta().getDisplayName().equals(totemName)) {
            totemStack = player.getEquipment().getItem(offHand);
            if (totemStack == null || !totemStack.getItemMeta().getDisplayName().equals(totemName)) {
                return;
            }
        }

        Player killer = player.getKiller();
        Bukkit.getServer().broadcastMessage(DarsaConfig.SYSTEM_NAME + ChatColor.GOLD + ChatColor.BOLD + player.getName() + ChatColor.translateAlternateColorCodes('&', "&aMenggunakan &4&lTotem Of Reversal &adan membalikkan seluruh serangan ke Lawan"));
        if (killer == null) return;

        // give damage to killer
        killer.setHealth(killer.getHealth() / 2);

    }
}
