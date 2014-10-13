/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Student.AttendanceReport;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author salim
 */
public class AttendanceReportServiceImpl implements AttendanceReportService {

    @Override
    public List<AttendanceReport> sectionWisePsnAbs_List(Date currentDate) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
         
        FacesContext context=FacesContext.getCurrentInstance();
        
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<AttendanceReport> stdAttendance_List = new ArrayList<AttendanceReport>();

//        String query = " SELECT scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,"
//                + "(select count(studentid) from student_attendence where attendancedate=? and"
//                + " studentid in(select studentid from student_identification where classconfigid=scCnf.scconfigid)) total,"
//                + " (select count(studentid) from student_attendence where absent=false and attendancedate=?"
//                + " and studentid in(select studentid from student_identification where classconfigid=scCnf.scconfigid)) present,"
//                + " (select count(studentid) from student_attendence where absent=true and attendancedate=?"
//                + " and studentid in(select studentid from student_identification where classconfigid=scCnf.scconfigid)) absent"
//                + " FROM classconfig scCnf,class c,shift s,section sctn, department d where scCnf.ClassID=c.ClassID"
//                + " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.DeptID=d.departmentid order by scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName";
        
          String query = "SELECT scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,sa.total,sa.present,sa.absent\n" +
        " FROM classconfig scCnf,class c,shift s,section sctn, department d, student_attendace_info sa where scCnf.ClassID=c.ClassID\n" +
        " and sa.instituteid=sctn.instituteid and sa.ClassConfigID=scCnf.ScConfigID\n" +
        " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.DeptID=d.departmentid \n" +
        " and sa.AttendanceDate=? and sa.InstituteID=? \n" +
        " order by scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName ";      

        try {
            prst = con.prepareStatement(query);

            prst.setDate(1, new java.sql.Date(currentDate.getTime()));

            prst.setString(2, institueID);

            rs = prst.executeQuery();

            while (rs.next()) {
                double total;
                double presentp;
                double absentp;

                total = (double) (rs.getInt("sa.total")) ;

                if (total == 0) {
                    presentp = 0;
                    absentp = 0;
                } else {
                    presentp = (double) (rs.getInt("sa.present") * 100) / total;
                    absentp = (double) (rs.getInt("sa.absent") * 100) / total;
                }

                stdAttendance_List.add(new AttendanceReport(rs.getString("c.classname"), rs.getString("s.shiftname"), rs.getString("sctn.SectionName"), rs.getInt("total"),
                        rs.getInt("present"), presentp, rs.getInt("absent"), absentp));
            }
        } catch (Exception ex) {
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

        return stdAttendance_List;
    }

    @Override
    public List<AttendanceReport> specificSectionAttendance_List(int scCnfID, Date specificDate, String status) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        String sq="";
        
        if(status.equals("All")){
                sq=" sa.absent in(0,1) ";
                
            }else if(status.equals("Present")){
                 sq=" sa.absent in(0) ";
            }else if(status.equals("Absent")){
                sq=" sa.absent in(1) ";
            }

        List<AttendanceReport> specificAttendance_List = new ArrayList<AttendanceReport>();

        String query = "select sbi.studentid, sbi.studentname, sbi.studentroll, sa.absent, sa.note, sa.attendancedate\n"
                + " from student_basic_info sbi, student_attendence sa, student_identification si \n"
                + " where sbi.studentid= sa.studentid and si.StudentID=sbi.StudentID\n"
                + " and sbi.InstituteID=sa.InstituteID and sa.InstituteID=si.InstituteID \n"
                + " and si.InstituteID='"+institueID+"' and si.classconfigid=? and sa.attendancedate=? and "+sq+" \n"
                + " order by sbi.studentroll";

        try {
            
            
            prst = con.prepareStatement(query);

            prst.setInt(1, scCnfID);

            prst.setDate(2, new java.sql.Date(specificDate.getTime()));
            
            //prst.setString(3, sq);

            rs = prst.executeQuery();

            while (rs.next()) {
                specificAttendance_List.add(new AttendanceReport(rs.getString("sbi.studentid"), rs.getString("sbi.studentname"), rs.getInt("sbi.studentroll"), rs.getInt("absent"), rs.getString("note")));

                
            }

        } catch (Exception ex) {
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

        return specificAttendance_List;

    }

    @Override
    public List<AttendanceReport> classList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<AttendanceReport> scCnfList = new ArrayList<AttendanceReport>();

        try {
            prst = con.prepareStatement(" select scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,dpt.DepartmentName\n"
                    + " from classconfig scCnf,class c,shift s,section sctn, department dpt where scCnf.ClassID=c.ClassID and scCnf.InstituteID=sctn.InstituteID\n"
                    + " and sctn.InstituteID=? and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.DeptID=dpt.DepartmentID group by scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,dpt.DepartmentName order by scCnf.ScConfigID ");

            prst.setString(1, institueID);
            rs = prst.executeQuery();

            while (rs.next()) {
                scCnfList.add(new AttendanceReport(rs.getString("scCnf.AcYrID"), rs.getString("c.ClassName"), rs.getString("dpt.DepartmentName"), rs.getString("s.ShiftName"), rs.getString("sctn.SectionName")));
            }
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

        return scCnfList;
    }

    @Override
    public int getScCnfID(AttendanceReport sq) {
        int scCnfID = 0;

        DB_Connection o;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;
        
         
        String institueID="";
        
        FacesContext context=FacesContext.getCurrentInstance();
        
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            o = new DB_Connection();

            con = o.getConnection();

            prst = con.prepareStatement("select ScConfigID from classconfig where AcYrID=? "
                    + " and DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and ClassID=(select ClassID from class where ClassName=?)"
                    + " and shiftID=(select ShiftID from shift where ShiftName=?)"
                    + " and SectionID=(select SectionID from section where SectionName=? and instituteid=?)");

            prst.setString(1, sq.getAcyr());

            prst.setString(2, sq.getDepartmentName());

            prst.setString(3, sq.getClassName());

            prst.setString(4, sq.getShiftName());

            prst.setString(5, sq.getSectionName());
            
            prst.setString(6, institueID);

            rs = prst.executeQuery();
            while (rs.next()) {
                scCnfID = rs.getInt(1);
            }

            return scCnfID;

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
        return scCnfID;
    }

}
