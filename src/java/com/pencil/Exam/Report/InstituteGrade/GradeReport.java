/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.InstituteGrade;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class GradeReport implements Serializable{
    
    
    private int acYr;

    private String examName;

    private String className;
    
    private String departmentName;

    private String shiftName;

    private String sectionName;
    
    private int totalStudent;
    
    private int aPlus;

    private int a;
    
    private int aMinus;

    private int b;

    private int c;
    
    private int d;

    private int f;

    public GradeReport() {
    }

    public GradeReport(String className, String departmentName, String shiftName, String sectionName, int totalStudent, int aPlus, int a, int aMinus, int b, int c, int d, int f) {
        this.className = className;
        this.departmentName = departmentName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.totalStudent = totalStudent;
        this.aPlus = aPlus;
        this.a = a;
        this.aMinus = aMinus;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
    }


    public int getAcYr() {
        return acYr;
    }

    public void setAcYr(int acYr) {
        this.acYr = acYr;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
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

    
}
