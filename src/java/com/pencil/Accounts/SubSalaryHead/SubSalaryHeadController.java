/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SubSalaryHead;

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
public class SubSalaryHeadController {

    private SubSalaryHead subSalaryHead;
    
    private List<SubSalaryHead> subSalaryHeadList;
    
    SubSalaryHeadService serviceDao = new SubSalaryHeadServiceImpl();

    public SubSalaryHeadController() {
    }
    
    public void addSubSalaryHead() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addSubSalaryHead(this.subSalaryHead))
        {
            context.addMessage(null, new FacesMessage("Successful", "Salary Sub head Added"));
            
            this.subSalaryHead=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Salary Sub-head is not added"));
        }
    }

    public SubSalaryHead getSubSalaryHead() {
        
        if(this.subSalaryHead==null) 
        {
            this.subSalaryHead = new SubSalaryHead();
        }
        
        return subSalaryHead;
    }

    
    public void setSubSalaryHead(SubSalaryHead subSalaryHead) 
    {
        
        this.subSalaryHead = subSalaryHead;
    }

    
    public List<SubSalaryHead> getSubSalaryHeadList() 
    {
        this.subSalaryHeadList = serviceDao.getAllSubSalaryHead();
        
        return subSalaryHeadList;
    }

    
    public void setSubSalaryHeadList(List<SubSalaryHead> subSalaryHeadList) 
    {
        this.subSalaryHeadList = subSalaryHeadList;
    }
    
    
    
    
    
    
}
