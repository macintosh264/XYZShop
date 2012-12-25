/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.xyzcraft.net.xyzshop.dataObject;

/**
 *
 * @author Joey
 */
public class MSItem {
    public Integer quantity;
    public Integer itemID;
    public Short itemDataValue;
    public Long itemSellPrice;
    public Long itemBuyPrice;
    public MSItem(Integer q, Integer id, Short dv, Long sell, Long buy) { 
        quantity = q;
        itemID = id;
        itemDataValue = dv;
        itemSellPrice = sell;
        itemBuyPrice = buy;
    }
}
