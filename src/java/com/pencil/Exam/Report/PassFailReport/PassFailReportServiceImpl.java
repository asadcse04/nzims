/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.PassFailReport;

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
public class PassFailReportServiceImpl implements PassFailReportService{
    

     public List<String> ExamNameList(){
      
         List<String> list=new ArrayList<String>();
      
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select ExamName from exam");

            rs = prst.executeQuery();

            while (rs.next()) {
                
                list.add(rs.getString(1));
            
            }

            return list;

        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        finally {
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
     
     
     public List<PassFailReport> totalPassFail(PassFailReport passFailReport){
         
         List<PassFailReport> list=new ArrayList<PassFailReport>();
         
         DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
          
            prst=con.prepareCall("select (select count(status) from student_result_summary where status='pass'\n" +
                                 "and excnfid in (select excnfid from exam_config where acyr=? and examid=(select exam_id from exam where examname=?)))  pass,\n" +
                                 "(select count(status) from student_result_summary where status='fail'\n" +
                                 "and excnfid in (select excnfid from exam_config where acyr=? and examid=(select exam_id from exam where examname=?))) fail,\n" +
                                 "(select count(status) from student_result_summary where \n" +
                                 "excnfid in (select excnfid from exam_config where acyr=? and examid=(select exam_id from exam where examname=?)))as total from dual;");
 

           prst.setInt(1, passFailReport.getAcademicyear());
           prst.setString(2, passFailReport.getExamname());
           prst.setInt(3, passFailReport.getAcademicyear());
           prst.setString(4, passFailReport.getExamname());
           prst.setInt(5, passFailReport.getAcademicyear());
           prst.setString(6, passFailReport.getExamname());
           

        rs = prst.executeQuery();

            while (rs.next()) {
                
                list.add(new PassFailReport(rs.getInt(1),rs.getInt(2),rs.getInt(3)));

        }

            return list;

        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        finally {
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
