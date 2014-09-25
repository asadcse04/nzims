/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeHead;

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
public class FeeHeadServiceImpl implements FeeHeadService {

    @Override
    public boolean addFeeHead(FeeHead feeHead) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try 
        {
            prst = con.prepareStatement("insert into student_fee_head values (null, ?, ?, ?, ?, ?)");
            
            prst.setString(1, institueID);
            
            prst.setString(2, feeHead.getFeeHeadName());
            
            prst.setString(3, feeHead.getPrintName());
            
            prst.setString(4, feeHead.getNote());
            
            prst.setInt(5, feeHead.getFeeCategoryID());
   

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
    public List<FeeHead> getAllFeeHead() 
    {
        
       List <FeeHead> feeHeadList = new ArrayList<FeeHead>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            prst = con.prepareStatement("select FeeHeadID,FeeHeadName,PrintName,Note,FeeCategoryID from student_fee_head where InstituteID=?");
            
            prst.setString(1, institueID);
            
            rs = prst.executeQuery();

            while (rs.next()) 
            {
                feeHeadList.add(new FeeHead(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));

            }

            return feeHeadList;

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
       
       return feeHeadList;
    }
    
    
    
}
