/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig.Routine;

import com.pencil.Period.Period;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mahfuj
 */
public class ClassRoutine implements Serializable
{
    private int scClassCnfID;
    
    private String shiftName;
    
    private List<Period> period_List;
    
    private List<String> subject_List;
    
    private String subject;
    
    private String note;
    
    
    //String teacherName;

    public ClassRoutine()
    {
        
    }
    
    /**
     * @return the scClassCnfID
     */
    public int getScClassCnfID() {
        return scClassCnfID;
    }

    /**
     * @param scClassCnfID the scClassCnfID to set
     */
    public void setScClassCnfID(int scClassCnfID) {
        this.scClassCnfID = scClassCnfID;
    }

    /**
     * @return the period_List
     */
    public List<Period> getPeriod_List() {
        return period_List;
    }

    /**
     * @param period_List the period_List to set
     */
    public void setPeriod_List(List<Period> period_List) {
        this.period_List = period_List;
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
     * @return the subject_List
     */
    public List<String> getSubject_List() {
        return subject_List;
    }

    /**
     * @param subject_List the subject_List to set
     */
    public void setSubject_List(List<String> subject_List) {
        this.subject_List = subject_List;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

}
