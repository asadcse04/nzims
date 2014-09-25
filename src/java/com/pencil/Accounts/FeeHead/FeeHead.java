/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeHead;

import java.io.Serializable;

/**
 *
 * @author Mamun
 */
public class FeeHead implements Serializable {
    
    private int feeHeadID;
    
    private String feeHeadName;
    
    private String printName;
    
    private String note;
    
    private int feeCategoryID;

    public FeeHead() {
    }

    public FeeHead(int feeHeadID, String feeHeadName, String printName, String note, int feeCategoryID) {
        this.feeHeadID = feeHeadID;
        this.feeHeadName = feeHeadName;
        this.printName = printName;
        this.note = note;
        this.feeCategoryID = feeCategoryID;
    }
    
    

    public int getFeeHeadID() {
        return feeHeadID;
    }

    public void setFeeHeadID(int feeHeadID) {
        this.feeHeadID = feeHeadID;
    }

    public String getFeeHeadName() {
        return feeHeadName;
    }

    public void setFeeHeadName(String feeHeadName) {
        this.feeHeadName = feeHeadName;
    }

    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFeeCategoryID() {
        return feeCategoryID;
    }

    public void setFeeCategoryID(int feeCategoryID) {
        this.feeCategoryID = feeCategoryID;
    }
    
       
}
