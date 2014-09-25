/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.MainHead;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class MainHead implements Serializable
{
    private int trMainHeadID;
    
    private String mainHeadName;
    
    private String note;
    
    private String trCatagoryName;
    
    private Date createDate;
    
    private int userID;
    
    private String trType;

    public MainHead()
    {
        
    }

    public MainHead(int trMainHeadID, String mainHeadName, String note, String trCatagoryName, Date createDate, int userID)
    {
        this.trMainHeadID = trMainHeadID;
        this.mainHeadName = mainHeadName;
        this.note = note;
        this.trCatagoryName = trCatagoryName;
        this.createDate = createDate;
        this.userID = userID;
    }

    public int getTrMainHeadID() {
        return trMainHeadID;
    }

    public void setTrMainHeadID(int trMainHeadID) {
        this.trMainHeadID = trMainHeadID;
    }

    public String getMainHeadName() {
        return mainHeadName;
    }

    public void setMainHeadName(String mainHeadName) {
        this.mainHeadName = mainHeadName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTrCatagoryName() {
        return trCatagoryName;
    }

    public void setTrCatagoryName(String trCatagoryName) {
        this.trCatagoryName = trCatagoryName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTrType() {
        return trType;
    }

    public void setTrType(String trType) {
        this.trType = trType;
    }
    
    
}
