/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryStockIn;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface InventoryStockInService {
    
    public boolean createInventoryStockIn(InventoryStockIn inventoryStockIn, InventoryPayment inventoryPayment);
    
    public boolean updateInventoryStockIn(InventoryStockIn inventoryStockIn_obj);
    
    List<InventoryStockIn> inventoryStockInList();

    
}
