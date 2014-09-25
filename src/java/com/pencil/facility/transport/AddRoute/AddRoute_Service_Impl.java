/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.transport.AddRoute;

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
public class AddRoute_Service_Impl implements AddRoute_Service, Serializable {

    @Override
    public boolean createAddRoute(AddRoute route) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("insert into transport_addroute values (null,?,?,?)");

            prst.setString(1, route.getRouteName());

            prst.setString(2, route.getRouteLocation());

            prst.setString(3, route.getRouteNote());

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
    public List<AddRoute> addRouteList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<AddRoute> addList = new ArrayList<AddRoute>();

        try {

            prst = con.prepareStatement("select * from transport_addroute");

            rs = prst.executeQuery();

            while (rs.next()) {
                addList.add(new AddRoute(rs.getInt("RouteID"), rs.getString("RouteName"), rs.getString("Location"), rs.getString("Note")));
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
    public boolean updateRoute(AddRoute upRoute) {
       
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("update transport_addroute set RouteName=?,Location=?,Note=? where RouteID=? ");

            prst.setString(1, upRoute.getRouteName());

            prst.setString(2, upRoute.getRouteLocation());

            prst.setString(3, upRoute.getRouteNote());
            
            prst.setInt(4, upRoute.getRouteID());

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
