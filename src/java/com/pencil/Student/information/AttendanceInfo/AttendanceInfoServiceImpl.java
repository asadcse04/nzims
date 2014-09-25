/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Student.information.AttendanceInfo;

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
 * @author SHOHUG.SQ
 */
public class AttendanceInfoServiceImpl implements AttendanceInfoService, Serializable {

    @Override
    public List<AttendanceInfo> attenList(AttendanceInfo attendanceInfo, AttendanceInfoController aic ) {
        

        List<AttendanceInfo> stdInfolist = new ArrayList<AttendanceInfo>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            String query = "select attendancedate, absent, note from student_attendence s where "
                    + " attendancedate between  ? and ?  and studentid= ? ";

            prst = con.prepareStatement(query);

            prst.setDate(1, new java.sql.Date(attendanceInfo.getFromDate().getTime()));
            prst.setDate(2, new java.sql.Date(attendanceInfo.getToDate().getTime()));

            prst.setString(3, aic.getID());

            rs = prst.executeQuery();

            while (rs.next()) {

                stdInfolist.add(new AttendanceInfo(rs.getString(1), rs.getInt(2), rs.getString(3)));
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException sql) {
                System.out.println(sql);
            }
        }

        return stdInfolist;
    }

    @Override
    public List<AttendanceInfo> attenListCount(AttendanceInfo attendanceInfo, AttendanceInfoController aic) {

        List<AttendanceInfo> stdInfolist = new ArrayList<AttendanceInfo>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            String query = "select"
                    + " sum(case when absent=1 then 1 else 0 end) absent,"
                    + " sum(case when absent=0 then 1 else 0 end) present,"
                    + " sum(case when note='Leave' then 1 else 0 end) stdleave,"
                    + " sum(case when note='Incomplete' then 1 else 0 end) incomplete,"
                    + " sum(case when note='Application' then 1 else 0 end) aplication"
                    + " from student_attendence s where "
                    + " attendancedate between  ? and ? and studentid=?";

            prst = con.prepareStatement(query);

            prst.setDate(1, new java.sql.Date(attendanceInfo.getFromDate().getTime()));
            prst.setDate(2, new java.sql.Date(attendanceInfo.getToDate().getTime()));

            prst.setString(3, aic.getID());

            rs = prst.executeQuery();

            while (rs.next()) {

                stdInfolist.add(new AttendanceInfo( rs.getInt(2),rs.getInt(1),rs.getInt(3),rs.getInt(5),rs.getInt(4)));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException sql) {
                System.out.println(sql);
            }
        }

        return stdInfolist;
    }

    @Override
    public AttendanceInfo getStudentAllinfo(String stdID) {
        
        AttendanceInfo allInfo= new AttendanceInfo();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            String query = "SELECT sb.StudentID,sb.StudentName, sb.StudentRoll,sb.Gender,sg.FatherName,sg.ContactNo,acyr.AcYrID,"
                    + " c.ClassName,d.DepartmentName,s.ShiftName,sctn.SectionName,sb.ImgPath"
                    + " from student_basic_info sb,student_guardian_info sg,classconfig scCnf,"
                    + " student_identification si,academic_year acyr,"
                    + " department d,class c,shift s,section sctn"
                    + " where sg.StudentID=sb.StudentID and si.StudentID=sb.StudentID and"
                    + " si.ClassConfigID=scCnf.ScConfigID and scCnf.AcYrID=acyr.AcYrID and"
                    + " scCnf.DeptID=d.DepartmentID and"
                    + " scCnf.ClassID=c.ClassID and scCnf.ShiftID=s.ShiftID and"
                    + " scCnf.SectionID=sctn.SectionID and sb.StudentID=?";

            prst = con.prepareStatement(query);

            prst.setString(1, stdID);

            rs = prst.executeQuery();

            if (rs.next()) {

                allInfo.setStudentID(rs.getString("sb.StudentID"));
                
                allInfo.setStudentName(rs.getString("sb.StudentName"));
                
                allInfo.setFatherName(rs.getString("sg.FatherName"));
                
                allInfo.setStudentRoll(rs.getInt("sb.StudentRoll"));
                
                allInfo.setGender(rs.getString("sb.Gender"));
                
                allInfo.setContactNo(rs.getString("sg.ContactNo"));
                
                allInfo.setAcyr(rs.getInt("acyr.AcYrID"));
                
                allInfo.setClassName(rs.getString("c.ClassName"));
                
                allInfo.setDeptName(rs.getString("d.DepartmentName"));
                
                allInfo.setShiftName(rs.getString("s.ShiftName"));
                
                allInfo.setSectionName(rs.getString("sctn.SectionName"));
                
                allInfo.setImgPath(rs.getString("sb.ImgPath"));
                
                return allInfo;
                
                
            }

            
        }
        catch (SQLException e)
        {
            System.out.println("Can't Find Student ID ..."+e);
        } 
        finally 
        {
            try 
            {
                if (prst != null)
                {
                    prst.close();
                }

                if (con != null)
                {
                    con.close();
                }
            } 
            catch (SQLException sql) 
            {
                System.out.println(sql);
            }
        }

        return allInfo;
    }
    }


