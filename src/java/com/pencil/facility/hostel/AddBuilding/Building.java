/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddBuilding;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class Building implements Serializable {

    private int buildingId;

    private String buildingName;

    private String buildingAddress;

    private String buildingNote;

    private int hostelId;

    private String hostelName;

    public Building() {

    }

    public Building(int buildingId, String buildingName, String buildingAddress, String buildingNote, int hostelId, String hostelName) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingNote = buildingNote;
        this.hostelId = hostelId;
        this.hostelName = hostelName;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getBuildingNote() {
        return buildingNote;
    }

    public void setBuildingNote(String buildingNote) {
        this.buildingNote = buildingNote;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

}
