/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookSubCategory;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class BookSubCategory implements Serializable{

    private int bookSubCategoryId;

    private String bookSubCategoryName;

    private String bookSubCategorynote;

    private int bookCategoryId;

    public BookSubCategory() {
        
        
    }

    public BookSubCategory(int bookSubCategoryId, String bookSubCategoryName, String bookSubCategorynote, int bookCategoryId) {
        this.bookSubCategoryId = bookSubCategoryId;
        this.bookSubCategoryName = bookSubCategoryName;
        this.bookSubCategorynote = bookSubCategorynote;
        this.bookCategoryId = bookCategoryId;
    }

    
    /**
     * @return the bookSubCategoryId
     */
    public int getBookSubCategoryId() {
        return bookSubCategoryId;
    }

    /**
     * @param bookSubCategoryId the bookSubCategoryId to set
     */
    public void setBookSubCategoryId(int bookSubCategoryId) {
        this.bookSubCategoryId = bookSubCategoryId;
    }

    /**
     * @return the bookSubCategoryName
     */
    public String getBookSubCategoryName() {
        return bookSubCategoryName;
    }

    /**
     * @param bookSubCategoryName the bookSubCategoryName to set
     */
    public void setBookSubCategoryName(String bookSubCategoryName) {
        this.bookSubCategoryName = bookSubCategoryName;
    }

    /**
     * @return the bookSubCategorynote
     */
    public String getBookSubCategorynote() {
        return bookSubCategorynote;
    }

    /**
     * @param bookSubCategorynote the bookSubCategorynote to set
     */
    public void setBookSubCategorynote(String bookSubCategorynote) {
        this.bookSubCategorynote = bookSubCategorynote;
    }

    /**
     * @return the bookCategoryId
     */
    public int getBookCategoryId() {
        return bookCategoryId;
    }

    /**
     * @param bookCategoryId the bookCategoryId to set
     */
    public void setBookCategoryId(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }
    
    
    
    
}
