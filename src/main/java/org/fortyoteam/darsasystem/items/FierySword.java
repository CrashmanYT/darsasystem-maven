package org.fortyoteam.darsasystem.items;

import io.lumine.mythic.bukkit.utils.lib.jooq.False;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.fortyoteam.darsasystem.config.DarsaConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FierySword {

    public FierySword(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Server server = event.getPlayer().getServer();
            Player player = event.getPlayer();
            Location playerLocation = player.getLocation();
            int radius = 5;

            server.broadcastMessage(DarsaConfig.SYSTEM_NAME + ChatColor.translateAlternateColorCodes('&',
                    "&6&l" + player.getName() + "&a Mengaktifkan kemampuan &c&lFire King's wrath"
            ));

            // collect other players around player
            // burn enemy
            Collection<Entity> entities = playerLocation.getWorld().getNearbyEntities(playerLocation, radius, radius, radius);
            for (Entity entity : entities) {
                if (entity instanceof Player) {
                    Player other = (Player) entity;
                    if (!other.equals(player)) {
                        other.setFireTicks(30);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10, 3));
                        player.getWorld().createExplosion(playerLocation, 1, false);
                    }
                }
            }
            player.getWorld().playSound(playerLocation, Sound.ENTITY_GENERIC_EXPLODE, 1, 1); // play sound
            Location playerLoc = player.getLocation();

            // get player location/coordinate
            int x = playerLoc.getBlockX();
            int y = playerLoc.getBlockY();
            int z = playerLoc.getBlockZ();

            World world = playerLoc.getWorld();

            // get blocks around player
            List<Block> blocks = new ArrayList<>();
            for (int i = -radius; i <= radius; i++) {
                for (int j = -radius; j <= radius; j++) {
                    Block block = world.getBlockAt(x + i, y, z + j);
                    blocks.add(block);
                }
            }
            // set blocks around player to snow
            for (Block block : blocks) {
                block.setType(Material.FIRE);
            }


        }
    }
}
