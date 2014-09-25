/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamWiseReport;

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
public class ExamReportServiceImpl implements Serializable,ExamReportService
{

    @Override
    public List<ExamReport> ExamPassFailReport(int exCnfID, int scCnfID) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<ExamReport> exam_mark_List = new ArrayList<ExamReport>();
        
         try {
             
//            String qr1 = "SELECT s.subjectid, s.subjectName, (select count(studentId) from student_result where subjectid=s.subjectId and excnfid=?"
//                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) total,"
//                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='F' and excnfid=?"
//                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) FAIL,"
//                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade!='F' and excnfid=?"
//                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) PASS," 
//                    +" (select distinct(teacherid) from student_result where subjectid=s.subjectId  and excnfid=?"
//                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) teacherid"
//                    +" FROM subject s;";
             
             String qr = "SELECT sc.subjectid,s.subjectname,(select count(studentId) from student_result where subjectid=sc.subjectId "
                     + " and excnfid=?  and  studentid in (select studentid from student_identification where classconfigid=?  )) total, "
                     + " (select count(studentId) from student_result where subjectid=sc.subjectId and lettergrade='F' "
                     + " and excnfid=?  and  studentid in (select studentid from student_identification where classconfigid=?  )) FAIL, "
                     + " (select count(studentId) from student_result where subjectid=sc.subjectId and lettergrade!='F' "
                     + " and excnfid=?  and  studentid in (select studentid from student_identification where classconfigid=?  )) PASS, "
                     + " (select distinct(teacherid) from student_result where subjectid=sc.subjectId  and excnfid=? "
                     + " and  studentid in (select studentid from student_identification where classconfigid=?  )) "
                     + " teacherid FROM subjectconfig sc, classconfig cg, subject s where s.subjectid=sc.subjectid and sc.deptid=cg.deptid and sc.classid=cg.classid "
                     + " and cg.scconfigid=? ";

            prst = con.prepareStatement(qr);
         
            prst.setInt(1,exCnfID);
            
            prst.setInt(2,scCnfID);
            
            prst.setInt(3,exCnfID);
            
            prst.setInt(4,scCnfID);
            
            prst.setInt(5,exCnfID);
            
            prst.setInt(6,scCnfID);
            
            prst.setInt(7,exCnfID);
            
            prst.setInt(8,scCnfID);
            
            prst.setInt(9,scCnfID);
            
            rs = prst.executeQuery();
            

            while (rs.next()) {
                //exam_mark_List.add(new ExamReport(rs.getInt("s.subjectid"), rs.getString("s.subjectName"), rs.getInt("total"),rs.getInt("FAIL"),rs.getInt("PASS"),rs.getString("teacherid")));
                 exam_mark_List.add(new ExamReport(rs.getInt("sc.subjectid"), rs.getString("s.subjectName"), rs.getInt("total"),rs.getInt("FAIL"),rs.getInt("PASS"),rs.getString("teacherid")));
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

        return exam_mark_List;
    }

    @Override
    public List<ExamReport> GradingReport(int exCnfID, int scCnfID)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<ExamReport> grading_List = new ArrayList<ExamReport>();
        
          try {
             
            String qr = "SELECT s.subjectid, s.subjectName,"
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and  excnfid=?"
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) total,"
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='A+' and excnfid=?" 
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) APlus,"
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='A' and excnfid=?"
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) AAA," 
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='A-' and excnfid=?"
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) Aminus," 
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='B' and excnfid=?" 
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) BBB," 
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='C' and excnfid=?"
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) CCC," 
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='D' and excnfid=?"
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) DDD,"
                    +" (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='F' and excnfid=?"
                    +" and  studentid in (select studentid from student_identification where classconfigid=?)) FFF"
                    +" FROM subject s;";

            prst = con.prepareStatement(qr);
         
            prst.setInt(1,exCnfID);
            
            prst.setInt(2,scCnfID);
            
            prst.setInt(3,exCnfID);
            
            prst.setInt(4,scCnfID);
            
            prst.setInt(5,exCnfID);
            
            prst.setInt(6,scCnfID);
            
            prst.setInt(7,exCnfID);
            
            prst.setInt(8,scCnfID);
            
            prst.setInt(9,exCnfID);
            
            prst.setInt(10,scCnfID);
            
            prst.setInt(11,exCnfID);
            
            prst.setInt(12,scCnfID);
            
            prst.setInt(13,exCnfID);
            
            prst.setInt(14,scCnfID);
            
            prst.setInt(15,exCnfID);
            
            prst.setInt(16,scCnfID);
            
            
            rs = prst.executeQuery();
            

            while (rs.next())
            {
                grading_List.add(new ExamReport(rs.getInt("s.subjectid"), rs.getString("s.subjectName"), rs.getInt("total"), rs.getInt("APlus"), rs.getInt("AAA"), rs.getInt("Aminus"), rs.getInt("BBB"), rs.getInt("CCC"), rs.getInt("DDD"), rs.getInt("FFF")));
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

        return grading_List;
        
    }

    @Override
    public List<ExamReport> SectionWise_meritList(int exCnfID, int scCnfID)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<ExamReport> sec_wise_merit_List = new ArrayList<ExamReport>();
        
          try {
             
            String qr = "SELECT r.sectionposition, r.studentid, sbi.studentname, sbi.studentroll, ROUND(r.totalmark,2) as totalMark, ROUND(r.cgpa,2) as cgpa, r.finalgrade"
                    +" FROM student_result_summary r, student_identification s, student_basic_info sbi"
                    +" where r.studentid=s.studentid and s.studentid=sbi.studentid and r.excnfid=? and s.classconfigid=? order by r.sectionposition;";

            prst = con.prepareStatement(qr);
         
            prst.setInt(1,exCnfID);
            
            prst.setInt(2,scCnfID);
            
            rs = prst.executeQuery();
            

            while (rs.next()) {
                sec_wise_merit_List.add(new ExamReport(rs.getInt("r.sectionposition"),rs.getString("r.studentid"), rs.getString("sbi.studentname"), rs.getInt("sbi.studentroll"),rs.getDouble("totalMark"),rs.getDouble("cgpa"),rs.getString("r.finalgrade")));
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

        return sec_wise_merit_List;
        
    }
    
}
