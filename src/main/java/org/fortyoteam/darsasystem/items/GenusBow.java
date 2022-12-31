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
                    int arrowsCount = 5;
                    Player player = (Player) event.getEntity();
                        Arrow arrow = player.launchProjectile(Arrow.class);
                        Vector arrowVector = player.getLocation().getDirection().clone();

                        arrowVector.rotateAroundY(0.3);
                        arrow.setVelocity(arrowVector);
                        arrow.setShooter(player);

                }
            }
        }
    }
}
