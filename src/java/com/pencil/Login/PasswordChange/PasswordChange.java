/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Login.PasswordChange;

import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG.SQ
 */
public class PasswordChange implements Serializable{
    
   
    
    private String userID, currentPassword, repetPass;

    public PasswordChange() {
    }

    public PasswordChange(String currentPassword) {
        this.currentPassword = currentPassword;
    }
    
    

    public String getUserID() {
        FacesContext context=FacesContext.getCurrentInstance();
        userID=context.getExternalContext().getSessionMap().get("UserID").toString();
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getRepetPass() {
        return repetPass;
    }

    public void setRepetPass(String repetPass) {
        this.repetPass = repetPass;
    }
    
    
    
}
