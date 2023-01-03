package org.fortyoteam.darsasystem.type;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.fortyoteam.darsasystem.enums.ButtonType;

import java.util.Arrays;

public class Button extends ItemStack {

    Material material;
    String name;
    String[] lore;
    ButtonType type;

    public Button(Material material, ButtonType type, String name, String[] lore) {
        this.material = material;
        this.type = type;
        this.name = name;
        this.lore = lore;

        switch (type) {
            case NEXT_PAGE:
                Arrays.asList(this.lore).add("NEXT_PAGE");
                break;
            case PREVIOUS_PAGE:
                Arrays.asList(this.lore).add("PREVIOUS_PAGE");
                break;
            case CLOSE_INV:
                Arrays.asList(this.lore).add("CLOSE_INV");
                break;
            default:
        }
    }

    public void setButtonType(ButtonType type) { this.type = type; }
    public ButtonType getButtonType() { return this.type; }
    public String getName() { return this.name; }
    public String[] getLore() { return this.lore; }
}
