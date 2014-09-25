/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SubFeeHead;

import java.io.Serializable;

/**
 *
 * @author Mamun
 */
public class SubFeeHead implements Serializable {
    
    private int subFeeHeadID;
    
    private String subFeeHeadName;
    
    private String note;

    public SubFeeHead() {
    }

    public SubFeeHead(int subFeeHeadID, String subFeeHeadName, String note) {
        this.subFeeHeadID = subFeeHeadID;
        this.subFeeHeadName = subFeeHeadName;
        this.note = note;
    }
    
    

    public int getSubFeeHeadID() {
        return subFeeHeadID;
    }

    public void setSubFeeHeadID(int subFeeHeadID) {
        this.subFeeHeadID = subFeeHeadID;
    }

    public String getSubFeeHeadName() {
        return subFeeHeadName;
    }

    public void setSubFeeHeadName(String subFeeHeadName) {
        this.subFeeHeadName = subFeeHeadName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
