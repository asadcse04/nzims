/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.GradeWiseReport;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class GradeWiseReport implements Serializable{
    
    private int academicyear;
    private String examname;
    
    private int totalstudent;
    private int aPlus;
    private int a;
    private int aMinus;
    private int b;
    private int c;
    private int d;
    private int f;

    public GradeWiseReport() {
    }

    public GradeWiseReport(int totalstudent, int aPlus, int a, int aMinus, int b, int c, int d, int f) {
        this.totalstudent = totalstudent;
        this.aPlus = aPlus;
        this.a = a;
        this.aMinus = aMinus;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
    }

    public int getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(int totalstudent) {
        this.totalstudent = totalstudent;
    }

    public int getaPlus() {
        return aPlus;
    }

    public void setaPlus(int aPlus) {
        this.aPlus = aPlus;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getaMinus() {
        return aMinus;
    }

    public void setaMinus(int aMinus) {
        this.aMinus = aMinus;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
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

   

    
    
    
    
    
}
