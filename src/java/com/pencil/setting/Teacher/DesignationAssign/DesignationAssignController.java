/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.Teacher.DesignationAssign;

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
public class DesignationAssignController implements Serializable {

    private DesignationAssign designationAssign;

    private List<DesignationAssign> designationAssignList;

    private List<DesignationAssign> teacherList;

    private List<String> DesignationList;

    private List<String> categoryList;

    DesignationAssignService dao = new DesignationAssignServiceImpl();

    public DesignationAssignController() {

        this.teacherList = dao.teacherList();

        this.categoryList = dao.categoryList();
    }

    public void insertDesignation() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.AddDesignation(this.designationAssign)) {

            this.designationAssign = null;

            context.addMessage(null, new FacesMessage("Successful", "Insert information."));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert info!", ""));
        }
    }

    public void designationName_List() {
        this.DesignationList = dao.designationList(this.designationAssign.getCategoryName());
    }

    public DesignationAssign getDesignationAssign() {
        if (this.designationAssign == null) {

            this.designationAssign = new DesignationAssign();
        }
        return this.designationAssign;
    }

    public void setDesignationAssign(DesignationAssign designationAssign) {
        this.designationAssign = designationAssign;
    }

    public List<DesignationAssign> getDesignationAssignList() {
        return designationAssignList;
    }

    public void setDesignationAssignList(List<DesignationAssign> designationAssignList) {
        this.designationAssignList = designationAssignList;
    }

    public List<DesignationAssign> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<DesignationAssign> teacherList) {
        this.teacherList = teacherList;
    }

    public List<String> getDesignationList() {
        return DesignationList;
    }

    public void setDesignationList(List<String> DesignationList) {
        this.DesignationList = DesignationList;
    }

    public List<String> getCategoryList() {

        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

}
