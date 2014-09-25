/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass;

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
public class SchoolClassController implements Serializable
{
    private SchoolClass school_class;
    
    private List<SchoolClass> class_List;
    
    SchoolClass_Service ClassServiceDao = new SchoolClass_Service_Impl();
    
    /**
     * Creates a new instance of SchoolClassController
     */
    public SchoolClassController() 
    {
        this.class_List = ClassServiceDao.schoolclassList();
    }
    
    public void insertClass()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(ClassServiceDao.createSchoolClass(this.school_class))
        {
            this.class_List=ClassServiceDao.schoolclassList();
            
            this.school_class=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert class information."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert class info!",""));
        }
    }
    
    public void editSchoolClass()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(ClassServiceDao.updateSchoolClass(this.school_class))
        {
            this.class_List=ClassServiceDao.schoolclassList();
            
            this.school_class=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update class info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update class info!",""));
        } 
    }

    /**
     * @return the school_class
     */
    public SchoolClass getSchool_class()
    {
        if(this.school_class==null)
        {
            this.school_class=new SchoolClass();
        }
        
        return this.school_class;
    }

    /**
     * @param school_class the school_class to set
     */
    public void setSchool_class(SchoolClass school_class)
    {
        this.school_class = school_class;
    }

    /**
     * @return the class_List
     */
    public List<SchoolClass> getClass_List()
    {
        return class_List;
    }

    /**
     * @param class_List the class_List to set
     */
    public void setClass_List(List<SchoolClass> class_List)
    {
        this.class_List = class_List;
    }
}
