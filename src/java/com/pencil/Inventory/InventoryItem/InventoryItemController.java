/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryItem;

import com.pencil.Inventory.InventoryCategory.InventoryCategoryService;
import com.pencil.Inventory.InventoryCategory.InventoryCategoryServiceImpl;
import com.pencil.Inventory.InventoryConfig.InventoryConfigService;
import com.pencil.Inventory.InventoryConfig.InventoryConfigServiceImpl;
import com.pencil.Inventory.InventorySubGroup.InventorySubGroupService;
import com.pencil.Inventory.InventorySubGroup.InventorySubGroupServiceImpl;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mastermind
 */
@ManagedBean
@ViewScoped
public class InventoryItemController implements Serializable
{

    private InventoryItem inventoryItem;
    
    private List<InventoryItem> inventoryItemData;
    
    private List<String> inventoryTypeNameData;
    
    private List<String> inventoryCategoryNameData;
    
    private List<String> inventoryGroupNameData;
    
    private List<String> inventorySubGroupNameData;
    
    InventoryItemService inventoryItemdao = new InventoryItemServiceImpl();
    
    InventorySubGroupService inventorySubGroupdao= new InventorySubGroupServiceImpl();
    
    InventoryConfigService inventoryConfigdao = new InventoryConfigServiceImpl();
    
    InventoryCategoryService inventoryCategorydao = new InventoryCategoryServiceImpl();
    
    public InventoryItemController()
    {
        this.inventoryItemData = inventoryItemdao.inventoryItemList();
        
        this.inventoryTypeNameData = inventoryCategorydao.inventoryTypeNameList();
    }
    
    public void InvItemCatagory_List() 
    {
        this.inventoryCategoryNameData = inventoryConfigdao.listInvCategory(this.inventoryItem.getInventoryTypeName());
    }
    
    public void InvItemGRoup_List() 
    {
        this.inventoryGroupNameData = inventoryConfigdao.listInvGroup(this.inventoryItem.getInventoryCatagoryName());
    }
    
    public void InvItemSubGroup_list()
    {
        this.inventorySubGroupNameData = inventoryConfigdao.listInvSubGroup(this.inventoryItem.getInventoryGroupName());
    }
    
    public void insertInventoryItem()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryItemdao.createInventoryItem(this.inventoryItem))
        {
            this.inventoryItemData=inventoryItemdao.inventoryItemList();
            
            this.inventoryItem=null;
            
            context.addMessage(null, new FacesMessage("Successful Insert inventory item info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert inventory item info!",""));
        }
    }

    public InventoryItem getInventoryItem() 
    {
        if(this.inventoryItem==null)
        {
            this.inventoryItem = new InventoryItem();
        }
        return this.inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public List<InventoryItem> getInventoryItemData() {
        return inventoryItemData;
    }

    public void setInventoryItemData(List<InventoryItem> inventoryItemData) {
        this.inventoryItemData = inventoryItemData;
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
    
    
    
}
