/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SmsStatus;

import com.pencil.Connection.DB_Connection;
import com.pencil.InstituteSetup.InstituteSetup;
import com.pencil.InstituteSetup.InstituteSetupService;
import com.pencil.InstituteSetup.InstituteSetupServiceImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG.SQ
 */
public class SmsStatusServiceImpl implements SmsStatusService, Serializable{

    @Override
    public SmsStutas statusList() {
        // List<SmsStutas> buildingList = new ArrayList<SmsStutas>();
        
        InstituteSetupService instituteService = new InstituteSetupServiceImpl();
        
        SmsStutas smsStatus = new SmsStutas();

        DB_Connection o = new DB_Connection();

        Connection con = o.getSms_db_Connection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        
             
        InstituteSetup institute = new InstituteSetup();
    
        String instituteId="";
        
//        institute = instituteService.instituteSetup();
//        
//        if(institute!=null){
//            
//        instituteId= institute.getInstituteID();      
//        
//        }
        
        FacesContext context=FacesContext.getCurrentInstance();
        
        instituteId=context.getExternalContext().getSessionMap().get("SchoolID").toString();

         try {
       

            prst = con.prepareStatement("select AccountBalance, ActiveTo, Status from sms_manage where School_ID =?");
            
            prst.setString(1, instituteId);

            rs = prst.executeQuery();

            while (rs.next()) {

                smsStatus=new SmsStutas(rs.getInt(1), rs.getString(2), rs.getInt(3));

            }

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

        return smsStatus;
    }

    }
    

