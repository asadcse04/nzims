/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.attendance.report.PresentReport;

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
public class PresentReportServiceImpl implements PresentReportService {

    public List<PresentReport> searchPresent(PresentReport presentReport) {

        List<PresentReport> list = new ArrayList<PresentReport>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        int twototal = 0;
        int twopresent = 0;
        int threetotal = 0;
        int threepresent = 0;
        int fourtotal = 0;
        int fourpresent = 0;
        int fivetotal = 0;
        int fivepresent = 0;
        int sixtotal = 0;
        int sixpresent = 0;
        int saventotal = 0;
        int savenpresent = 0;
        int eighttotal = 0;
        int eightpresent = 0;
        int ninetotal = 0;
        int ninepresent = 0;
        int tentotal = 0;
        int tenpresent = 0;

        ResultSet rs = null;
        ResultSet rs2 = null;

        try {

            prst = con.prepareStatement("select ClassID from class");
            rs2 = prst.executeQuery();

            while (rs2.next()) {
                int classid = rs2.getInt(1);

                prst = con.prepareStatement("select(select count(Absent) from student_attendence st, student_identification si \n" +
                                            "where st.studentid=si.studentid \n" +
                                            "and si.classconfigid in\n" +
                                            "(select scconfigid from classconfig where classid=?)\n" +
                                            "and  st.AttendanceDate=?) as total ,\n" +
                                            "(select count(Absent) FROM student_attendence st, student_identification si \n" +
                                            "where st.studentid=si.studentid \n" +
                                            "and si.classconfigid \n" +
                                            "in(select scconfigid from classconfig where classid=?)\n" +
                                            "and  AttendanceDate=? and Absent='0')as present from dual;");
                
                prst.setInt(1, classid);
                prst.setDate(2, new java.sql.Date(presentReport.getDate().getTime()));
                prst.setInt(3, classid);
                prst.setDate(4, new java.sql.Date(presentReport.getDate().getTime()));
                rs = prst.executeQuery();

                if (rs.next()) {
                    
                    if(classid==1){
                    twototal = rs.getInt(1);
                    twopresent = rs.getInt(2);
                    }
                    if(classid==2){
                    threetotal = rs.getInt(1);
                    threepresent = rs.getInt(2);
                    }
                    if(classid==3){
                    fourtotal = rs.getInt(1);
                    fourpresent = rs.getInt(2);
                    }
                    if(classid==4){
                    fivetotal = rs.getInt(1);
                    fivepresent = rs.getInt(2);
                    }
                    if(classid==5){
                    sixtotal = rs.getInt(1);
                    sixpresent = rs.getInt(2);
                    }
                    if(classid==6){
                    saventotal = rs.getInt(1);
                    savenpresent = rs.getInt(2);
                    }
                      if(classid==7){
                    eighttotal = rs.getInt(1);
                    eightpresent = rs.getInt(2);
                    }
                        if(classid==8){
                    ninetotal = rs.getInt(1);
                    ninepresent = rs.getInt(2);
                    }
                          if(classid==9){
                    tentotal = rs.getInt(1);
                    tenpresent = rs.getInt(2);
                    }

                }
                 rs=null;

            }

            list.add(new PresentReport(twototal, twopresent, threetotal, threepresent, fourtotal, fourpresent, fivetotal, fivepresent, sixtotal, sixpresent, saventotal, savenpresent, eighttotal, eightpresent, ninetotal, ninepresent, tentotal, tenpresent));

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
