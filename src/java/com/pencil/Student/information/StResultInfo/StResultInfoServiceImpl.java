/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Student.information.StResultInfo;

import com.pencil.Connection.DB_Connection;
import com.pencil.Student.information.AttendanceInfo.AttendanceInfoController;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author SHOHUG.SQ
 */
public class StResultInfoServiceImpl implements StResultInfoService, Serializable {

    @Override
    public List<StResultInfo> resultList(StResultInfoController stResultInfo) {

        AttendanceInfoController aic = new AttendanceInfoController();

        DB_Connection db;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        FacesContext context = FacesContext.getCurrentInstance();

        String id = context.getExternalContext().getSessionMap().get("StudentID").toString();

        FacesContext contextClass = FacesContext.getCurrentInstance();

        String className = contextClass.getExternalContext().getSessionMap().get("class").toString();

        List<StResultInfo> mark_List = new ArrayList<StResultInfo>();

        try {
            db = new DB_Connection();

            con = db.getConnection();

            prst = con.prepareStatement("SELECT distinct sbj.SubjectID, sbj.SubjectName,sr.ShortCode1,sr.ShortCode2,sr.ShortCode3,sr.ShortCode4,sr.TotalScore,ROUND(sr.Average,2) as avg, ROUND(sr.FinalScore,2) as finalScore,\n"
                    + " sr.LetterGrade, sr.GradePoint FROM student_result sr,\n"
                    + " subject sbj,exam_config ec where sr.SubjectID=sbj.SubjectID\n"
                    + "	and sr.StudentID=? and sr.ExcnfID= (select ExcnfID from exam_config where AcYr=? \n"
                    + " and ExamID=(select Exam_ID from exam where ExamName=? ) \n"
                    + " and ClassID=(select ClassID from class where ClassName=?))");

            prst.setString(1, id);
            prst.setString(2, stResultInfo.getAcYr());
            prst.setString(3, stResultInfo.getExamName());
            prst.setString(4, className);
            
            rs = prst.executeQuery();

            while (rs.next()) {
                mark_List.add(new StResultInfo(rs.getString("sbj.SubjectName"), rs.getString("sr.ShortCode1"), rs.getString("sr.ShortCode2"), rs.getString("sr.ShortCode3"), rs.getString("sr.ShortCode4"),
                        rs.getDouble("sr.TotalScore"), rs.getDouble("avg"), rs.getDouble("finalScore"), rs.getString("sr.LetterGrade"), rs.getDouble("sr.GradePoint"), rs.getString("sbj.SubjectName")));
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

        return mark_List;
    }

    @Override
    public List<StResultInfo> finalGrade(StResultInfoController resultInfo) {

        DB_Connection db;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        FacesContext context = FacesContext.getCurrentInstance();

        String id = context.getExternalContext().getSessionMap().get("StudentID").toString();

        FacesContext contextClass = FacesContext.getCurrentInstance();

        String className = contextClass.getExternalContext().getSessionMap().get("class").toString();

        List<StResultInfo> total_grade_List = new ArrayList<StResultInfo>();

        try {
            db = new DB_Connection();

            con = db.getConnection();

            prst = con.prepareStatement("select ROUND(TotalMark,2) as total,ROUND(CGPA,2) as cgpa,FinalGrade,Status,\n"
                    + " ClassPosition,ShiftPosition,SectionPosition from student_result_summary\n"
                    + " where StudentID=? and ExcnfID= (select ExcnfID from exam_config where AcYr=? \n"
                    + " and ExamID=(select Exam_ID from exam where ExamName=? ) \n"
                    + " and ClassID=(select ClassID from class where ClassName=?))");

            prst.setString(1, id);
            prst.setString(2, resultInfo.getAcYr());
            prst.setString(3, resultInfo.getExamName());
            prst.setString(4, className);

            rs = prst.executeQuery();

            while (rs.next()) {
                total_grade_List.add(new StResultInfo(rs.getDouble("total"), rs.getDouble("cgpa"), rs.getString("FinalGrade"), rs.getString("Status"), rs.getInt("ClassPosition"), rs.getInt("ShiftPosition"), rs.getInt("SectionPosition")));
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

        return total_grade_List;
    }
}
