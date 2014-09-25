package com.pencil.EmailBook;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sis
 */
public class EmailBook implements Serializable{

    private int contactId;

    private String contactName;

    private String emailAddress;

    private String emailNote;

   private int categoryId;
    
   private String categoryName;

    public EmailBook() {
        
        
        
    }

    public EmailBook(int contactId, String contactName, String emailAddress, String emailNote,int categoryId, String categoryName ) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.emailAddress = emailAddress;
        this.emailNote = emailNote;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

  
   

   
    /**
     * @return the contactId
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * @param contactId the contactId to set
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the emailNote
     */
    public String getEmailNote() {
        return emailNote;
    }

    /**
     * @param emailNote the emailNote to set
     */
    public void setEmailNote(String emailNote) {
        this.emailNote = emailNote;
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

    
    
    
    
    

}
