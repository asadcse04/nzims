/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.BasicView;

import com.pencil.Connection.DB_Connection;
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
public class BasicReportServiceImlp implements BasicReportService, Serializable {

    @Override
    public List<BasicReport> yearClassDepartShiftSection() {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<BasicReport> scCnfList = new ArrayList<BasicReport>();

        try {
            prst = con.prepareStatement("select scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,dpt.DepartmentName\n" +
                                        " from classconfig scCnf,class c,shift s,section sctn, department dpt where scCnf.ClassID=c.ClassID \n" +
                                        " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.DeptID=dpt.DepartmentID and scCnf.InstituteID=sctn.InstituteID and scCnf.InstituteID=? \n" +
                                        " group by scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,dpt.DepartmentName order by scCnf.ScConfigID ");
            
            prst.setString(1, institueID);
            
            rs = prst.executeQuery();

            while (rs.next()) {
                scCnfList.add(new BasicReport(rs.getInt("scCnf.AcYrID"), rs.getString("c.ClassName"), rs.getString("dpt.DepartmentName"), rs.getString("s.ShiftName"), rs.getString("sctn.SectionName")));
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
    public int getScCnfID(BasicReport sq) {

        int scCnfID = 0;

        DB_Connection o;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            o = new DB_Connection();

            con = o.getConnection();

            prst = con.prepareStatement("select ScConfigID from classconfig where AcYrID=? "
                    + " and DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and ClassID=(select ClassID from class where ClassName=?)"
                    + " and shiftID=(select ShiftID from shift where ShiftName=?)"
                    + " and SectionID=(select SectionID from section where SectionName=?)");

            prst.setInt(1, sq.getAcYr());

            prst.setString(2, sq.getDepartmentName());

            prst.setString(3, sq.getClassName());

            prst.setString(4, sq.getShiftName());

            prst.setString(5, sq.getSectionName());

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

    @Override
    public int getExCnfID(BasicReport sq) {
        int exCnfId = 0;

        DB_Connection o;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;
        try {
            o = new DB_Connection();

            con = o.getConnection();

            prst = con.prepareStatement("select ExCnfID from exam_config where AcYr=? and ClassID=(select ClassID from class where ClassName=?) \n"
                    + " and ExamID=(select Exam_ID from exam where ExamName=?)");

            prst.setInt(1, sq.getAcYr());

            System.out.println("exxy" + sq.getAcYr());
            System.out.println("claaa" + sq.getClassName());

            System.out.println("exn" + sq.getExamName());

            prst.setString(2, sq.getClassName());

            prst.setString(3, sq.getExamName());

            rs = prst.executeQuery();

            while (rs.next()) {
                exCnfId = rs.getInt(1);
                
                System.out.println("exCnfIdexCnfId"+exCnfId);
            }
        } catch (SQLException ex) {
            System.out.println("ResultServiceImpl:" + ex);
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

        return exCnfId;
    }

    @Override
    public List<String> subjectName(BasicReport className) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> subject = new ArrayList<String>();

        try {
            prst = con.prepareStatement("select distinct SubjectName from subject s, subjectconfig sc, class c, department d \n"
                    + " where s.SubjectID=sc.SubjectID and sc.ClassID=(select ClassID from class where ClassName=?) \n"
                    + " and sc.DeptID=(select DepartmentID from department where DepartmentName=?)");

            prst.setString(1, className.getClassName());

            prst.setString(2, className.getDepartmentName());

            rs = prst.executeQuery();

            while (rs.next()) {
                subject.add(rs.getString("SubjectName"));
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

        return subject;
    }

    @Override
    public List<BasicReport> ExamPassFailReport(int exCnfID, int scCnfID) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<BasicReport> exam_mark_List = new ArrayList<BasicReport>();

        try {

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

            prst.setInt(1, exCnfID);

            prst.setInt(2, scCnfID);

            prst.setInt(3, exCnfID);

            prst.setInt(4, scCnfID);

            prst.setInt(5, exCnfID);

            prst.setInt(6, scCnfID);

            prst.setInt(7, exCnfID);

            prst.setInt(8, scCnfID);

            prst.setInt(9, scCnfID);

            rs = prst.executeQuery();

            while (rs.next()) {
                //exam_mark_List.add(new ExamReport(rs.getInt("s.subjectid"), rs.getString("s.subjectName"), rs.getInt("total"),rs.getInt("FAIL"),rs.getInt("PASS"),rs.getString("teacherid")));
                exam_mark_List.add(new BasicReport(rs.getInt("sc.subjectid"), rs.getString("s.subjectName"), rs.getInt("total"), rs.getInt("FAIL"), rs.getInt("PASS"), rs.getString("teacherid")));
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
    public List<BasicReport> GradingReport(int exCnfID, int scCnfID) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<BasicReport> grading_List = new ArrayList<BasicReport>();

        try {

            String qr = "SELECT s.subjectid, s.subjectName,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and  excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) total,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='A+' and excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) APlus,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='A' and excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) AAA,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='A-' and excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) Aminus,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='B' and excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) BBB,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='C' and excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) CCC,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='D' and excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) DDD,"
                    + " (select count(studentId) from student_result where subjectid=s.subjectId and lettergrade='F' and excnfid=?"
                    + " and  studentid in (select studentid from student_identification where classconfigid=?)) FFF"
                    + " FROM subject s;";

            prst = con.prepareStatement(qr);

            prst.setInt(1, exCnfID);

            prst.setInt(2, scCnfID);

            prst.setInt(3, exCnfID);

            prst.setInt(4, scCnfID);

            prst.setInt(5, exCnfID);

            prst.setInt(6, scCnfID);

            prst.setInt(7, exCnfID);

            prst.setInt(8, scCnfID);

            prst.setInt(9, exCnfID);

            prst.setInt(10, scCnfID);

            prst.setInt(11, exCnfID);

            prst.setInt(12, scCnfID);

            prst.setInt(13, exCnfID);

            prst.setInt(14, scCnfID);

            prst.setInt(15, exCnfID);

            prst.setInt(16, scCnfID);

            rs = prst.executeQuery();

            while (rs.next()) {
                grading_List.add(new BasicReport(rs.getInt("s.subjectid"), rs.getString("s.subjectName"), rs.getInt("total"), rs.getInt("APlus"), rs.getInt("AAA"), rs.getInt("Aminus"), rs.getInt("BBB"), rs.getInt("CCC"), rs.getInt("DDD"), rs.getInt("FFF")));
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
    public List<BasicReport> SectionWise_meritList(int exCnfID, int scCnfID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BasicReport> DetailsMarkReport(int exCnfID, int scCnfID, String subjectName) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<BasicReport> details_mark_List = new ArrayList<BasicReport>();

        try {

            prst = con.prepareStatement("SELECT sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, ROUND(sr.TotalScore,2) as totalscore, ROUND(sr.Average,2) as avg, sr.LetterGrade, ROUND(sr.GradePoint,2) as gradepoint"
                    + " FROM student_result sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID and sr.ExCnfID=?"
                    + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll");

            prst.setInt(1, exCnfID);
            System.out.println(exCnfID + "exCnfID");
            prst.setString(2, subjectName);
            System.out.println("sub" + subjectName);
            prst.setInt(3, scCnfID);
            System.out.println(scCnfID + "scCnfID");
            rs = prst.executeQuery();

            while (rs.next()) {
                details_mark_List.add(new BasicReport(rs.getString("sr.StudentID"), rs.getString("sb.StudentName"), rs.getInt("sb.StudentRoll"), rs.getString("sr.ShortCode1"), rs.getString("sr.ShortCode2"), rs.getString("sr.ShortCode3"), rs.getString("sr.ShortCode4"), rs.getDouble("avg"), rs.getDouble("totalscore"), rs.getDouble("gradepoint"), rs.getString("sr.LetterGrade")));
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

    @Override
    public List<BasicReport> subjectMarkReport(int exCnfID, int scCnfID, String subjectName) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
       

        List<BasicReport> subj_mark_List = new ArrayList<BasicReport>();

        try {

            prst = con.prepareStatement("SELECT sr.StudentID,sb.StudentName,sb.StudentRoll, ROUND(sr.TotalScore,2) as totalscore, sr.LetterGrade, ROUND(sr.GradePoint,2) as gradepoint"
                    + " FROM student_result sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID and sr.ExCnfID=?"
                    + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll");

            prst.setInt(1, exCnfID);

            prst.setString(2, subjectName);

            prst.setInt(3, scCnfID);

            rs = prst.executeQuery();

            while (rs.next()) {
                subj_mark_List.add(new BasicReport(rs.getString("sr.StudentID"), rs.getString("sb.StudentName"), rs.getInt("sb.StudentRoll"), rs.getDouble("totalscore"), rs.getDouble("gradepoint"), rs.getString("sr.LetterGrade")));
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

}
