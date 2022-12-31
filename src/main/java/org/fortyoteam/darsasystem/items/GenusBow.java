package org.fortyoteam.darsasystem.items;

import org.bukkit.event.entity.EntityShootBowEvent;
import org.fortyoteam.darsasystem.config.ItemConfig;

public class GenusBow {

    public GenusBow(EntityShootBowEvent event) {
        String genusBowName = ItemConfig.get().getString("genusbow.DisplayName");

    }
}
