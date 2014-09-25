/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryType;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class InventoryType implements Serializable
{
    private int inventoryTypeID;
    
    private String inventoryTypeName;
    
    private String note;
    
    private Date createDate;
    
    private int userID;

    public InventoryType()
    {
        
    }

    public InventoryType(int inventoryTypeID, String inventoryTypeName, String note, Date createDate, int userID) 
    {
        this.inventoryTypeID = inventoryTypeID;
        this.inventoryTypeName = inventoryTypeName;
        this.note = note;
        this.createDate = createDate;
        this.userID = userID;
    }

    public int getInventoryTypeID() {
        return inventoryTypeID;
    }

    public void setInventoryTypeID(int inventoryTypeID) {
        this.inventoryTypeID = inventoryTypeID;
    }

    public String getInventoryTypeName() {
        return inventoryTypeName;
    }

    public void setInventoryTypeName(String inventoryTypeName) {
        this.inventoryTypeName = inventoryTypeName;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    
}
