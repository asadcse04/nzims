/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Department;

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
public class DepartmentController implements Serializable
{
    private Department department;
    
    private List<Department> departmentData;
    
    DepartmentService serviceDao=new DepartmentServiceImpl();

    /**
     * Creates a new instance of DepartmentController
     */
    public DepartmentController()
    {
        this.departmentData=serviceDao.departmentList();
    }
    
    public void insertDepartment()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.createDepartment(this.department))
        {
            this.departmentData=serviceDao.departmentList();
            
            this.department=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert department info."));  
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert department info!",""));
        }
    }
    
    public void editDepartment()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateDepartment(this.department))
        {
            this.departmentData=serviceDao.departmentList();
            
            this.department=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update department info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update department info!",""));
        } 
    }

    /**
     * @return the department
     */
    public Department getDepartment()
    {
        if(this.department==null)
        {
            this.department=new Department();
        }
        return this.department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return the departmentData
     */
    public List<Department> getDepartmentData() {
        return departmentData;
    }

    /**
     * @param departmentData the departmentData to set
     */
    public void setDepartmentData(List<Department> departmentData) {
        this.departmentData = departmentData;
    }
}
