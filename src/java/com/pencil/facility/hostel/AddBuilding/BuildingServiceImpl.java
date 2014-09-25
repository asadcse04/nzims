/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.AddBuilding;

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
public class BuildingServiceImpl implements BuildingService {

    @Override
    public boolean addBuilding(Building building) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into hostel_addbuilding values (null, ?, ?, ?, (select Hostet_ID from hostel_create where Hostel_Name=?) )");

            prst.setString(1, building.getBuildingName());

            prst.setString(2, building.getBuildingAddress());

            prst.setString(3, building.getBuildingNote());

            prst.setString(4, building.getHostelName());

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
    public boolean updateBuilding(Building building) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update hostel_addbuilding set Building_Name=?, Building_Address=?, Note=?, Hostel_ID=(Select Hostet_ID from hostel_create where Hostel_Name=?) where Building_ID=?");

            prst.setString(1, building.getBuildingName());

            prst.setString(2, building.getBuildingAddress());

            prst.setString(3, building.getBuildingNote());

            prst.setString(4, building.getHostelName());

            prst.setInt(5, building.getBuildingId());

            int b = prst.executeUpdate();

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
    public List<Building> getAllBuilding() {

        List<Building> buildingList = new ArrayList<Building>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            prst = con.prepareStatement("select ab.Building_ID, ab.Building_Name, ab.Building_Address, ab.Note, ab.Hostel_ID, hc.Hostel_Name from hostel_addbuilding ab, hostel_create hc where ab.Hostel_ID=hc.Hostet_ID");

            rs = prst.executeQuery();

            while (rs.next()) {

                buildingList.add(new Building(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));

            }

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

        return buildingList;
    }

}
