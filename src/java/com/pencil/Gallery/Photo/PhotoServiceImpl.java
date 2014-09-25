/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Gallery.Photo;

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
public class PhotoServiceImpl implements PhotoService{
    
  public boolean savePhoto(Photo photo){
      
       
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        PreparedStatement prst2 = null;

        ResultSet rs = null;

        String ID = null;
        
         
         
          try {
            prst = con.prepareStatement("SELECT max(CAST(ID  AS UNSIGNED)) as ID FROM gallery_photo");

            rs = prst.executeQuery();

            while (rs.next()) {
                
                ID = rs.getString("ID");
            }
            
            if (ID == null) {
               
                ID = "100";
                
            }

          photo.setId(String.valueOf(Long.parseLong(ID) + 1));
            
          prst2=con.prepareStatement("insert into gallery_photo values(?,?,?,?,?)");
          
          prst2.setString(1,photo.getId());
          
          prst2.setString(2,photo.getEventname());
          
          prst2.setDate(3,new java.sql.Date(photo.getEnentdate().getTime()));
          
          prst2.setString(4,photo.getAbout());
          
          prst2.setString(5,(String.valueOf(Long.parseLong(ID)+1))+"_"+photo.getImgpath());
         
          int a=prst2.executeUpdate();
          
          return true; 
            
        }
        
          catch (SQLException e) 
        {
            System.out.println(e);
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
                
                 if (prst2 != null) {
                    prst2.close();
                }
            } 
            
            catch (SQLException e) {
                System.out.println(e);
            }
        }
          
      return false;  
      
  }
  
  
   public List<Photo> photoList(){
    
       List<Photo> list=new ArrayList<Photo>();
       
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from gallery_photo");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                list.add(new Photo(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5)));

            }

            return list;

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
       
       return list;
        }
   

    
    public boolean updatePhoto(Photo photo){
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
       
         
          try {

            
          prst=con.prepareStatement("update gallery_photo set EventName=?,EventDate=?,About=?,imgpath=? where ID=?");

          prst.setString(1,photo.getEventname());
          
          prst.setDate(2,new java.sql.Date(photo.getEnentdate().getTime()));
          
          prst.setString(3,photo.getAbout());
          
          prst.setString(4,photo.getImgpath());
          
          prst.setString(5,photo.getId());
  
          int a=prst.executeUpdate();
          
          return true; 
            
        }
        
          catch (SQLException e) 
        {
            System.out.println(e);
        } 
        
          finally 
        {
            try {
              
                if (prst != null) {
                    prst.close();
                }
                
                if(con !=null){
                    con.close();
                }
                
               
            } 
            
            catch (SQLException e) {
                System.out.println(e);
            }
        }
          
      return false;
        
    }
    
}
