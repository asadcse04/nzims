/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.hostel.AddFloor;

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
public class FloorServiceImpl implements FloorService {
    
    @Override
    public boolean addFloor(Floor floor) {
        
        DB_Connection o = new DB_Connection();
        
        Connection con = o.getConnection();
        
        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into hostel_addfloor values (null, ?, ?, ?, (select Building_ID from hostel_addbuilding where Building_Name=?))");
            
            prst.setString(1, floor.getFloorName());
            
            prst.setString(2, floor.getFloorLocation());
            
            prst.setString(3, floor.getFloorNote());
            
            prst.setString(4, floor.getBuildingName());

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
    public boolean updateFloor(Floor floor) {
        
        DB_Connection o = new DB_Connection();
        
        Connection con = o.getConnection();
        
        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update hostel_addfloor set Floor_Name=?, Floor_Location=?, Note=?, Building_ID=(Select Building_ID from hostel_addbuilding where Building_Name=?)  where Floor_ID=?");
            
            prst.setString(1, floor.getFloorName());
            
            prst.setString(2, floor.getFloorLocation());
            
            prst.setString(3, floor.getFloorLocation());
            
            prst.setInt(4, floor.getBuildingId());
            
            prst.setInt(5, floor.getFloorId());
            
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
    public List<Floor> getAllFloor() {
        
        List<Floor> floorAllList = new ArrayList<Floor>();
        
        DB_Connection o = new DB_Connection();
        
        Connection con = o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        try {
            prst = con.prepareStatement("select af.Floor_ID, af.Floor_Name, af.Floor_Location, af.Note, af.Building_ID, ab.Building_Name, ab.Hostel_ID, hc.Hostel_Name from hostel_addfloor af, hostel_addbuilding ab, hostel_create hc where af.Building_ID=ab.Building_ID and ab.Hostel_ID=hc.Hostet_ID");
            
            rs = prst.executeQuery();
            
            while (rs.next()) {
                
                floorAllList.add(new Floor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
                
            }
            return floorAllList;
            
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
        
        return floorAllList;
    }
    
}
