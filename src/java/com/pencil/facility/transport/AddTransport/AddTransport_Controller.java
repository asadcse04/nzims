/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddTransport;

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
public class AddTransport_Controller {

    private AddTransport addTransport;

    private List<AddTransport> addTransportList;

    private List<String> transportTypeName;

    AddTransport_Service dao = new AddTransport_service_Impl();

    public AddTransport_Controller() {

        this.addTransportList = dao.transportList();

        this.transportTypeName = dao.transportTypeNameList();
    }

    ///////////////////////////
    public void insertTransport() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.createTransport(this.addTransport)) {
            this.addTransportList = dao.transportList();

            context.addMessage(null, new FacesMessage("Successful", "Insert Transport information."));

            this.addTransport = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert Transport info!", ""));
        }

    }
    ///////////////////////////
     public void updateTransport() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.updateTransport(this.addTransport)) {
            this.addTransportList = dao.transportList();

            context.addMessage(null, new FacesMessage("Successful", "Update Transport information."));

            this.addTransport = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update transport info!", ""));
        }

    }
    ///////////////////////////

    public AddTransport getAddTransport() {

        if (this.addTransport == null) {

            this.addTransport = new AddTransport();
        }
        return addTransport;
    }

    public void setAddTransport(AddTransport addTransport) {
        this.addTransport = addTransport;
    }

    public List<AddTransport> getAddTransportList() {
        return addTransportList;
    }

    public void setAddTransportList(List<AddTransport> addTransportList) {
        this.addTransportList = addTransportList;
    }

    public List<String> getTransportTypeName() {
        return transportTypeName;
    }

    public void setTransportTypeName(List<String> transportTypeName) {
        this.transportTypeName = transportTypeName;
    }

}
