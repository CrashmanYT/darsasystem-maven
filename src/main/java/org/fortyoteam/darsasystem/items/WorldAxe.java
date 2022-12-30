package org.fortyoteam.darsasystem.items;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.fortyoteam.darsasystem.config.ItemConfig;

import java.util.Arrays;

public class WorldAxe {

    public Material[] BlocksList = {
            Material.OAK_LOG, Material.DARK_OAK_LOG, Material.BIRCH_LOG, Material.ACACIA_LOG, Material.SPRUCE_LOG, Material.JUNGLE_LOG, Material.MANGROVE_LOG,
    };

    public WorldAxe(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Location playerLocation = player.getLocation();
        int radius = 10;

        // check if player hand is empty
        if (!player.getInventory().getItemInMainHand().hasItemMeta()) return;

        String WorldAxeName = ChatColor.translateAlternateColorCodes('&',ItemConfig.get().getString("worldaxe.DisplayName"));
        // check if player is using world axe

        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(WorldAxeName)) {
            World world = playerLocation.getWorld();

            int x = playerLocation.getBlockX();
            int y = playerLocation.getBlockY();
            int z = playerLocation.getBlockZ();

            // get all logs near player
            for (int i = -radius; i <= radius; i++) {
                for (int j = -radius; j <= radius; j++) {
                    Block block = world.getBlockAt(x + i, y , z + j);
                    if (Arrays.asList(BlocksList).contains(block)) {
                        player.sendMessage("Block ini adalah kayu");
                    }
                }
            }
        }
    }

}
