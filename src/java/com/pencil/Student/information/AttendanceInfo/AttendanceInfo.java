/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Student.information.AttendanceInfo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SHOHUG.SQ
 */
public class AttendanceInfo implements Serializable {

    private String studentID;

    private String studentName;

    private String fatherName;

    private int studentRoll;

    private String contactNo;

    private String gender;

    private int acyr;

    private String deptName;

    private String className;

    private String shiftName;

    private String sectionName;

    private String imgPath;

    private int studentAtten;

    private String absent;

    private String note;

    private String date;

    private Date fromDate;

    private Date toDate;

    private int presentCount;

    private int absentCount;

    private int leaveCount;

    private int applicationCount;

    private int incomlieleCount;

    public AttendanceInfo() {

    }

    public AttendanceInfo(String studentID, String studentName, int studentRoll, String gender, String fatherName, String contactNo, int acyr, String className, String deptName, String shiftName, String sectionName, String imgPath) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.gender = gender;
        this.fatherName = fatherName;
        this.contactNo = contactNo;
        this.acyr = acyr;
        this.className = className;
        this.deptName = deptName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.imgPath = imgPath;
    }

    public AttendanceInfo(String date, int studentAtten, String note) {

        this.studentAtten = studentAtten;
        this.note = note;
        this.date = date;
    }

    public AttendanceInfo(int presentCount, int absentCount, int leaveCount, int applicationCount, int incomlieleCount) {
        this.presentCount = presentCount;
        this.absentCount = absentCount;
        this.leaveCount = leaveCount;
        this.applicationCount = applicationCount;
        this.incomlieleCount = incomlieleCount;
    }

    public int getAbsentCount() {
        return absentCount;
    }

    public void setAbsentCount(int absentCount) {
        this.absentCount = absentCount;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public void setPresentCount(int presentCount) {
        this.presentCount = presentCount;
    }

    public int getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(int leaveCount) {
        this.leaveCount = leaveCount;
    }

    public int getApplicationCount() {
        return applicationCount;
    }

    public void setApplicationCount(int applicationCount) {
        this.applicationCount = applicationCount;
    }

    public int getIncomlieleCount() {
        return incomlieleCount;
    }

    public void setIncomlieleCount(int incomlieleCount) {
        this.incomlieleCount = incomlieleCount;
    }

    public String getStudentID() {

        return studentID;
    }

    public void setStudentID(String studentID) {

        this.studentID = studentID;
    }

    public int getStudentAtten() {

        return studentAtten;
    }

    public void setStudentAtten(int studentAtten) {

        this.studentAtten = studentAtten;
    }

    public String getAbsent() {
        if (this.studentAtten == 1) {
            this.absent = "Absent";
        } else {
            this.absent = "Present";
        }
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

///////////////
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getImgPath() {
        
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

}
