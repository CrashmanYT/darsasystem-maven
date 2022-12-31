package org.fortyoteam.darsasystem.items;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.fortyoteam.darsasystem.config.ItemConfig;

import java.util.Arrays;
import java.util.HashMap;

public class WorldAxe {

    public Material[] logsList = {
            Material.OAK_LOG, Material.DARK_OAK_LOG, Material.BIRCH_LOG, Material.ACACIA_LOG, Material.SPRUCE_LOG, Material.JUNGLE_LOG, Material.MANGROVE_LOG,
            Material.STRIPPED_OAK_LOG, Material.STRIPPED_DARK_OAK_LOG, Material.STRIPPED_BIRCH_LOG, Material.STRIPPED_ACACIA_LOG, Material.STRIPPED_SPRUCE_LOG, Material.STRIPPED_JUNGLE_LOG, Material.STRIPPED_MANGROVE_LOG,
    };
    public Material[] plantableBlocks = {
            Material.DIRT, Material.GRASS_BLOCK, Material.ROOTED_DIRT, Material.COARSE_DIRT, Material.PODZOL, Material.MYCELIUM
    };
    public Material[] leavesList = {
            Material.OAK_LEAVES, Material.BIRCH_LEAVES, Material.SPRUCE_LEAVES, Material.ACACIA_LEAVES, Material.DARK_OAK_LEAVES, Material.JUNGLE_LEAVES, Material.MANGROVE_LEAVES
    };

    public static HashMap<String, Material> saplings;
    static {
        saplings = new HashMap<>();
        saplings.put("OAK", Material.OAK_SAPLING);
        saplings.put("BIRCH", Material.BIRCH_SAPLING);
        saplings.put("DARK_OAK", Material.DARK_OAK_SAPLING);
        saplings.put("ACACIA", Material.ACACIA_SAPLING);
        saplings.put("JUNGLE", Material.JUNGLE_SAPLING);
        saplings.put("SPRUCE", Material.SPRUCE_SAPLING);
    }

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

            int x = (int)playerLocation.getX();
            int y = (int)playerLocation.getY();
            int z = (int)playerLocation.getZ();

            // get all blocks near player
            for (int i = -radius; i <= radius; i++) {
                for (int j = -radius; j <= radius; j++) {
                    for (int k = -radius; k <= radius; k++) {
                        Block block = world.getBlockAt(x + i, y + k, z + j);
                        // get listed logs
                        for (Material listedBlock : logsList) {
                            if (isPlantableBlock(listedBlock, plantableBlocks, world, block))
                                block.setType(setSapling(block));

                            // break all logs
                            if (block.getType() == listedBlock) block.breakNaturally();
                            removeLeaves(block);
                        }

                    }
                }
            }
        }
    }

    public Boolean isPlantableBlock(Material listedBlock, Material[] plantableBlocks, World world, Block block) {
        for (Material plantableBlock : plantableBlocks) {
            if (world.getBlockAt(block.getX(), block.getY() - 1,block.getZ()).getType() == plantableBlock) {
                if (block.getType() == listedBlock) {
                    return true;
                }
            }
        }
        return false;
    }

    public Material setSapling(Block block) {
        for (String key : saplings.keySet()) {
            if (block.getType().name().contains(key)) {

                return saplings.get(key);
            }
        }
        return Material.AIR;
    }

    public void removeLeaves(Block block) {
        if (Arrays.asList(leavesList).contains(block.getType()))
            block.breakNaturally();
    }

}
