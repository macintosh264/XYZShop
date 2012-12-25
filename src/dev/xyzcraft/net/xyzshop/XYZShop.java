/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.xyzcraft.net.xyzshop;

import dev.xyzcraft.net.database.DatabaseHandler;
import dev.xyzcraft.net.xyzshop.commands.BuyCommand;
import dev.xyzcraft.net.xyzshop.commands.SellCommand;
import dev.xyzcraft.net.xyzshop.commands.ShopCommand;
import dev.xyzcraft.net.xyzshop.commands.WorthCommand;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Joey
 */
public class XYZShop extends JavaPlugin{
    public boolean db = false;
    public DatabaseHandler database = null;
    public Shop shop;
    public Economy econ = null;
    @Override
    public void onEnable() {
        getLogger().info("Starting XYZ Shop");
        /*
         * Verify config.yml
         *  Write config.yml defaults
        */
        this.saveDefaultConfig();
        /*
         * Connect to database
        */
        String url = "jdbc:mysql://" + this.getConfig().getString("mysql.host") + ":" + this.getConfig().getInt("mysql.port") + "/" + this.getConfig().getString("mysql.database");
        try {
            database = new DatabaseHandler(url,this.getConfig().getString("mysql.username"),this.getConfig().getString("mysql.password"));
            db = true;
        } catch (SQLException ex) {
            Logger.getLogger(XYZShop.class.getName()).log(Level.SEVERE, null, ex);
            database = null;
            db = false;
        }
        /*
         * Register commands
         */
        this.getCommand("sell").setExecutor(new SellCommand(this));
        this.getCommand("buy").setExecutor(new BuyCommand(this));
        this.getCommand("shop").setExecutor(new ShopCommand(this));
        this.getCommand("worth").setExecutor(new WorthCommand(this));
        /*
         * Connect to Vault
         */
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        }
        shop = new Shop(this);
        getLogger().info("XYZ Shop has been started");

    }
    @Override
    public void onDisable() {
        /*
         * Database Close up
         */
        database.close();
        database = null;
        db = false;
    }
}
