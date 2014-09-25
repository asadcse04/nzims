/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.BankGroup;

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
public class BankGroupController {
    
    private BankGroup bankGroup;
    
    private List<BankGroup> bankGroupList;
    
    BankGroupService serviceDao = new BankGroupServiceImpl();

    public BankGroupController() {
    }
    
    public void addBankGroup() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addBankGroup(this.bankGroup))
        {
            context.addMessage(null, new FacesMessage("Successful", "Bank Group Added"));
            
            this.bankGroup=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Bank Group is not added"));
        }
    }

    public BankGroup getBankGroup() {
        
        if(this.bankGroup==null) 
        {
            this.bankGroup = new BankGroup();
        }
        
        return bankGroup;
    }

    public void setBankGroup(BankGroup bankGroup) {
        this.bankGroup = bankGroup;
    }

    public List<BankGroup> getBankGroupList() 
    {
        this.bankGroupList = serviceDao.getAllBankGroup();
        
        return bankGroupList;
    }

    public void setBankGroupList(List<BankGroup> bankGroupList) {
        this.bankGroupList = bankGroupList;
    }
    
    
    
    
    
}
