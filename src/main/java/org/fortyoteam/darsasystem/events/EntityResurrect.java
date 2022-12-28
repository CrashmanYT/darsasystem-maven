package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.fortyoteam.darsasystem.items.TotemOfReversal;

public class EntityResurrect implements Listener {

    @EventHandler
    public void onEntityResurrectEvent(EntityResurrectEvent e) {

        new TotemOfReversal(e);

    }
}
