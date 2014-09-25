/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ElectiveSubjectSelection;

import java.io.Serializable;

/**
 *
 * @author INSPIRON 5421
 */
public class ElectiveSubject implements Serializable
{
    private int acyr;
    
    private String className;
    
    private String deptName;
    
    private String shiftName;
    
    private String sectionName;
    
    
    private String cmpl_1_sbjName;
    
    private String optn_1_sbjName;
    
    private String cmpl_2_sbjName;
    
    private String optn_2_sbjName;
    
    private String subjectStatus;

    /**
     * @return the acyr
     */
    public int getAcyr() {
        return acyr;
    }

    /**
     * @param acyr the acyr to set
     */
    public void setAcyr(int acyr) {
        this.acyr = acyr;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
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
     * @return the sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @param sectionName the sectionName to set
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * @return the cmpl_1_sbjName
     */
    public String getCmpl_1_sbjName() {
        return cmpl_1_sbjName;
    }

    /**
     * @param cmpl_1_sbjName the cmpl_1_sbjName to set
     */
    public void setCmpl_1_sbjName(String cmpl_1_sbjName) {
        this.cmpl_1_sbjName = cmpl_1_sbjName;
    }

    /**
     * @return the optn_1_sbjName
     */
    public String getOptn_1_sbjName() {
        return optn_1_sbjName;
    }

    /**
     * @param optn_1_sbjName the optn_1_sbjName to set
     */
    public void setOptn_1_sbjName(String optn_1_sbjName) {
        this.optn_1_sbjName = optn_1_sbjName;
    }

    /**
     * @return the cmpl_2_sbjName
     */
    public String getCmpl_2_sbjName() {
        return cmpl_2_sbjName;
    }

    /**
     * @param cmpl_2_sbjName the cmpl_2_sbjName to set
     */
    public void setCmpl_2_sbjName(String cmpl_2_sbjName) {
        this.cmpl_2_sbjName = cmpl_2_sbjName;
    }

    /**
     * @return the optn_2_sbjName
     */
    public String getOptn_2_sbjName() {
        return optn_2_sbjName;
    }

    /**
     * @param optn_2_sbjName the optn_2_sbjName to set
     */
    public void setOptn_2_sbjName(String optn_2_sbjName) {
        this.optn_2_sbjName = optn_2_sbjName;
    }

    /**
     * @return the subjectStatus
     */
    public String getSubjectStatus() {
        return subjectStatus;
    }

    /**
     * @param subjectStatus the subjectStatus to set
     */
    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
    }
}
