/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryItem;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class InventoryItem implements Serializable
{
    private int inventoryItemID;
    
    private String inventoryItem;
    
    private String note;
 
    private Date createDate;
    
    private String subGroupName;
    
    private int userID;
    
    private String inventoryGroupName;
    
    private String inventoryCatagoryName;
    
    private String inventoryTypeName;

    public InventoryItem()
    {
        
    }

    public InventoryItem(int inventoryItemID, String inventoryItem, String note, Date createDate, String subGroupName, int userID) {
        this.inventoryItemID = inventoryItemID;
        this.inventoryItem = inventoryItem;
        this.note = note;
        this.createDate = createDate;
        this.subGroupName = subGroupName;
        this.userID = userID;
    }
    
    

    public int getInventoryItemID() {
        return inventoryItemID;
    }

    public void setInventoryItemID(int inventoryItemID) {
        this.inventoryItemID = inventoryItemID;
    }

    public String getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(String inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(String inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }

    public String getInventoryCatagoryName() {
        return inventoryCatagoryName;
    }

    public void setInventoryCatagoryName(String inventoryCatagoryName) {
        this.inventoryCatagoryName = inventoryCatagoryName;
    }

    public String getInventoryTypeName() {
        return inventoryTypeName;
    }

    public void setInventoryTypeName(String inventoryTypeName) {
        this.inventoryTypeName = inventoryTypeName;
    }
    
    
    
}
