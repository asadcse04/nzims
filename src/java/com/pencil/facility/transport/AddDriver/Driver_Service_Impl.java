/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddDriver;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
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
public class Driver_Service_Impl implements Driver_Service, Serializable {

    @Override
    public boolean createDriver(Driver add) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        int driverID = 0;

        try {
            prst = con.prepareStatement("select max(DriverID) as DriverID from transport_driver");

            rs = prst.executeQuery();

            if (rs.next()) {
                driverID = rs.getInt("DriverID");
            }
            if (driverID == 0) {
                driverID = 5000;

            }

            add.setDriverID(driverID + 1);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prst != null) {
                    prst.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        try {

            prst = con.prepareStatement("insert into transport_driver values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            prst.setInt(1, add.getDriverID());

            prst.setString(2, add.getDriverName());

            prst.setString(3, add.getFatherName());

            prst.setString(4, add.getMotherName());

            prst.setString(5, add.getNationalID());

            prst.setString(6, add.getQualification());

            prst.setString(7, add.getMaritalStatus());

            prst.setString(8, add.getReligion());

            prst.setString(9, add.getContactNo());

            prst.setString(10, add.getPresentAddress());

            prst.setString(11, add.getPermanentAddress());

            prst.setString(12, add.getAttachePapper());

            prst.setString(13, add.getNote());

            prst.setString(14, (driverID + 1)+"_"+add.getImage());

            prst.execute();

            prst.close();

            con.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
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
    public List<Driver> driverList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<Driver> addList = new ArrayList<Driver>();

        try {

            prst = con.prepareStatement("select * from transport_driver");

            rs = prst.executeQuery();

            while (rs.next()) {
                addList.add(new Driver(rs.getInt("DriverID"), rs.getString("DriverName"), rs.getString("FatherName"), rs.getString("MotherName"), rs.getString("NationalID"), rs.getString("Qualification"), rs.getString("MaritalStatus"), rs.getString("Religion"), rs.getString("ContactNo"), rs.getString("PresentAddress"), rs.getString("PermanentAddress"), rs.getString("AttachedPaper"), rs.getString("Note"), rs.getString("imgPath")));
            }

            prst.close();

            con.close();

            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
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

        return addList;
    }

    @Override
    public boolean updateDriver(Driver driver) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            con.setAutoCommit(false);

            Long.parseLong(driver.getContactNo());

            prst = con.prepareStatement("update transport_driver set DriverName=?, FatherName=?, MotherName=?, NationalID=?,"
                    + " Qualification=?, MaritalStatus=?, Religion=?, ContactNo=?, PresentAddress=?, PermanentAddress=?,"
                    + " AttachedPaper=?, Note=?, imgPath=null  where DriverID=?");

            prst.setString(1, driver.getDriverName());

            prst.setString(2, driver.getFatherName());

            prst.setString(3, driver.getFatherName());

            prst.setString(4, driver.getNationalID());

            prst.setString(5, driver.getQualification());

            prst.setString(6, driver.getMaritalStatus());

            prst.setString(7, driver.getReligion());

            prst.setString(8, driver.getContactNo());

            prst.setString(9, driver.getPresentAddress());

            prst.setString(10, driver.getPermanentAddress());

            prst.setString(11, driver.getAttachePapper());

            prst.setString(12, driver.getNote());

            prst.setInt(13, driver.getDriverID());

            prst.execute();

            prst.close();

            con.commit();

            con.close();

            return true;
        } catch (Exception e) {
            System.out.println(e);
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

        return false;

    }

}
