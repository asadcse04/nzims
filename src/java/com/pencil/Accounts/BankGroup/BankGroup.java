/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.BankGroup;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class BankGroup implements Serializable {
 
    private int bankGroupID;
    
    private String bankGroupName;
    
    private String note;
    
    public BankGroup(){
        
    }

    
    public BankGroup(int bankGroupID,String bankGroupName,String note){
      this.bankGroupID=bankGroupID;
      this.bankGroupName=bankGroupName;
      this.note=note;
    }
    
    
    /**
     * @return the bankGroupID
     */
    public int getBankGroupID() {
        return bankGroupID;
    }

    /**
     * @param bankGroupID the bankGroupID to set
     */
    public void setBankGroupID(int bankGroupID) {
        this.bankGroupID = bankGroupID;
    }

    /**
     * @return the bankGroupName
     */
    public String getBankGroupName() {
        return bankGroupName;
    }

    /**
     * @param bankGroupName the bankGroupName to set
     */
    public void setBankGroupName(String bankGroupName) {
        this.bankGroupName = bankGroupName;
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
