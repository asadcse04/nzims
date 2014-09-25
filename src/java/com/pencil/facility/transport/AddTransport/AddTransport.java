/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddTransport;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class AddTransport implements Serializable {

    private int vehicleID;

    private String vehicleName;

    private String VehicleDescription;

    private String specialSymbol;

    private int seatCapacity;

    private String Note;

    private String imgPath;

    private int vehicleTypeID;

    private String typeName;

    public AddTransport() {
    }

    public AddTransport(int vehicleID, String vehicleName, String VehicleDescription, String specialSymbol, int seatCapacity, String Note, String imgPath, int vehicleTypeID, String typeName) {
        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.VehicleDescription = VehicleDescription;
        this.specialSymbol = specialSymbol;
        this.seatCapacity = seatCapacity;
        this.Note = Note;
        this.imgPath = imgPath;
        this.vehicleTypeID = vehicleTypeID;
        this.typeName = typeName;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleDescription() {
        return VehicleDescription;
    }

    public void setVehicleDescription(String VehicleDescription) {
        this.VehicleDescription = VehicleDescription;
    }

    public String getSpecialSymbol() {
        return specialSymbol;
    }

    public void setSpecialSymbol(String specialSymbol) {
        this.specialSymbol = specialSymbol;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(int vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
