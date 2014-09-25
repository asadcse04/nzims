/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult;

import java.io.Serializable;

/**
 *
 * @author apple
 */
public class StudentExamResult implements Serializable
{
    private String studentID;
    
    private String studentName;
    
    private int studentRoll;
    
    private String shortcode1;
    
    private String shortcode2;
    
    private String shortcode3;
    
    private String shortcode4;

    public StudentExamResult() {
    }

    public StudentExamResult(String studentID, String studentName, int studentRoll, String shortcode1, String shortcode2, String shortcode3, String shortcode4) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.shortcode1 = shortcode1;
        this.shortcode2 = shortcode2;
        this.shortcode3 = shortcode3;
        this.shortcode4 = shortcode4;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    /**
     * @return the shortcode1
     */
    public String getShortcode1() {
        return shortcode1;
    }

    /**
     * @param shortcode1 the shortcode1 to set
     */
    public void setShortcode1(String shortcode1) {
        this.shortcode1 = shortcode1;
    }

    /**
     * @return the shortcode2
     */
    public String getShortcode2() {
        return shortcode2;
    }

    /**
     * @param shortcode2 the shortcode2 to set
     */
    public void setShortcode2(String shortcode2) {
        this.shortcode2 = shortcode2;
    }

    /**
     * @return the shortcode3
     */
    public String getShortcode3() {
        return shortcode3;
    }

    /**
     * @param shortcode3 the shortcode3 to set
     */
    public void setShortcode3(String shortcode3) {
        this.shortcode3 = shortcode3;
    }

    /**
     * @return the shortcode4
     */
    public String getShortcode4() {
        return shortcode4;
    }

    /**
     * @param shortcode4 the shortcode4 to set
     */
    public void setShortcode4(String shortcode4) {
        this.shortcode4 = shortcode4;
    }
     
}
