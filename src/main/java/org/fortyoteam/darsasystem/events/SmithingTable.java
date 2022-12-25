package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.SmithingInventory;
import org.fortyoteam.darsasystem.commands.Blacksmith;

import java.util.List;

public class SmithingTable implements Listener {

    @EventHandler
    public void onSmithingTableEvent(PrepareSmithingEvent e) {
        List<HumanEntity> viewers = e.getViewers();
        viewers.forEach(humanEntity -> ((Player)humanEntity).updateInventory());
        if (e.getInventory().equals(Blacksmith.blacksmithGui)) {
            SmithingInventory inv = e.getInventory();


        }
    }
}
