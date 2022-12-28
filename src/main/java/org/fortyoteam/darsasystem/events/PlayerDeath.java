package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.fortyoteam.darsasystem.items.TotemOfReversal;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        TotemOfReversal.setEvent(e);
    }
}
