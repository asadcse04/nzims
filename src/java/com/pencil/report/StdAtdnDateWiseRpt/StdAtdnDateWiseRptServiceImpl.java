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

        try {

            prst = con.prepareStatement("select sa.AttendanceDate, count(sa.studentid) total,\n" +
                                        "(select count(s.studentid) from student_attendence s where absent='0' and s.AttendanceDate= sa.AttendanceDate) present,\n" +
                                        "(select count(s.studentid) from student_attendence s where absent='1' and s.AttendanceDate=sa.AttendanceDate) absent\n" +
                                        "from student_attendence sa where AttendanceDate between ? and ? group by AttendanceDate;");

            prst.setDate(1, new java.sql.Date(stdAtdnDateWiseRpt.getFromdate().getTime()));
            prst.setDate(2, new java.sql.Date(stdAtdnDateWiseRpt.getTodate().getTime()));


            rs = prst.executeQuery();

            while (rs.next()) {       
                
                int total;
               
                double presentp;
                
                double absentp;
                
                total = rs.getInt(3) + rs.getInt(4);
                
                if (total == 0) {
                    presentp = 0;
                    absentp = 0;
                } 
                else {
                    presentp = (float)(rs.getInt(3) * 100) / total;
                    absentp = (float)(rs.getInt(4) * 100)/ total;
                } 

                list.add(new StdAtdnDateWiseRpt(rs.getDate(1), rs.getInt(2), rs.getInt(3),presentp,rs.getInt(4),absentp));

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
    

