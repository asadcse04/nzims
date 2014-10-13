/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.report.StudentAttendenceReport;

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
public class StudentAttendenceReportServiceImpl implements StudentAttendenceReportService {

    public List<StudentAttendenceReport> AttendenceList(StudentAttendenceReport studentAttendenceReport) {

        List<StudentAttendenceReport> list = new ArrayList<StudentAttendenceReport>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {

//            prst = con.prepareStatement("select (select count(StudentID) from student_attendence where AttendanceDate=?) as totalstudent,\n"
//                    + "(select count(StudentID) from student_attendence where AttendanceDate=? and Absent=false) as present,\n"
//                    + "(select count(StudentID) from student_attendence where AttendanceDate=? and Absent=true) as absent from dual");
            
            prst = con.prepareStatement("select total,Present,Absent from student_attendace_info where AttendanceDate=? and InstituteID=? ");

            prst.setDate(1, new java.sql.Date(studentAttendenceReport.getDate().getTime()));
            prst.setString(2, institueID);
            
            
            rs = prst.executeQuery();

            while (rs.next()) {

                list.add(new StudentAttendenceReport(rs.getInt("total"), rs.getInt("Present"), rs.getInt("Absent")));

            }

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
