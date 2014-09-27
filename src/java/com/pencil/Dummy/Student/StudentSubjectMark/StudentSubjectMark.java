/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.StudentSubjectMark;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mamun
 */
public class StudentSubjectMark implements Serializable
{
   
    private int ScConfigID;
    
    private int acyr;
    
    private String className;
    
    private String deptName;
    
    private String shiftName;
    
    private String sectionName;
    
    private String examName;
    
    private String subjectName;
    
    private String teacherName;
    
    private int resultid;
    private String studentid;
    private String studentname;
    private int roll;
    private String shortcode1;
    private String shortcode2;
    private String shortcode3;
    private String shortcode4;
    private int examconfigid;
    private int subjectid;
    private String instituteid;
    
    
   
    
    private List<String> subjectlist;
    
    
    public StudentSubjectMark() {
    }

    public StudentSubjectMark(int resultid, String studentid, String studentname, int roll, String shortcode1, String shortcode2, String shortcode3, String shortcode4, int examconfigid, int subjectid, String instituteid) {
        this.resultid = resultid;
        this.studentid = studentid;
        this.studentname = studentname;
        this.roll = roll;
        this.shortcode1 = shortcode1;
        this.shortcode2 = shortcode2;
        this.shortcode3 = shortcode3;
        this.shortcode4 = shortcode4;
        this.examconfigid = examconfigid;
        this.subjectid = subjectid;
        this.instituteid = instituteid;
    }
    
    
    

    public StudentSubjectMark(String studentid, String studentname, int roll, String shortcode1, String shortcode2, String shortcode3, String shortcode4) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.roll = roll;
        this.shortcode1 = shortcode1;
        this.shortcode2 = shortcode2;
        this.shortcode3 = shortcode3;
        this.shortcode4 = shortcode4;
    }
    
    

    public StudentSubjectMark(int acyr, String className,String shiftName, String sectionName, String  deptName, List<String> subjectlist) {
        this.acyr = acyr;
        this.className = className;
        this.deptName = deptName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.subjectlist = subjectlist;
    }

    public StudentSubjectMark(int ScConfigID, int acyr, String className,String shiftName,String sectionName, String deptName, List<String> subjectlist) {
        this.ScConfigID = ScConfigID;
        this.acyr = acyr;
        this.className = className;
        this.deptName = deptName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.subjectlist = subjectlist;
    }
    
    

    
    
    
    
    
    public int getScConfigID() {
        return ScConfigID;
    }

    public void setScConfigID(int ScConfigID) {
        this.ScConfigID = ScConfigID;
    }
    

    
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

    public List<String> getSubjectlist() {
        return subjectlist;
    }

    public void setSubjectlist(List<String> subjectlist) {
        this.subjectlist = subjectlist;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getShortcode1() {
        return shortcode1;
    }

    public void setShortcode1(String shortcode1) {
        this.shortcode1 = shortcode1;
    }

    public String getShortcode2() {
        return shortcode2;
    }

    public void setShortcode2(String shortcode2) {
        this.shortcode2 = shortcode2;
    }

    public String getShortcode3() {
        return shortcode3;
    }

    public void setShortcode3(String shortcode3) {
        this.shortcode3 = shortcode3;
    }

    public String getShortcode4() {
        return shortcode4;
    }

    public void setShortcode4(String shortcode4) {
        this.shortcode4 = shortcode4;
    }

    public int getResultid() {
        return resultid;
    }

    public void setResultid(int resultid) {
        this.resultid = resultid;
    }

    public int getExamconfigid() {
        return examconfigid;
    }

    public void setExamconfigid(int examconfigid) {
        this.examconfigid = examconfigid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getInstituteid() {
        return instituteid;
    }

    public void setInstituteid(String instituteid) {
        this.instituteid = instituteid;
    }
    
    
}
