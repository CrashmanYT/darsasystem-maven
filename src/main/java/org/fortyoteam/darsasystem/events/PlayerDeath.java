package org.fortyoteam.darsasystem.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class PlayerDeath implements Listener {
    String[] coresName = {"&c&lRED CORES","&1&lBLUE CORES","&2&lGREEN CORES","&6&lYELLOW CORES"};
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = sbm.getMainScoreboard();

        Player player = event.getEntity();
        Inventory playerInv = player.getInventory();

        if (event.getEntity().getKiller() == null) return;
        Player killer = event.getEntity().getKiller();
        Inventory killerInv = killer.getInventory();
        for (Team team : scoreboard.getTeams()) {
            if (team.hasEntry(player.getDisplayName())) {
                for (ItemStack item : playerInv.getContents()) {
                    if (item.getItemMeta() != null) {
                        for (String coreName : coresName) {
                            if (item.getItemMeta().getDisplayName() == ChatColor.translateAlternateColorCodes('&',coreName)) {
                                killerInv.addItem(new ItemStack(Material.NETHER_STAR));
                            }
                        }
                    }
                }
            }
        }

    }
}
