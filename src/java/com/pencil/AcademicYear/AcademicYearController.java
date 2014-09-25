/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.AcademicYear;

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
public class AcademicYearController implements Serializable
{
    private AcademicYear AcYr;
    
    private List<AcademicYear> AcYrList;
    
    AcYrService serviceDao=new AcYrServiceImpl();
    

    /**
     * Creates a new instance of AcademicYearController
     */
    public AcademicYearController() 
    {
        this.AcYrList=serviceDao.academicYrList();
    }
    
    public void insertAcYr()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.createAcYr(this.AcYr))
        {
            this.AcYrList=serviceDao.academicYrList();
            
            this.AcYr=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert academic year info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert academic year!",""));
        }
    }
    
    public void editAcyr()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateAcYr(this.AcYr))
        {
            this.AcYrList=serviceDao.academicYrList();
            
            this.AcYr=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update academic year info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update academic year!",""));
        } 
    }

    /**
     * @return the AcYr
     */
    public AcademicYear getAcYr() 
    {
        if(this.AcYr==null)
        {
            this.AcYr=new AcademicYear();
        }
        return this.AcYr;
    }

    /**
     * @param AcYr the AcYr to set
     */
    public void setAcYr(AcademicYear AcYr) {
        this.AcYr = AcYr;
    }

    /**
     * @return the AcYrList
     */
    public List<AcademicYear> getAcYrList() {
        return AcYrList;
    }

    /**
     * @param AcYrList the AcYrList to set
     */
    public void setAcYrList(List<AcademicYear> AcYrList) {
        this.AcYrList = AcYrList;
    }
}
