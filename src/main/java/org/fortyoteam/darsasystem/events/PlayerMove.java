package org.fortyoteam.darsasystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.fortyoteam.darsasystem.items.LightBoots;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent e) {

        new LightBoots(e);
    }
}
