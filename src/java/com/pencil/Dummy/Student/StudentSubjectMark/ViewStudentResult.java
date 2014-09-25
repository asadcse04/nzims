/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.StudentSubjectMark;


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
    
    private String shortCode1;
    
    private String shortCode2;
    
    private String shortCode3;
    
    private String shortCode4;
    
    private int examConfigID;
    
    private int subjectID;
    
    private String instituteID;
    
   

    public ViewStudentResult()
    {
        
    }

    public ViewStudentResult(int ResultID, String StudentID, String studentName, int studentRoll, String shortCode1, String shortCode2, String shortCode3, String shortCode4, int examConfigID, int subjectID, String instituteID) {
        this.ResultID = ResultID;
        this.StudentID = StudentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.shortCode1 = shortCode1;
        this.shortCode2 = shortCode2;
        this.shortCode3 = shortCode3;
        this.shortCode4 = shortCode4;
        this.examConfigID = examConfigID;
        this.subjectID = subjectID;
        this.instituteID = instituteID;
    }

    
    
    public int getExamConfigID() {
        return examConfigID;
    }

    public void setExamConfigID(int examConfigID) {
        this.examConfigID = examConfigID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
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
