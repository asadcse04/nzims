/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Subject;

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
public class SubjectController implements Serializable
{
    private Subject subject;
     
    private List<Subject> sbjList;
    
    SubjectService serviceDao= new SubjectServiceImpl() ;

    /**
     * Creates a new instance of SubjectController
     */
    public SubjectController()
    {
        this.sbjList= serviceDao.subjectList();
    }
    
    public void insertSubject()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.createSubject(this.subject))
        {
            this.sbjList=serviceDao.subjectList();
            
            this.subject=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert subject info."));  
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert subject info!",""));
        }
    }
    
    
    public void editSubject()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateSubject(this.subject))
        {
            this.sbjList=serviceDao.subjectList();
            
            this.subject=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update subject info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update subject info!",""));
        } 
    }

    /**
     * @return the subject
     */
    public Subject getSubject()
    {
        if(this.subject==null)
        {
            this.subject=new Subject();
        }
        return this.subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the sbjList
     */
    public List<Subject> getSbjList() {
        return sbjList;
    }

    /**
     * @param sbjList the sbjList to set
     */
    public void setSbjList(List<Subject> sbjList) {
        this.sbjList = sbjList;
    }
}
