/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.TransportType;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class TransportType implements Serializable{
    
    private int transportTypeID;
    
    private String transportTypeName;
    
    private String about;
    
    private String note;

    public TransportType() {
    }

    public TransportType(int transportTypeID, String transportTypeName, String about, String note) {
        this.transportTypeID = transportTypeID;
        this.transportTypeName = transportTypeName;
        this.about = about;
        this.note = note;
    }

    public int getTransportTypeID() {
        return transportTypeID;
    }

    public void setTransportTypeID(int transportTypeID) {
        this.transportTypeID = transportTypeID;
    }

    public String getTransportTypeName() {
        return transportTypeName;
    }

    public void setTransportTypeName(String transportTypeName) {
        this.transportTypeName = transportTypeName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
