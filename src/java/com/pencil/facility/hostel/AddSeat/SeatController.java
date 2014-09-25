/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddSeat;

import com.pencil.facility.hostel.config.HostelConfig;
import com.pencil.facility.hostel.config.HostelConfigImpl;
import java.io.Serializable;
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

public class SeatController implements Serializable {

    private Seat seat;

    private List<Seat> seatList;

    private List<String> hostelNameList;

    private List<String> buildingNameList;

    private List<String> floorNameList;

    private List<String> roomNameList;

    SeatService serviceDao = new SeatServiceImpl();

    HostelConfig configDao = new HostelConfigImpl();

    public SeatController() {

        this.seatList = serviceDao.getAllSeat();

        this.hostelNameList = configDao.listHostelName();
    }

    public void buildingName_List() {
        this.buildingNameList = configDao.listBuildingName(this.seat.getHostelName());
    }

    public void floorName_List() {
        this.floorNameList = configDao.listFloorName(this.seat.getBuildingName());
    }

    public void roomName_List() {
        this.roomNameList = configDao.listRoomName(this.seat.getFloorName());
    }

    public void addSeat() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addSeat(this.seat)) {

            context.addMessage(null, new FacesMessage("Successful", "Seat data Added"));

            this.seat = null;
        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Seat data is not added"));
        }
    }

    public void updateSeat() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateSeat(this.seat)) {

            context.addMessage(null, new FacesMessage("Successful", "Seat is Updated"));

            this.seat = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Seat is not Updated"));
        }
    }

    public Seat getSeat() {

        if (this.seat == null) {

            this.seat = new Seat();
        }
        return this.seat;

    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public List<Seat> getSeatList() {
        this.seatList = serviceDao.getAllSeat();
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
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

    public List<String> getRoomNameList() {
        return roomNameList;
    }

    public void setRoomNameList(List<String> roomNameList) {
        this.roomNameList = roomNameList;
    }

}
