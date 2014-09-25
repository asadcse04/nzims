/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.MarkSheetPrint;

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
public class MarkSheetPrintServiceImpl implements Serializable, MarkSheetPrintService {

    @Override
    public List<MarkSheetPrint> student_Info_List(int ExCnfID)
    {
        DB_Connection db;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<MarkSheetPrint> std_info_List = new ArrayList<MarkSheetPrint>();

        try 
        {
            db = new DB_Connection();
            
            con = db.getConnection();
            
            prst = con.prepareStatement("SELECT sb.StudentID,sb.StudentName, sb.StudentRoll,sb.Gender,"
                    + " acyr.AcYrID,d.DepartmentName,c.ClassName,s.ShiftName,sctn.SectionName"
                    + " from student_basic_info sb,classconfig scCnf,student_identification si,student_result_summary srs,academic_year acyr,department d,class c,shift s,section sctn"
                    + " where si.StudentID=sb.StudentID and srs.StudentID=sb.StudentID and si.ClassConfigID=scCnf.ScConfigID and scCnf.AcYrID=acyr.AcYrID"
                    + " and scCnf.DeptID=d.DepartmentID and scCnf.ClassID=c.ClassID and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and srs.ExcnfID=? order by sb.StudentRoll");

            prst.setInt(1,ExCnfID);
            
            rs = prst.executeQuery();

            while (rs.next()) 
            {
                std_info_List.add(new MarkSheetPrint(rs.getString("sb.StudentID"), rs.getString("sb.StudentName"), rs.getInt("sb.StudentRoll"), rs.getString("sb.Gender"),
                        
                        rs.getInt("acyr.AcYrID"), rs.getString("d.DepartmentName"), rs.getString("c.ClassName"), rs.getString("s.ShiftName"), rs.getString("sctn.SectionName")));
            }
        } 
        catch (SQLException ex)
        {
            System.out.println(ex);
        } 
        finally
        {
            try {
                if (rs != null)
                {
                    rs.close();
                }
                if (prst != null)
                {
                    prst.close();
                }
                if (con != null) 
                {
                    con.close();
                }
            } 
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }

        return std_info_List;
    }

    @Override
    public List<MarkSheetPrint> mark_sheet_List(String studentID,int ExCnfID)
    {
        DB_Connection db;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<MarkSheetPrint> mark_List = new ArrayList<MarkSheetPrint>();

        try 
        {
            db = new DB_Connection();
            
            con = db.getConnection();
            
            prst = con.prepareStatement("SELECT sbj.SubjectID, sbj.SubjectName,sr.ShortCode1,sr.ShortCode2,sr.ShortCode3,sr.ShortCode4,sr.TotalScore,ROUND(sr.Average,2) as avg, ROUND(sr.FinalScore,2) as finalScore,"
                    + " sr.LetterGrade, sr.GradePoint,t.TeacherName FROM student_result sr,"
                    + " subject sbj,teacher t where sr.SubjectID=sbj.SubjectID and"
                    + " sr.teacherID=t.TeacherID and sr.StudentID=? and sr.ExCnfID=? ORDER BY sbj.SubjectID");
            
            prst.setString(1,studentID);
            
            prst.setInt(2,ExCnfID);

            rs = prst.executeQuery();

            while (rs.next())
            {
                mark_List.add(new MarkSheetPrint(rs.getString("sbj.SubjectName"), rs.getString("sr.ShortCode1"), rs.getString("sr.ShortCode2"), rs.getString("sr.ShortCode3"), rs.getString("sr.ShortCode4"),
                        
                        rs.getDouble("sr.TotalScore"), rs.getDouble("avg"), rs.getDouble("finalScore"), rs.getString("sr.LetterGrade"), rs.getDouble("sr.GradePoint"), rs.getString("t.TeacherName")));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        finally
        {
            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (prst != null)
                {
                    prst.close();
                }
                if (con != null)
                {
                    con.close();
                }
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }

        return mark_List;
    }

    @Override
    public List<MarkSheetPrint> mark_sheet_finalGrade(String studentID, int ExCnfID)
    {
        DB_Connection db;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

		
        List<MarkSheetPrint> total_grade_List = new ArrayList<MarkSheetPrint>();

        try
        {
            db = new DB_Connection();
            
            con = db.getConnection();
            
            prst = con.prepareStatement("select ROUND(TotalMark,2) as total,ROUND(CGPA,2) as cgpa,FinalGrade,Status,ClassPosition,ShiftPosition,SectionPosition from student_result_summary"
                    
                    + " where StudentID=? and ExcnfID=?");
            
            prst.setString(1,studentID);
            
            prst.setInt(2,ExCnfID);

            rs=prst.executeQuery();

             while (rs.next()) {
                total_grade_List.add(new MarkSheetPrint(rs.getDouble("total"),rs.getDouble("cgpa"),rs.getString("FinalGrade"),rs.getString("Status"),rs.getInt("ClassPosition"),rs.getInt("ShiftPosition"),rs.getInt("SectionPosition")));
            }
        } 
        catch (SQLException ex)
        {
            System.out.println(ex);
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (prst != null)
                {
                    prst.close();
                }
                if (con != null) 
                {
                    con.close();
                }
            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }

        return total_grade_List;
    }
}
