/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Period;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class PeriodController implements Serializable
{
    private Period period;
    
    private List<Period> periodData;
    
    private List<String> shiftNameData;
    
    PeriodService serviceDao=new PeriodServiceImpl();

    /**
     * Creates a new instance of PeriodController
     */
    public PeriodController()
    {
        this.shiftNameData=serviceDao.shiftNameList();
        
        this.periodData=serviceDao.periodList();
    }
    
    public void insertPeriod()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.createPeriod(this.period))
        {
            this.periodData=serviceDao.periodList();
            
            this.period=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert period info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert period info!",""));
        }
    }
    
    public void editPeriod()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updatePeriod(this.period))
        {
            this.periodData=serviceDao.periodList();
            
            this.period=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert period info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert period info!",""));
        }
    }

    /**
     * @return the period
     */
    public Period getPeriod()
    {
        if(this.period==null)
        {
            this.period=new Period();
        }
        return this.period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(Period period) {
        this.period = period;
    }

    /**
     * @return the periodData
     */
    public List<Period> getPeriodData() {
        return periodData;
    }

    /**
     * @param periodData the periodData to set
     */
    public void setPeriodData(List<Period> periodData) {
        this.periodData = periodData;
    }

    /**
     * @return the shiftNameData
     */
    public List<String> getShiftNameData() {
        return shiftNameData;
    }

    /**
     * @param shiftNameData the shiftNameData to set
     */
    public void setShiftNameData(List<String> shiftNameData) {
        this.shiftNameData = shiftNameData;
    }
}
