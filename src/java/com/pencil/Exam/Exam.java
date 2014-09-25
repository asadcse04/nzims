/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam;

import java.io.Serializable;


 
public class Exam implements Serializable {
   
    private int examID;
  
    private String examName;
    
    private String note;
    
    private String instituteID;

    public Exam() {
    }

    public Exam(int examID, String examName, String note) {
        this.examID = examID;
        this.examName = examName;
        this.note = note;
    }
    
    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }

    
    
}
