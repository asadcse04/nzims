/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.user.AssignStuffType;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class AssignStuffType implements Serializable {

    private int stuffID;

    private String stuffName;

    private String gender;

    private String contactNo;

    private String UserName;
    
    private String password;

    private String userType;
    
    private String userTypeCode;

    private String note;

    public AssignStuffType() {
    }

    public AssignStuffType(int stuffID, String stuffName, String gender, String contactNo) {
        this.stuffID = stuffID;
        this.stuffName = stuffName;
        this.gender = gender;
        this.contactNo = contactNo;
        
    }

    public int getStuffID() {
        return stuffID;
    }

    public void setStuffID(int stuffID) {
        this.stuffID = stuffID;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return UserName=String.valueOf(stuffID);
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
