/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.StudentAttendance;

import java.io.Serializable;

/**
 *
 * @author Mahfuj
 */
public class StudentAttendanceReport implements Serializable
{ 
    private String studentID;
    
    private String StudentName;
    
    private int roll;
    
    private int present;
    
    private int absent;
    
    private int leave;
    
    private int application_;
    
    private int incompelte;

    public StudentAttendanceReport() {
    }

    public StudentAttendanceReport(String studentID, String StudentName, int roll, int present, int absent, int leave, int application_, int incompelte) {
        this.studentID = studentID;
        this.StudentName = StudentName;
        this.roll = roll;
        this.present = present;
        this.absent = absent;
        this.leave = leave;
        this.application_ = application_;
        this.incompelte = incompelte;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the StudentName
     */
    public String getStudentName() {
        return StudentName;
    }

    /**
     * @param StudentName the StudentName to set
     */
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    /**
     * @return the roll
     */
    public int getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(int roll) {
        this.roll = roll;
    }

    /**
     * @return the present
     */
    public int getPresent() {
        return present;
    }

    /**
     * @param present the present to set
     */
    public void setPresent(int present) {
        this.present = present;
    }

    /**
     * @return the absent
     */
    public int getAbsent() {
        return absent;
    }

    /**
     * @param absent the absent to set
     */
    public void setAbsent(int absent) {
        this.absent = absent;
    }

    /**
     * @return the leave
     */
    public int getLeave() {
        return leave;
    }

    /**
     * @param leave the leave to set
     */
    public void setLeave(int leave) {
        this.leave = leave;
    }

    /**
     * @return the incompelte
     */
    public int getIncompelte() {
        return incompelte;
    }

    /**
     * @param incompelte the incompelte to set
     */
    public void setIncompelte(int incompelte) {
        this.incompelte = incompelte;
    }

    /**
     * @return the application_
     */
    public int getApplication_() {
        return application_;
    }

    /**
     * @param application_ the application_ to set
     */
    public void setApplication_(int application_) {
        this.application_ = application_;
    }
    
    
    
}
