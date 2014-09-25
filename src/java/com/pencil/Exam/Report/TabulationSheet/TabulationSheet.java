/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.TabulationSheet;

import java.io.Serializable;

/**
 *
 * @author SHOHUG.SQ
 */
public class TabulationSheet implements Serializable {


    private String studentName;

    private int studentRoll;
    
     private String subjectName;

    private String ShortCode1;

    private String ShortCode2;

    private String ShortCode3;

    private String ShortCode4;
    
    private String LetterGrade;

    private double TotalScore;
    
    private double grandTotalScore;

    private double FinalScore;

    private double GradePoint;

    public TabulationSheet() {
    }

    public TabulationSheet(String studentName, int studentRoll, String subjectName) {
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.subjectName = subjectName;
    }

    public TabulationSheet(String studentName, int studentRoll, String subjectName, String LetterGrade) {
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.subjectName = subjectName;
        this.LetterGrade = LetterGrade;
    }

    
    
    

    public TabulationSheet(String studentName, int studentRoll, String subjectName, String ShortCode1, String ShortCode2, String ShortCode3, String ShortCode4) {
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.subjectName = subjectName;
        this.ShortCode1 = ShortCode1;
        this.ShortCode2 = ShortCode2;
        this.ShortCode3 = ShortCode3;
        this.ShortCode4 = ShortCode4;
    }

    public TabulationSheet(String studentName, int studentRoll, String subjectName, String ShortCode1, String ShortCode2, String ShortCode3, String ShortCode4, double TotalScore) {
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.subjectName = subjectName;
        this.ShortCode1 = ShortCode1;
        this.ShortCode2 = ShortCode2;
        this.ShortCode3 = ShortCode3;
        this.ShortCode4 = ShortCode4;
        this.TotalScore = TotalScore;
    }
    
    

    

    

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
    

    public int getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getShortCode1() {
        return ShortCode1;
    }

    public void setShortCode1(String ShortCode1) {
        this.ShortCode1 = ShortCode1;
    }

    public String getShortCode2() {
        return ShortCode2;
    }

    public void setShortCode2(String ShortCode2) {
        this.ShortCode2 = ShortCode2;
    }

    public String getShortCode3() {
        return ShortCode3;
    }

    public void setShortCode3(String ShortCode3) {
        this.ShortCode3 = ShortCode3;
    }

    public String getShortCode4() {
        return ShortCode4;
    }

    public void setShortCode4(String ShortCode4) {
        this.ShortCode4 = ShortCode4;
    }

    public String getLetterGrade() {
        return LetterGrade;
    }

    public void setLetterGrade(String LetterGrade) {
        this.LetterGrade = LetterGrade;
    }

    public double getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(double TotalScore) {
        this.TotalScore = TotalScore;
    }

    public double getGrandTotalScore() {
        return grandTotalScore;
    }

    public void setGrandTotalScore(double grandTotalScore) {
        this.grandTotalScore = grandTotalScore;
    }

    public double getFinalScore() {
        return FinalScore;
    }

    public void setFinalScore(double FinalScore) {
        this.FinalScore = FinalScore;
    }

    public double getGradePoint() {
        return GradePoint;
    }

    public void setGradePoint(double GradePoint) {
        this.GradePoint = GradePoint;
    }
    
    

}
