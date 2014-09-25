/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login.PasswordChange;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG.SQ
 */
@ManagedBean
@ViewScoped

public class PasswordChangeController {

    private PasswordChange passwordChange;

    private List<String> currentPass;

    private String currenPass = "true";

    PasswordChangeService dao = new PasswordChangeServiceImpl();

    public PasswordChangeController() {

    }

    public void upPassword() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.updatePassword(passwordChange)) {

            context.addMessage(null, new FacesMessage("Successful", "Password is Updated"));

            this.passwordChange = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Password is not Updated"));
        }

    }

    public void checkPass() {
        if (dao.currentPassword(passwordChange)) {
            this.currenPass = "false";
        } else {
            this.currenPass = "true";
        }

    }

    public PasswordChange getPasswordChange() {
        if (this.passwordChange == null) {
            this.passwordChange = new PasswordChange();
        }
        return passwordChange;
    }

    public void setPasswordChange(PasswordChange passwordChange) {
        this.passwordChange = passwordChange;
    }

    public List<String> getCurrentPass() {
        return currentPass;
    }

    public void setCurrentPass(List<String> currentPass) {
        this.currentPass = currentPass;
    }

    public String getCurrenPass() {
        return currenPass;
    }

    public void setCurrenPass(String currenPass) {
        this.currenPass = currenPass;
    }

}
