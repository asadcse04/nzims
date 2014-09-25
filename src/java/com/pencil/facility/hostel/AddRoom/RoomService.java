/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddRoom;

import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public interface RoomService {

    public boolean addRoom(Room room);

    public boolean updateRoom(Room room);

    public List<Room> getAllRoom();

}
