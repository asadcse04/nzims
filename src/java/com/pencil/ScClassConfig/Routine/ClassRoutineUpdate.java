/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig.Routine;

import java.io.Serializable;

/**
 *
 * @author Mahfuj
 */
public class ClassRoutineUpdate implements Serializable
{
    private int sc_cnf_id;
    
    private String day;
    
    private String periodName;
    
    private String startTime;
    
    private String endTime;
    
    private String shiftName;
   
    
    private String subjectName;
    
    private String subjectNote;
    
    
    private int teacherID;
    
    private String teacherName;
    

    public ClassRoutineUpdate()
    {
        
    }

    public ClassRoutineUpdate(int sc_cnf_id, String day, String periodName, String startTime, String endTime, String shiftName, String subjectName, String subjectNote, int teacherID, String teacherName) {
        this.sc_cnf_id = sc_cnf_id;
        this.day = day;
        this.periodName = periodName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftName = shiftName;
        this.subjectName = subjectName;
        this.subjectNote = subjectNote;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
    }
    
    

    /**
     * @return the sc_cnf_id
     */
    public int getSc_cnf_id() {
        return sc_cnf_id;
    }

    /**
     * @param sc_cnf_id the sc_cnf_id to set
     */
    public void setSc_cnf_id(int sc_cnf_id) {
        this.sc_cnf_id = sc_cnf_id;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the periodName
     */
    public String getPeriodName() {
        return periodName;
    }

    /**
     * @param periodName the periodName to set
     */
    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the shiftName
     */
    public String getShiftName() {
        return shiftName;
    }

    /**
     * @param shiftName the shiftName to set
     */
    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the subjectNote
     */
    public String getSubjectNote() {
        return subjectNote;
    }

    /**
     * @param subjectNote the subjectNote to set
     */
    public void setSubjectNote(String subjectNote) {
        this.subjectNote = subjectNote;
    }

    /**
     * @return the teacherID
     */
    public int getTeacherID() {
        return teacherID;
    }

    /**
     * @param teacherID the teacherID to set
     */
    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
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

    
}
