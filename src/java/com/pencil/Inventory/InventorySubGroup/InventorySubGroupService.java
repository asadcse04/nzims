/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventorySubGroup;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface InventorySubGroupService
{
    public boolean createInventorySubGroup(InventorySubGroup inv_subgroup);
    
    public boolean updateInventorySubGroup(InventorySubGroup inv_subgroupObj);
          
    List<InventorySubGroup> inventorySubGroupList(); 
    
}
