/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SubFeeHead;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean

@ViewScoped

/**
 *
 * @author Mamun
 */
public class SubFeeHeadController {
    
    private SubFeeHead subFeeHead;
    
    private List<SubFeeHead> subFeeHeadList;
    
    SubFeeHeadService serviceDao = new SubFeeHeadServiceImpl();

    public SubFeeHeadController() {
    }
    
    public void addSubFeeHead() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addSubFeeHead(this.subFeeHead))
        {
            context.addMessage(null, new FacesMessage("Successful", "Month Configuration Added"));
            
            this.subFeeHead=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Month Configuration is not added"));
        }
    }

    public SubFeeHead getSubFeeHead() {
        
        if(this.subFeeHead==null) 
        {
            this.subFeeHead = new SubFeeHead();
        }
        
        return subFeeHead;
    }

    public void setSubFeeHead(SubFeeHead subFeeHead) {
        this.subFeeHead = subFeeHead;
    }

    public List<SubFeeHead> getSubFeeHeadList() 
    {
        this.subFeeHeadList = serviceDao.getAllSubFeeHead();
        
        return subFeeHeadList;
    }

    public void setSubFeeHeadList(List<SubFeeHead> subFeeHeadList) {
        this.subFeeHeadList = subFeeHeadList;
    }
    
    
    
    
    
}
