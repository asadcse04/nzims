/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.hostel.config;

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
public class HostelConfigImpl implements HostelConfig, Serializable{

    @Override
    public List<String> listHostelName() {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> nameList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct Hostel_Name from hostel_create");
           
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                nameList.add(rs.getString("Hostel_Name"));
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
        
        return nameList;
    }

    @Override
    public List<String> listBuildingName(String HostelName) {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> nameList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct hb.Building_Name from hostel_addbuilding hb,hostel_create hc where hc.Hostet_ID=hb.Hostel_ID  and hc.Hostel_Name=?");
            
            prst.setString(1,HostelName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                nameList.add(rs.getString("hb.Building_Name"));
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
        
        return nameList;
    }

    @Override
    public List<String> listFloorName(String BuildingName) {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> nameList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct hb.Floor_Name from hostel_addfloor hb, hostel_addbuilding hc where hc.Building_ID=hb.Building_ID and hc.Building_Name=?");
            
            prst.setString(1,BuildingName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                nameList.add(rs.getString("hb.Floor_Name"));
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
        
        return nameList;
    }

    @Override
    public List<String> listRoomName(String FloorName) {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> nameList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct hb.Room_Name from hostel_addroom hb, hostel_addfloor hc where hc.Floor_ID=hb.Floor_ID and hc.Floor_Name=?");
            
            prst.setString(1,FloorName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                nameList.add(rs.getString("hb.Room_Name"));
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
        
        return nameList;
    }
}
    