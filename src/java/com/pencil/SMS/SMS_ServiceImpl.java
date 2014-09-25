/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS;

import com.pencil.Connection.DB_Connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author INSPIRON 5421
 */
public class SMS_ServiceImpl implements Serializable,SMS_Service
{

    /**
     *
     * @param contactNo
     * @param smsbody
     * @return
     */
    @Override
    public int sendBulkSms(StringBuilder contactNo, String smsbody)
    {
        StringBuilder rqString; 
         
        List<NameValuePair> urlParameters; 
          
        CloseableHttpClient client; 
          
        HttpGet request; 
          
        HttpResponse r = null; 
        
        BufferedReader rd;
        
        StringBuilder result;
        
        int rspnCode;
        
        String[] rspn_arry;
          
       
        urlParameters = new ArrayList<NameValuePair>(); 
          
        urlParameters.add(new BasicNameValuePair("REQUESTTYPE","SMSSubmitReq")); 
  
        urlParameters.add(new BasicNameValuePair("USERNAME","01678568240")); 
          
        urlParameters.add(new BasicNameValuePair("PASSWORD","Allahu")); 
  
        urlParameters.add(new BasicNameValuePair("MOBILENO",contactNo.toString())); 
          
        urlParameters.add(new BasicNameValuePair("MESSAGE",smsbody)); 
                
        urlParameters.add(new BasicNameValuePair("TYPE","0"));
        
        urlParameters.add(new BasicNameValuePair("ORIGIN_ADDR","01678568240"));
  
        rqString = new StringBuilder(); 
   
        rqString.append("http://portals.bd.airtel.com/msdpapi".replaceAll("\\s","")); 
  
        rqString.append("?"); 
  
        rqString.append(URLEncodedUtils.format(urlParameters,"UTF-8")); 
        
        client  = HttpClients.createDefault(); 
  
        request = new HttpGet(rqString.toString()); 
          
        try 
        { 
            r = client.execute(request); 
            
            rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));

            result = new StringBuilder();

            String line;

            while ((line = rd.readLine()) != null)
            {
                result.append(line);
            }
            
            rspn_arry=result.toString().split("\\s+");

            if (r.getStatusLine().getStatusCode() == 200)
            {
                if (rspn_arry[0].equals("+OK"))
                {
                    rspnCode=200;
                } 
                else 
                {
                    rspnCode=500;//sms not sent
                }
            } 
            else
            {
                rspnCode=450;//internet not available
            }

            return rspnCode; 
        }  
        catch (IOException e) 
        { 
            System.out.println(e); 
        }  
        finally 
        { 
            try
            { 
                if(r!=null) 
                { 
                    r.getEntity().getContent().close(); 
                } 
                  
                request.abort(); 
  
                client.close(); 
                
                contactNo.setLength(0);
                
                rqString.setLength(0);
            }  
            catch (IOException e) 
            { 
                System.out.println(e); 
            } 
        } 
        
        return 0;
    }

    /**
     *
     * @param contactNo
     * @param smsbody
     * @return
     */
    @Override
    public int sendIndividual_Sms(String contactNo, String smsbody)
    {
        StringBuilder rqString; 
         
        List<NameValuePair> urlParameters; 
          
        CloseableHttpClient client; 
          
        HttpGet request; 
          
        HttpResponse r = null;
        
        BufferedReader rd;
        
        StringBuilder result;
        
        int rspnCode;
        
        String[] rspn_arry;
          
       
        urlParameters = new ArrayList<NameValuePair>(); 
          
        urlParameters.add(new BasicNameValuePair("REQUESTTYPE","SMSSubmitReq")); 
  
        urlParameters.add(new BasicNameValuePair("USERNAME","01678568240")); 
          
        urlParameters.add(new BasicNameValuePair("PASSWORD","Allahu")); 
  
        urlParameters.add(new BasicNameValuePair("MOBILENO",contactNo)); 
          
        urlParameters.add(new BasicNameValuePair("MESSAGE",smsbody)); 
                
        urlParameters.add(new BasicNameValuePair("TYPE","0"));
        
        urlParameters.add(new BasicNameValuePair("ORIGIN_ADDR","01678568240"));
  
        rqString = new StringBuilder(); 
   
        rqString.append("http://portals.bd.airtel.com/msdpapi".replaceAll("\\s","")); 
  
        rqString.append("?"); 
  
        rqString.append(URLEncodedUtils.format(urlParameters,"UTF-8")); 
        
        client  = HttpClients.createDefault(); 
  
        request = new HttpGet(rqString.toString()); 
          
        try 
        { 
            r = client.execute(request); 
            
            rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));

            result = new StringBuilder();

            String line;

            while ((line = rd.readLine()) != null)
            {
                result.append(line);
            }
            
            rspn_arry=result.toString().split("\\s+");

            if (r.getStatusLine().getStatusCode() == 200)
            {
                if (rspn_arry[0].equals("+OK"))
                {
                    rspnCode=200;
                } 
                else 
                {
                    rspnCode=500;//sms not sent
                }
            } 
            else
            {
                rspnCode=450;//internet not available
            }

            return rspnCode; 

        }  
        catch (IOException e) 
        { 
            System.out.println(e); 
        }  
        finally 
        { 
            try
            { 
                if(r!=null) 
                { 
                    r.getEntity().getContent().close(); 
                } 
                  
                request.abort(); 
  
                client.close(); 
            }  
            catch (IOException e) 
            { 
                System.out.println(e); 
            } 
        } 
        
        return 0;
    }

    /**
     *
     * @param school_id
     * @return
     */
    @Override
    public int getSmsCurrent_Ac_Balance(int school_id) 
    {
        DB_Connection db = new DB_Connection();

        Connection con = db.getSms_db_Connection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try
        {
            prst=con.prepareStatement("select AccountBalance,ActiveFrom,ActiveTo from sms_manage where School_ID=? ");
            
            prst.setInt(1,school_id);
            
            rs=prst.executeQuery();
            
            if(rs.next())
            {
                if((new java.util.Date().after(new java.util.Date(rs.getDate("ActiveFrom").getTime()))) && (new java.util.Date().before(new java.util.Date(rs.getDate("ActiveTo").getTime()))))
                {
                    return rs.getInt("AccountBalance");
                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }   
                if (prst != null)
                {
                    prst.close();
                }
                if (con != null)
                {
                    con.close();
                }
                System.out.println("Hello I am in finally clause in getSmsCurrent_Ac_Balance..");
            }
            catch (SQLException ex)
            {
                System.out.println(ex);
            }
            
        }
        
        return 0;
    }
   
}
