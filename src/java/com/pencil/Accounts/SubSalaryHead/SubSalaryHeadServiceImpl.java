/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.SubSalaryHead;

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
 * @author Riad
 */
public class SubSalaryHeadServiceImpl implements SubSalaryHeadService {
    
 public boolean addSubSalaryHead(SubSalaryHead subSalaryHead) {
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try 
        {
            prst = con.prepareStatement("insert into salary_sub_head values (null, ?, ?, ?)");
            
            prst.setString(1, institueID);
            
            prst.setString(2, subSalaryHead.getSubSalaryHeadName());
            
            prst.setString(3, subSalaryHead.getNote());

            int add = prst.executeUpdate();

            return true;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        finally 
        {
            try 
            {
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            catch (SQLException e) 
            {

                System.out.println(e);
            }
        } 
        return false;
    }

    @Override
    public List<SubSalaryHead> getAllSubSalaryHead() {
        
        List <SubSalaryHead> subSalaryHeadList = new ArrayList<SubSalaryHead>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            prst = con.prepareStatement("select SalarySubHeadID,SalarySubHeadName,SalarySubHeadNote from salary_sub_head where InstituteID=?");
            prst.setString(1, institueID);
            rs = prst.executeQuery();

            while (rs.next()) 
            {
            subSalaryHeadList.add(new SubSalaryHead(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

            return subSalaryHeadList;

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
       
       return subSalaryHeadList;
    }
    
}
