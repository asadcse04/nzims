/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SHOHUG-SQ
 */
public class Stuff_Reg implements Serializable{
   
    private int stuffID;
    
    private String name;
    
    private String gender;
    
    private Date dob;
    
    private String fatherName;
    
    private String motherName;
    
    private String qualification;
    
    private String passedFrom;
     

    private String bloodGroup;
    
    private String maritalStatus;
    
    private String religion;
    
    private String imgPath;
        
    private String contactNo;
    
    private String email;
    
    private String presentAddress;
    
    private String permanentAddress; 

    public Stuff_Reg() 
    {
        
    }

    public Stuff_Reg(int stuffID, String name, String gender, Date dob, String fatherName, String motherName, String qualification, String passedFrom, String bloodGroup, String maritalStatus, String religion, String imgPath, String contactNo, String email, String presentAddress, String permanentAddress) 
    {
        this.stuffID = stuffID;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.qualification = qualification;
        this.passedFrom = passedFrom;
        this.bloodGroup = bloodGroup;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.imgPath = imgPath;
        this.contactNo = contactNo;
        this.email = email;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
    }
    
    /**
     * @return the stuffID
     */
    public int getStuffID() {
        return stuffID;
    }

    /**
     * @param stuffID the othersID to set
     */
    public void setStuffID(int stuffID) {
        this.stuffID = stuffID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName the motherName to set
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the passedFrom
     */
    public String getPassedFrom() {
        return passedFrom;
    }

    /**
     * @param passedFrom the passedFrom to set
     */
    public void setPassedFrom(String passedFrom) {
        this.passedFrom = passedFrom;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the religion
     */
    public String getReligion() {
        return religion;
    }

    /**
     * @param religion the religion to set
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the presentAddress
     */
    public String getPresentAddress() {
        return presentAddress;
    }

    /**
     * @param presentAddress the presentAddress to set
     */
    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    /**
     * @return the permanentAddress
     */
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * @param permanentAddress the permanentAddress to set
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
    
    
}
