/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddStops;

import com.pencil.facility.transport.AddRoute.AddRoute;
import com.pencil.facility.transport.AddRoute.AddRoute_Service;
import com.pencil.facility.transport.AddRoute.AddRoute_Service_Impl;
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
public class AddStops_Controller {

    private AddStops addStops;

    private List<AddStops> stopsList;

    private String stopName;

    private List<String> routeNameList;

    private List<AddRoute> routeList;

    AddStops_Service dao = new AddStops_Service_Impl();

    AddRoute_Service routeDao = new AddRoute_Service_Impl();

    public AddStops_Controller() {

        this.routeList = routeDao.addRouteList();

        this.routeNameList = dao.routeNameList();

        this.stopsList = dao.addStopsList();
    }

    ////////////////// Insert ///////////////
    public void insertStops() {
        FacesContext context = FacesContext.getCurrentInstance();

        this.addStops.setRouteID(Integer.parseInt(stopName.split("-")[0]));

        if (dao.createStops(this.addStops)) {
            this.stopsList = dao.addStopsList();

            context.addMessage(null, new FacesMessage("Successful", "Insert stops information."));

            this.addStops = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert stops info!", ""));
        }
    }

    ////////////////////// Update ///////////////////////
    public void updateStops() {
        FacesContext context = FacesContext.getCurrentInstance();

        this.addStops.setRouteID(Integer.parseInt(stopName.split("-")[0]));

        if (dao.updateStops(this.addStops)) {
            this.stopsList = dao.addStopsList();

            context.addMessage(null, new FacesMessage("Successful", "Update stops information."));

            this.addStops = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update stops info!", ""));
        }
    }
    /////////////////////////////////////////////////////

    public AddStops getAddStops() {

        if (this.addStops == null) {
            this.addStops = new AddStops();
        }
        return addStops;
    }

    public void setAddStops(AddStops addStops) {
        this.addStops = addStops;
    }

    public List<AddStops> getStopsList() {

        return stopsList;
    }

    public void setStopsList(List<AddStops> stopsList) {
        this.stopsList = stopsList;
    }

    public List<String> getRouteNameList() {
        this.routeNameList = new ArrayList<String>();
        for (AddRoute route : routeList) {
            this.routeNameList.add(route.getRouteID() + "-" + route.getRouteName());
        }
        return routeNameList;
    }

    public void setRouteNameList(List<String> routeNameList) {
        this.routeNameList = routeNameList;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public List<AddRoute> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<AddRoute> routeList) {
        this.routeList = routeList;
    }

}
