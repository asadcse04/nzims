/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Fee;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jahangiralamdiu
 */
public class Fee implements Serializable {
    
   
    private int studentfeeid;

    private int acyearid;
    
    private int feeID;
    
    private String feeName;
    
    private List<String> subHeadNameList;

   
    public Fee() {
    
    }
    
    
    

    public Fee(int studentfeeid, int acyearid, int feeID, List<String> subHeadNameList, String feeName) {
        this.studentfeeid = studentfeeid;
        this.acyearid = acyearid;
        this.feeID = feeID;
        this.subHeadNameList = subHeadNameList;
        this.feeName = feeName;
    }
    
   
    
    
 

    public int getFeeID() {
        return feeID;
    }

    public void setFeeID(int feeID) {
        this.feeID = feeID;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public List<String> getSubHeadNameList() {
        return subHeadNameList;
    }

    public void setSubHeadNameList(List<String> subHeadNameList) {
        this.subHeadNameList = subHeadNameList;
    }

    /**
     * @return the studentfeeid
     */
    public int getStudentfeeid() {
        return studentfeeid;
    }

    /**
     * @param studentfeeid the studentfeeid to set
     */
    public void setStudentfeeid(int studentfeeid) {
        this.studentfeeid = studentfeeid;
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
