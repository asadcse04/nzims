/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookCategory;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG-SQ
 */

@ManagedBean
@ViewScoped
public class BookCategoryController implements Serializable {

    private BookCategory bookCategory;

    private List<BookCategory> bookCategoryAllList;

    BookCategoryService serviceDao = new BookCategoryServiceImpl();

    public BookCategoryController() {
        
        this.bookCategoryAllList=serviceDao.getAllBookCategory();
    }
    
    

    public void addBookCategory() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addBookCategory(this.bookCategory)) {
            context.addMessage(null, new FacesMessage("Successful", "BookCategory is Added"));

            this.bookCategory = null;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "BookCategory is not added"));
        }
    }

    public void updateBookCategory() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateBookCategory(this.bookCategory)) {
            context.addMessage(null, new FacesMessage("Successful", "BookCategory is Updated"));

            this.bookCategory = null;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "BookCategory is not updated"));
        }

    }

    /**
     * @return the bookCategory
     */
    public BookCategory getBookCategory() {

        if (this.bookCategory == null) {
            this.bookCategory = new BookCategory();
        }
        return this.bookCategory;
    }

    /**
     * @param bookCategory the bookCategory to set
     */
    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    /**
     * @return the bookCategoryAllList
     */
    public List<BookCategory> getBookCategoryAllList() {

        this.bookCategoryAllList = serviceDao.getAllBookCategory();

        return this.bookCategoryAllList;

    }

    /**
     * @param bookCategoryAllList the bookCategoryAllList to set
     */
    public void setBookCategoryAllList(List<BookCategory> bookCategoryAllList) {
        this.bookCategoryAllList = bookCategoryAllList;
    }

}
