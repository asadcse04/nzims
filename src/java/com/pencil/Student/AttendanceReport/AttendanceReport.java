/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Student.AttendanceReport;

/**
 *
 * @author salim
 */
public class AttendanceReport
{
    
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private int status;
    
    private String note;
    
    
    private String acyr;
    
    private String className;
    
    private String departmentName;
    
    private String shiftName;
    
    private String sectionName;
    
    private int totalStudent;
    
    private int present;
    
    private double persentsOfPresent;
    
    private int absent;
    
    private double persentsOfAbsent;

    public AttendanceReport() {
    }

    public AttendanceReport(String studentID, String studentName, int studentRoll, int status, String note) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.status = status;
        this.note = note;
    }


    public AttendanceReport(String className, String shiftName, String sectionName, int totalStudent, int present, double persentsOfPresent, int absent, double persentsOfAbsent) {
        this.className = className;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.totalStudent = totalStudent;
        this.present = present;
        this.persentsOfPresent = persentsOfPresent;
        this.absent = absent;
        this.persentsOfAbsent = persentsOfAbsent;
    }

    public AttendanceReport(String acyr, String className, String departmentName, String shiftName, String sectionName) {
        this.acyr = acyr;
        this.className = className;
        this.departmentName = departmentName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public double getPersentsOfPresent() {
        return persentsOfPresent;
    }

    public void setPersentsOfPresent(double persentsOfPresent) {
        this.persentsOfPresent = persentsOfPresent;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public double getPersentsOfAbsent() {
        return persentsOfAbsent;
    }

    public void setPersentsOfAbsent(double persentsOfAbsent) {
        this.persentsOfAbsent = persentsOfAbsent;
    }

    public String getAcyr() {
        return acyr;
    }

    public void setAcyr(String acyr) {
        this.acyr = acyr;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    
}
