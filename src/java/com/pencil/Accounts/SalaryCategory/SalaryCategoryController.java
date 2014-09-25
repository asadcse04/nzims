/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SalaryCategory;

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
public class SalaryCategoryController {
 
    private SalaryCategory salaryCategory;
    
    private List<SalaryCategory> salaryCategoryList;
    
    SalaryCategoryService serviceDao = new SalaryCategoryServiceImpl();

    /**
     * Creates a new instance of FeeCategoryController
     */
    public SalaryCategoryController() {
    }
    
    public void createSalary() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addSalaryCategory(this.salaryCategory))
        {
            context.addMessage(null, new FacesMessage("Successful", "Salary Category Added"));
            
            this.salaryCategory=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Salary Category is not added"));
        }
        
    }

    public SalaryCategory getSalaryCategory() 
    {
        if(this.salaryCategory==null)
        {
            this.salaryCategory=new SalaryCategory();
        }
        return salaryCategory;
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        this.salaryCategory = salaryCategory;
    }

    public List<SalaryCategory> getSalaryCategoryList() 
    {
        this.salaryCategoryList=serviceDao.getAllSalaryCategory();
        return this.salaryCategoryList;
    }

    public void setSalaryCategoryList(List<SalaryCategory> salaryCategoryList) {
        this.salaryCategoryList = salaryCategoryList;
    }
    
    
    
    
}
