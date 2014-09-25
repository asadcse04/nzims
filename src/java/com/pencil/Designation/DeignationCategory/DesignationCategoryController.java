/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Designation.DeignationCategory;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class DesignationCategoryController {
    
private DesignationCategory designationCategory;
    
    private List<DesignationCategory> designationCategoryList;
    
    DesignationCategoryService serviceDao = new DesignationCategoryServiceImpl();

    /**
     * Creates a new instance of FeeCategoryController
     */
    public DesignationCategoryController() {
    }
    
    public void createDesignationCategory() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addDesignationCategory(this.designationCategory))
        {
            context.addMessage(null, new FacesMessage("Successful", "Designation Category Added"));
            
            this.designationCategory=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Designation Category is not added"));
        }
        
    }

    public DesignationCategory getDesignationCategory() 
    {
        if(this.designationCategory==null)
        {
            this.designationCategory=new DesignationCategory();
        }
        return designationCategory;
    }

    public void setDesignationCategory(DesignationCategory designationCategory) {
        this.designationCategory = designationCategory;
    }

    public List<DesignationCategory> getDesignationCategoryList() 
    {
        this.designationCategoryList=serviceDao.getAllDesignationCategory();
        return this.designationCategoryList;
    }

    public void setDesignationCategoryList(List<DesignationCategory> designationCategoryList) {
        this.designationCategoryList = designationCategoryList;
    }
    
    
    
    
}