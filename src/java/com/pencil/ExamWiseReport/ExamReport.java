/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamWiseReport;

import java.io.Serializable;

/**
 *
 * @author salim
 */
public class ExamReport implements Serializable
{
    //............................Subject Wise Pass/Fail Report...................
    private int subjectID;
    
    private String subjectName;
    
    private int totalStudent;
    
    private int fail;
    
    private int pass;
    
    private String teacherName;
    
    //............................Subject Wise Grading..........................
    
    private int aplus;
    
    private int aaa;
    
    private int aminus;
    
    private int bbb;
    
    private int ccc;
    
    private int ddd;
    
    private int fff;
    
    //........................Section Wise Merit List..........................
    
    private int sectionPosition;
    
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private Double totalMarks;
    
    private Double cgpa;
    
    private String finalGrade;


    public ExamReport()
    {
        
    }
    
  //.....................Subject Wise Pass/Fail Report Constructor..............
    public ExamReport(int subjectID, String subjectName, int totalStudent, int fail, int pass, String teacherName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.totalStudent = totalStudent;
        this.fail = fail;
        this.pass = pass;
        this.teacherName = teacherName;
    }

     //......................Subject Wise Grading Constructor...................
    public ExamReport(int subjectID, String subjectName,int totalStudent, int aplus, int aaa, int aminus, int bbb, int ccc, int ddd, int fff) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.totalStudent = totalStudent;
        this.aplus = aplus;
        this.aaa = aaa;
        this.aminus = aminus;
        this.bbb = bbb;
        this.ccc = ccc;
        this.ddd = ddd;
        this.fff = fff;
    }
  //........................Section Wise Merit List Constructor.................
    public ExamReport(int sectionPosition, String studentID, String studentName, int studentRoll, Double totalMarks, Double cgpa, String finalGrade) {
        this.sectionPosition = sectionPosition;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.totalMarks = totalMarks;
        this.cgpa = cgpa;
        this.finalGrade = finalGrade;
    }
  
    
    
    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }


    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getAplus() {
        return aplus;
    }

    public void setAplus(int aplus) {
        this.aplus = aplus;
    }

    public int getAaa() {
        return aaa;
    }

    public void setAaa(int aaa) {
        this.aaa = aaa;
    }

    public int getAminus() {
        return aminus;
    }

    public void setAminus(int aminus) {
        this.aminus = aminus;
    }

    public int getBbb() {
        return bbb;
    }

    public void setBbb(int bbb) {
        this.bbb = bbb;
    }

    public int getCcc() {
        return ccc;
    }

    public void setCcc(int ccc) {
        this.ccc = ccc;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getFff() {
        return fff;
    }

    public void setFff(int fff) {
        this.fff = fff;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public Double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public int getSectionPosition() {
        return sectionPosition;
    }

    public void setSectionPosition(int sectionPosition) {
        this.sectionPosition = sectionPosition;
    }
    
    
}
