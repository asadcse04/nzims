/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Subject;

import java.io.Serializable;

/**
 *
 * @author user
 */

public class Subject implements Serializable
{
   
    private int subjectID;
   
    private String subjectName;
   
    private int subjectCode;
    
    private boolean status;
    
    private String note;

    public Subject()
    {
        
    }

    public Subject(int subjectID, String subjectName, int subjectCode, boolean status, String note) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.status = status;
        this.note = note;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
