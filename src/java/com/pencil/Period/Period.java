/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Period;

import java.io.Serializable;

/**
 *
 * @author Mahfuj
 */
public class Period implements Serializable
{
    private int periodID;
    
    private String periodName;
    
    private String startTime;
    
    private String endTime;
    
    private String shiftName;

    public Period()
    {
        
    }

    public Period(String periodName, String startTime, String endTime) {
        this.periodName = periodName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    

    public Period(int periodID, String periodName, String startTime, String endTime, String shiftName) {
        this.periodID = periodID;
        this.periodName = periodName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftName = shiftName;
    }

    /**
     * @return the periodID
     */
    public int getPeriodID() {
        return periodID;
    }

    /**
     * @param periodID the periodID to set
     */
    public void setPeriodID(int periodID) {
        this.periodID = periodID;
    }

    /**
     * @return the periodName
     */
    public String getPeriodName() {
        return periodName;
    }

    /**
     * @param periodName the periodName to set
     */
    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the shiftName
     */
    public String getShiftName() {
        return shiftName;
    }

    /**
     * @param shiftName the shiftName to set
     */
    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }
        
}
