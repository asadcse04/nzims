/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SubjectWiseReport;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salim
 */
public class SubjectReportServiceImpl implements Serializable, SubjectReportService {

    @Override
    public List<SubjectReport> subjectMarkReport(int exCnfID, int scCnfID, String subjectName)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<SubjectReport> subj_mark_List = new ArrayList<SubjectReport>();

        try {

            prst = con.prepareStatement("SELECT sr.StudentID,sb.StudentName,sb.StudentRoll, ROUND(sr.TotalScore,2) as totalscore, sr.LetterGrade, ROUND(sr.GradePoint,2) as gradepoint" 
                    +" FROM student_result sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID and sr.ExCnfID=?" 
                    +" and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll");
         
            prst.setInt(1,exCnfID);
            
            prst.setString(2,subjectName);
            
            prst.setInt(3,scCnfID);
            
            rs = prst.executeQuery();
            
         

            while (rs.next()) {
                subj_mark_List.add(new SubjectReport(rs.getString("sr.StudentID"), rs.getString("sb.StudentName"), rs.getInt("sb.StudentRoll"),rs.getDouble("totalscore"),rs.getDouble("gradepoint"),rs.getString("sr.LetterGrade")));
            }

            prst.close();

            con.close();

            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
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

        return subj_mark_List;
    }

    @Override
    public List<SubjectReport> DetailsMarkReport(int exCnfID, int scCnfID, String subjectName) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<SubjectReport> details_mark_List = new ArrayList<SubjectReport>();
     
        
        try {

            prst = con.prepareStatement("SELECT sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, ROUND(sr.TotalScore,2) as totalscore, ROUND(sr.Average,2) as avg, sr.LetterGrade, ROUND(sr.GradePoint,2) as gradepoint" 
                    +" FROM student_result sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID and sr.ExCnfID=?" 
                    +" and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll");
         
            prst.setInt(1,exCnfID);
            System.out.println(exCnfID+"jjjjjjjjjj");
            prst.setString(2,subjectName);
            
            prst.setInt(3,scCnfID);
             System.out.println(scCnfID+"hhhhh");
            rs = prst.executeQuery();

            while (rs.next()) {
                details_mark_List.add(new SubjectReport(rs.getString("sr.StudentID"),rs.getString("sb.StudentName"),rs.getInt("sb.StudentRoll"),rs.getString("sr.ShortCode1"), rs.getString("sr.ShortCode2"), rs.getString("sr.ShortCode3"), rs.getString("sr.ShortCode4"), rs.getDouble("avg"), rs.getDouble("totalscore"), rs.getDouble("gradepoint"),rs.getString("sr.LetterGrade")));
            }
            prst.close();

            con.close();

            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
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

        return details_mark_List;
    }

}
