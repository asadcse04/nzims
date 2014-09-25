/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Shift;

import java.io.Serializable;


/**
 *
 * @author user
 */

public class Shift implements Serializable 
{
    
    private int shiftID;
    
    private String shiftName;
    
    private String startTime;
    
    private String endTime;
    
    private String note;

    public Shift() {
    }

    public Shift(int shiftID, String shiftName, String startTime, String endTime, String note) {
        this.shiftID = shiftID;
        this.shiftName = shiftName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
    }

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
  
}
