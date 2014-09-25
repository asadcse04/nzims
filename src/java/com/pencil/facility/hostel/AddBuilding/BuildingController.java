/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddBuilding;

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
public class BuildingController {

    private Building building;

    private List<Building> buildingAllList;
    
    
    private List<String> hostelNameList;

    BuildingService serviceDao = new BuildingServiceImpl();

    HostelConfig configDao = new HostelConfigImpl();

    public BuildingController() {
        this.buildingAllList = serviceDao.getAllBuilding();
        this.hostelNameList = configDao.listHostelName();
    }

    public void addBuilding() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.addBuilding(this.building)) {

            context.addMessage(null, new FacesMessage("Successful", "Building data Added"));

            this.building = null;
        } else {

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Building data is not added"));
        }
    }

    public void updateBuilding() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.updateBuilding(this.building)) {

            context.addMessage(null, new FacesMessage("Successful", "Building is Updated"));

            this.building = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Building is not Updated"));
        }
    }

    public Building getBuilding() {
        if (this.building == null) {

            this.building = new Building();
        }
        return this.building;

    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Building> getBuildingAllList() {
        return buildingAllList;
    }

    public void setBuildingAllList(List<Building> buildingAllList) {
        this.buildingAllList = buildingAllList;
    }

    public List<String> getHostelNameList() {
        return hostelNameList;
    }

    public void setHostelNameList(List<String> hostelNameList) {
        this.hostelNameList = hostelNameList;
    }

}
