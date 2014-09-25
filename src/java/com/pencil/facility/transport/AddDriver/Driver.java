/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddDriver;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class Driver implements Serializable{
    
    private int driverID;
    
    private String driverName;
    
    private String fatherName;
    
    private String motherName;
    
    private String nationalID;
    
    private String qualification;
    
    private String maritalStatus;
    
    private String religion;
    
    private String contactNo;
    
    private String presentAddress;
    
    private String permanentAddress;
    
    private String attachePapper;
    
    private String note;
    
    private String image;

    public Driver() {
    }

    public Driver(int driverID, String driverName, String fatherName, String motherName, String nationalID, String qualification, String maritalStatus, String religion, String contactNo, String presentAddress, String permanentAddress, String attachePapper, String note, String image) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.nationalID = nationalID;
        this.qualification = qualification;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.contactNo = contactNo;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.attachePapper = attachePapper;
        this.note = note;
        this.image = image;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getAttachePapper() {
        return attachePapper;
    }

    public void setAttachePapper(String attachePapper) {
        this.attachePapper = attachePapper;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
   
}
