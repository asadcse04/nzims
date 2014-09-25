/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.Stuff.DesignationAssign;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class DesignationAssign implements Serializable{

    private String categoryName;

    private String designationName;

    private int designationID;

    private int stuffID;

    private String stuffName;

    private String gender;

    private String contactNo;

    private String note;

    public DesignationAssign() {
    }

    public DesignationAssign(int stuffID, String stuffName, String gender, String contactNo) {
        this.stuffID = stuffID;
        this.stuffName = stuffName;
        this.gender = gender;
        this.contactNo = contactNo;
    }

    public DesignationAssign(String categoryName, String designationName, int designationID, int stuffID, String stuffName, String gender, String contactNo, String note) {
        this.categoryName = categoryName;
        this.designationName = designationName;
        this.designationID = designationID;
        this.stuffID = stuffID;
        this.stuffName = stuffName;
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
