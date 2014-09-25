/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddFloor;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class Floor implements Serializable {

    private int floorId;

    private String floorName;

    private String floorLocation;

    private String floorNote;

    private int buildingId;

    private String buildingName;
    
    private int hostelId;

    private String hostelName;

    public Floor() {

    }

    public Floor(int floorId, String floorName, String floorLocation, String floorNote, int buildingId, String buildingName, int hostelId, String hostelName) {
        this.floorId = floorId;
        this.floorName = floorName;
        this.floorLocation = floorLocation;
        this.floorNote = floorNote;
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.hostelId = hostelId;
        this.hostelName = hostelName;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getFloorLocation() {
        return floorLocation;
    }

    public void setFloorLocation(String floorLocation) {
        this.floorLocation = floorLocation;
    }

    public String getFloorNote() {
        return floorNote;
    }

    public void setFloorNote(String floorNote) {
        this.floorNote = floorNote;
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
