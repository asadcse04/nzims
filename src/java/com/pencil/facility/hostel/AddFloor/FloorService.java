/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddFloor;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface FloorService {

    public boolean addFloor(Floor floor);

    public boolean updateFloor(Floor floor);

    public List<Floor> getAllFloor();

}
