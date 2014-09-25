/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Gallery.Photo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Riad
 */
public class Photo implements Serializable{
    
    private String id;
    private String eventname;
    private Date enentdate;
    private String about;
    private String imgpath;

    public Photo() {
    }

    public Photo(String id, String eventname, Date enentdate, String about, String imgpath) {
        this.id = id;
        this.eventname = eventname;
        this.enentdate = enentdate;
        this.about = about;
        this.imgpath = imgpath;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the eventname
     */
    public String getEventname() {
        return eventname;
    }

    /**
     * @param eventname the eventname to set
     */
    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    /**
     * @return the enentdate
     */
    public Date getEnentdate() {
        return enentdate;
    }

    /**
     * @param enentdate the enentdate to set
     */
    public void setEnentdate(Date enentdate) {
        this.enentdate = enentdate;
    }

    /**
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * @param about the about to set
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * @return the imgpath
     */
    public String getImgpath() {
        return imgpath;
    }

    /**
     * @param imgpath the imgpath to set
     */
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
    
    
    
    
}
