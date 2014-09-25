/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SubSalaryHead;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class SubSalaryHead implements Serializable {
    
    private int subSalaryHeadID;
    
    private String subSalaryHeadName;
    
    private String note;

   
    public SubSalaryHead() {
    }   

    
    public SubSalaryHead(int subSalaryHeadID, String subSalaryHeadName, String note) {
        
        this.subSalaryHeadID = subSalaryHeadID;
        
        this.subSalaryHeadName = subSalaryHeadName;
        
        this.note = note;
    }
    /**
     * @return the subSalaryHeadID
     */
    public int getSubSalaryHeadID() {
        return subSalaryHeadID;
    }

    /**
     * @param subSalaryHeadID the subSalaryHeadID to set
     */
    public void setSubSalaryHeadID(int subSalaryHeadID) {
        this.subSalaryHeadID = subSalaryHeadID;
    }

    /**
     * @return the subSalaryHeadName
     */
    public String getSubSalaryHeadName() {
        return subSalaryHeadName;
    }

    /**
     * @param subSalaryHeadName the subSalaryHeadName to set
     */
    public void setSubSalaryHeadName(String subSalaryHeadName) {
        this.subSalaryHeadName = subSalaryHeadName;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

}
