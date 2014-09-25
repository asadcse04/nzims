/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.AttendenceSmsTemplate;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class AttendenceSmsTemplate implements Serializable{
    
    private int id;
    private String message;
    private String instituteID;

    public AttendenceSmsTemplate() {
    }

    
    public AttendenceSmsTemplate(int id, String message, String instituteID) {
        this.id = id;
        this.message = message;
        this.instituteID = instituteID;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }
    

}
