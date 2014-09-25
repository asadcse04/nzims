/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass.ClassRoom;

import java.io.Serializable;


/**
 *
 * @author Mahfuj
 */

public class ClassRoom implements Serializable {
   
  
    private int roomID;

    private String roomNo;
 
    private String location;

    private String note;
 
    private int roomCapacity;
 
    private int examCapacity;

    public ClassRoom() 
    {
    
    }

    public ClassRoom(int roomID, String roomNo, String location, String note, int roomCapacity, int examCapacity) {
        this.roomID = roomID;
        this.roomNo = roomNo;
        this.location = location;
        this.note = note;
        this.roomCapacity = roomCapacity;
        this.examCapacity = examCapacity;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public int getExamCapacity() {
        return examCapacity;
    }

    public void setExamCapacity(int examCapacity) {
        this.examCapacity = examCapacity;
    }

}
