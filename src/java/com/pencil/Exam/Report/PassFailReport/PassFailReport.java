/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.PassFailReport;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class PassFailReport implements Serializable{
   

  private int academicyear;
  private String examname;
   private int totalstudent;
   private int totalfail;
   private int totalpass;
   private double totalfailpercentage;
   private double totalpasspercentage;

    
    
   public PassFailReport() {
    
   }

    public PassFailReport(int totalstudent, int totalfail,double totalfailpercentage, int totalpass, double totalpasspercentage) {
        this.totalstudent = totalstudent;
        this.totalfail = totalfail;
        this.totalfailpercentage = totalfailpercentage;
        this.totalpass = totalpass;
        this.totalpasspercentage = totalpasspercentage;
    }

    public PassFailReport(int totalpass,int totalfail,int totalstudent) {
        this.totalpass = totalpass;
        this.totalfail = totalfail;
        this.totalstudent = totalstudent;
 
    }
    
    

    public int getAcademicyear() {
        return academicyear;
    }

    public void setAcademicyear(int academicyear) {
        this.academicyear = academicyear;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

  
  
 
    public int getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(int totalstudent) {
        this.totalstudent = totalstudent;
    }

   
    public int getTotalfail() {
        return totalfail;
    }

    public void setTotalfail(int totalfail) {
        this.totalfail = totalfail;
    }

  
    public int getTotalpass() {
        return totalpass;
    }

    public void setTotalpass(int totalpass) {
        this.totalpass = totalpass;
    }


    public double getTotalfailpercentage() {
        return totalfailpercentage;
    }

    public void setTotalfailpercentage(double totalfailpercentage) {
        this.totalfailpercentage = totalfailpercentage;
    }

 
    public double getTotalpasspercentage() {
        return totalpasspercentage;
    }

    public void setTotalpasspercentage(double totalpasspercentage) {
        this.totalpasspercentage = totalpasspercentage;
    }

   
   
}
