/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.AcademicYear;

import java.io.Serializable;
import java.util.Date;



public class AcademicYear implements Serializable 
{
    private int acYrID;
   
    private Date startTime;
   
    private Date endTime;
 
    private String note;

    public AcademicYear() 
    {
        
    }

    public AcademicYear(int acYrID, Date startTime, Date endTime, String note) {
        this.acYrID = acYrID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
    }

    public int getAcYrID() {
        return acYrID;
    }

    public void setAcYrID(int acYrID) {
        this.acYrID = acYrID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
     
}
