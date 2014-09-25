/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.hostel.config;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface HostelConfig {
    
    public List<String> listHostelName();
    
    public List<String> listBuildingName(String HostelName);
    
    public List<String> listFloorName(String BuildingName);
    
    public List<String> listRoomName(String FloorName);
    
   
    
}
