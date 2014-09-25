/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventorySubGroup;

import com.pencil.Inventory.InventoryCategory.InventoryCategoryService;
import com.pencil.Inventory.InventoryCategory.InventoryCategoryServiceImpl;
import com.pencil.Inventory.InventoryConfig.InventoryConfigService;
import com.pencil.Inventory.InventoryConfig.InventoryConfigServiceImpl;
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
public class InventorySubGroupController implements Serializable
{
    private InventorySubGroup inventorySubGroup;
   
    private List<InventorySubGroup> inventorySubGroupData;
    
    private List<String> inventoryTypeNameData;
    
    private List<String> inventoryCategoryNameData;
    
    private List<String> inventoryGroupNameData;
    
    InventorySubGroupService inventorySubGroupdao= new InventorySubGroupServiceImpl();
    
    InventoryConfigService inventoryConfigdao = new InventoryConfigServiceImpl();
    
    InventoryCategoryService inventoryCategorydao = new InventoryCategoryServiceImpl();

    public InventorySubGroupController()
    {
       this.inventoryTypeNameData = inventoryCategorydao.inventoryTypeNameList();
       
       this.inventorySubGroupData = inventorySubGroupdao.inventorySubGroupList();
    }
    
    public void InvSubGupCatagory_List() 
    {
        this.inventoryCategoryNameData = inventoryConfigdao.listInvCategory(this.inventorySubGroup.getInventoryTypeName());
    }
    
     public void InvSubGRoup_List() 
    {
        this.inventoryGroupNameData = inventoryConfigdao.listInvGroup(this.inventorySubGroup.getInventoryCatagoryName());
    }
     
    public void insertInventorySubGroup()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventorySubGroupdao.createInventorySubGroup(this.inventorySubGroup))
        {
            this.inventorySubGroupData=inventorySubGroupdao.inventorySubGroupList();
            
            this.inventorySubGroup=null;
            
            context.addMessage(null, new FacesMessage("Successful Insert inventory sub group info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert inventory sub group info!",""));
        }
    }
    
     public void updateInventorySubGroup()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventorySubGroupdao.updateInventorySubGroup(this.inventorySubGroup))
        {
            this.inventorySubGroupData=inventorySubGroupdao.inventorySubGroupList();
            
            this.inventorySubGroup=null;
            
            context.addMessage(null, new FacesMessage("Successful update inventory sub group info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update inventory sub group info!",""));
        }
    }

    public InventorySubGroup getInventorySubGroup() 
    {
        if(this.inventorySubGroup==null)
        {
            this.inventorySubGroup=new InventorySubGroup();
        }
        return this.inventorySubGroup;
    }

    public void setInventorySubGroup(InventorySubGroup inventorySubGroup) {
        this.inventorySubGroup = inventorySubGroup;
    }

    public List<InventorySubGroup> getInventorySubGroupData() {
        return inventorySubGroupData;
    }

    public void setInventorySubGroupData(List<InventorySubGroup> inventorySubGroupData) {
        this.inventorySubGroupData = inventorySubGroupData;
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
    
    
    
}
