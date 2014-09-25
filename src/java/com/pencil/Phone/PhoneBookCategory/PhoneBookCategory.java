/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBookCategory;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class PhoneBookCategory implements Serializable{
    
    private int categoryId;
    
    private String categoryName;
    
    private String note;
    
    
    public PhoneBookCategory(){
        
    }

    
    public PhoneBookCategory(int categoryId, String categoryName, String note) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.note = note;
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
    
}
