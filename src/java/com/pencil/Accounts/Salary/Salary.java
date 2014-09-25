/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Salary;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jahangiralamdiu
 */
public class Salary implements Serializable {
    
    private int acYearId;
    
    private int salaryHeadID;
    
    private List<String> subHeadNameList;
    
    private String salaryName;

    /**
     * @return the salaryHeadID
     */
    public int getSalaryHeadID() {
        return salaryHeadID;
    }

    /**
     * @param salaryHeadID the salaryHeadID to set
     */
    public void setSalaryHeadID(int salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    /**
     * @return the subHeadNameList
     */
    public List<String> getSubHeadNameList() {
        return subHeadNameList;
    }

    /**
     * @param subHeadNameList the subHeadNameList to set
     */
    public void setSubHeadNameList(List<String> subHeadNameList) {
        this.subHeadNameList = subHeadNameList;
    }

    /**
     * @return the salaryName
     */
    public String getSalaryName() {
        return salaryName;
    }

    /**
     * @param salaryName the salaryName to set
     */
    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    /**
     * @return the acYearId
     */
    public int getAcYearId() {
        return acYearId;
    }

    /**
     * @param acYearId the acYearId to set
     */
    public void setAcYearId(int acYearId) {
        this.acYearId = acYearId;
    }
    
    
 

    
   
    
    
}
