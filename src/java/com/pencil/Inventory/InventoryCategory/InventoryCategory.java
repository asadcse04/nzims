/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryCategory;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class InventoryCategory implements Serializable
{
    private int inventoryCategoryID;
    
    private String inventoryCategoryName;
    
    private String note;
    
    private Date createDate;
    
    private String inventoryTypeName;
    
    private int inventoryTypeID;
    
    private int userID;

    public InventoryCategory() 
    {
        
    }

    public InventoryCategory(int inventoryCategoryID, String inventoryCategoryName, String note, Date createDate, String inventoryTypeName, int inventoryTypeID, int userID) {
        this.inventoryCategoryID = inventoryCategoryID;
        this.inventoryCategoryName = inventoryCategoryName;
        this.note = note;
        this.createDate = createDate;
        this.inventoryTypeName = inventoryTypeName;
        this.inventoryTypeID = inventoryTypeID;
        this.userID = userID;
    }

    
    public int getInventoryCategoryID() {
        return inventoryCategoryID;
    }

    public void setInventoryCategoryID(int inventoryCategoryID) {
        this.inventoryCategoryID = inventoryCategoryID;
    }

    public String getInventoryCategoryName() {
        return inventoryCategoryName;
    }

    public void setInventoryCategoryName(String inventoryCategoryName) {
        this.inventoryCategoryName = inventoryCategoryName;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getInventoryTypeID() {
        return inventoryTypeID;
    }

    public void setInventoryTypeID(int inventoryTypeID) {
        this.inventoryTypeID = inventoryTypeID;
    }
    
    
}
