/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.StudentSubjectMark;

import com.pencil.Dummy.Student.ExamResult.*;
import java.io.Serializable;

/**
 *
 * @author INSPIRON 5421
 */
public class ExamGrade implements Serializable
{
    private String letterGrade;
    
    private double gradeNumber;
    
    private double point;
    
    private int rangelow;
    
    private int rangehigh;

    public ExamGrade() {
    }

    public ExamGrade(String letterGrade, double gradeNumber, double point, int rangelow, int rangehigh) {
        this.letterGrade = letterGrade;
        this.gradeNumber = gradeNumber;
        this.point = point;
        this.rangelow = rangelow;
        this.rangehigh = rangehigh;
    }
    
    

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public double getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(double gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getRangelow() {
        return rangelow;
    }

    public void setRangelow(int rangelow) {
        this.rangelow = rangelow;
    }

    public int getRangehigh() {
        return rangehigh;
    }

    public void setRangehigh(int rangehigh) {
        this.rangehigh = rangehigh;
    }

  

   
    
    
}
