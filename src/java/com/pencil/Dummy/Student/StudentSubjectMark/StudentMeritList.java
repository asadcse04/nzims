/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.StudentSubjectMark;


import java.io.Serializable;

/**
 *
 * @author Mastermind
 */
public class StudentMeritList implements Serializable
{
    //ID, StudentID, ExcnfID, TotalMark, TotalGpa, CGPA, FinalGrade
    
      
    private int id;
    
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private String grdnCn;
    
    private Double totalMark;
    
    private Double totalGpa;
    
    private Double CGPA;
    
    private String finalGrade;
    
    private String status;
    
    private int cP;
    
    private int sP;
    
    private int secP;

    public StudentMeritList() 
    {
        
    }
    
    
    public StudentMeritList(String studentID, String studentName, Double totalMark, Double totalGpa, Double CGPA, String finalGrade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.totalMark = totalMark;
        this.totalGpa = totalGpa;
        this.CGPA = CGPA;
        this.finalGrade = finalGrade;
    }


    public StudentMeritList(String studentID, String studentName,int studentRoll, Double totalMark, Double totalGpa, Double CGPA, String finalGrade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll=studentRoll;
        this.totalMark = totalMark;
        this.totalGpa = totalGpa;
        this.CGPA = CGPA;
        this.finalGrade = finalGrade;
    }

    public StudentMeritList(String studentID,int studentRoll,String grdnCn, Double totalMark, Double CGPA, String finalGrade, String status, int cP, int sP, int secP) {
        this.studentID = studentID;
        this.studentRoll=studentRoll;
        this.grdnCn = grdnCn;
        this.totalMark = totalMark;
        this.CGPA = CGPA;
        this.finalGrade = finalGrade;
        this.status = status;
        this.cP = cP;
        this.sP = sP;
        this.secP = secP;
    }//for sending sms
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getTotalGpa() {
        return totalGpa;
    }

    public void setTotalGpa(Double totalGpa) {
        this.totalGpa = totalGpa;
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

    /**
     * @return the grdnCn
     */
    public String getGrdnCn() {
        return grdnCn;
    }

    /**
     * @param grdnCn the grdnCn to set
     */
    public void setGrdnCn(String grdnCn) {
        this.grdnCn = grdnCn;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the cP
     */
    public int getcP() {
        return cP;
    }

    /**
     * @param cP the cP to set
     */
    public void setcP(int cP) {
        this.cP = cP;
    }

    /**
     * @return the sP
     */
    public int getsP() {
        return sP;
    }

    /**
     * @param sP the sP to set
     */
    public void setsP(int sP) {
        this.sP = sP;
    }

    /**
     * @return the secP
     */
    public int getSecP() {
        return secP;
    }

    /**
     * @param secP the secP to set
     */
    public void setSecP(int secP) {
        this.secP = secP;
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
