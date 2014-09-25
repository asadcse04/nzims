/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Notice.NoticeCategory;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class NoticeCategory implements Serializable{
   
    private int categoryid;
    
    private String categoryname;
    
    private String color;
    
    private String note;

    
    public NoticeCategory()
    {
        
    } 
    
    
    public NoticeCategory(int categoryid, String categoryname, String color, String note)
    {
        
        this.categoryid = categoryid;
        
        this.categoryname = categoryname;
        
        this.color = color;
        
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

    /**
     * @return the categoryname
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * @param categoryname the categoryname to set
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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
