/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.InstituteGrade;

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
 * @author SHOHUG-SQ
 */
public class GradeReportServiceImpl implements GradeReportService, Serializable {

    @Override
    public List<GradeReport> gradeList(GradeReport gradeReport) {

        List<GradeReport> gradeList = new ArrayList<GradeReport>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            prst = con.prepareStatement("select s.shiftname, d.departmentname, c.classname, sc.sectionname,\n"
                    + "(select count(finalgrade) from student_result_summary where finalgrade='a+' and studentid in(select studentid from student_identification where classconfigid=cg.scconfigid) \n"
                    + "and excnfid=(select excnfid from exam_config where classid=c.classid and acyr=? and examid=(select exam_id from exam where examname =? ))) a_plus,\n"
                    + "(select count(finalgrade) from student_result_summary where finalgrade ='a' and studentid in(select studentid from student_identification where classconfigid=cg.scconfigid) \n"
                    + "and excnfid=(select excnfid from exam_config where classid=c.classid and acyr=? and examid=(select exam_id from exam where examname =?  ))) a,\n"
                    + "(select count(finalgrade) from student_result_summary where finalgrade ='a-' and studentid in(select studentid from student_identification where classconfigid=cg.scconfigid) \n"
                    + "and excnfid=(select excnfid from exam_config where classid=c.classid and acyr=? and examid=(select exam_id from exam where examname =?  ))) a_minus,\n"
                    + "(select count(finalgrade) from student_result_summary where finalgrade ='b' and studentid in(select studentid from student_identification where classconfigid=cg.scconfigid) \n"
                    + "and excnfid=(select excnfid from exam_config where classid=c.classid and acyr=? and examid=(select exam_id from exam where examname =?  ))) b,\n"
                    + "(select count(finalgrade) from student_result_summary where finalgrade ='c' and studentid in(select studentid from student_identification where classconfigid=cg.scconfigid) \n"
                    + "and excnfid=(select excnfid from exam_config where classid=c.classid and acyr=? and examid=(select exam_id from exam where examname =?  ))) c,\n"
                    + "(select count(finalgrade) from student_result_summary where finalgrade ='d' and studentid in(select studentid from student_identification where classconfigid=cg.scconfigid) \n"
                    + "and excnfid=(select excnfid from exam_config where classid=c.classid and acyr=? and examid=(select exam_id from exam where examname =?  ))) d,\n"
                    + "(select count(finalgrade) from student_result_summary where finalgrade ='f' and studentid in(select studentid from student_identification where classconfigid=cg.scconfigid) \n"
                    + "and excnfid=(select excnfid from exam_config where classid=c.classid and acyr=? and examid=(select exam_id from exam where examname =?  ))) f\n"
                    + "from shift s, department d, class c, section sc, classconfig cg\n"
                    + "where s.shiftid=cg.shiftid and d.departmentid=cg.deptid and c.classid=cg.classid and sc.sectionid=cg.sectionid\n"
                    + "order by sectionname, shiftname,departmentname,classname  asc");

            prst.setInt(1, gradeReport.getAcYr());

            prst.setString(2, gradeReport.getExamName());

            prst.setInt(3, gradeReport.getAcYr());

            prst.setString(4, gradeReport.getExamName());

            prst.setInt(5, gradeReport.getAcYr());

            prst.setString(6, gradeReport.getExamName());

            prst.setInt(7, gradeReport.getAcYr());

            prst.setString(8, gradeReport.getExamName());

            prst.setInt(9, gradeReport.getAcYr());

            prst.setString(10, gradeReport.getExamName());

            prst.setInt(11, gradeReport.getAcYr());

            prst.setString(12, gradeReport.getExamName());

            prst.setInt(13, gradeReport.getAcYr());

            prst.setString(14, gradeReport.getExamName());

            rs = prst.executeQuery();

            while (rs.next()) {

                gradeList.add(new GradeReport(rs.getString("CLASSNAME"), rs.getString("DEPARTMENTNAME"), rs.getString("SHIFTNAME"), rs.getString("SECTIONNAME"), (rs.getInt("A_PLUS") + rs.getInt("A") + rs.getInt("A_MINUS") + rs.getInt("B") + rs.getInt("C") + rs.getInt("D") + rs.getInt("F")), rs.getInt("A_PLUS"), rs.getInt("A"), rs.getInt("A_MINUS"), rs.getInt("B"), rs.getInt("C"), rs.getInt("D"), rs.getInt("F")));
            }
            return gradeList;

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
        return gradeList;
    }
}
