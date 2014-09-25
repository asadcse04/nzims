/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Gallery.Committee;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class Committee implements Serializable{
    
    private String id;
    private String designation;
    private String name;
    private String fathername;
    private String address;
    private String mobile;
    private String about;
    private String imgpath;

    public Committee() {
    
    }

    public Committee(String id, String designation, String name, String fathername, String address, String mobile, String about, String imgpath) {
        this.id = id;
        this.designation = designation;
        this.name = name;
        this.fathername = fathername;
        this.address = address;
        this.mobile = mobile;
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
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fathername
     */
    public String getFathername() {
        return fathername;
    }

    /**
     * @param fathername the fathername to set
     */
    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
