/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddDriver;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author SHOHUG-SQ
 */
@ManagedBean
@ViewScoped

public class Driver_Controller implements Serializable {

    private Driver driver;

    private List<Driver> driverData;

    private UploadedFile photoFile;

    ImgUpLoad uploadService = new ImgUpload_Impl();

    Driver_Service dao = new Driver_Service_Impl();

    public Driver_Controller() {

        this.driverData = dao.driverList();
    }

    ////////////////// Insert ///////////////
    public void insertDriver() {
        if (this.photoFile != null) {
            this.driver.setImage(this.photoFile.getFileName());
            if (dao.createDriver(this.driver)) {
                uploadService.uploadImg("DriverImages", driver.getDriverID() + "_" + photoFile.getFileName(), photoFile);
//                this.driverData = dao.driverList();
                this.driver = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful", "Insert Driver information."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert driver info!", ""));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warnning", "Please select driver image...!"));
        }
    }

    /////////////////////////////////////////////
    public void updateDriver() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (dao.updateDriver(this.driver)) {
            this.driverData = dao.driverList();
            context.addMessage(null, new FacesMessage("Successful", "Update Driver information."));

            this.driver = null;

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update driver info!", ""));
        }
    }

    ///////////////////////////////////////
    public Driver getDriver() {
        if (this.driver == null) {
            this.driver = new Driver();
        }
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Driver> getDriverData() {
        return driverData;
    }

    public void setDriverData(List<Driver> driverData) {
        this.driverData = driverData;
    }

    public UploadedFile getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }

}
