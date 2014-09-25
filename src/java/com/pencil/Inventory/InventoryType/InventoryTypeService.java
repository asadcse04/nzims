/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryType;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface InventoryTypeService 
{
    public boolean createInventoryType(InventoryType inventorytype);
    
    public boolean updateInventoryType(InventoryType inventorytypeObj);
    
    List<InventoryType> InventoryTypeList(); 
}
