/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryStockIn;

import com.pencil.Inventory.InventoryCategory.InventoryCategoryService;
import com.pencil.Inventory.InventoryCategory.InventoryCategoryServiceImpl;
import com.pencil.Inventory.InventoryConfig.InventoryConfigService;
import com.pencil.Inventory.InventoryConfig.InventoryConfigServiceImpl;
import com.pencil.Inventory.InventoryItem.InventoryItemService;
import com.pencil.Inventory.InventoryItem.InventoryItemServiceImpl;
import com.pencil.Inventory.InventorySubGroup.InventorySubGroupService;
import com.pencil.Inventory.InventorySubGroup.InventorySubGroupServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG-SQ
 */

@ManagedBean
@ViewScoped
public class InventoryStockInController implements Serializable{
    
    private InventoryStockIn inventoryStockIn;
    
    private List<InventoryStockIn> inventoryStockInData;
    
    private List<String> inventoryTypeNameData;
    
    private List<String> inventoryCategoryNameData;
    
    private List<String> inventoryGroupNameData;
    
    private List<String> inventorySubGroupNameData;
    
    private List<String> inventoryItemNameData;
    
    private InventoryPayment inventoryPayment;
    
    private double price;
    
    
    InventoryStockInService inventoryStockIndao = new InventoryStockInServiceImpl();
    
    InventorySubGroupService inventorySubGroupdao= new InventorySubGroupServiceImpl();
    
    InventoryConfigService inventoryConfigdao = new InventoryConfigServiceImpl();
    
    InventoryCategoryService inventoryCategorydao = new InventoryCategoryServiceImpl();
    
    InventoryItemService inventoryItemdao = new InventoryItemServiceImpl();
    
    static Map <Integer, InventoryStockIn> map = new <Integer, InventoryStockIn> HashMap();
    
    static List<InventoryStockIn> item = new ArrayList<InventoryStockIn>();
    
    static List<InventoryStockIn> item2 = new ArrayList<InventoryStockIn>();
    
    public InventoryStockInController()
    {
        this.inventoryStockInData = inventoryStockIndao.inventoryStockInList();
        
        this.inventoryTypeNameData = inventoryCategorydao.inventoryTypeNameList();
    }
    
    
    // Add to cart//
    
    public void addStockIn(){
    
     int i=map.size();
       
     map.put(++i, new InventoryStockIn(this.inventoryStockIn.getInventoryItemName(),this.inventoryStockIn.getUnitPrice(),this.inventoryStockIn.getQuantity(),this.inventoryStockIn.getTotalPrice()));
 
     //item.addAll((Collection<? extends InventoryStockIn>) inventoryStockIn);
     
    }
    
    //Add item from map to table//
    
    public static List<InventoryStockIn> cartDetails() {
        item.clear();
        item.addAll(map.values());
        return item;
    }
    
    /////////////////////////////
    public  double calPrice(){
        double totalPrice=0.0d;
        Iterator<InventoryStockIn> ite=item.iterator();
        while(ite.hasNext()){
            totalPrice+=ite.next().getTotalPrice();
        }
        
        this.inventoryStockIn.setGrandTotal(totalPrice);
     
        return totalPrice;
    }
    
    
    public void InvStockInCatagory_List() 
    {
        this.inventoryCategoryNameData = inventoryConfigdao.listInvCategory(this.inventoryStockIn.getInventoryTypeName());
    }
    
    public void InvStockInGRoup_List() 
    {
        this.inventoryGroupNameData = inventoryConfigdao.listInvGroup(this.inventoryStockIn.getInventoryCatagoryName());
    }
    
    public void InvStockInSubGroup_list()
    {
        this.inventorySubGroupNameData = inventoryConfigdao.listInvSubGroup(this.inventoryStockIn.getInventoryGroupName());
    }
    
    public void InvStockInItem_List(){
        
        this.inventoryItemNameData = inventoryConfigdao.listInvItem(this.inventoryStockIn.getSubGroupName());
    }
    
    public void insertInventoryStockIn()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryStockIndao.createInventoryStockIn(this.inventoryStockIn, this.inventoryPayment))
        {
            this.inventoryStockInData=inventoryStockIndao.inventoryStockInList();
            
            this.inventoryStockIn=null;
            
            context.addMessage(null, new FacesMessage("Successful Insert inventory stockIn info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert inventory stockIn info!",""));
        }
    }

    public InventoryStockIn getInventoryStockIn() 
    {
        if(this.inventoryStockIn==null)
        {
            this.inventoryStockIn = new InventoryStockIn();
        }
        return this.inventoryStockIn;
    }
    
    public void setInventoryStockIn(InventoryStockIn inventoryStockIn) {
        this.inventoryStockIn = inventoryStockIn;
    }

    public List<InventoryStockIn> getInventoryStockInData() {
        return inventoryStockInData;
    }

    public void setInventoryStockInData(List<InventoryStockIn> inventoryStockInData) {
        this.inventoryStockInData = inventoryStockInData;
    }

    public List<String> getInventoryTypeNameData() {
        return inventoryTypeNameData;
    }

    public void setInventoryTypeNameData(List<String> inventoryTypeNameData) {
        this.inventoryTypeNameData = inventoryTypeNameData;
    }

    public List<String> getInventoryCategoryNameData() {
        return inventoryCategoryNameData;
    }

    public void setInventoryCategoryNameData(List<String> inventoryCategoryNameData) {
        this.inventoryCategoryNameData = inventoryCategoryNameData;
    }

    public List<String> getInventoryGroupNameData() {
        return inventoryGroupNameData;
    }

    public void setInventoryGroupNameData(List<String> inventoryGroupNameData) {
        this.inventoryGroupNameData = inventoryGroupNameData;
    }

    public List<String> getInventorySubGroupNameData() {
        return inventorySubGroupNameData;
    }

    public void setInventorySubGroupNameData(List<String> inventorySubGroupNameData) {
        this.inventorySubGroupNameData = inventorySubGroupNameData;
    }

    public List<String> getInventoryItemNameData() {
        return inventoryItemNameData;
    }

    public void setInventoryItemNameData(List<String> inventoryItemNameData) {
        this.inventoryItemNameData = inventoryItemNameData;
    }

    public InventoryPayment getInventoryPayment() {
        return inventoryPayment;
    }

    public void setInventoryPayment(InventoryPayment inventoryPayment) {
        this.inventoryPayment = inventoryPayment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
            
}
