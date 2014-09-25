/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Department;

import java.io.Serializable;

/**
 *
 * @author user
 */

public class Department implements Serializable {
   

    private int departmentID;
    
    private String departmentName;
    
    private String note;
    
    
    public Department()
    {
        
    }

    public Department(int departmentID, String departmentName, String note) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.note = note;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
  
}
