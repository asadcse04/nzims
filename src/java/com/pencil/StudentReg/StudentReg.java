/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentReg;

import java.io.Serializable;

/**
 *
 * @author salim
 */
public class StudentReg implements Serializable
{
     //----------------------------------Student Basic(Change By Requirement)--------------------------------------
    
    
    //---------------------------------------Student Basic Info---------------------------------------------------
    
    private String studentID;
    
    private int studentId;
    
    private String studentName;
    
    private int studentRoll;
    
    private String gender;

    
    //-------------------------------------Student GuardianInfo-----------------------------------------------------
    
    private String fatherName;
    
    
    private String guardianContactNo;
    
    private String guardianEmail;
   
   
    //-------------------------------------Student Identification(fixed)-------------------------------------------------------------
    
    private int acyr;
    
    private String deptName;
    
    private String className;
    
    private String shiftName;
    
    private String sectionName;
    
    public StudentReg() {
    }

    public StudentReg(String studentID,String studentName, int studentRoll, String gender, String fatherName, String guardianContactNo) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.gender = gender;
        this.fatherName = fatherName;
        this.guardianContactNo = guardianContactNo;
    }

    
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGuardianContactNo() {
        return guardianContactNo;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setGuardianContactNo(String guardianContactNo) {
        this.guardianContactNo = guardianContactNo;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }

    public int getAcyr() {
        return acyr;
    }

    public void setAcyr(int acyr) {
        this.acyr = acyr;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    


   
    
}
