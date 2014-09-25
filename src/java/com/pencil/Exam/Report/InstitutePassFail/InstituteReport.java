/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.InstitutePassFail;

/**
 *
 * @author SHOHUG-SQ
 */
public class InstituteReport {

    private int acYr;

    private String examName;

    private String className;

    private String departmentName;

    private String shiftName;

    private String sectionName;

    private int totalStudent;

    private int totalFail;

    private int totalFailPercentage;

    private int totalPass;

    private int totalPassPercentage;

    public InstituteReport() {
    }

    public InstituteReport(String className, String departmentName, String shiftName, String sectionName, int totalStudent, int totalFail, int totalFailPercentage, int totalPass, int totalPassPercentage) {
        this.className = className;
        this.departmentName = departmentName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.totalStudent = totalStudent;
        this.totalFail = totalFail;
        this.totalFailPercentage = totalFailPercentage;
        this.totalPass = totalPass;
        this.totalPassPercentage = totalPassPercentage;
    }

    public int getAcYr() {
        return acYr;
    }

    public void setAcYr(int acYr) {
        this.acYr = acYr;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
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

    public int getTotalFail() {
        return totalFail;
    }

    public void setTotalFail(int totalFail) {
        this.totalFail = totalFail;
    }

    public int getTotalPass() {
        return totalPass;
    }

    public void setTotalPass(int totalPass) {
        this.totalPass = totalPass;
    }

    public int getTotalFailPercentage() {
        return totalFailPercentage;
    }

    public void setTotalFailPercentage(int totalFailPercentage) {
        this.totalFailPercentage = totalFailPercentage;
    }

    public int getTotalPassPercentage() {
        return totalPassPercentage;
    }

    public void setTotalPassPercentage(int totalPassPercentage) {
        this.totalPassPercentage = totalPassPercentage;
    }

}
