/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Accounts.MonthConfig;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mamun
 */

public class MonthConfig implements Serializable {

    private int monthConfigID;
    
    private int academicYear;

    private String monthName;

    private String displayName;

    private Date startDate;

    private Date endDate;

    private Date penaltyStart;
    
    private boolean penaltyStatus;

    public int getMonthConfigID() {
        return monthConfigID;
    }

    public void setMonthConfigID(int monthConfigID) {
        this.monthConfigID = monthConfigID;
    }   
    

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPenaltyStart() {
        return penaltyStart;
    }

    public void setPenaltyStart(Date penaltyStart) {
        this.penaltyStart = penaltyStart;
    }

    public boolean isPenaltyStatus() {
        return penaltyStatus;
    }

    public void setPenaltyStatus(boolean penaltyStatus) {
        this.penaltyStatus = penaltyStatus;
    }
    
    

}
