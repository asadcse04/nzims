/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddRoute;

import java.io.Serializable;

/**
 *
 * @author SHOHUG-SQ
 */
public class AddRoute implements Serializable{
    
    private int routeID;
    
    private String routeName;
    
    private String routeLocation;
    
    private String routeNote;

    public AddRoute() {
    }

    public AddRoute(int routeID, String routeName, String routeLocation, String routeNote) {
        this.routeID = routeID;
        this.routeName = routeName;
        this.routeLocation = routeLocation;
        this.routeNote = routeNote;
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

    public String getRouteLocation() {
        return routeLocation;
    }

    public void setRouteLocation(String routeLocation) {
        this.routeLocation = routeLocation;
    }

    public String getRouteNote() {
        return routeNote;
    }

    public void setRouteNote(String routeNote) {
        this.routeNote = routeNote;
    }
      
}
