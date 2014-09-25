/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddStops;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class AddStops implements Serializable{
    
    private int stopsID;
    
    private String stopsName;
    
    private String stopsLocation;
    
    private String stopsNote;
    
    private int routeID;
    
    private String routeName; 

    public AddStops() {
    }

    public AddStops(int stopsID, String stopsName, String stopsLocation, String stopsNote) {
        this.stopsID = stopsID;
        this.stopsName = stopsName;
        this.stopsLocation = stopsLocation;
        this.stopsNote = stopsNote;
    }
    
    
    public AddStops(int stopsID, String stopsName, String stopsLocation, String stopsNote, int routeID, String routeName) {
        this.stopsID = stopsID;
        this.stopsName = stopsName;
        this.stopsLocation = stopsLocation;
        this.stopsNote = stopsNote;
        this.routeID = routeID;
        this.routeName = routeName;
    }

    public int getStopsID() {
        return stopsID;
    }

    public void setStopsID(int stopsID) {
        this.stopsID = stopsID;
    }

    public String getStopsName() {
        return stopsName;
    }

    public void setStopsName(String stopsName) {
        this.stopsName = stopsName;
    }

    public String getStopsLocation() {
        return stopsLocation;
    }

    public void setStopsLocation(String stopsLocation) {
        this.stopsLocation = stopsLocation;
    }

    public String getStopsNote() {
        return stopsNote;
    }

    public void setStopsNote(String stopsNote) {
        this.stopsNote = stopsNote;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
   
}
