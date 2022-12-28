package org.fortyoteam.darsasystem.type;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tier {
    ItemStack item;
    ItemMeta meta;
    boolean cancel;

    public Tier(ItemStack item, ItemMeta meta, boolean cancel ) {
        this.item = item;
        this.meta = meta;
        this.cancel = cancel;

    }

    public ItemStack getItem() {
        return item;
    }

    public ItemMeta getItemMeta(){
        return meta;
    }

    public boolean isCancel() {
        return cancel;
    }


}
