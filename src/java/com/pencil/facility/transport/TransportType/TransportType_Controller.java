/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.TransportType;

import java.io.Serializable;
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

public class TransportType_Controller implements Serializable{
    
    private TransportType transportType;
    
    private List<TransportType> transportTypeList;
    
    TransportType_Service dao = new TransportType_Service_Impl();

    public TransportType_Controller() {
        
        this.transportTypeList = dao.transportList();
    }
    
    ////////////////////////////////////////
    
    public void insertTransportType()
            
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(dao.createTransportType(this.transportType))
        {
            this.transportTypeList = dao.transportList();
            
            this.transportType=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert information."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert info!",""));
        }
    }
    
    ////////////////////////////////////////
    
    public void updateTransportType()
            
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(dao.updateTransportType(this.transportType))
        {
            this.transportTypeList = dao.transportList();
            
            this.transportType=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update information."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update info!",""));
        }
    }
    
    ////////////////////////////////////////
    
    public TransportType getTransportType() {
        
        if(this.transportType==null){
            
          this.transportType=new TransportType();
        }
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public List<TransportType> getTransportTypeList() {
        return transportTypeList;
    }

    public void setTransportTypeList(List<TransportType> transportTypeList) {
        this.transportTypeList = transportTypeList;
    }
    
    
}
