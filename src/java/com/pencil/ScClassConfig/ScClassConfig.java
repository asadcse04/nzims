/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mahfuj
 */
public class ScClassConfig implements Serializable
{
    private int scConfigID;
    
    private int acyrID;
    
    private String className;
    
    private String deptName;
    
    private String shiftName;
    
    private String sectionName;
    
    private String roomNum;
    
    private int totalStudentCount;

    public ScClassConfig()
    {
       
        Date date = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy");
        acyrID =Integer.valueOf(simpleDateformat.format(date)); 
    }

    public ScClassConfig(int scConfigID, int acyrID, String className, String deptName, String shiftName, String sectionName, String roomNum) {
        this.scConfigID = scConfigID;
        this.acyrID = acyrID;
        this.className = className;
        this.deptName = deptName;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.roomNum = roomNum;
    }

    public ScClassConfig(int acyrID, String className, String shiftName, String sectionName) { //Student Attendence purpose
        this.acyrID = acyrID;
        this.className = className;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
    }
    
    
    public ScClassConfig(int acyrID, String className, String shiftName, String sectionName,int totalStudentCount) { //Student Attendence purpose
        this.acyrID = acyrID;
        this.className = className;
        this.shiftName = shiftName;
        this.sectionName = sectionName;
        this.totalStudentCount = totalStudentCount;
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
     * @return the roomNum
     */
    public String getRoomNum() {
        return roomNum;
    }

    /**
     * @param roomNum the roomNum to set
     */
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    /**
     * @return the scConfigID
     */
    public int getScConfigID() {
        return scConfigID;
    }

    /**
     * @param scConfigID the scConfigID to set
     */
    public void setScConfigID(int scConfigID) {
        this.scConfigID = scConfigID;
    }

    public int getTotalStudentCount() {
        return totalStudentCount;
    }

    public void setTotalStudentCount(int totalStudentCount) {
        this.totalStudentCount = totalStudentCount;
    }
    
    
}
