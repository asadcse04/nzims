/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventorySubGroup;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class InventorySubGroup implements Serializable
{
    private int subGroupID;
    
    private String subGroupName;
    
    private String note;
    
    private Date createDate;
    
    private String inventoryGroupName;
    
    private int userID;
    
    private String inventoryCatagoryName;
    
    private String inventoryTypeName;

    public InventorySubGroup() 
    {
        
    }

    public InventorySubGroup(int subGroupID, String subGroupName, String note, Date createDate, String inventoryGroupName, int userID) {
        this.subGroupID = subGroupID;
        this.subGroupName = subGroupName;
        this.note = note;
        this.createDate = createDate;
        this.inventoryGroupName = inventoryGroupName;
        this.userID = userID;
    }
    
    

    public int getSubGroupID() {
        return subGroupID;
    }

    public void setSubGroupID(int subGroupID) {
        this.subGroupID = subGroupID;
    }

    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
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

    public String getInventoryGroupName() {
        return inventoryGroupName;
    }

    public void setInventoryGroupName(String inventoryGroupName) {
        this.inventoryGroupName = inventoryGroupName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
