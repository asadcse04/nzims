/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.EmailBook;

import com.pencil.EmailBookCategory.EmailBookCategory;
import com.pencil.EmailBookCategory.EmailBookCategoryService;
import com.pencil.EmailBookCategory.EmailBookCategoryServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sis
 */

@ManagedBean
@ViewScoped

public class EmailBookController {
 
    private EmailBook   emailBook;

    private List<EmailBook> emailBookAllList;

    private String emailBookName;

    private List<String> emailBookNameList;

    private List< EmailBookCategory> emailBookCategoryList;

    EmailBookService serviceDao = new EmailBookServiceImpl();
    
   EmailBookCategoryService  emailBookCategoryService = new EmailBookCategoryServiceImpl();
   
   
    public EmailBookController() {
        
               this.emailBookCategoryList = emailBookCategoryService.getAllEmailBookCategory();
 
        
    }

    
     
    public void  addEmailBook() {
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        
          this.emailBook.setCategoryId((Integer.parseInt(emailBookName.split("-")[0])));

        
        if (serviceDao.addEmailBook(this.emailBook)) {
            
            context.addMessage(null, new FacesMessage("Successful", "EmailBook data Added"));

            this.emailBook = null;
        } 
        else {
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "EmailBook data is not added"));
        }
    }

   
    public void updateEmailBook() {
        
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateEmailBook(this.emailBook)) {
            
            context.addMessage(null, new FacesMessage("Successful", "EmailBook is Updated"));

            this.emailBook=null;
            
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "EmailBook is not Updated"));
        }
    }

    
    /**
     * @return the emailBook
     */
    public EmailBook getEmailBook() {
     
        
         if (this.emailBook == null) {
           
            this.emailBook = new EmailBook();
        }
        return this.emailBook;
        
    }

    /**
     * @param emailBook the emailBook to set
     */
    public void setEmailBook(EmailBook emailBook) {
        this.emailBook = emailBook;
    }

    /**
     * @return the emailBookAllList
     */
    public List<EmailBook> getEmailBookAllList() {
 
        this.emailBookAllList = serviceDao.getAllEmailBook();
                
        return this.emailBookAllList;
        
        
    }

    /**
     * @param emailBookAllList the emailBookAllList to set
     */
    public void setEmailBookAllList(List<EmailBook> emailBookAllList) {
        this.emailBookAllList = emailBookAllList;
    }

    /**
     * @return the emailBookName
     */
    public String getEmailBookName() {
        return emailBookName;
    }

    /**
     * @param emailBookName the emailBookName to set
     */
    public void setEmailBookName(String emailBookName) {
        this.emailBookName = emailBookName;
    }

    /**
     * @return the emailBookNameList
     */
    public List<String> getEmailBookNameList() {
      
        
        
         this.emailBookNameList = new ArrayList<String>();

        for (EmailBookCategory  emailBookCategory : emailBookCategoryList) {
            
            this.emailBookNameList.add(emailBookCategory.getCategoryId()+"-"+ emailBookCategory.getCategoryName());

        }

        return this.emailBookNameList;
        
    }

    /**
     * @param emailBookNameList the emailBookNameList to set
     */
    public void setEmailBookNameList(List<String> emailBookNameList) {
        this.emailBookNameList = emailBookNameList;
    }

    /**
     * @return the emailBookCategoryList
     */
    public List< EmailBookCategory> getEmailBookCategoryList() {
        return emailBookCategoryList;
    }

    /**
     * @param emailBookCategoryList the emailBookCategoryList to set
     */
    public void setEmailBookCategoryList(List< EmailBookCategory> emailBookCategoryList) {
        this.emailBookCategoryList = emailBookCategoryList;
    }
    
  
    
}
