/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddBuilding;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface BuildingService {

    public boolean addBuilding(Building building);

    public boolean updateBuilding(Building building);

    public List<Building> getAllBuilding();

}
