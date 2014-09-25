/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryItem;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface InventoryItemService 
{
    public boolean createInventoryItem(InventoryItem inv_item);
    
    public boolean updateInventoryItem(InventoryItem inv_itemObj);
          
    List<InventoryItem> inventoryItemList(); 
}
