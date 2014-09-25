/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Designation.Designation;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riad
 */
public class DesignationServiceImpl implements DesignationService {
@Override
    public boolean addDesignation(Designation designation) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try 
        {
            prst = con.prepareStatement("insert into designation values (null, ?, ?, ?)");
            
            prst.setString(1, designation.getDesignationName());
            
            prst.setString(2, designation.getNote());
            
            prst.setInt(3, designation.getDesignationCategoryID());
   

            int add = prst.executeUpdate();

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
    
    public List<Designation> getAllDesignation() 
    {
        
       List <Designation> designationList = new ArrayList<Designation>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try 
        {
            prst = con.prepareStatement("select * from designation");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                designationList.add(new Designation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

            }

            return designationList;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        finally 
        {
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
       
       return designationList;
    }
    
    
    
}
