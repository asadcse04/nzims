/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCategory;

import java.io.Serializable;

/**
 *
 * @author Mamun
 */
public class FeeCategory implements Serializable {
    
    private int categoryID;
    
    private String categoryName;
    
    private String note;

    public FeeCategory() {
    }

    public FeeCategory(int categoryID, String categoryName, String note) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.note = note;
    }
    
    
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
