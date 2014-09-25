/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryGroup;

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
public class InventoryGroupController implements Serializable
{

    private InventoryGroup inventoryGroup;
    
    private List<InventoryGroup> inventoryGroupData;
    
    private List<String> inventoryTypeNameData;
    
    private List<String> inventoryCategoryNameData;
  
    InventoryGroupService inventoryGroupdao = new InventoryGroupServiceImpl();
    
    InventoryCategoryService inventoryCategorydao = new InventoryCategoryServiceImpl();
    
    InventoryConfigService inventoryConfigdao = new InventoryConfigServiceImpl();
    
    public InventoryGroupController() 
    {     
        this.inventoryGroupData = inventoryGroupdao.inventoryGroupList();
        
        this.inventoryTypeNameData = inventoryCategorydao.inventoryTypeNameList();

    }
    
    public void InvCatagory_List() 
    {
        this.inventoryCategoryNameData = inventoryConfigdao.listInvCategory(this.inventoryGroup.getInventoryTypeName());
    }
    
    public void insertInventoryGroup()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryGroupdao.createInventoryGroup(this.inventoryGroup))
        {
            this.inventoryGroupData=inventoryGroupdao.inventoryGroupList();
            
            this.inventoryGroup=null;
            
            context.addMessage(null, new FacesMessage("Successful Insert inventory group info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert inventory group info!",""));
        }
    }
    
    public void updateInventoryGroup()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryGroupdao.updateInventoryGroup(this.inventoryGroup))
        {
            this.inventoryGroupData=inventoryGroupdao.inventoryGroupList();
            
            this.inventoryGroup=null;
            
            context.addMessage(null, new FacesMessage("Successful update inventory group info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update inventory group info!",""));
        }
    }
       

    public InventoryGroup getInventoryGroup()
    {
         if(this.inventoryGroup==null)
        {
            this.inventoryGroup=new InventoryGroup();
        }
        return this.inventoryGroup;
    }

    public void setInventoryGroup(InventoryGroup inventoryGroup) {
        this.inventoryGroup = inventoryGroup;
    }

    public List<InventoryGroup> getInventoryGroupData() {
        return inventoryGroupData;
    }

    public void setInventoryGroupData(List<InventoryGroup> inventoryGroupData) {
        this.inventoryGroupData = inventoryGroupData;
    }

    public List<String> getInventoryTypeNameData()
    {
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

    
}
