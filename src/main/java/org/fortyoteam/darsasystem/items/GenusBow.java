package org.fortyoteam.darsasystem.items;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class GenusBow {

    public GenusBow(EntityShootBowEvent event) {
        String genusBowName = ChatColor.translateAlternateColorCodes('&',ItemConfig.get().getString("genusbow.DisplayName"));
        if (!event.getBow().hasItemMeta()) return;
        if (event.getBow().getItemMeta().getDisplayName().equals(genusBowName)) {
            if (event.getProjectile() instanceof Arrow) {
                if (event.getEntity() instanceof Player) {
                    int arrowsCount = 5;
                    Player player = (Player) event.getEntity();
                    for (int velocity = 30; velocity <= 30 * arrowsCount; velocity += 30 ) {
                        Arrow arrow = player.getWorld().spawn(player.getEyeLocation(), Arrow.class);
                        arrow.setShooter(player);
                        arrow.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(velocity)));
                    }
                    for (int velocity = -30; velocity <= -30 * arrowsCount; velocity += -30) {
                        Arrow arrow = player.getWorld().spawn(player.getEyeLocation(), Arrow.class);
                        arrow.setShooter(player);
                        arrow.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(velocity)));
                    }
                }
            }
        }
    }
}
