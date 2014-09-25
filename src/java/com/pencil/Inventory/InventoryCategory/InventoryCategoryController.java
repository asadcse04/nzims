/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryCategory;

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
public class InventoryCategoryController  implements Serializable
{

    private InventoryCategory inventoryCategory;
    
    private List<InventoryCategory> inventoryCategoryData;
    
    private List<String> inventoryTypeNameData;
    
    InventoryCategoryService inventoryCategorydao = new InventoryCategoryServiceImpl();
    
    public InventoryCategoryController()
    {
        this.inventoryTypeNameData = inventoryCategorydao.inventoryTypeNameList();
        
        this.inventoryCategoryData = inventoryCategorydao.inventoryCategoryList();
    }

    public void insertInventoryCategory()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryCategorydao.createInventoryCategory(this.inventoryCategory))
        {
            this.inventoryCategoryData=inventoryCategorydao.inventoryCategoryList();
            
            this.inventoryCategory=null;
            
            context.addMessage(null, new FacesMessage("Successful Insert inventory category info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert inventory category info!",""));
        }
    }
     
    public void editInventoryCategory()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryCategorydao.updateInventoryCategory(this.inventoryCategory))
        {
            this.inventoryCategoryData=inventoryCategorydao.inventoryCategoryList();
            
            this.inventoryCategory=null;
            
            context.addMessage(null, new FacesMessage("Successful Upadte inventory category info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to Upadte inventory category info!",""));
        }
    }
     
    public InventoryCategory getInventoryCategory()
    {
       if(this.inventoryCategory==null)
        {
            this.inventoryCategory=new InventoryCategory();
        }
        return this.inventoryCategory;
    }

    public void setInventoryCategory(InventoryCategory inventoryCategory) {
        this.inventoryCategory = inventoryCategory;
    }

    public List<InventoryCategory> getInventoryCategoryData() {
        return inventoryCategoryData;
    }

    public void setInventoryCategoryData(List<InventoryCategory> inventoryCategoryData) {
        this.inventoryCategoryData = inventoryCategoryData;
    }

    public List<String> getInventoryTypeNameData() {
        return inventoryTypeNameData;
    }

    public void setInventoryTypeNameData(List<String> inventoryTypeNameData) {
        this.inventoryTypeNameData = inventoryTypeNameData;
    }
    
}
