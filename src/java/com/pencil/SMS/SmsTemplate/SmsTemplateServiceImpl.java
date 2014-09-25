/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS.SmsTemplate;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mamun
 */
public class SmsTemplateServiceImpl implements SmsTemplateService {
  
 @Override
 public boolean addSmsTemplate(SmsTemplate smsTemplate) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try 
        {
            prst = con.prepareStatement("insert into sms_template values (null, ?, ?)");
            
            prst.setString(1, smsTemplate.getSmsTemplateName());
            
            prst.setString(2, smsTemplate.getSmsTemplateDescription());
            
            
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

            } catch (SQLException e) {

                System.out.println(e);
            }
        }
       
        return false;
    }

    @Override
    public List<SmsTemplate> getAllSmsTemplate() 
    {
        
       List <SmsTemplate> smsTemplateList = new ArrayList<SmsTemplate>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try 
        {
            prst = con.prepareStatement("select * from sms_template");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                smsTemplateList.add(new SmsTemplate(rs.getInt(1), rs.getString(2), rs.getString(3)));

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

