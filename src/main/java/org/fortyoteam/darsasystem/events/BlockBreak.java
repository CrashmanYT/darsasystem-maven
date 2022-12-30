package org.fortyoteam.darsasystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.fortyoteam.darsasystem.items.WorldAxe;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBrockBreakEvent(BlockBreakEvent e) {
        new WorldAxe(e);
    }
}
