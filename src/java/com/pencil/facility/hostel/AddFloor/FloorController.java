/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddFloor;

import com.pencil.facility.hostel.AddBuilding.Building;
import com.pencil.facility.hostel.AddBuilding.BuildingService;
import com.pencil.facility.hostel.AddBuilding.BuildingServiceImpl;
import com.pencil.facility.hostel.CreateHostel.Hostel;
import com.pencil.facility.hostel.CreateHostel.HostelService;
import com.pencil.facility.hostel.CreateHostel.HostelServiceImpl;
import com.pencil.facility.hostel.config.HostelConfig;
import com.pencil.facility.hostel.config.HostelConfigImpl;
import java.util.ArrayList;
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
public class FloorController {

    private Floor floor;

    private List<Floor> floorAllList;

    private String floorName;

    private List<String> hostelNameList;

    private List<String> hostelNameListdata;

    private List<String> floorNameList;

    private List<Hostel> hostelList;

    private List<String> buildingNameList;

    private List<Building> buildingList;

    FloorService serviceDao = new FloorServiceImpl();

    BuildingService buildingService = new BuildingServiceImpl();

    HostelService hostelDao = new HostelServiceImpl();

    HostelConfig confDao = new HostelConfigImpl();

    public FloorController() {

        this.hostelNameListdata = confDao.listHostelName();
        this.floorAllList = serviceDao.getAllFloor();
        this.buildingList = buildingService.getAllBuilding();
        this.hostelList = hostelDao.getAllHostel();

    }

    public void buildingName_List() {
        this.buildingNameList = confDao.listBuildingName(this.floor.getHostelName());
    }

    public void addFloor() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addFloor(this.floor)) {

            context.addMessage(null, new FacesMessage("Successful", "Floor data Added"));

            this.floor = null;
        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Floor data is not added"));
        }
    }

    public void updateFloor() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateFloor(this.floor)) {

            context.addMessage(null, new FacesMessage("Successful", "Floor is Updated"));

            this.floor = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Floor is not Updated"));
        }
    }

    /**
     * @return the floor
     */
    public Floor getFloor() {

        if (this.floor == null) {

            this.floor = new Floor();
        }
        return this.floor;

    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    /**
     * @return the floorAllList
     */
    public List<Floor> getFloorAllList() {

        return this.floorAllList;
    }

    /**
     * @param floorAllList the floorAllList to set
     */
    public void setFloorAllList(List<Floor> floorAllList) {
        this.floorAllList = floorAllList;
    }

    /**
     * @return the floorName
     */
    public String getFloorName() {
        return floorName;
    }

    /**
     * @param floorName the floorName to set
     */
    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    /**
     * @return the floorNameList
     */
    public List<String> getFloorNameList() {

        this.floorNameList = new ArrayList<String>();

        for (Building building : buildingList) {

            this.floorNameList.add(building.getBuildingId() + "-" + building.getBuildingName());

        }

        return this.floorNameList;

    }

    /**
     * @param floorNameList the floorNameList to set
     */
    public void setFloorNameList(List<String> floorNameList) {
        this.floorNameList = floorNameList;
    }

    public List<String> getHostelNameList() {

        this.hostelNameList = new ArrayList<String>();

        for (Hostel hostel : hostelList) {

            this.hostelNameList.add(hostel.getHostelId() + "-" + hostel.getHostelName());

        }
        return hostelNameList;
    }

    public void setHostelNameList(List<String> hostelNameList) {
        this.hostelNameList = hostelNameList;
    }

    /**
     * @return the buildingList
     */
    public List< Building> getBuildingList() {
        return buildingList;
    }

    /**
     * @param buildingList the buildingList to set
     */
    public void setBuildingList(List< Building> buildingList) {
        this.buildingList = buildingList;
    }

    public List<Hostel> getHostelList() {
        return hostelList;
    }

    public void setHostelList(List<Hostel> hostelList) {
        this.hostelList = hostelList;
    }

    public List<String> getBuildingNameList() {
        return buildingNameList;
    }

    public void setBuildingNameList(List<String> buildingNameList) {
        this.buildingNameList = buildingNameList;
    }

    public List<String> getHostelNameListdata() {

        return hostelNameListdata;
    }

    public void setHostelNameListdata(List<String> hostelNameListdata) {
        this.hostelNameListdata = hostelNameListdata;
    }

}
