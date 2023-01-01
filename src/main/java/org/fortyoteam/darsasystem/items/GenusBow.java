package org.fortyoteam.darsasystem.items;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class GenusBow {

    public GenusBow(EntityShootBowEvent event) {
        String genusBowName = ChatColor.translateAlternateColorCodes('&',ItemConfig.get().getString("genusbow.DisplayName"));
        if (!event.getBow().hasItemMeta()) return;
        if (event.getBow().getItemMeta().getDisplayName().equals(genusBowName)) {
            if (event.getProjectile() instanceof Arrow) {
                if (event.getEntity() instanceof Player) {

                }
            }
        }
    }

    public void shootArrow(Player player, Vector vector) {
        Arrow arrow = player.launchProjectile(Arrow.class);

        arrow.setVelocity(vector);
        arrow.setShooter(player);
    }
}
