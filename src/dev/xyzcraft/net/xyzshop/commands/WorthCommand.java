/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.xyzcraft.net.xyzshop.commands;

import dev.xyzcraft.net.xyzshop.XYZShop;
import dev.xyzcraft.net.xyzshop.dataObject.MSItem;
import dev.xyzcraft.net.xyzshop.util.MacCommand;
import dev.xyzcraft.net.xyzshop.util.MacCommandStatus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Joey
 */
public class WorthCommand extends MacCommand{
    public WorthCommand(XYZShop pl) {
         super(pl);
    }
    @Override
    public MacCommandStatus onCommand(Player cs, Command cmnd, String label, String[] args) {
        ItemStack inhand = cs.getItemInHand();
        MSItem item = this.plugin.database.getItem(inhand.getTypeId(), inhand.getDurability());
        if (item == null) {
            cs.sendMessage(ChatColor.RED + "This item is not in the store.");
            return MacCommandStatus.SUCESSFUL;
        }
        //cs.sendMessage(ChatColor.YELLOW + item.quantity.toString() +  " of " + ChatColor.RED + inhand.getType().name() + ChatColor.YELLOW + " is worth " + ChatColor.GREEN + "$" + item.itemBuyPrice + ChatColor.YELLOW + " to purchase from the store and " + ChatColor.DARK_RED + "$" + item.itemSellPrice + ChatColor.YELLOW + " when selling to the store.");
        cs.sendMessage(ChatColor.DARK_RED + item.quantity.toString() + ChatColor.YELLOW + "x[" + ChatColor.DARK_RED + item.itemID + ChatColor.YELLOW + "] " + ChatColor.DARK_GREEN + inhand.getType().name() + ChatColor.GRAY + ":");
        cs.sendMessage(ChatColor.YELLOW + "   Buy Price (From Shop)" + ChatColor.GRAY + ": " + ChatColor.GREEN + ((item.itemBuyPrice > 0) ? ("$" + item.itemBuyPrice.toString()) : "Not For Sale"));
        cs.sendMessage(ChatColor.YELLOW + "   Sell Price (To Shop)" + ChatColor.GRAY + ": " + ChatColor.RED + ((item.itemSellPrice > 0) ? ("$" + item.itemSellPrice.toString()) : "Cannot Sell To Store"));
        return MacCommandStatus.SUCESSFUL;
    }
    
}
