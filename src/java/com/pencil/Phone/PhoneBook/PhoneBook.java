/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class PhoneBook implements Serializable{
    
    private int contactid;
    
    private String contactName;
    
    private String mobile;
    
    private String note;
    
    private int categoryid;
    
    public PhoneBook(){
        
    }

    public PhoneBook(int contactid, String contactName, String mobile, String note, int categoryid) {
        this.contactid = contactid;
        this.contactName = contactName;
        this.mobile = mobile;
        this.note = note;
        this.categoryid = categoryid;
    }
    
    

    /**
     * @return the contactid
     */
    public int getContactid() {
        return contactid;
    }

    /**
     * @param contactid the contactid to set
     */
    public void setContactid(int contactid) {
        this.contactid = contactid;
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
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    /**
     * @return the categoryid
     */
    public int getCategoryid() {
        return categoryid;
    }

    /**
     * @param categoryid the categoryid to set
     */
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    
     
    
    public boolean equals(Object obj)
    
     {
        if(!(obj instanceof PhoneBook))
        {
            return false;
        }
        return ((PhoneBook)obj).contactid==this.contactid;
    }

    @Override
   
    
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.contactid;
        return hash;
    }



}