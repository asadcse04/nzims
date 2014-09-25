/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.CreateHostel;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class Hostel implements Serializable {

    private int hostelId;

    private String hostelName;
   
    private String hostelType;

    private String hostelAddress;

    private String hostelNote;

    public Hostel() {
    }

    public Hostel(int hostelId, String hostelName, String hostelType, String hostelAddress, String hostelNote) {
        this.hostelId = hostelId;
        this.hostelName = hostelName;
        this.hostelType = hostelType;
        this.hostelAddress = hostelAddress;
        this.hostelNote = hostelNote;
    }
    
    

    /**
     * @return the hostelId
     */
    public int getHostelId() {
        return hostelId;
    }

    /**
     * @param hostelId the hostelId to set
     */
    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    /**
     * @return the hostelName
     */
    public String getHostelName() {
        return hostelName;
    }

    /**
     * @param hostelName the hostelName to set
     */
    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    /**
     * @return the hostelType
     */
    public String getHostelType() {
        return hostelType;
    }

    /**
     * @param hostelType the hostelType to set
     */
    public void setHostelType(String hostelType) {
        this.hostelType = hostelType;
    }

    /**
     * @return the hostelAddress
     */
    public String getHostelAddress() {
        return hostelAddress;
    }

    /**
     * @param hostelAddress the hostelAddress to set
     */
    public void setHostelAddress(String hostelAddress) {
        this.hostelAddress = hostelAddress;
    }

    /**
     * @return the hostelNote
     */
    public String getHostelNote() {
        return hostelNote;
    }

    /**
     * @param hostelNote the hostelNote to set
     */
    public void setHostelNote(String hostelNote) {
        this.hostelNote = hostelNote;
    }

}
