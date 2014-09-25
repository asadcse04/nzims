package com.pencil.Inventory.InventoryStockIn;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHOHUG-SQ
 */
public class InventoryStockIn implements Serializable{
    
    private int inventoryItemID;
    
    private String inventoryStockIN;
    
    private String note;
 
    private Date createDate;
       
    private int userID;
    
    private double quantity;
    
    private double unitPrice;
    
    private double totalPrice;
    
    private double price;
         
    private String subGroupName;
    
    private String inventoryGroupName;
    
    private String inventoryCatagoryName;
    
    private String inventoryTypeName;
    
    private String inventoryItemName;
    
    private double grandTotal;
    
    private int serial=0;

    public InventoryStockIn() {
    }

    public InventoryStockIn(int inventoryItemID, String inventoryStockIN, String note, Date createDate, String inventoryItemName, int userID) {
        this.inventoryItemID = inventoryItemID;
        this.inventoryStockIN = inventoryStockIN;
        this.note = note;
        this.createDate = createDate;
        this.inventoryItemName = inventoryItemName;
        this.userID = userID;
        
    }

    public InventoryStockIn(String inventoryItemName,double unitPrice,double quantity,double totalPrice ) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.inventoryItemName = inventoryItemName;
    }
    
    
    
    
    
    public double stockInTotalPrice() {
        
        this.totalPrice =(this.unitPrice * this.quantity);
        return totalPrice;
        
       
    }
    
    
        
    public int getInventoryItemID() {
        return inventoryItemID;
    }

    public void setInventoryItemID(int inventoryItemID) {
        this.inventoryItemID = inventoryItemID;
    }

    public String getInventoryStockIN() {
        return inventoryStockIN;
    }

    public void setInventoryStockIN(String inventoryStockIN) {
        this.inventoryStockIN = inventoryStockIN;
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

    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
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

    public String getInventoryItemName() {
        return inventoryItemName;
    }

    public void setInventoryItemName(String inventoryItemName) {
        this.inventoryItemName = inventoryItemName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    
    @Transient
    public int getSerial() {
        
        this.serial=serial+1;
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
    
    
    
    
    
    
}
