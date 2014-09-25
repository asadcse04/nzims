/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryGroup;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface InventoryGroupService 
{
    public boolean createInventoryGroup(InventoryGroup invgroup);
    
    public boolean updateInventoryGroup(InventoryGroup invgroupObj);
     
    List<InventoryGroup> inventoryGroupList(); 
    
}
