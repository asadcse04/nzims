/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddRoute;

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
public class AddRoute_Controller implements Serializable {

    private AddRoute addRouteItem;

    private List<AddRoute> routeList;

    AddRoute_Service dao = new AddRoute_Service_Impl();

    public AddRoute_Controller() {

        this.routeList = dao.addRouteList();
    }

    ////////////////// Insert ///////////////
    public void insertRoute() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.createAddRoute(this.addRouteItem)) {
            this.routeList = dao.addRouteList();

            this.addRouteItem = null;

            context.addMessage(null, new FacesMessage("Successful", "Insert route information."));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert route info!", ""));
        }
    }

    ///////////////////// Update ////////////////////////
    public void updateRoute() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.updateRoute(this.addRouteItem)) {
            this.routeList = dao.addRouteList();

            this.addRouteItem = null;

            context.addMessage(null, new FacesMessage("Successful", "Update route information."));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update route info!", ""));
        }

    }
//////////////////////////////////////////////////////////////
    public AddRoute getAddRouteItem() {

        if (this.addRouteItem == null) {
            this.addRouteItem = new AddRoute();
        }

        return addRouteItem;
    }

    public void setAddRouteItem(AddRoute addRouteItem) {
        this.addRouteItem = addRouteItem;
    }

    public List<AddRoute> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<AddRoute> routeList) {
        this.routeList = routeList;
    }

}
