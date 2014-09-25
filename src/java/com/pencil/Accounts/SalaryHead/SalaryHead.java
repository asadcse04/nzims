/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SalaryHead;

import java.io.Serializable;

/**
 *
 * @author Mamun
 */
public class SalaryHead implements Serializable {
    
    private int salaryHeadID;
    
    private String salaryHeadName;
    
   private String note;
    
    private int salaryCategoryID;

    public SalaryHead() {
    }

    public SalaryHead(int salaryHeadID, String salaryHeadName, String note, int salaryCategoryID) {
        this.salaryHeadID = salaryHeadID;
        this.salaryHeadName = salaryHeadName;
        this.note = note;
        this.salaryCategoryID = salaryCategoryID;
    }
    
    

    public int getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setFeeHeadID(int salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public String getSalaryHeadName() {
        return salaryHeadName;
    }

    public void setSalaryHeadName(String salaryHeadName) {
        this.salaryHeadName = salaryHeadName;
    }

   

   

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSalaryCategoryID() {
        return salaryCategoryID;
    }

    public void setSalaryCategoryID(int salaryCategoryID) {
        this.salaryCategoryID = salaryCategoryID;
    }
    
       
}
    

