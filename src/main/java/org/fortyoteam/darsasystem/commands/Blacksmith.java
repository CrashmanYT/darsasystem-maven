package org.fortyoteam.darsasystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.fortyoteam.darsasystem.config.ItemConfig;
import org.fortyoteam.darsasystem.type.Tier;

import java.util.*;

public class Blacksmith implements CommandExecutor {
    public static Inventory blacksmithGui;
    public static NavigableMap<String, String[]> tiers;


    static {
        tiers = new TreeMap<String, String[]>();
        tiers.put("(1) " + "Tier C", new String[] {"STONE", "IRON"});
        tiers.put( "(2) " + ChatColor.BLUE + "" + ChatColor.BOLD + "Tier B", new String[] {"GOLD", "BOW"});
        tiers.put( "(3) " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Tier A", new String[] {"DIAMOND", "CROSSBOW"});
        tiers.put( "(4) " + ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Tier S", new String[] {"NETHERITE"});
        tiers.put( "(5) " + ChatColor.RED + "" + ChatColor.BOLD + "Tier S+", new String[] {});
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player)sender;


        Inventory blacksmithGui = Bukkit.createInventory(null, InventoryType.SMITHING);
        player.openInventory(blacksmithGui);


        return false;
    }

//    public static void initRecipe(Main main) {
//        SmithingRecipe netheriteSword = new SmithingRecipe(new NamespacedKey(main, "netheriteSword"),
//                new ItemStack(Material.NETHERITE_SWORD),
//                new RecipeChoice.MaterialChoice(Material.DIAMOND_SWORD),
//                new RecipeChoice.MaterialChoice(Material.AMETHYST_SHARD)
//        );
//
//        Bukkit.addRecipe(netheriteSword);
//    }
//

    /**
     *
     * Event that used this function :
     * - PrepareItemCraft
     * - PrepareAnvil
     * - PrepareSmithing
     * - PlayerPickupItem
     *
     *
     */
    public Tier setItemTier(Player player, ItemStack e, boolean cancel, boolean isGrindstone) {
         ItemStack item = e;
         String itemType =  item.getType().name();
         ItemMeta meta = item.getItemMeta();
         List<String> lore = new ArrayList<>();
         StringBuilder test = new StringBuilder();


         // if item is darsa item
        for (String key : ItemConfig.get().getKeys(false)) {
            if (item.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', ItemConfig.get().getString(key + ".DisplayName")))) {
                return new Tier(item ,meta,false);
            }
        }
        //loop tiers type
        for (String tier : tiers.keySet()) {
            // loop tiers item
             for (String tierItemType : tiers.get(tier)) {

                 if (!itemType.contains(tierItemType)) continue; // if item type isn't items that listed in tiers list
                 // if item is enchanted, upgrade tier
                 if (item.getEnchantments().size() > 0) {
                     lore.add((!tier.contains("S+") ? tiers.higherKey(tier) : tier));
                 } else {
                     lore.add(tier);
                 }

                 meta.setLore(lore);
                 item.setItemMeta(meta);

                 // if setCancelled true, give item to player
                 if (cancel) {
                     player.getInventory().addItem(item);
                     return new Tier(item, item.getItemMeta(), true);
                 }
                // return [Cancel condition, item, meta]
                 return new Tier(item,meta, false);
             }
         }
        player.getInventory().addItem(item);
        return new Tier(item,meta,cancel);

    }

}
