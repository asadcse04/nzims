/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.StudentAttendance;

import java.io.Serializable;
import java.util.Date;
 
/**
 *
 * @author Mahfuj
 */
public class StudentAttendance implements Serializable
{
    private Date attendance_date;
    
    private boolean absent;
    
    private String remarks;
    
    private String period;
    
    private String studentID;

    public StudentAttendance() 
    {
        
    }

    /**
     * @return the attendance_date
     */
    public Date getAttendance_date() {
        return attendance_date;
    }

    /**
     * @param attendance_date the attendance_date to set
     */
    public void setAttendance_date(Date attendance_date) {
        this.attendance_date = attendance_date;
    }

    /**
     * @return the absent
     */
    public boolean isAbsent() {
        return absent;
    }

    /**
     * @param absent the absent to set
     */
    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

   
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
   
    
    
}
