/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.report.StdAtdnDateWiseRpt;

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
public class StdAtdnDateWiseRptServiceImpl implements StdAtdnDateWiseRptService{
  
    public List<StdAtdnDateWiseRpt> attendenceReport(StdAtdnDateWiseRpt stdAtdnDateWiseRpt){
    
        List<StdAtdnDateWiseRpt> list = new ArrayList<StdAtdnDateWiseRpt>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        

        try {

            prst = con.prepareStatement("select AttendanceDate,total,Present,Absent from  student_attendace_info where AttendanceDate between ? and ? and InstituteID=? group by AttendanceDate");

            prst.setDate(1, new java.sql.Date(stdAtdnDateWiseRpt.getFromdate().getTime()));
            prst.setDate(2, new java.sql.Date(stdAtdnDateWiseRpt.getTodate().getTime()));
            prst.setString(3, institueID);


            rs = prst.executeQuery();

            while (rs.next()) {       
                
                int total=rs.getInt("total");
               
                double presentp;
                
                double absentp;
   
                
                if (total == 0) {
                    presentp = 0;
                    absentp = 0;
                } 
                else {
                    presentp = (float)(rs.getInt("Present") * 100) / total;
                    absentp = (float)(rs.getInt("Absent") * 100)/ total;
                } 

                list.add(new StdAtdnDateWiseRpt(rs.getDate("AttendanceDate"), rs.getInt("total"), rs.getInt("Present"),presentp,rs.getInt("Absent"),absentp));

            }
            
            System.out.println("List Size "+list.size());

            return list;

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

        return list;
    }
    
}
    

