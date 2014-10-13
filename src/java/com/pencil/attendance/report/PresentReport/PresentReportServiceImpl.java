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
import javax.faces.context.FacesContext;

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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {

            prst = con.prepareStatement("select ClassID from class");
            rs2 = prst.executeQuery();

            while (rs2.next()) {
                int classid = rs2.getInt(1);

//                prst = con.prepareStatement("select(select count(Absent) from student_attendence st, student_identification si \n" +
//                                            "where st.studentid=si.studentid \n" +
//                                            "and si.classconfigid in\n" +
//                                            "(select scconfigid from classconfig where classid=?)\n" +
//                                            "and  st.AttendanceDate=?) as total ,\n" +
//                                            "(select count(Absent) FROM student_attendence st, student_identification si \n" +
//                                            "where st.studentid=si.studentid \n" +
//                                            "and si.classconfigid \n" +
//                                            "in(select scconfigid from classconfig where classid=?)\n" +
//                                            "and  AttendanceDate=? and Absent='0')as present from dual;");
                
                prst=con.prepareStatement("SELECT sum(present), sum(absent), sum(total) FROM nzims_db.student_attendace_info "
                                            + "where ClassConfigID in(select ScConfigID from classconfig where ClassID=?) \n" +
                                            " and AttendanceDate=? and InstituteID=? group by AttendanceDate");
                
                prst.setInt(1, classid);
                prst.setDate(2, new java.sql.Date(presentReport.getDate().getTime()));
                prst.setString(3, institueID);
                
                rs = prst.executeQuery();

                if (rs.next()) {
                    
                    if(classid==21){
                    twototal = rs.getInt("sum(total)");
                    twopresent = rs.getInt("sum(present)");
                    }
                    if(classid==22){
                    threetotal = rs.getInt("sum(total)");
                    threepresent = rs.getInt("sum(present)");
                    }
                    if(classid==23){
                    fourtotal = rs.getInt("sum(total)");
                    fourpresent = rs.getInt("sum(present)");
                    }
                    if(classid==24){
                    fivetotal = rs.getInt("sum(total)");
                    fivepresent = rs.getInt("sum(present)");
                    }
                    if(classid==25){
                    sixtotal = rs.getInt("sum(total)");
                    sixpresent = rs.getInt("sum(present)");
                    }
                    if(classid==26){
                    saventotal = rs.getInt("sum(total)");
                    savenpresent = rs.getInt("sum(present)");
                    }
                      if(classid==27){
                    eighttotal = rs.getInt("sum(total)");
                    eightpresent = rs.getInt("sum(present)");
                    }
                        if(classid==28){
                    ninetotal = rs.getInt("sum(total)");
                    ninepresent = rs.getInt("sum(present)");
                    }
                          if(classid==29){
                    tentotal = rs.getInt("sum(total)");
                    tenpresent = rs.getInt("sum(present)");
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
