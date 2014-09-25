/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.hostel.CreateHostel;

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
public class HostelServiceImpl implements HostelService {

    @Override
    public boolean addHostel(Hostel hostel) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into hostel_create values (null, ?, ?, ?, ?)");

            prst.setString(1, hostel.getHostelName());

            prst.setString(2, hostel.getHostelType());

            prst.setString(3, hostel.getHostelAddress());

            prst.setString(4, hostel.getHostelNote());

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
    public boolean updateHostel(Hostel hostel) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update hostel_create set Hostel_Name=?, Hostel_Type=?, Hostel_Address=?, Note=? where Hostet_ID=?");

            prst.setString(1, hostel.getHostelName());

            prst.setString(2, hostel.getHostelType());

            prst.setString(3, hostel.getHostelAddress());

            prst.setString(4, hostel.getHostelNote());

            prst.setInt(5, hostel.getHostelId());

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
    public List<Hostel> getAllHostel() {

        List<Hostel> hostelAllList = new ArrayList<Hostel>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from hostel_create");

            rs = prst.executeQuery();

            while (rs.next()) {
                hostelAllList.add(new Hostel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            return hostelAllList;

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

        return hostelAllList;
    }

}
