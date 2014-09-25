/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.TransportType;

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
public class TransportType_Service_Impl implements TransportType_Service, Serializable {

    @Override
    public boolean createTransportType(TransportType transportType) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("insert into transport_vehicletype values (null,?,?,?)");

            prst.setString(1, transportType.getTransportTypeName());

            prst.setString(2, transportType.getAbout());

            prst.setString(3, transportType.getNote());

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
    public boolean updateTransportType(TransportType upTransport) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("update transport_vehicletype set TypeName=?,About=?,Note=? where VehicleTypeID=?");

            prst.setString(1, upTransport.getTransportTypeName());

            prst.setString(2, upTransport.getAbout());

            prst.setString(3, upTransport.getNote());

            prst.setInt(4, upTransport.getTransportTypeID());

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
    public List<TransportType> transportList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<TransportType> addList = new ArrayList<TransportType>();

        try {

            prst = con.prepareStatement("select * from transport_vehicletype");

            rs = prst.executeQuery();

            while (rs.next()) {
                addList.add(new TransportType(rs.getInt("VehicleTypeID"), rs.getString("TypeName"), rs.getString("About"), rs.getString("Note")));
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

}
