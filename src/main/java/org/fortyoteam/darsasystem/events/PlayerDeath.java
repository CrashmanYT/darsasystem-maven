package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDeath implements Listener {

    public static HashMap<UUID, Integer> deathsCount = new HashMap<UUID, Integer>();
    public static HashMap<UUID, Integer> killsCount = new HashMap<UUID, Integer>();
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        Player killer = player.getKiller();
        UUID playerID = player.getUniqueId();

        if (killer == null)
            killer = player;

        // add death count
        if (deathsCount.containsKey(playerID))
            deathsCount.replace(playerID, deathsCount.get(playerID) + 1);
        deathsCount.putIfAbsent(playerID, 1);

        // add kill count
        if (killsCount.containsKey(killer.getUniqueId()))
            killsCount.replace(killer.getUniqueId(), killsCount.get(killer.getUniqueId()) + 1);
        killsCount.putIfAbsent(killer.getUniqueId(), 1);

        player.sendMessage(deathsCount.toString());
    }
}
