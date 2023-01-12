package org.fortyoteam.darsasystem.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        ScoreboardManager sbm = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = sbm.getMainScoreboard();
        Player player = (Player) event.getEntity();

        for (Team team : scoreboard.getTeams()) {

        }

    }
}
