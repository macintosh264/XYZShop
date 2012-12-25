/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.xyzcraft.net.xyzshop.commands;

import dev.xyzcraft.net.xyzshop.XYZShop;
import dev.xyzcraft.net.xyzshop.util.MacCommand;
import dev.xyzcraft.net.xyzshop.util.MacCommandStatus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author Joey
 */
public class ShopCommand extends MacCommand{
    public ShopCommand(XYZShop pl) {
         super(pl);
         super.requiresDB = false;
    }
    @Override
    public MacCommandStatus onCommand(Player cs, Command cmnd, String label, String[] args) {
       /* if (args.length < 1) {
            sendHelp(cs);
            return MacCommandStatus.SUCESSFUL;
        }
        String subCommand = args[0];
        if (subCommand.equals("buy")) {
            if (args.length < 3) {
                sendHelp(cs);
                return MacCommandStatus.SUCESSFUL;
            }
            return MacCommandStatus.UNSUPPORTED;
        }
        else if (subCommand.equals("sell")) {
            if (args.length < 2) {
                sendHelp(cs);
                return MacCommandStatus.SUCESSFUL;
            }
            return MacCommandStatus.UNSUPPORTED;
        }
        else if (subCommand.equals("worth")) {
            return MacCommandStatus.UNSUPPORTED;
        }
        else if (subCommand.equals("reload")) {
            return MacCommandStatus.UNSUPPORTED;
        }*/
        if (args.length >= 1) {
            if (args[0].equals("reload")) {
                return MacCommandStatus.UNSUPPORTED;
            } 
        }
        sendHelp(cs);
        return MacCommandStatus.SUCESSFUL;
    }
    public void sendHelp(Player cs) {
            cs.sendMessage(ChatColor.BLUE + "XYZ " + ChatColor.YELLOW + "Shop" + ChatColor.GRAY + ":");
            cs.sendMessage(ChatColor.RED + "-----------------------------------------------------");
            cs.sendMessage(ChatColor.DARK_GREEN + "Commands: ");
            cs.sendMessage(ChatColor.AQUA + "  - " + ChatColor.GREEN + "/buy <item ID> <quantity>" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Buys an Item");
            cs.sendMessage(ChatColor.AQUA + "  - " + ChatColor.GREEN + "/sell <hand|inv|all|item> [quantity]" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Sells an item");
            cs.sendMessage(ChatColor.AQUA + "  - " + ChatColor.GREEN + "/worth" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Gives the value of the item in the player's hand");
            if (cs.hasPermission("xyzshop.admin.reload")) {
                cs.sendMessage(ChatColor.AQUA + "  - " + ChatColor.DARK_RED + "/shop reload " + ChatColor.GRAY + " - " + ChatColor.GOLD + "Reloads XYZ Shop " + ChatColor.RED + "ADMIN COMMAND");
            }
            cs.sendMessage(ChatColor.RED + "-----------------------------------------------------");
    }
    
}
