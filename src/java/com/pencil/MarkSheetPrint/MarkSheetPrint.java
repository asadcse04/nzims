/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.MarkSheetPrint;

import java.io.Serializable;

/**
 *
 * @author salim
 */
public class MarkSheetPrint implements Serializable
{
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private String gender;
    
    private int acyr;
    
    private String deptName;
    
    private String className;
    
    private String shiftName;
    
    private String sectionName;
    
    //for mark sheet
    
    private String subjectName;
    
    private String shortCode1;
    
    private String shortCode2;
    
    private String shortCode3;
 
    private String shortCode4;
    
    private Double totalScore;

    private Double average;
    
    private Double finalScore;
    
    private String letterGrade;
    
    private Double gradePoint;
    
    private String teacherName;
    
    
    private Double totalMark;
    
    private Double CGPA;
    
    private String finalGrade;
    
    private String status;
    
    private int classPosition;
    
    private int shiftPosition;
    
    private int sectionPosition;
    
    public MarkSheetPrint() 
    {
        
    }

    public MarkSheetPrint(String studentID, String studentName, int studentRoll, String gender, int acyr, String deptName, String className, String shiftName, String sectionName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.gender = gender;
        this.acyr = acyr;
        this.deptName = deptName;
        this.className = className;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
    }

    public MarkSheetPrint(String subjectName, String shortCode1, String shortCode2, String shortCode3, String shortCode4, Double totalScore, Double average, Double finalScore, String letterGrade, Double gradePoint, String teacherName) {
        this.subjectName = subjectName;
        this.shortCode1 = shortCode1;
        this.shortCode2 = shortCode2;
        this.shortCode3 = shortCode3;
        this.shortCode4 = shortCode4;
        this.totalScore = totalScore;
        this.average = average;
        this.finalScore = finalScore;
        this.letterGrade = letterGrade;
        this.gradePoint = gradePoint;
        this.teacherName = teacherName;
    }

    public MarkSheetPrint(Double totalMark, Double CGPA, String finalGrade, String status, int classPosition, int shiftPosition, int sectionPosition) {
        this.totalMark = totalMark;
        this.CGPA = CGPA;
        this.finalGrade = finalGrade;
        this.status = status;
        this.classPosition = classPosition;
        this.shiftPosition = shiftPosition;
        this.sectionPosition = sectionPosition;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAcyr() {
        return acyr;
    }

    public void setAcyr(int acyr) {
        this.acyr = acyr;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public Double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(Double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Double totalMark) {
        this.totalMark = totalMark;
    }

    public Double getCGPA() {
        return CGPA;
    }

    public void setCGPA(Double CGPA) {
        this.CGPA = CGPA;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClassPosition() {
        return classPosition;
    }

    public void setClassPosition(int classPosition) {
        this.classPosition = classPosition;
    }

    public int getShiftPosition() {
        return shiftPosition;
    }

    public void setShiftPosition(int shiftPosition) {
        this.shiftPosition = shiftPosition;
    }

    public int getSectionPosition() {
        return sectionPosition;
    }

    public void setSectionPosition(int sectionPosition) {
        this.sectionPosition = sectionPosition;
    }
    
    
}
