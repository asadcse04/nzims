/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SubjectWiseReport;

import java.io.Serializable;

/**
 *
 * @author salim
 */
public class SubjectReport implements Serializable
{ 
    
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private Double totalMark;
    
    private Double cgpa;
    
    private String finalGrade;
    
    
    
    private String shortCode1;
    
    private String shortCode2;
    
    private String shortCode3;
    
    private String shortCode4;
    
    private Double average;
    
    private Double totalScore;
    
    private Double gradePoint;
    
    private String letterGrade;

    public SubjectReport() {
    }

    public SubjectReport(String studentID, String studentName, int studentRoll, Double totalMark,Double cgpa, String finalGrade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.totalMark = totalMark;
        this.cgpa = cgpa;
        this.finalGrade = finalGrade;
    }

    public SubjectReport(String studentID, String studentName, int studentRoll, String shortCode1, String shortCode2, String shortCode3, String shortCode4, Double average, Double totalScore, Double gradePoint, String letterGrade) {
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

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
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
       
    
}
