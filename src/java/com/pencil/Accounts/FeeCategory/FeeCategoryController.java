/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCategory;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mamun
 */
@ManagedBean
@ViewScoped
public class FeeCategoryController {
    
    private FeeCategory feeCategory;
    
    private List<FeeCategory> feeCategoryList;
    
    FeeCategoryService serviceDao = new FeeCategoryServiceImpl();

    /**
     * Creates a new instance of FeeCategoryController
     */
    public FeeCategoryController() {
    }
    
    public void createFee() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addFeeCategory(this.feeCategory))
        {
            context.addMessage(null, new FacesMessage("Successful Fee Category Added", "Fee Category Added"));
            
            this.feeCategory=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Fee Category is not added"));
        }
        
    }
    
    
     
    public void updateFee() 
    
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateFeeCategory(this.feeCategory))
        {
            context.addMessage(null, new FacesMessage("Successful", "Fee Category Updated"));
            
            this.feeCategory=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Fee Category is not updated"));
        }
        
    }

    
    public FeeCategory getFeeCategory() 
    {
        if(this.feeCategory==null)
        {
            this.feeCategory=new FeeCategory();
        }
        return feeCategory;
    }

    public void setFeeCategory(FeeCategory feeCategory) {
        this.feeCategory = feeCategory;
    }

    public List<FeeCategory> getFeeCategoryList() 
    {
        this.feeCategoryList=serviceDao.getAllFeeCategory();
        return this.feeCategoryList;
    }

    public void setFeeCategoryList(List<FeeCategory> feeCategoryList) {
        this.feeCategoryList = feeCategoryList;
    }
    
    
    
    
    
}
