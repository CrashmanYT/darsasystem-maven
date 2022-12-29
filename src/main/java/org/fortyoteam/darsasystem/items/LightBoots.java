package org.fortyoteam.darsasystem.items;

import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Light;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class LightBoots {

    public LightBoots(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // set walk speed to normal
        if (player.getEquipment().getBoots() == null) {
            player.setWalkSpeed(0.2f);
            return;
        }

        String LightBootsDisplayName = ChatColor.translateAlternateColorCodes('&',ItemConfig.get().getString("lightboots.DisplayName"));
        String PlayerBootsEquipment = ChatColor.translateAlternateColorCodes('&', player.getEquipment().getBoots().getItemMeta().getDisplayName());

        // set walk speed to high
        if (PlayerBootsEquipment.contains(LightBootsDisplayName)) {
            player.setWalkSpeed(0.4f);
        } else {
            player.setWalkSpeed(0.2f);
        }
    }
}
