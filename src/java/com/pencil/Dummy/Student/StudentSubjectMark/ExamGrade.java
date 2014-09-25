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

    public ExamGrade() {
    }

    public ExamGrade(String letterGrade, double gradeNumber, double point) {
        this.letterGrade = letterGrade;
        this.gradeNumber = gradeNumber;
        this.point = point;
    }

    /**
     * @return the letterGrade
     */
    public String getLetterGrade() {
        return letterGrade;
    }

    /**
     * @param letterGrade the letterGrade to set
     */
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    /**
     * @return the gradeNumber
     */
    public double getGradeNumber() {
        return gradeNumber;
    }

    /**
     * @param gradeNumber the gradeNumber to set
     */
    public void setGradeNumber(double gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    /**
     * @return the point
     */
    public double getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(double point) {
        this.point = point;
    }
    
    
}
