/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Notice.NoticeCategory;

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
 * @author Riad
 */
public class NoticeCategoryServiceImpl implements NoticeCategoryService,Serializable
{    
    public boolean addNoticeCategory(NoticeCategory noticeCategory){
     
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into acdnotice_category values (null, ?, ?, ?)");
            
            prst.setString(1, noticeCategory.getCategoryname());
            
            prst.setString(2, noticeCategory.getColor());
            
            prst.setString(3, noticeCategory.getNote());

            prst.executeUpdate();

            return true;

        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        } 
                
        finally 
        {
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
    
    public List<NoticeCategory> NoticeCategoryList(){
        
     List<NoticeCategory> acdCatList=new ArrayList<NoticeCategory>();   
    
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        
        try {
            prst = con.prepareStatement("select * from acdnotice_category");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                acdCatList.add(new NoticeCategory(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)));

            }

            return acdCatList;

        } 
        
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        finally {
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
       
       return acdCatList;
    }
}
