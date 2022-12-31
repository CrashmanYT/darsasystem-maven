package org.fortyoteam.darsasystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.fortyoteam.darsasystem.items.GenusBow;

public class EntityShootBow implements Listener {

    @EventHandler
    public void onEntityShootBowEvent(EntityShootBowEvent event) {
        new GenusBow(event);
    }


}
