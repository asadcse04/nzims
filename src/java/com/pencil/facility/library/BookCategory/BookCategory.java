/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookCategory;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class BookCategory implements Serializable {

    private int bookCategoryId;

    private String bookCategoryName;

    private String bookCategorynote;

    public BookCategory() {

    }

    public BookCategory(int bookCategoryId, String bookCategoryName, String bookCategorynote) {
        
        this.bookCategoryId = bookCategoryId;
        this.bookCategoryName = bookCategoryName;
        this.bookCategorynote = bookCategorynote;
        
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

    /**
     * @return the bookCategoryName
     */
    public String getBookCategoryName() {
        return bookCategoryName;
    }

    /**
     * @param bookCategoryName the bookCategoryName to set
     */
    public void setBookCategoryName(String bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }

    /**
     * @return the bookCategorynote
     */
    public String getBookCategorynote() {
        return bookCategorynote;
    }

    /**
     * @param bookCategorynote the bookCategorynote to set
     */
    public void setBookCategorynote(String bookCategorynote) {
        this.bookCategorynote = bookCategorynote;
    }

}
