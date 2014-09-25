/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamConfig;

import java.io.Serializable;

/**
 *
 * @author apple
 */
public class ExamConfig implements Serializable
{
    private int excnf_id;
    
    private int acyrID;
    
    private String className;
    
    private String instituteID;
    
//    private String deptName;
//    
//    private String shiftName;
//    
//    private String sectionName;
//    
//    private String subjectName;
//    
//    private String teacherName;
    
    private String examName;

    public ExamConfig() {
    }

    public ExamConfig(int excnf_id, int acyrID, String className, String examName) {
        this.excnf_id = excnf_id;
        this.acyrID = acyrID;
        this.className = className;
        this.examName = examName;
    }

//    public ExamConfig(int acyrID, String className, String deptName, String shiftName, String sectionName, String subjectName, String teacherName, String examName) {
//        this.acyrID = acyrID;
//        this.className = className;
//        this.deptName = deptName;
//        this.shiftName = shiftName;
//        this.sectionName = sectionName;
//        this.subjectName = subjectName;
//        this.teacherName = teacherName;
//        this.examName = examName;
//    }
 
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

    
    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }

    
    /**
     * @return the deptName
     */
//    public String getDeptName() {
//        return deptName;
//    }
//
//    /**
//     * @param deptName the deptName to set
//     */
//    public void setDeptName(String deptName) {
//        this.deptName = deptName;
//    }
//
//    /**
//     * @return the shiftName
//     */
//    public String getShiftName() {
//        return shiftName;
//    }
//
//    /**
//     * @param shiftName the shiftName to set
//     */
//    public void setShiftName(String shiftName) {
//        this.shiftName = shiftName;
//    }
//
//    /**
//     * @return the sectionName
//     */
//    public String getSectionName() {
//        return sectionName;
//    }
//
//    /**
//     * @param sectionName the sectionName to set
//     */
//    public void setSectionName(String sectionName) {
//        this.sectionName = sectionName;
//    }
//
//    /**
//     * @return the subjectName
//     */
//    public String getSubjectName() {
//        return subjectName;
//    }
//
//    /**
//     * @param subjectName the subjectName to set
//     */
//    public void setSubjectName(String subjectName) {
//        this.subjectName = subjectName;
//    }
//
//    /**
//     * @return the teacherName
//     */
//    public String getTeacherName() {
//        return teacherName;
//    }
//
//    /**
//     * @param teacherName the teacherName to set
//     */
//    public void setTeacherName(String teacherName) {
//        this.teacherName = teacherName;
//    }

    /**
     * @return the examName
     */
    public String getExamName() {
        return examName;
    }

    /**
     * @param examName the examName to set
     */
    public void setExamName(String examName) {
        this.examName = examName;
    }

    /**
     * @return the excnf_id
     */
    public int getExcnf_id() {
        return excnf_id;
    }

    /**
     * @param excnf_id the excnf_id to set
     */
    public void setExcnf_id(int excnf_id) {
        this.excnf_id = excnf_id;
    }
     
}
