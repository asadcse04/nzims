/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook.SMS;

import com.pencil.Connection.DB_Connection;
import com.pencil.Phone.PhoneBook.PhoneBook;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author salim
 */
public class SendSms_PhoneBook_ServiceImpl implements SendSms_PhoneBook_Service
{

    @Override
    public boolean sendSms(List<PhoneBook> selectedPhnBookArry, String message, int smsBal)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();
        
        Connection cn = o.getSms_db_Connection();

        PreparedStatement prst = null;
        
        CallableStatement cs = null;
        
        SMS_Service service=new SMS_ServiceImpl();
        
        StringBuilder cntnoList=new StringBuilder();
        
        
        String instituteID="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        int instituteId=Integer.valueOf(instituteID);
            
        
        int count=0;
        
        if(smsBal!=0)
        {
            try
            {
                con.setAutoCommit(false);

                prst = con.prepareStatement("insert into phonebook_sms_record values(null,?,?,?,now())");

                for (PhoneBook phnBook : selectedPhnBookArry)
                {
                    if (count <= smsBal)
                    {
                        prst.setInt(1, phnBook.getContactid());

                        prst.setString(2, phnBook.getMobile());

                        prst.setString(3, message);

                        prst.addBatch();

                        cntnoList.append(phnBook.getMobile());

                        cntnoList.append(",");
                    }

                    count = count + 1;
                }

                if (cntnoList.length() > 0)
                {
                    cntnoList.setLength(cntnoList.length() - 1);

                    if (service.sendBulkSms(cntnoList,message) == 200)
                    {
                        int[] update = prst.executeBatch();

                        cs = cn.prepareCall("{call smsCntManage(?,?)}");

                        cs.setInt(1, update.length);

                        //cs.setInt(2, 1);
                        
                        cs.setInt(2, instituteId);

                        cs.execute();

                        System.out.println("Total number of sms send to the Phone Book::" + update.length);

                        con.commit();

                        return true;
                    }
                }
            } 
            catch (SQLException ex)
            {
                System.out.println(ex);
            } 
            finally
            {
                try 
                {
                    if (prst != null) 
                    {
                        prst.close();
                    }
                    if (cs != null)
                    {
                        cs.close();
                    }
                    if (con != null)
                    {
                        con.close();
                    }
                } 
                catch (SQLException ex)
                {
                    System.out.println(ex);
                }

                selectedPhnBookArry.clear();

                message = null;
            }
        }
       
        return false;
    }
        
    
}
