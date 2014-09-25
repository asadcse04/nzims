/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Designation.Designation;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class Designation implements Serializable {
    
    private int designationID;
    
    private String designationName;
    
    private String note;
    
    private int designationCategoryID;

    
    
    public Designation() 
    {
    
    }

    
    
    public Designation(int designationID, String designationName, String note, int designationCategoryID) 
    {
        this.designationID = designationID;
        this.designationName = designationName;
        this.note = note;
        this.designationCategoryID = designationCategoryID;
    }

    /**
     * @return the designationID
     */
    public int getDesignationID() {
        return designationID;
    }

    /**
     * @param designationID the designationID to set
     */
    public void setDesignationID(int designationID) {
        this.designationID = designationID;
    }

    /**
     * @return the designationName
     */
    public String getDesignationName() {
        return designationName;
    }

    /**
     * @param designationName the designationName to set
     */
    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the designationCategoryID
     */
    public int getDesignationCategoryID() {
        return designationCategoryID;
    }

    /**
     * @param designationCategoryID the designationCategoryID to set
     */
    public void setDesignationCategoryID(int designationCategoryID) {
        this.designationCategoryID = designationCategoryID;
    }
    
    

    
       
}
