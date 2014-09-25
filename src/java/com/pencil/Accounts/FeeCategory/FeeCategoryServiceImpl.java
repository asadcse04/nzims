/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCategory;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mamun
 */
public class FeeCategoryServiceImpl implements FeeCategoryService {

    @Override
    public boolean addFeeCategory(FeeCategory feeCategory) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        
        try {
            prst = con.prepareStatement("insert into student_fee_category values (null, ?, ?, ?)");
            
            prst.setString(1, institueID);
            
            prst.setString(2, feeCategory.getCategoryName());
            
            prst.setString(3, feeCategory.getNote());

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
    
    public boolean updateFeeCategory(FeeCategory feeCategory) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try {
            prst = con.prepareStatement("update student_fee_category set FeeCategoryName=?, FeeCategoryNote=? where FeeCategoryID=? and InstituteID=?");
            
            prst.setString(1, feeCategory.getCategoryName());
            
            prst.setString(2, feeCategory.getNote());
            
            prst.setInt(3, feeCategory.getCategoryID());
            
            prst.setString(4, institueID);

            int add = prst.executeUpdate();

            return true;

        } 
        catch (SQLException ex) {
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

            } catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return false;
    }

    @Override
    public List<FeeCategory> getAllFeeCategory() 
    {
     List <FeeCategory> feeCategoryList = new ArrayList<FeeCategory>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            prst = con.prepareStatement("select FeeCategoryID,FeeCategoryName,FeeCategoryNote from student_fee_category where InstituteID=?");
            prst.setString(1, institueID);
            
            rs = prst.executeQuery();

            while (rs.next()) 
            {
                feeCategoryList.add(new FeeCategory(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

            return feeCategoryList;

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
       
       return feeCategoryList;
    }   
    
    
}
