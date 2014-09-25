/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookSubCategory;


import com.pencil.facility.library.BookCategory.BookCategory;
import com.pencil.facility.library.BookCategory.BookCategoryService;
import com.pencil.facility.library.BookCategory.BookCategoryServiceImpl;
import java.util.ArrayList;
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
public class BookSubCategoryController {

    private BookSubCategory bookSubCategory;

    private List<BookSubCategory> bookSubCategoryAllList;

    private String bookSubCategoryName;

    private List<String> bookSubCategoryNameList;

    private List<BookCategory> bookCategoryList;

    BookSubCategoryService serviceDao = new BookSubCategoryImpl();

    BookCategoryService bookCategoryService = new BookCategoryServiceImpl();

    public BookSubCategoryController() {

        this.bookCategoryList = bookCategoryService.getAllBookCategory();

    }

    public void addBookSubCategory() {
        FacesContext context = FacesContext.getCurrentInstance();

        this.getBookSubCategory().setBookCategoryId(Integer.parseInt(getBookSubCategoryName().split("-")[0]));

        if (serviceDao.addBookSubCategory(this.getBookSubCategory())) {
            context.addMessage(null, new FacesMessage("Successful", "BookSubCategory is Added"));

            this.setBookSubCategory(null);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "BookSubCategoryis not added"));
        }
    }

    public void updateBookSubCategory() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateBookSubCategory(this.bookSubCategory)) {

            context.addMessage(null, new FacesMessage("Successful", "BookSubCategory is Updated"));

            this.setBookSubCategory(null);

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "BookSubCategoryis not Updated"));
        }
    }

    /**
     * @return the bookSubCategory
     */
    public BookSubCategory getBookSubCategory() {
        if (this.bookSubCategory == null) {
            this.bookSubCategory = new BookSubCategory();
        }
        return this.bookSubCategory;
    }

    /**
     * @param bookSubCategory the bookSubCategory to set
     */
    public void setBookSubCategory(BookSubCategory bookSubCategory) {
        this.bookSubCategory = bookSubCategory;
    }

    /**
     * @return the bookSubCategoryAllList
     */
    public List<BookSubCategory> getBookSubCategoryAllList() {
        this.bookSubCategoryAllList = serviceDao.getAllBookSubCategory();
        return this.bookSubCategoryAllList;
    }

    /**
     * @param bookSubCategoryAllList the bookSubCategoryAllList to set
     */
    public void setBookSubCategoryAllList(List<BookSubCategory> bookSubCategoryAllList) {
        this.bookSubCategoryAllList = bookSubCategoryAllList;
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
     * @return the bookSubCategoryNameList
     */
    public List<String> getBookSubCategoryNameList() {
        this.bookSubCategoryNameList = new ArrayList<String>();

        for (BookCategory bookCategory : bookCategoryList) {
            this.bookSubCategoryNameList.add(bookCategory.getBookCategoryId() + "-" + bookCategory.getBookCategoryName());

        }
        return this.bookSubCategoryNameList;
    }

    /**
     * @param bookSubCategoryNameList the bookSubCategoryNameList to set
     */
    public void setBookSubCategoryNameList(List<String> bookSubCategoryNameList) {
        this.bookSubCategoryNameList = bookSubCategoryNameList;
    }

    /**
     * @return the bookCategoryList
     */
    public List<BookCategory> getBookCategoryList() {
        return bookCategoryList;
    }

    /**
     * @param bookCategoryList the bookCategoryList to set
     */
    public void setBookCategoryList(List<BookCategory> bookCategoryList) {
        this.bookCategoryList = bookCategoryList;
    }

}
