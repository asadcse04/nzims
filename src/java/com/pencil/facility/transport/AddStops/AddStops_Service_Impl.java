/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.transport.AddStops;

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
public class AddStops_Service_Impl implements AddStops_Service, Serializable{

    @Override
    public boolean createStops(AddStops stops) {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into transport_addstops values(null,?,?,?,?)");
            
            prst.setString(1,stops.getStopsName());
            
            prst.setString(2,stops.getStopsLocation());
     
            prst.setString(3,stops.getStopsNote());
            
            prst.setInt(4, stops.getRouteID());
            
            prst.execute();
               
            prst.close();
               
            con.close();
               
            return true;  
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
         finally
        {
            try
            {
                if(prst!=null)
                {
                    prst.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        }
        return false;
    }
    
    @Override
    public boolean updateStops(AddStops upStops) {
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("update transport_addstops set StopsName=?,Location=?,Note=?,RouteID=? where StopsID=? ");

            prst.setString(1, upStops.getStopsName());

            prst.setString(2, upStops.getStopsLocation());

            prst.setString(3, upStops.getStopsNote());
            
            prst.setInt(4, upStops.getRouteID());
            
            prst.setInt(5, upStops.getStopsID());

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
    public List<AddStops> addStopsList() {
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs = null;

        List<AddStops> addList = new ArrayList<AddStops>();
        
        try {

            //prst = con.prepareStatement("select * from transport_addstops");
            
            prst = con.prepareStatement("select ts.StopsID, ts.StopsName, ts.Location, ts.Note, tr.RouteName, ts.RouteID from transport_addstops ts,transport_addroute tr where ts.RouteID=tr.RouteID");

            rs = prst.executeQuery();
            
            while (rs.next())
            {                
                addList.add(new AddStops(rs.getInt("StopsID"), rs.getString("StopsName"), rs.getString("Location"),rs.getString("Note"),rs.getInt("RouteID"),rs.getString("RouteName")));
            }

            prst.close();

            con.close();
            
            rs.close();

        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        } 
        finally
        {
            try {
                if(rs!=null)
                {
                    rs.close();
                }
                if (prst != null) 
                {
                    prst.close();
                }
                if (con != null) 
                {
                    con.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }

        return addList;
    }

    @Override
    public List<String> routeNameList() {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> routList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("select RouteName from transport_addroute");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                routList.add(rs.getString("RouteName"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        }
        
        return routList;
    }

    
    
}
