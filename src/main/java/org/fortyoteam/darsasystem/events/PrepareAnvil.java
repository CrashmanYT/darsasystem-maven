package org.fortyoteam.darsasystem.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.commands.Blacksmith;

public class PrepareAnvil implements Listener {

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent e) {
        if (e == null || e.getResult() == null) return;

        e.setResult(new Blacksmith().setItemTier((Player) e.getView().getPlayer(), e.getResult(), false, false).getItem());
    }
}
