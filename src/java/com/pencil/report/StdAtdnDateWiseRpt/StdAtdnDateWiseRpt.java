/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.report.StdAtdnDateWiseRpt;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Riyad
 */
public class StdAtdnDateWiseRpt implements Serializable{
   
    private Date date;
    private int totalstudent;
    private int totalpresent;
    private double presentpercentage;
    private int totalabsent;
    private double absentpercentage;
    
    
    private Date fromdate;
    private Date todate;

    public StdAtdnDateWiseRpt() {
    }


    public StdAtdnDateWiseRpt(Date date, int totalstudent, int totalpresent, double presentpercentage, int totalabsent, double absentpercentage) {
        this.date = date;
        this.totalstudent = totalstudent;
        this.totalpresent = totalpresent;
        this.presentpercentage = presentpercentage;
        this.totalabsent = totalabsent;
        this.absentpercentage = absentpercentage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(int totalstudent) {
        this.totalstudent = totalstudent;
    }

    public int getTotalpresent() {
        return totalpresent;
    }

    public void setTotalpresent(int totalpresent) {
        this.totalpresent = totalpresent;
    }

    public double getPresentpercentage() {
        return presentpercentage;
    }

    public void setPresentpercentage(double presentpercentage) {
        this.presentpercentage = presentpercentage;
    }

    public int getTotalabsent() {
        return totalabsent;
    }

    public void setTotalabsent(int totalabsent) {
        this.totalabsent = totalabsent;
    }

    public double getAbsentpercentage() {
        return absentpercentage;
    }

    public void setAbsentpercentage(double absentpercentage) {
        this.absentpercentage = absentpercentage;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }
    
    
  
    
    
    
}
