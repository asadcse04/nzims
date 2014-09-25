/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult;

import java.io.Serializable;

/**
 *
 * @author INSPIRON 5421
 */
public class ViewStudentResult implements Serializable
{
    private int ResultID;
    
    private String StudentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private String ShortCode1;
    
    private String ShortCode2;
    
    private String ShortCode3;
    
    private String ShortCode4;
    
    private double TotalScore;
    
    private double Average;
    
    private double FinalScore;
    
    private String LetterGrade;
    
    private double GradePoint;
    
    private String teacherName;
    
    private String exam_note;
    
    private double SbjFullMark;

    public ViewStudentResult()
    {
        
    }

    public ViewStudentResult(int ResultID, String StudentID, String studentName, int studentRoll, String ShortCode1, String ShortCode2, String ShortCode3, String ShortCode4, double TotalScore, double Average, double FinalScore, String LetterGrade, double GradePoint, String teacherName, String exam_note, double SbjFullMark) {
        this.ResultID = ResultID;
        this.StudentID = StudentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.ShortCode1 = ShortCode1;
        this.ShortCode2 = ShortCode2;
        this.ShortCode3 = ShortCode3;
        this.ShortCode4 = ShortCode4;
        this.TotalScore = TotalScore;
        this.Average = Average;
        this.FinalScore = FinalScore;
        this.LetterGrade = LetterGrade;
        this.GradePoint = GradePoint;
        this.teacherName = teacherName;
        this.exam_note = exam_note;
        this.SbjFullMark = SbjFullMark;
    }

    /**
     * @return the ResultID
     */
    public int getResultID() {
        return ResultID;
    }

    /**
     * @param ResultID the ResultID to set
     */
    public void setResultID(int ResultID) {
        this.ResultID = ResultID;
    }

    /**
     * @return the StudentID
     */
    public String getStudentID() {
        return StudentID;
    }

    /**
     * @param StudentID the StudentID to set
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    /**
     * @return the ShortCode1
     */
    public String getShortCode1() {
        return ShortCode1;
    }

    /**
     * @param ShortCode1 the ShortCode1 to set
     */
    public void setShortCode1(String ShortCode1) {
        this.ShortCode1 = ShortCode1;
    }

    /**
     * @return the ShortCode2
     */
    public String getShortCode2() {
        return ShortCode2;
    }

    /**
     * @param ShortCode2 the ShortCode2 to set
     */
    public void setShortCode2(String ShortCode2) {
        this.ShortCode2 = ShortCode2;
    }

    /**
     * @return the ShortCode3
     */
    public String getShortCode3() {
        return ShortCode3;
    }

    /**
     * @param ShortCode3 the ShortCode3 to set
     */
    public void setShortCode3(String ShortCode3) {
        this.ShortCode3 = ShortCode3;
    }

    /**
     * @return the ShortCode4
     */
    public String getShortCode4() {
        return ShortCode4;
    }

    /**
     * @param ShortCode4 the ShortCode4 to set
     */
    public void setShortCode4(String ShortCode4) {
        this.ShortCode4 = ShortCode4;
    }

    /**
     * @return the TotalScore
     */
    public double getTotalScore() {
        return TotalScore;
    }

    /**
     * @param TotalScore the TotalScore to set
     */
    public void setTotalScore(double TotalScore) {
        this.TotalScore = TotalScore;
    }

    /**
     * @return the Average
     */
    public double getAverage() {
        return Average;
    }

    /**
     * @param Average the Average to set
     */
    public void setAverage(double Average) {
        this.Average = Average;
    }

    /**
     * @return the FinalScore
     */
    public double getFinalScore() {
        return FinalScore;
    }

    /**
     * @param FinalScore the FinalScore to set
     */
    public void setFinalScore(double FinalScore) {
        this.FinalScore = FinalScore;
    }

    /**
     * @return the LetterGrade
     */
    public String getLetterGrade() {
        return LetterGrade;
    }

    /**
     * @param LetterGrade the LetterGrade to set
     */
    public void setLetterGrade(String LetterGrade) {
        this.LetterGrade = LetterGrade;
    }

    /**
     * @return the GradePoint
     */
    public double getGradePoint() {
        return GradePoint;
    }

    /**
     * @param GradePoint the GradePoint to set
     */
    public void setGradePoint(double GradePoint) {
        this.GradePoint = GradePoint;
    }

    /**
     * @return the SbjFullMark
     */
    public double getSbjFullMark() {
        return SbjFullMark;
    }

    /**
     * @param SbjFullMark the SbjFullMark to set
     */
    public void setSbjFullMark(double SbjFullMark) {
        this.SbjFullMark = SbjFullMark;
    }

    /**
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return the exam_note
     */
    public String getExam_note() {
        return exam_note;
    }

    /**
     * @param exam_note the exam_note to set
     */
    public void setExam_note(String exam_note) {
        this.exam_note = exam_note;
    } 

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentRoll
     */
    public int getStudentRoll() {
        return studentRoll;
    }

    /**
     * @param studentRoll the studentRoll to set
     */
    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }
}
