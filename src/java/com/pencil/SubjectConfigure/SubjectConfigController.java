/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SubjectConfigure;

import com.pencil.Presentation.Presentation;
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
public class SubjectConfigController implements Serializable
{
    private SubjectConfig subject_config;
    
    
    private List<String> academicYearList;
    
    private List<String> schoolClassList;
    
    private List<String> departmentList;
    
    private List<String> sbjList;
    
    
    SubjectConfigService serviceDao=new SubjectConfigService_Impl();
    
    Presentation pr=new Presentation();

    /**
     * Creates a new instance of SubjectConfigController
     */
    public SubjectConfigController()
    {
        this.academicYearList=pr.infoList("acyr");
        
        this.schoolClassList=pr.infoList("Scl_class");
        
        this.departmentList=pr.infoList("dept");
        
        this.sbjList=pr.infoList("subject");
    }

    /**
     *
     */
    public void saveConfig()
    {
        if(serviceDao.saveSubjectConfig(this.subject_config))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully save subject configuration."));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to save subject configuration."));
        }
    }

    /**
     * @return the subject_config
     */
    public SubjectConfig getSubject_config()
    {
        if(this.subject_config==null)
        {
            this.subject_config=new SubjectConfig();
        }
        return this.subject_config;
    }

    /**
     * @param subject_config the subject_config to set
     */
    public void setSubject_config(SubjectConfig subject_config) {
        this.subject_config = subject_config;
    }

    /**
     * @return the schoolClassList
     */
    public List<String> getSchoolClassList() {
        return schoolClassList;
    }

    /**
     * @param schoolClassList the schoolClassList to set
     */
    public void setSchoolClassList(List<String> schoolClassList) {
        this.schoolClassList = schoolClassList;
    }

    /**
     * @return the departmentList
     */
    public List<String> getDepartmentList() {
        return departmentList;
    }

    /**
     * @param departmentList the departmentList to set
     */
    public void setDepartmentList(List<String> departmentList) {
        this.departmentList = departmentList;
    }

    /**
     * @return the academicYearList
     */
    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    /**
     * @param academicYearList the academicYearList to set
     */
    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }

    /**
     * @return the sbjList
     */
    public List<String> getSbjList() {
        return sbjList;
    }

    /**
     * @param sbjList the sbjList to set
     */
    public void setSbjList(List<String> sbjList) {
        this.sbjList = sbjList;
    }

}
