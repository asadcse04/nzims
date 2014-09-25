/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Notice.NoticeCreate;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Riad
 */
public class NoticePublishServiceImpl implements NoticePublishService{
    
     
    
    public boolean addNoticePublish(NoticePublish noticePublish){
      
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try 
        {
            prst = con.prepareStatement("insert into acdnotice_publish values (null, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            prst.setString(1, noticePublish.getNoticeFrom());           
            prst.setString(2, noticePublish.getNoticeFor());            
            prst.setDate(3,new java.sql.Date(noticePublish.getStartDisplay().getTime()));            
            prst.setDate(4,new java.sql.Date(noticePublish.getValidTill().getTime()));
            prst.setString(5, noticePublish.getNoticeHead()); 
            prst.setString(6, noticePublish.getNoticeDetails()); 
            prst.setInt(7, noticePublish.getRating()); 
            prst.setInt(8, noticePublish.getAcdNoticeCategoryId());
             
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
    
    public boolean updateNoticePublish(NoticePublish noticePublish){
     
         DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try 
        {
            prst = con.prepareStatement("update acdnotice_publish set NoticeForm=?,NoticeFor=?,StartDisplay=?,ValidTill=?,NoticeHead=?,NoticeDetails=?,Rating=?  where AcdNoticeID=?");
            
            prst.setString(1, noticePublish.getNoticeFrom());           
            prst.setString(2, noticePublish.getNoticeFor());            
            prst.setDate(3,new java.sql.Date(noticePublish.getStartDisplay().getTime()));            
            prst.setDate(4,new java.sql.Date(noticePublish.getValidTill().getTime()));
            prst.setString(5, noticePublish.getNoticeHead()); 
            prst.setString(6, noticePublish.getNoticeDetails()); 
            prst.setInt(7, noticePublish.getRating());           
            prst.setInt(8, noticePublish.getAcdNoticeId());
             
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
    
    
    

 public List<NoticePublish> noticePublishList(){
     
   List<NoticePublish> list=new ArrayList<NoticePublish>();
   
   DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try 
        {
            prst = con.prepareStatement("select * from acdnotice_publish");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                
                list.add(new NoticePublish(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9)));

            }

            return list;

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
       
       return list;
 }
    
    
}
