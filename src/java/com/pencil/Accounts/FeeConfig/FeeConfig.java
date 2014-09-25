/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeConfig;

import java.io.Serializable;

/**
 *
 * @author jahangiralamdiu
 */
public class FeeConfig implements Serializable{
    
    private int feeConfigID;
    
    private int acyearid;
    
    private int feeHeadID;
        
    private double amount;
    
    private String note;
    
   

    
    public FeeConfig() {
    }



    public int getFeeConfigID() {
        return feeConfigID;
    }

    public void setFeeConfigID(int feeConfigID) {
        this.feeConfigID = feeConfigID;
    }

 

    public int getFeeHeadID() {
        return feeHeadID;
    }

    public void setFeeHeadID(int feeHeadID) {
        this.feeHeadID = feeHeadID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the acyearid
     */
    public int getAcyearid() {
        return acyearid;
    }

    /**
     * @param acyearid the acyearid to set
     */
    public void setAcyearid(int acyearid) {
        this.acyearid = acyearid;
    }

 
    
    
    
}
