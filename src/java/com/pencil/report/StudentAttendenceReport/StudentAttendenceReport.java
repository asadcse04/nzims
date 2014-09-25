/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.report.StudentAttendenceReport;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Riad
 */
public class StudentAttendenceReport implements Serializable{
    
    private int totalstudent;
    private int present;
    private double presentpercent;
    private int abcent;
    private double abcentpercent;
    
    
    private Date date;

    public StudentAttendenceReport() {
    }

    public StudentAttendenceReport(int totalstudent, int present, int abcent) {
        this.totalstudent = totalstudent;
        this.present = present;
        this.abcent = abcent;
    }

    public StudentAttendenceReport(int totalstudent, int present, double presentpercent, int abcent, double abcentpercent) {
        this.totalstudent = totalstudent;
        this.present = present;
        this.presentpercent = presentpercent;
        this.abcent = abcent;
        this.abcentpercent = abcentpercent;
    }

   
    
    
    
    public int getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(int totalstudent) {
        this.totalstudent = totalstudent;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public double getPresentpercent() {
        return presentpercent;
    }

    public void setPresentpercent(double presentpercent) {
        this.presentpercent = presentpercent;
    }

    public int getAbcent() {
        return abcent;
    }

    public void setAbcent(int abcent) {
        this.abcent = abcent;
    }

    public double getAbcentpercent() {
        return abcentpercent;
    }

    public void setAbcentpercent(double abcentpercent) {
        this.abcentpercent = abcentpercent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
    
}
