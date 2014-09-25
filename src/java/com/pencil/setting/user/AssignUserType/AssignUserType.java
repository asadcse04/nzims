/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.user.AssignUserType;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class AssignUserType implements Serializable {

    private int teacherID;

    private String teacherName;

    private String gender;

    private String contactNo;
    
    private String UserName;
    
    private String password;

    private String userType;
    
    private String userTypeCode;

    private String note;

    public AssignUserType() {
    }

    public AssignUserType(int teacherID, String teacherName, String gender, String contactNo) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.gender = gender;
        this.contactNo = contactNo;
        
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
        return UserName = String.valueOf(teacherID);
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
