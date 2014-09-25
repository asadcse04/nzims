/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryType;

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
public class InventoryTypeController implements Serializable
{

    private InventoryType inventoryType;
    
    private List<InventoryType> inventoryTypeList;
    
    InventoryTypeService inventoryTypedao = new InventoryTypeServiceImpl();
    
    public InventoryTypeController()
    {
        this.inventoryTypeList=inventoryTypedao.InventoryTypeList();
    }
    
    public void insertInventoryType()
     {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryTypedao.createInventoryType(this.inventoryType))
        {
            this.inventoryTypeList=inventoryTypedao.InventoryTypeList();
            
            this.inventoryType=null;
            
            context.addMessage(null, new FacesMessage("Successful Insert inventory type info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert inventory type!",""));
        }
     }
    
     public void updateInventoryType()
     {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(inventoryTypedao.updateInventoryType(this.inventoryType))
        {
            this.inventoryTypeList=inventoryTypedao.InventoryTypeList();
            
            this.inventoryType=null;
            
            context.addMessage(null, new FacesMessage("Successful update inventory type info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update inventory type!",""));
        }
     }

    public InventoryType getInventoryType()
    {
       if(this.inventoryType==null)
        {
            this.inventoryType=new InventoryType();
        }
        return this.inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    public List<InventoryType> getInventoryTypeList() {
        return inventoryTypeList;
    }

    public void setInventoryTypeList(List<InventoryType> inventoryTypeList) {
        this.inventoryTypeList = inventoryTypeList;
    }
    
}
