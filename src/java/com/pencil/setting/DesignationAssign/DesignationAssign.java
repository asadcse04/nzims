/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.DesignationAssign;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class DesignationAssign implements Serializable{

    private String categoryName;

    private String designationName;

    private int designationID;

    private int teacherID;

    private String teacherName;

    private String gender;

    private String contactNo;

    private String note;

    public DesignationAssign() {
    }

    public DesignationAssign(int teacherID, String teacherName, String gender, String contactNo) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.gender = gender;
        this.contactNo = contactNo;
    }
    
    public DesignationAssign(String categoryName, String designationName, int designationID, int teacherID, String teacherName, String gender, String contactNo, String note) {
        this.categoryName = categoryName;
        this.designationName = designationName;
        this.designationID = designationID;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.gender = gender;
        this.contactNo = contactNo;
        this.note = note;
    }

    

    public int getDesignationID() {
        return designationID;
    }

    public void setDesignationID(int designationID) {
        this.designationID = designationID;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

}
