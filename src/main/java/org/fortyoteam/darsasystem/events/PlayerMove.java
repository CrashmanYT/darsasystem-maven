package org.fortyoteam.darsasystem.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.fortyoteam.darsasystem.items.LightBoots;
import org.fortyoteam.darsasystem.items.ShadowCape;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent e) {
        new LightBoots(e);
        new ShadowCape(e);
    }
}
