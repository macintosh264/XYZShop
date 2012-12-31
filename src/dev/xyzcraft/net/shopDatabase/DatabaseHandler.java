/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.xyzcraft.net.shopDatabase;

import dev.xyzcraft.net.xyzshop.dataObject.MSItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joey
 */
public class DatabaseHandler extends MacDatabaseEngine{
    /*
     * Database Structure
     * tables:
     *  xyz_shop:
     *      item (int)
     *      datavalue (short)
     *      buyprice (long)
     *      sellprice (long)
     *      quantity (int)
     */
    public DatabaseHandler(String url,String username, String password) throws SQLException {
        super(url,username,password);
    }
    public MSItem getItem(int ID, short dataValue) {
        ResultSet itemQuery;
        try {
            itemQuery = this.executeMySql("SELECT * FROM `items` WHERE item=" + ID + " AND datavalue=" + dataValue);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        try {
            if (itemQuery.wasNull()) {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        try {
            if (!itemQuery.first()) {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        Integer quantity = null;
        Integer itemID = null;
        Short itemDataValue = null;
        Long itemSellPrice = null;
        Long itemBuyPrice = null;
        try {
            quantity = itemQuery.getInt("quantity");
            itemID = itemQuery.getInt("item");
            itemDataValue = itemQuery.getShort("datavalue");
            itemSellPrice = itemQuery.getLong("sellprice");
            itemBuyPrice = itemQuery.getLong("buyprice");
        } catch (SQLException ex) {
           Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
        if (quantity == null || itemID == null || itemDataValue == null || itemSellPrice == null || itemBuyPrice == null) {
            return null;
        }
        return new MSItem(quantity, itemID, itemDataValue, itemSellPrice, itemBuyPrice);
    }
}
