/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.SubHead;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class SubHead implements Serializable
{
    private int trSubHeadID;
    
    private String subHeadName;
    
    private String note;
    
    private String trMainHeadName;
    
    private Date createDate;
    
    private int userID;
    
    private String trType;
    
    private String trCategoryName;

    public SubHead()
    {
        
    }

    public SubHead(int trSubHeadID, String subHeadName, String note, String trMainHeadName, Date createDate, int userID) {
        this.trSubHeadID = trSubHeadID;
        this.subHeadName = subHeadName;
        this.note = note;
        this.trMainHeadName = trMainHeadName;
        this.createDate = createDate;
        this.userID = userID;
    }

    public int getTrSubHeadID() {
        return trSubHeadID;
    }

    public void setTrSubHeadID(int trSubHeadID) {
        this.trSubHeadID = trSubHeadID;
    }

    public String getSubHeadName() {
        return subHeadName;
    }

    public void setSubHeadName(String subHeadName) {
        this.subHeadName = subHeadName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTrMainHeadName() {
        return trMainHeadName;
    }

    public void setTrMainHeadName(String trMainHeadName) {
        this.trMainHeadName = trMainHeadName;
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

    public String getTrCategoryName() {
        return trCategoryName;
    }

    public void setTrCategoryName(String trCategoryName) {
        this.trCategoryName = trCategoryName;
    }
    
    
}
