/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SubjectConfigure;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mahfuj
 */
public class SubjectConfig implements Serializable
{
    private int acyrID;
    
    private String schoolClassName;
    
    private String deptName;
    
    private List<String> subjectList;

    public SubjectConfig() {
    }

    public SubjectConfig(int acyrID, String schoolClassName, String deptName)
    {
        this.acyrID = acyrID;
        this.schoolClassName = schoolClassName;
        this.deptName = deptName;
    }
   
    /**
     * @return the acyrID
     */
    public int getAcyrID() {
        return acyrID;
    }

    /**
     * @param acyrID the acyrID to set
     */
    public void setAcyrID(int acyrID) {
        this.acyrID = acyrID;
    }

    /**
     * @return the schoolClassName
     */
    public String getSchoolClassName() {
        return schoolClassName;
    }

    /**
     * @param schoolClassName the schoolClassName to set
     */
    public void setSchoolClassName(String schoolClassName) {
        this.schoolClassName = schoolClassName;
    }

    /**
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName the deptName to set
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return the subjectList
     */
    public List<String> getSubjectList() {
        return subjectList;
    }

    /**
     * @param subjectList the subjectList to set
     */
    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }      
}
