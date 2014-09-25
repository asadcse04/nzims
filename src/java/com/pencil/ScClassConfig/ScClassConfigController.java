/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig;

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
public class ScClassConfigController implements Serializable
{
    private ScClassConfig classConfig;
    
    private List<ScClassConfig> listClassConfig;
    
    private List<ScClassConfig> filterClassConfig;
    
    
    Presentation pr=new Presentation();
    
    Sc_ClassConfigService serviceDao=new Sc_ClassCofigService_Impl();
    
    
    private List<String> academicYearList;
    
    private List<String> schoolClassList;
    
    private List<String> departmentList;
    
    private List<String> shiftList;
    
    private List<String> sectionList;
    
    private List<String> sc_roomList;
    
    
    /**
     * Creates a new instance of ScClassConfigController
     */
    public ScClassConfigController()
    {
        this.academicYearList=pr.infoList("acyr");
        
        this.shiftList=pr.infoList("shift");
        
        this.sectionList=pr.infoList("section");   
        
        this.sc_roomList=pr.infoList("clsRm");
        
        this.listClassConfig=serviceDao.listScClassConfig();
        
        this.schoolClassList=serviceDao.listScClassGlobal();
         
        this.departmentList=serviceDao.listScDeptGlobal();
    }

    /**
     *
     */
    public void scClass_List()
    {
        this.schoolClassList=serviceDao.listScClass(this.classConfig.getAcyrID());
    }
    
    /**
     *
     */
    public void deptList()
    {
        this.departmentList=serviceDao.listScDept(this.classConfig.getAcyrID(),this.classConfig.getClassName());
    }
    
    /**
     *
     */
    public void insertClassConfig()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.saveScClassConfig(this.classConfig))
        {
            context.addMessage(null, new FacesMessage("Successful","SetUp Class Configuration info."));  
            
            this.listClassConfig=serviceDao.listScClassConfig();
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to setup class configuration!",""));  
        }
    }
    
    
    
        public void updateClassConfig()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateScClassConfig(this.classConfig))
        {
            context.addMessage(null, new FacesMessage("Successful updated","SetUp Class Configuration info."));  
            
            this.listClassConfig=serviceDao.listScClassConfig();
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update class configuration!",""));  
        }
    }
    
    /**
     * @return the classConfig
     */
    public ScClassConfig getClassConfig()
    {
        if(this.classConfig==null)
        {
            this.classConfig=new ScClassConfig();
        }
        return this.classConfig;
    }

    /**
     * @param classConfig the classConfig to set
     */
    public void setClassConfig(ScClassConfig classConfig) {
        this.classConfig = classConfig;
    }

    /**
     * @return the listClassConfig
     */
    public List<ScClassConfig> getListClassConfig() {
        return listClassConfig;
    }

    /**
     * @param listClassConfig the listClassConfig to set
     */
    public void setListClassConfig(List<ScClassConfig> listClassConfig) {
        this.listClassConfig = listClassConfig;
    }

    /**
     * @return the filterClassConfig
     */
    public List<ScClassConfig> getFilterClassConfig() {
        return filterClassConfig;
    }

    /**
     * @param filterClassConfig the filterClassConfig to set
     */
    public void setFilterClassConfig(List<ScClassConfig> filterClassConfig) {
        this.filterClassConfig = filterClassConfig;
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
     * @return the shiftList
     */
    public List<String> getShiftList() {
        return shiftList;
    }

    /**
     * @param shiftList the shiftList to set
     */
    public void setShiftList(List<String> shiftList) {
        this.shiftList = shiftList;
    }

    /**
     * @return the sectionList
     */
    public List<String> getSectionList() {
        return sectionList;
    }

    /**
     * @param sectionList the sectionList to set
     */
    public void setSectionList(List<String> sectionList) {
        this.sectionList = sectionList;
    }

    /**
     * @return the sc_roomList
     */
    public List<String> getSc_roomList() {
        return sc_roomList;
    }

    /**
     * @param sc_roomList the sc_roomList to set
     */
    public void setSc_roomList(List<String> sc_roomList) {
        this.sc_roomList = sc_roomList;
    }
    
}
