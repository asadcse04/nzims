/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass;

import java.io.Serializable;


public class SchoolClass implements Serializable
{   
    private int classID;

    private String className;

    private String note;
    

    public SchoolClass()
    {
        
    }

    public SchoolClass(int classID, String className, String note) {
        this.classID = classID;
        this.className = className;
        this.note = note;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

  
}
