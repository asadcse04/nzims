/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Student.information.StResultInfo;

import java.io.Serializable;

/**
 *
 * @author SHOHUG.SQ
 */
public class StResultInfo implements Serializable{
    
     
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
    
    public StResultInfo() 
    {
        
    }
    
////////////////////
    public StResultInfo(String subjectName, String shortCode1, String shortCode2, String shortCode3, String shortCode4, Double totalScore, Double average, Double finalScore, String letterGrade, Double gradePoint, String teacherName) {
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
///////////////////////////
    public StResultInfo(Double totalMark, Double CGPA, String finalGrade, String status, int classPosition, int shiftPosition, int sectionPosition) {
        this.totalMark = totalMark;
        this.CGPA = CGPA;
        this.finalGrade = finalGrade;
        this.status = status;
        this.classPosition = classPosition;
        this.shiftPosition = shiftPosition;
        this.sectionPosition = sectionPosition;
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
