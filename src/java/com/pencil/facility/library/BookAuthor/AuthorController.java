/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookAuthor;

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

public class AuthorController {

    private Author author;

    private List<Author> allAuthorList = new ArrayList<Author>();

    AuthorService serviceDao = new AuthorServiceImpl();

    public void addAuthor() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addAuthor(this.author)) {
            context.addMessage(null, new FacesMessage("Successful", "Author is Added"));

            this.author = null;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Author is not added"));
        }

    }

    
   public void updateAuthor() 
    
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateAuthor(this.author))
        {
            context.addMessage(null, new FacesMessage("Successful", "Author is Updated"));
            
            this.author=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Author is not updated"));
        }
        
    }
 
    /**
     * @return the author
     */
    public Author getAuthor() {

        if (this.author == null) {
            this.author = new Author();
        }
        return this.author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return the allAuthorList
     */
    public List<Author> getAllAuthorList() {

        this.allAuthorList = serviceDao.getAllAuthor();

        return this.allAuthorList;
    }

    /**
     * @param allAuthorList the allAuthorList to set
     */
    public void setAllAuthorList(List<Author> allAuthorList) {
        this.allAuthorList = allAuthorList;
    }

}
