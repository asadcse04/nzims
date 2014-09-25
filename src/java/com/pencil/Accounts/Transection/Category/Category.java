/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Category;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mastermind
 */
public class Category implements Serializable
{
    private int trCatagoryID;
    
    private String trCatagoryName;
    
    private String note;
    
    private String trType;
    
    private Date createDate;
    
    private int userID;

    public Category() 
    {
        
    }

    public Category(int trCatagoryID, String trCatagoryName, String note, String trType, Date createDate, int userID) {
        this.trCatagoryID = trCatagoryID;
        this.trCatagoryName = trCatagoryName;
        this.note = note;
        this.trType = trType;
        this.createDate = createDate;
        this.userID = userID;
    }

    public int getTrCatagoryID() {
        return trCatagoryID;
    }

    public void setTrCatagoryID(int trCatagoryID) {
        this.trCatagoryID = trCatagoryID;
    }

    public String getTrCatagoryName() {
        return trCatagoryName;
    }

    public void setTrCatagoryName(String trCatagoryName) {
        this.trCatagoryName = trCatagoryName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTrType() {
        return trType;
    }

    public void setTrType(String trType) {
        this.trType = trType;
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
    
    
}
