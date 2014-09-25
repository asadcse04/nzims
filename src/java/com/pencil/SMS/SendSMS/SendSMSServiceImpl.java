/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS.SendSMS;

import com.pencil.Connection.DB_Connection;
import com.pencil.SMS.SmsTemplate.SmsTemplate;
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
public class SendSMSServiceImpl implements SendSMSService{
  
  
    public String getSMSTemplateDetailByID(int template)
    
    {
       
        
        String a="";    
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
                    
        ResultSet rs=null;
        
        try{
        
         prst=con.prepareStatement("select * from sms_template where SmsTemplateId=?");
         prst.setInt(1, template);
       
         rs=prst.executeQuery();
         
         while(rs.next()){
         a=rs.getString(3);
         } 
         
         System.out.println(""+a);
            
         return a;         
         
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        finally{
            
            try{
                
                  if(rs !=null)
                {
               
                rs.close();
              } 
              
                if(prst !=null)
                {
               
                prst.close();
              }  
            
             if(con !=null)
                {
               
                con.close();
              }
            
            
            }
            
            catch(SQLException sq){
             sq.printStackTrace();
            }
        }
        
        return a;
        
        
    }
    
    @Override
    public List<SmsTemplate> getAllSmsTemplate(){
        
    List<SmsTemplate> alltemplate=new ArrayList<SmsTemplate>();
    
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try
        {
         prst=con.prepareStatement("select * from sms_template");
         
         rs=prst.executeQuery();
         
         while(rs.next())
         {
         
             alltemplate.add(new SmsTemplate(rs.getInt(1),rs.getString(2),rs.getString(3)));
         
         }
         
         return alltemplate;
         
        }
        catch(SQLException sql){
          
          System.out.println(sql);
        }
        
        finally
        {
          
        try
          
        {
           
         if(prst !=null){
         
         prst.close();
           
         
         }
           
       if(con !=null){
               con.close();
           
       }
          
       } 
          
          
       catch(SQLException sqle)
       {
       
           sqle.printStackTrace();
                   
      }
            
            
        }
        
    return  alltemplate;   

}

}
