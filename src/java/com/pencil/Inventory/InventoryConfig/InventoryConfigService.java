/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryConfig;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface InventoryConfigService
{
    public List<String> listInvCategory(String inventoryTypeName);
    
    public List<String> listInvGroup(String inventoryCategoryName);
    
    public List<String> listInvSubGroup(String inventoryGroupName);
    
    public List<String> listInvItem(String subGroupName);
 
}
