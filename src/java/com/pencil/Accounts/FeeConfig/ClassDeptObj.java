/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeConfig;

/**
 *
 * @author jahangiralamdiu
 */
public class ClassDeptObj {
    
    private int academicYear;
    
    private String className;
    
    private String departmentName;

    public ClassDeptObj() {
    }

    public ClassDeptObj(int academicYear, String className, String departmentName) {
        this.academicYear = academicYear;
        this.className = className;
        this.departmentName = departmentName;
    }
        
    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    
        
}
