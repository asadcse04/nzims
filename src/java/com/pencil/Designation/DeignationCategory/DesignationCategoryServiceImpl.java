/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Designation.DeignationCategory;

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
public class DesignationCategoryServiceImpl  implements DesignationCategoryService{
    
    @Override
    public boolean addDesignationCategory(DesignationCategory designationCategory) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into designation_category values (null, ?, ?)");
            
            prst.setString(1, designationCategory.getCategoryName());
            
            prst.setString(2, designationCategory.getNote());

            int add = prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        
        finally {
            try {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            
            catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return false;
    }

    
    public List<DesignationCategory> getAllDesignationCategory() 
    {
     List <DesignationCategory> designationCategoryList = new ArrayList<DesignationCategory>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from designation_category");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                designationCategoryList.add(new DesignationCategory(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

            return designationCategoryList;

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
       
       return designationCategoryList;
    }   
    
    
}