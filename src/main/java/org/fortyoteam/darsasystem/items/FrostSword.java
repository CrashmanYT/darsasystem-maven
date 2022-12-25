package org.fortyoteam.darsasystem.items;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.fortyoteam.darsasystem.config.DarsaConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FrostSword{


    public static void frostSwordEvent(PlayerInteractEvent e) {
        Server server = e.getPlayer().getServer();
        Player player = e.getPlayer();
        Location playerLocation = player.getLocation();
        int radius = 10;



        server.broadcastMessage(DarsaConfig.SYSTEM_NAME  + ChatColor.translateAlternateColorCodes('&',
                "&6&l" + e.getPlayer().getName() + "&a Mengaktifkan kemampuan &b&lIce Capsule"
        ));
        // stun enemy

        Collection<Entity> entities = playerLocation.getWorld().getNearbyEntities(playerLocation, radius, radius, radius);
        for (Entity entity : entities) {
            if (entity instanceof Player) {
                Player other = (Player) entity;
                if (!other.equals(player)) {
                    other.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 5));
                }
            }
        }
        player.getWorld().playSound(playerLocation, Sound.BLOCK_ANVIL_PLACE, 1, 1);
        Location playerLoc = player.getLocation();

        int x = playerLoc.getBlockX();
        int y = playerLoc.getBlockY();
        int z = playerLoc.getBlockZ();

        World world = playerLoc.getWorld();

        List<Block> blocks = new ArrayList<>();
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                Block block = world.getBlockAt(x + i, y, z + j);
                blocks.add(block);
            }
        }
        for (Block block : blocks) {
            block.setType(Material.SNOW);
        }

    }
}
