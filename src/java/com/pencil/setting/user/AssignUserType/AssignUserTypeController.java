/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.user.AssignUserType;

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
public class AssignUserTypeController {

    private String rePassword;

    private AssignUserType assignUserType;

    private List<AssignUserType> userTypeList;

    AssignUserTypeService dao = new AssignUserTypeServiceImpl();
    
/////////////////////////////////////////////////////////////
    public void insertUserType()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.addUserType(this.assignUserType)) {
            this.userTypeList = dao.userList();

            this.assignUserType = null;

            context.addMessage(null, new FacesMessage("Successful", "Insert information."));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert info!", ""));
        }
    }
/////////////////////////////////////////////////////////////////
    
////////////////////////////////////////////////////////////////////
    public AssignUserTypeController() {
        this.userTypeList = dao.userList();
    }

    public AssignUserType getAssignUserType() {
        if (this.assignUserType == null) {
            this.assignUserType = new AssignUserType();
        }
        return assignUserType;
    }

    public void setAssignUserType(AssignUserType assignUserType) {
        this.assignUserType = assignUserType;
    }

    public List<AssignUserType> getUserTypeList() {
        return userTypeList;
    }

    public void setUserTypeList(List<AssignUserType> userTypeList) {
        this.userTypeList = userTypeList;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

}
