package org.fortyoteam.darsasystem.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class EntityDamageByEntity implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
//        ScoreboardManager sbm = Bukkit.getScoreboardManager();
//        Scoreboard scoreboard = sbm.getMainScoreboard();
//
//        Player player = (Player) event.getEntity();
//        player.sendMessage(player.getDisplayName());
//        Player killer = (Player) event.getDamager();
//            for (Team team : scoreboard.getTeams()) {
//                if (team.hasEntry(player.getDisplayName())) {
//                    player.sendMessage(killer.getDisplayName());
//                }
//            }
    }
}
