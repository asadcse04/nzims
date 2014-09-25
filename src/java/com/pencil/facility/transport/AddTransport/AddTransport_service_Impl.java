/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddTransport;

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
public class AddTransport_service_Impl implements AddTransport_Service, Serializable {

    @Override
    public List<AddTransport> transportList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<AddTransport> addList = new ArrayList<AddTransport>();

        try {

            //prst = con.prepareStatement("select * from transport_addstops");
            prst = con.prepareStatement("select ts.VehicleID, ts.VehicleName, ts.VehicleDescription, ts.SpecialSymbol, ts.SeatCapacity,"
                    + "ts.Note, ts.imgPath, ts.VehicleTypeID, tr.TypeName from transport_addvehicle ts,transport_vehicletype tr where ts.VehicleTypeID=tr.VehicleTypeID");

            rs = prst.executeQuery();

            while (rs.next()) {
                addList.add(new AddTransport(rs.getInt("VehicleID"), rs.getString("VehicleName"), rs.getString("VehicleDescription"), rs.getString("SpecialSymbol"), rs.getInt("SeatCapacity"), rs.getString("Note"), rs.getString("imgPath"), rs.getInt("VehicleTypeID"), rs.getString("TypeName")));
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
    public List<String> transportTypeNameList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> routList = new ArrayList<String>();

        try {
            prst = con.prepareStatement("select TypeName from transport_vehicletype");

            rs = prst.executeQuery();

            while (rs.next()) {
                routList.add(rs.getString("TypeName"));
            }
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

        return routList;
    }

    @Override
    public boolean createTransport(AddTransport addTransport) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {
            prst = con.prepareStatement("insert into transport_addvehicle values(null,?,?,?,?,?,null,(select VehicleTypeID from transport_vehicletype where TypeName=?))");

            prst.setString(1, addTransport.getVehicleName());

            prst.setString(2, addTransport.getVehicleDescription());

            prst.setString(3, addTransport.getSpecialSymbol());

            prst.setInt(4, addTransport.getSeatCapacity());

            prst.setString(5, addTransport.getNote());

            prst.setString(6, addTransport.getTypeName());

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
    public boolean updateTransport(AddTransport upTransport) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("update transport_addvehicle set VehicleName=?,VehicleDescription=?,SpecialSymbol=?,SeatCapacity=?,Note=?,imgPath=null,VehicleTypeID=? where VehicleID=?");

            prst.setString(1, upTransport.getVehicleName());

            prst.setString(2, upTransport.getVehicleDescription());

            prst.setString(3, upTransport.getSpecialSymbol());

            prst.setInt(4, upTransport.getSeatCapacity());

            prst.setString(5, upTransport.getNote());

            prst.setInt(6, upTransport.getVehicleTypeID());

            prst.setInt(7, upTransport.getVehicleID());

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

}
