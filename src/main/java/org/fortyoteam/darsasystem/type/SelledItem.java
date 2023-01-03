package org.fortyoteam.darsasystem.type;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.enums.ButtonType;

public class SelledItem extends ItemStack {

    private Material itemMaterial;
    private Material money;
    private int count;
    private int price;

    public SelledItem(Material itemMaterial, Material money ,int count, int price) {
        this.itemMaterial = itemMaterial;
        this.money = money;
        this.count = count;
        this.price = price;
    }


    public Material getItemMaterial() { return this.itemMaterial; }
    public Material getMoney() { return this.money; }
    public int getItemCount() { return this.count; }
    public int getPrice() { return this.price; }


}
