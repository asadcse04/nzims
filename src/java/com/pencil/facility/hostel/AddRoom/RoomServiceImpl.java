/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.hostel.AddRoom;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public class RoomServiceImpl implements RoomService{

    @Override
    public boolean addRoom(Room room) {
       
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into hostel_addroom values (null, ?, ?, ?, (select Floor_ID from hostel_addfloor where Floor_Name=? ))");

            prst.setString(1, room.getRoomName());

            prst.setString(2, room.getRoomLocation());

            prst.setString(3, room.getRoomNote());
            
            prst.setString(4, room.getFloorName());

            prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
     
 DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update hostel_addroom set Room_Name=?, Room_Location=?, Note=?, Floor_ID=(Select Floor_ID from hostel_addfloor where Floor_Name=?) where Room_ID=?");

            prst.setString(1, room.getRoomName());

            prst.setString(2, room.getRoomLocation());

            prst.setString(3, room.getRoomNote());

            prst.setString(4, room.getFloorName());

            prst.setInt(5, room.getRoomId());

            prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return false;  
    
    
    }

    @Override
    public List<Room> getAllRoom() {

        List<Room>  roomAllList = new ArrayList<Room>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            
            prst = con.prepareStatement("select ar.Room_ID, ar.Room_Name, ar.Room_Location, ar.Note, ar.Floor_ID, af.Floor_Name from hostel_addroom ar, hostel_addfloor af where ar.Floor_ID=af.Floor_ID");
            
            rs = prst.executeQuery();

            while (rs.next()) {
                
                 roomAllList.add(new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));

            }
            return roomAllList;

        } catch (SQLException ex) {

            System.out.println(ex);
        } finally {
            try {

                if (rs != null) {

                    rs.close();

                }

                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return roomAllList;   
    
    }
    
}
