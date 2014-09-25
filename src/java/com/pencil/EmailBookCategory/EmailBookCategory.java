/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.EmailBookCategory;

import java.io.Serializable;

/**
 *
 * @author sis
 */
public class EmailBookCategory implements Serializable{

    private int categoryId;

    private String categoryName;

    private String categoryNote;

    public EmailBookCategory() {
        
        
    }

   
    public EmailBookCategory(int categoryId, String categoryName, String categoryNote) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryNote = categoryNote;
    }

     
    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the categoryNote
     */
    public String getCategoryNote() {
        return categoryNote;
    }

    /**
     * @param categoryNote the categoryNote to set
     */
    public void setCategoryNote(String categoryNote) {
        this.categoryNote = categoryNote;
    }

    
    
    
    
}
