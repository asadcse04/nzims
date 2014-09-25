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
 * @author apple
 */
public class ExamMarkDivision implements Serializable
{
    private int exmSbjID;
    
    private int shortCode;
    
    private double totalMark;
    
    private double acceptance;
    
    private double passMark;

    public ExamMarkDivision() {
    }

    public ExamMarkDivision(int exmSbjID, int shortCode, double totalMark, double acceptance, double passMark) {
        this.exmSbjID = exmSbjID;
        this.shortCode = shortCode;
        this.totalMark = totalMark;
        this.acceptance = acceptance;
        this.passMark = passMark;
    }

    /**
     * @return the exmSbjID
     */
    public int getExmSbjID() {
        return exmSbjID;
    }

    /**
     * @param exmSbjID the exmSbjID to set
     */
    public void setExmSbjID(int exmSbjID) {
        this.exmSbjID = exmSbjID;
    }

    /**
     * @return the shortCode
     */
    public int getShortCode() {
        return shortCode;
    }

    /**
     * @param shortCode the shortCode to set
     */
    public void setShortCode(int shortCode) {
        this.shortCode = shortCode;
    }

    /**
     * @return the totalMark
     */
    public double getTotalMark() {
        return totalMark;
    }

    /**
     * @param totalMark the totalMark to set
     */
    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    /**
     * @return the acceptance
     */
    public double getAcceptance() {
        return acceptance;
    }

    /**
     * @param acceptance the acceptance to set
     */
    public void setAcceptance(double acceptance) {
        this.acceptance = acceptance;
    }

    /**
     * @return the passMark
     */
    public double getPassMark() {
        return passMark;
    }

    /**
     * @param passMark the passMark to set
     */
    public void setPassMark(double passMark) {
        this.passMark = passMark;
    }
    
    
    
}
