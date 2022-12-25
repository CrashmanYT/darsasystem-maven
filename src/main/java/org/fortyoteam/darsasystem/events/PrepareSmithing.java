package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.commands.Blacksmith;

public class PrepareSmithing implements Listener {

    @EventHandler
    public void onPrepareItemCraft(PrepareSmithingEvent e) {
        e.setResult((ItemStack) Blacksmith.setItemTier((Player) e.getView().getPlayer(), e.getResult(), false, false)[1]);
    }
}
