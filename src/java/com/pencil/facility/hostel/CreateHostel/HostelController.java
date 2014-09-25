/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.hostel.CreateHostel;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG-SQ
 */
@ManagedBean
@ViewScoped
public class HostelController {
     private Hostel hostel;
    
    private List<Hostel> hostelAllList;
    
    HostelService serviceDao = new HostelServiceImpl(); 

    
    public HostelController() 
    {
       this.hostelAllList=serviceDao.getAllHostel(); 
    }

    
      public void addHostel() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addHostel(this.hostel))
        {
            context.addMessage(null, new FacesMessage("Successful", "Hostel List Added"));
            
            this.hostel=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Hostel List is not added"));
        }
        
    }
     
      
      public void updateHostel() 
    
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateHostel( this.hostel))
        {
            context.addMessage(null, new FacesMessage("Successful", "Hostel List Updated"));
            
            this.hostel=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Hostel List is not updated"));
        }
        
    }
    
    /**
     * @return the hostel
     */
    public Hostel getHostel() {
        if(this.hostel==null)
        {
            this.hostel=new Hostel();
        }
      
        return hostel;
    }

    /**
     * @param hostel the hostel to set
     */
    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    /**
     * @return the hostelAllList
     */
    public List<Hostel> getHostelAllList() {
        this.hostelAllList=serviceDao.getAllHostel();
        return this.hostelAllList;
       
    }

    /**
     * @param hostelAllList the hostelAllList to set
     */
    public void setHostelAllList(List<Hostel> hostelAllList) {
        this.hostelAllList = hostelAllList;
    }

   
    }
    
    

