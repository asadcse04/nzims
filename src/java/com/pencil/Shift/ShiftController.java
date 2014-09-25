/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Shift;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
@ViewScoped
public class ShiftController implements Serializable
{
    private Shift shift;
    
    private List<Shift> shiftData;

    ShiftService shifDao = new ShiftServiceImpl();
    
    
    
    public ShiftController()
    {
        this.shiftData=shifDao.shiftList();
    }
    
    

    public void insertShift()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(shifDao.createShift(this.shift))
        {
            this.shiftData=shifDao.shiftList();
            
            this.shift=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert shift info."));  
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert shift info!",""));
        }
    }
    
    public void editShift()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(shifDao.updateShift(this.shift))
        {
            this.shiftData=shifDao.shiftList();
            
            this.shift=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update shift info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update shift!",""));
        } 
    }
    /**
     * @return the shift
     */
    public Shift getShift()
    {
        if(this.shift==null)
        {
            this.shift=new Shift();
        }
        return this.shift;
    }

    /**
     * @param shift the shift to set
     */
    public void setShift(Shift shift) {
        this.shift = shift;
    }

    /**
     * @return the shiftData
     */
    public List<Shift> getShiftData() {
        return shiftData;
    }

    /**
     * @param shiftData the shiftData to set
     */
    public void setShiftData(List<Shift> shiftData) {
        this.shiftData = shiftData;
    }
}
