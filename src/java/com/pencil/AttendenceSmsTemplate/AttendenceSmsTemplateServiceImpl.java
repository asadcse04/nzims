/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.AttendenceSmsTemplate;

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
public class AttendenceSmsTemplateServiceImpl implements AttendenceSmsTemplateService {
    
     public boolean savaMessage(AttendenceSmsTemplate attendenceSmsTemplate){
         
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        PreparedStatement prst = null;
        try 
        {
            prst = con.prepareStatement("insert into attendence_message values (null, ?, ?)");
            
            prst.setString(1, attendenceSmsTemplate.getMessage());
            
            prst.setString(2,instituteid);

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
   
   public boolean updateMessage(AttendenceSmsTemplate attendenceSmsTemplate){
      
        DB_Connection o = new DB_Connection();
        Connection con = o.getConnection();
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        PreparedStatement prst = null;
        try 
        {
            prst = con.prepareStatement("update attendence_message set message=? where institute_id=?");
            
            prst.setString(1, attendenceSmsTemplate.getMessage());
            
            prst.setString(2,instituteid);

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

   
   public List<AttendenceSmsTemplate> smsList(){
       
        List <AttendenceSmsTemplate> smsTemplateList = new ArrayList<AttendenceSmsTemplate>();
       
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try 
        {
            prst = con.prepareStatement("select * from attendence_message");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                smsTemplateList.add(new AttendenceSmsTemplate(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

            return smsTemplateList;

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
       
       return smsTemplateList;
   }
}
