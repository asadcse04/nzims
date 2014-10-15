/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.BasicView;

import java.io.Serializable;

/**
 *
 * @author SHOHUG.SQ
 */
public class BasicReport implements Serializable {

    private int acYr;

    private String className;

    private int classID;

    private String departmentName;

    private String shiftName;

    private String sectionName;

    private String examName;

    private String subjectName;

    private String studentID;

    private String studentName;

    private int studentRoll;

    private String shortCode1;

    private String shortCode2;

    private String shortCode3;

    private String shortCode4;

    private Double average;

    private Double totalScore;

    private Double gradePoint;

    private String letterGrade;

    private Double totalMark;

    private Double cgpa;

    private String finalGrade;

    //Subject Wise Pass/Fail Report//
    private int subjectID;

    private int totalStudent;

    private int fail;

    private int pass;

    private String teacherName;

    //Subject Wise Grading..........................
    private int aplus;

    private int aaa;

    private int aminus;

    private int bbb;

    private int ccc;

    private int ddd;

    private int fff;

    ////////////////////constructors//////////
    public BasicReport() {

    }

    public BasicReport(int acYr, String className, String departmentName, String shiftName, String sectionName, int classId) {
        this.acYr = acYr;
        this.className = className;
        this.departmentName = departmentName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.classID = classId;
    }

    /// Details report ////
    public BasicReport(String studentID, String studentName, int studentRoll, String shortCode1, String shortCode2, String shortCode3, String shortCode4, Double average, Double totalScore, Double gradePoint, String letterGrade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.shortCode1 = shortCode1;
        this.shortCode2 = shortCode2;
        this.shortCode3 = shortCode3;
        this.shortCode4 = shortCode4;
        this.average = average;
        this.totalScore = totalScore;
        this.gradePoint = gradePoint;
        this.letterGrade = letterGrade;
    }
    //for summary///

    public BasicReport(String studentID, String studentName, int studentRoll, Double totalMark, Double cgpa, String finalGrade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.totalMark = totalMark;
        this.cgpa = cgpa;
        this.finalGrade = finalGrade;
    }

    //Subject Wise Pass/Fail Report Constructor//
    public BasicReport(int subjectID, String subjectName, int totalStudent, int fail, int pass, String teacherName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.totalStudent = totalStudent;
        this.fail = fail;
        this.pass = pass;
        this.teacherName = teacherName;
    }

    //Subject Wise Grading Constructor...................
    public BasicReport(int subjectID, String subjectName, int totalStudent, int aplus, int aaa, int aminus, int bbb, int ccc, int ddd, int fff) {
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
/////////////Set & Get  ////////////////

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

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
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

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public Double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Double totalMark) {
        this.totalMark = totalMark;
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

    public String getShortCode1() {
        return shortCode1;
    }

    public void setShortCode1(String shortCode1) {
        this.shortCode1 = shortCode1;
    }

    public String getShortCode2() {
        return shortCode2;
    }

    public void setShortCode2(String shortCode2) {
        this.shortCode2 = shortCode2;
    }

    public String getShortCode3() {
        return shortCode3;
    }

    public void setShortCode3(String shortCode3) {
        this.shortCode3 = shortCode3;
    }

    public String getShortCode4() {
        return shortCode4;
    }

    public void setShortCode4(String shortCode4) {
        this.shortCode4 = shortCode4;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(Double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
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

}
