package org.fortyoteam.darsasystem.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Objective;
import org.fortyoteam.darsasystem.Main;
import org.fortyoteam.darsasystem.ui.DScoreboard;


public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {

        final Player player= e.getPlayer();

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
            @Override
            public void run() {
                new DScoreboard(e.getPlayer().getServer().getOnlinePlayers());
            }
        },0,1);
    }
}
