/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddRoom;

import com.pencil.facility.hostel.config.HostelConfig;
import com.pencil.facility.hostel.config.HostelConfigImpl;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG-SQ
 */
@ManagedBean
@ViewScoped

public class RoomController {

    private Room room;

    private List<String> roomNameList;

    private List<Room> roomList;

    private List<String> hostelNameList;

    private List<String> buildingNameList;

    private List<String> floorNameList;

    RoomService serviceDao = new RoomServiceImpl();

    HostelConfig configDao = new HostelConfigImpl();

    public RoomController() {

        this.roomList = serviceDao.getAllRoom();

        this.hostelNameList = configDao.listHostelName();

    }

    public void buildingName_List() {
        this.buildingNameList = configDao.listBuildingName(this.room.getHostelName());
    }

    public void floorName_List() {
        this.floorNameList = configDao.listFloorName(this.room.getBuildingName());
    }

    public void addRoom() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addRoom(this.room)) {

            context.addMessage(null, new FacesMessage("Successful", "Room data Added"));

            this.room = null;
        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Room data is not added"));
        }
    }

    public void updateRoom() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateRoom(this.room)) {

            context.addMessage(null, new FacesMessage("Successful", "Room is Updated"));

            this.room = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Room is not Updated"));
        }
    }

    public Room getRoom() {
        if (this.room == null) {
            this.room = new Room();
        }
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<String> getRoomNameList() {
        return roomNameList;
    }

    public void setRoomNameList(List<String> roomNameList) {
        this.roomNameList = roomNameList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<String> getHostelNameList() {
        return hostelNameList;
    }

    public void setHostelNameList(List<String> hostelNameList) {
        this.hostelNameList = hostelNameList;
    }

    public List<String> getBuildingNameList() {
        return buildingNameList;
    }

    public void setBuildingNameList(List<String> buildingNameList) {
        this.buildingNameList = buildingNameList;
    }

    public List<String> getFloorNameList() {
        return floorNameList;
    }

    public void setFloorNameList(List<String> floorNameList) {
        this.floorNameList = floorNameList;
    }

}
