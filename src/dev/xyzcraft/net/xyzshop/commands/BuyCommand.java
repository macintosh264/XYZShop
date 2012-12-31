/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.xyzcraft.net.xyzshop.commands;

import dev.xyzcraft.net.xyzshop.XYZShop;
import dev.xyzcraft.net.xyzshop.util.MacCommand;
import dev.xyzcraft.net.xyzshop.util.MacCommandStatus;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 *
 * @author Joey
 */
public class BuyCommand extends MacCommand{
    public BuyCommand(XYZShop pl) {
         super(pl);
    }
    @Override
    public MacCommandStatus onCommand(Player cs, Command cmnd, String label, String[] args) {
        sendhelp(cs);
        return MacCommandStatus.SUCESSFUL;
    }
    public void sendhelp(Player cs) {
        
    }

  
    
}
