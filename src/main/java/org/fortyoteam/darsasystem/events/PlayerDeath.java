package org.fortyoteam.darsasystem.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.fortyoteam.darsasystem.config.DarsaConfig;
import org.fortyoteam.darsasystem.type.MyItem;

public class PlayerDeath implements Listener {
    ItemStack[] cores = {
            MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&c&lRED CORES"),
            MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&1&lBLUE CORES"),
            MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&2&lGREEN CORES"),
            MyItem.createItemStackWithDisplayName(new ItemStack(Material.NETHER_STAR), "&6&lYELLOW CORES"),
    };
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = sbm.getMainScoreboard();

        Player player = event.getEntity();
        if (player.getKiller() == null) return;

        Player killer = player.getKiller();

        // loop all teams
        for (Team team : scoreboard.getTeams()) {
            // get player team
            if (team.hasEntry(player.getName())) {
                for (String EntriesName : team.getEntries()) {
                    Player teamMember = Bukkit.getPlayer(EntriesName);

                    // check team member inventory
                    for (ItemStack item : teamMember.getInventory().getContents()){
                        if (item == null) return;
                        if (item.getType() == Material.NETHER_STAR) {
                            killer.getInventory().addItem(item);
                            player.getInventory().removeItem(item);
                            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', DarsaConfig.SYSTEM_NAME + "&5&l" + killer.getDisplayName() + " &aBerhasil merebut core tim " + team.getDisplayName()));
                            return;
                        }
                    }
                }
                Location lobby = new Location(Bukkit.getWorld("lobby"), Bukkit.getWorld("lobby").getSpawnLocation().getX(),Bukkit.getWorld("lobby").getSpawnLocation().getY(),Bukkit.getWorld("lobby").getSpawnLocation().getZ());
                if (lobby != null)
                    player.teleport(lobby);
            }
        }

    }}
