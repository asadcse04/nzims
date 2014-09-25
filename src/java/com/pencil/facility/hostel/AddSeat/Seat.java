/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddSeat;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class Seat implements Serializable{

    private int seatId;

    private String seatName;

    private String seatLocation;

    private String seatNote;

    private int roomId;
    
    private String hostelName;
    
    private String buildingName;
    
    private String floorName;
    
    private String roomName;

    public Seat() {
    }

    public Seat(int seatId, String seatName, String seatLocation, String seatNote, int roomId, String roomName) {
        this.seatId = seatId;
        this.seatName = seatName;
        this.seatLocation = seatLocation;
        this.seatNote = seatNote;
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }

    public String getSeatNote() {
        return seatNote;
    }

    public void setSeatNote(String seatNote) {
        this.seatNote = seatNote;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


}
