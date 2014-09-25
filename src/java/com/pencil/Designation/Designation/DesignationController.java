/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Designation.Designation;

import com.pencil.Designation.DeignationCategory.DesignationCategory;
import com.pencil.Designation.DeignationCategory.DesignationCategoryService;
import com.pencil.Designation.DeignationCategory.DesignationCategoryServiceImpl;
import java.util.ArrayList;
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
public class DesignationController {
    
private Designation designation;
    
    private List<Designation> designationList;
    
    private String designationName;
    
    private List<String> designationNameList;    
    
    private List<DesignationCategory> designationCategoryList;    
        
    DesignationService serviceDao = new DesignationServiceImpl();    
        
    DesignationCategoryService designationCatService = new DesignationCategoryServiceImpl();

    public DesignationController() 
    {
        this.designationCategoryList = designationCatService.getAllDesignationCategory();        
        
    }
    
    public void createDesignation()
    {
          FacesContext context = FacesContext.getCurrentInstance();
          
          this.designation.setDesignationCategoryID(Integer.parseInt(designationName.split("-")[0]));
        
        if(serviceDao.addDesignation(this.designation))
        {
            context.addMessage(null, new FacesMessage("Successful", "Designation Added"));
            
            this.designation=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Designation is not added"));
        }
    }

    public Designation getDesignation() 
    {
        if(this.designation==null)
        {
            this.designation = new Designation();
        }
        return this.designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public List<Designation> getDesignationList() 
    {
        this.designationList=serviceDao.getAllDesignation();
        return this.designationList;
    }

    public void setDesignationList(List<Designation> designationList) {
        this.designationList = designationList;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    } 

    public List<DesignationCategory> getDesignationCategoryList() {
        return designationCategoryList;
    }

    public void setDesignationCategoryList(List<DesignationCategory> designationCategoryList) {
        this.designationCategoryList = designationCategoryList;
    }

    public List<String> getDesignationNameList() 
    {
        this.designationNameList = new ArrayList<String>();
        
        for(DesignationCategory designationCategory : designationCategoryList)
        {
            this.designationNameList.add(designationCategory.getCategoryID()+"-"+designationCategory.getCategoryName());
        
        }
        return this.designationNameList;
    }

    public void setDesignationNameList(List<String> designationNameList) {
        this.designationNameList = designationNameList;
    }
       
               
}