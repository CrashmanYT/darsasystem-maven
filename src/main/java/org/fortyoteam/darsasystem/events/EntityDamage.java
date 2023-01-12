package org.fortyoteam.darsasystem.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class EntityDamage implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = sbm.getMainScoreboard();
        EntityDamageByEntityEvent entityDamageByEntity = (EntityDamageByEntityEvent) event;

        Player player = (Player) event;
        Player killer = (Player) entityDamageByEntity.getDamager();
        if (player.isDead()) {
            for (Team team : scoreboard.getTeams()) {
                if (team.hasEntry(player.getDisplayName())) {

                }
            }
        }
     }
}
