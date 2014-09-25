/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryCategory;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface InventoryCategoryService 
{
    public boolean createInventoryCategory(InventoryCategory invcata);
    
    public boolean updateInventoryCategory(InventoryCategory invcataObj);
    
    List<String> inventoryTypeNameList();
    
    List<InventoryCategory> inventoryCategoryList();   
}
