/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryGroup;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class InventoryGroup implements Serializable
{
    private int inventoryGroupID;
    
    private String inventoryGroupName;
    
    private String note;
    
    private Date createDate;
    
    private String inventoryTypeName;
     
    private String inventoryCatagoryName;
    
    private int userID;

    public InventoryGroup() 
    {
        
    }

    public InventoryGroup(int inventoryGroupID, String inventoryGroupName, String note, Date createDate, String inventoryCatagoryName, int userID) {
        this.inventoryGroupID = inventoryGroupID;
        this.inventoryGroupName = inventoryGroupName;
        this.note = note;
        this.createDate = createDate;
        this.inventoryCatagoryName = inventoryCatagoryName;
        this.userID = userID;
    }
    
    
    public int getInventoryGroupID() {
        return inventoryGroupID;
    }

    public void setInventoryGroupID(int inventoryGroupID) {
        this.inventoryGroupID = inventoryGroupID;
    }

    public String getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(String inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInventoryTypeName() {
        return inventoryTypeName;
    }

    public void setInventoryTypeName(String inventoryTypeName) {
        this.inventoryTypeName = inventoryTypeName;
    }

    public String getInventoryCatagoryName() {
        return inventoryCatagoryName;
    }

    public void setInventoryCatagoryName(String inventoryCatagoryName) {
        this.inventoryCatagoryName = inventoryCatagoryName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    
}
