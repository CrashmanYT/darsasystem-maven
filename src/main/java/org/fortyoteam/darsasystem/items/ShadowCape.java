package org.fortyoteam.darsasystem.items;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class ShadowCape {

    public ShadowCape(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if  (player.getGameMode() == GameMode.SPECTATOR) return;

        // disable invisible
        if (player.getEquipment().getChestplate() == null) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            return;
        }

        String ShadowCapeDisplayName = ChatColor.translateAlternateColorCodes('&', ItemConfig.get().getString("shadowcape.DisplayName"));
        String PlayerBodyEquipment = ChatColor.translateAlternateColorCodes('&', player.getEquipment().getChestplate().getItemMeta().getDisplayName());

        // set player to invisible
        if (PlayerBodyEquipment.contains(ShadowCapeDisplayName) && player.isSneaking()) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1));
        } else {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
    }
}
