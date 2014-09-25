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

        try {

            prst = con.prepareStatement("select (select count(StudentID) from student_attendence where AttendanceDate=?) as totalstudent,\n"
                    + "(select count(StudentID) from student_attendence where AttendanceDate=? and Absent=false) as present,\n"
                    + "(select count(StudentID) from student_attendence where AttendanceDate=? and Absent=true) as absent from dual");

            prst.setDate(1, new java.sql.Date(studentAttendenceReport.getDate().getTime()));
            prst.setDate(2, new java.sql.Date(studentAttendenceReport.getDate().getTime()));
            prst.setDate(3, new java.sql.Date(studentAttendenceReport.getDate().getTime()));

            rs = prst.executeQuery();

            while (rs.next()) {

                list.add(new StudentAttendenceReport(rs.getInt(1), rs.getInt(2), rs.getInt(3)));

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
