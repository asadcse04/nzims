/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student.StudentSubjectMark;

import com.pencil.Connection.DB_Connection;
import com.pencil.ScClassConfig.ScClassConfig;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Md Mahfuj Jia
 * @StudentResult Module
 */
public class StudentSubjectMarkServiceImpl implements Serializable, StudentSubjectMarkService {

    /**
     *
     * @param acyr
     * @param className
     * @param ExamName
     * @return
     */
    @Override
    public int getExCnfID(int acyr, String className, String ExamName) {
        int exCnfId = 0;

        DB_Connection o;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;
        String instituteid = "";

        FacesContext context = FacesContext.getCurrentInstance();

        context.getExternalContext().getSessionMap().put("Examname", ExamName);

        instituteid = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            o = new DB_Connection();

            con = o.getConnection();

            prst = con.prepareStatement("select ExCnfID from exam_config where AcYr=? and ClassID=(select ClassID from class where ClassName=?) and ExamID=(select Exam_ID from exam where ExamName=? and instituteid=?) and instituteid=?");

            prst.setInt(1, acyr);

            prst.setString(2, className);

            prst.setString(3, ExamName);

            prst.setString(4, instituteid);

            prst.setString(5, instituteid);

            rs = prst.executeQuery();

            while (rs.next()) {
                exCnfId = rs.getInt(1);
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

            className = null;

            ExamName = null;
        }

        return exCnfId;
    }

    public List<StudentSubjectMark> scClassSubMarkInsert_List_ed() {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        PreparedStatement prst2 = null;

        ResultSet rs = null;

        ResultSet rs2 = null;

        String instituteid = "";
        FacesContext context = FacesContext.getCurrentInstance();
        instituteid = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<StudentSubjectMark> scCnfList = new ArrayList<StudentSubjectMark>();

        List<String> subList = new ArrayList<String>();

        try {
            prst = con.prepareStatement("SELECT scCnf.ScConfigID, scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,d.DepartmentName"
                    + " FROM classconfig scCnf,class c,shift s,section sctn,department d where scCnf.ClassID=c.ClassID and scCnf.InstituteID=sctn.InstituteID"
                    + " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.DeptID=d.DepartmentID and scCnf.InstituteID=? group by scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName order by scCnf.ScConfigID");

            prst.setString(1, instituteid);

            rs = prst.executeQuery();

            while (rs.next()) {
                prst2 = con.prepareStatement("select s.SubjectName from subjectconfig sc, subject s where s.SubjectID=sc.subjectid and acyrid=? and deptid=(select DepartmentID from department where DepartmentName=?) and classid=(select ClassID from class where ClassName=?) and instituteid=?");
                prst2.setInt(1, rs.getInt("scCnf.AcYrID"));
                prst2.setString(2, rs.getString("d.DepartmentName"));
                prst2.setString(3, rs.getString("c.ClassName"));
                prst2.setString(4, instituteid);
                rs2 = prst2.executeQuery();

                subList.clear();

                while (rs2.next()) {
                    subList.add(rs2.getString(1));
                }

                rs2 = null;

                scCnfList.add(new StudentSubjectMark(rs.getInt("scCnf.ScConfigID"), rs.getInt("scCnf.AcYrID"), rs.getString("c.ClassName"), rs.getString("s.ShiftName"), rs.getString("sctn.SectionName"), rs.getString("d.DepartmentName"), subList));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (rs2 != null) {
                    rs2.close();
                }
                if (prst != null) {
                    prst.close();
                }

                if (prst2 != null) {
                    prst2.close();
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

    public StringBuilder scClassConfig_ID_List(StudentSubjectMark scCnf) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        StringBuilder scCnfID = new StringBuilder();

        try {
            prst = con.prepareStatement("SELECT scCnf.ScConfigID FROM classconfig scCnf,class c,shift s,section sctn where scCnf.AcYrID=? and scCnf.ClassID=c.ClassID"
                    + " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.ClassID=(SELECT ClassID FROM class where ClassName=?)"
                    + " and scCnf.ShiftID=(SELECT ShiftID FROM shift where ShiftName=?) and scCnf.SectionID=(SELECT SectionID FROM section where SectionName=?)");

            prst.setInt(1, scCnf.getAcyr());

            prst.setString(2, scCnf.getClassName());

            prst.setString(3, scCnf.getShiftName());

            prst.setString(4, scCnf.getSectionName());

            rs = prst.executeQuery();

            while (rs.next()) {
                scCnfID.append(rs.getString("scCnf.ScConfigID"));

                scCnfID.append(",");
            }

            if (scCnfID.length() > 0) {
                scCnfID.setLength(scCnfID.length() - 1);
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

            scCnf = null;
        }

        return scCnfID;
    }

    public int ScCnfID(StudentSubjectMark list) {

        int scCnfID = 0;

        DB_Connection o;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            o = new DB_Connection();

            con = o.getConnection();

            prst = con.prepareStatement("select ScConfigID from classconfig where AcYrID=? and DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and ClassID=(select ClassID from class where ClassName=?)"
                    + " and shiftID=(select ShiftID from shift where ShiftName=?)"
                    + " and SectionID=(select SectionID from section where SectionName=?)");

            prst.setInt(1, list.getAcyr());

            prst.setString(2, list.getDeptName());

            prst.setString(3, list.getClassName());

            prst.setString(4, list.getShiftName());

            prst.setString(5, list.getSectionName());

            rs = prst.executeQuery();

            while (rs.next()) {
                scCnfID = rs.getInt(1);
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
        return scCnfID;
    }

    /**
     *
     * @param studentSubjectMark
     * @param scCnfID
     * @param subjectName
     * @return
     */
    @Override
    public List<StudentExamResult> getStudent_insertResult(StudentSubjectMark studentSubjectMark) {
        
        List<StudentExamResult> studentList = new ArrayList<>();

        int flag = 0;

        String qr = "";

        DB_Connection o;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            o = new DB_Connection();

            con = o.getConnection();

            prst = con.prepareStatement("select status from subject where SubjectName=?");

            prst.setString(1, studentSubjectMark.getSubjectName());

            rs = prst.executeQuery();

            if (rs.next()) {
                
                flag = rs.getInt(1);
            }
            rs.close();

            prst.close();

            if (flag == 0)//for common  subject
            {
                qr = "select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si"
                        + " where si.StudentID=sb.StudentID and si.instituteid=sb.instituteid "
                        + " and si.ClassConfigID IN(" + studentSubjectMark.getScConfigID() + ") and sb.InstituteID='" + instituteID + "' order by sb.StudentRoll";
            } else if (flag == 1)//for elective subject
            {
                qr = "select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si,student_4th_subject_wrap sw"
                        + " where si.StudentID=sb.StudentID and sw.StudentID=sb.StudentID and si.instituteid=sb.instituteid "
                        + " and sb.InstituteID='" + instituteID + "' and sw.SubjectID=(select SubjectID from subject where SubjectName='" + studentSubjectMark.getSubjectName() + "') and si.ClassConfigID=? order by sb.StudentRoll";

                // prst.setInt(1, scCnfID);
            } else if (flag == 2)//for departmental subject
            {
                qr = "select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si"
                        + " where si.StudentID=sb.StudentID and si.instituteid=sb.instituteid and sb.InstituteID='" + instituteID + "' "
                        + " and si.ClassConfigID=? order by sb.StudentRoll";

                //prst.setInt(1, scCnfID);
            } else if (flag == 3)//for common elective subject both science & commerce for example computer
            {
                qr = "select sb.StudentID,sb.StudentName,sb.StudentRoll from student_basic_info sb,student_identification si,student_4th_subject_wrap sw"
                        + " where si.StudentID=sb.StudentID and sw.StudentID=sb.StudentID and si.instituteid=sb.instituteid and sb.InstituteID='" + instituteID + "' "
                        + " and sw.SubjectID=(select SubjectID from subject where SubjectName='" + studentSubjectMark.getSubjectName() + "') and si.ClassConfigID IN(" + studentSubjectMark.getScConfigID() + ") order by sb.StudentRoll";

                // prst.setInt(1, scCnfID);
            }

            prst = con.prepareStatement(qr);

            if ((flag == 1) || (flag == 2)) {
                
                prst.setInt(1, studentSubjectMark.getScConfigID());
            }

            rs = prst.executeQuery();

            while (rs.next()) {
                
                studentList.add(new StudentExamResult(rs.getString(1), rs.getString(2), rs.getInt(3), "", "", "", ""));
            }

            System.out.println("Number of student to input mark:" + studentList.size());
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

        return studentList;
    }

    /**
     *
     * @param sc_cnf_id
     * @return
     */
    public StringBuilder getScCnf_id_List(int sc_cnf_id) {
        StringBuilder sb = new StringBuilder();

        String qr = "";

        DB_Connection db;

        Connection cn = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            db = new DB_Connection();

            cn = db.getConnection();

            prst = cn.prepareStatement("SELECT AcYrID, ClassID, ShiftID, SectionID FROM classconfig where ScConfigID=?  and InstituteID='" + instituteID + "'");

            prst.setInt(1, sc_cnf_id);

            rs = prst.executeQuery();

            if (rs.next()) {
                qr = "SELECT ScConfigID FROM classconfig where AcYrID=" + rs.getInt("AcYrID") + " and  ClassID=" + rs.getInt("ClassID") + " and ShiftID=" + rs.getInt("ShiftID") + " and SectionID=" + rs.getInt("SectionID") + "";
            }

            rs.close();

            prst.close();

            prst = cn.prepareStatement(qr);

            rs = prst.executeQuery();

            while (rs.next()) {
                sb.append(rs.getInt("ScConfigID"));

                sb.append(",");
            }

            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
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
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return sb;
    }

    /**
     *
     * @param exCnfID
     * @param subjectName
     * @param teacherID
     * @param examRsList
     * @param exmGrdList
     * @return
     */
    @Override
    public boolean insertStudentExamScore(int exCnfID, String subjectName, int teacherID, List<StudentExamResult> examRsList, List<ExamGrade> exmGrdList) {
        String sc1;

        String sc2;

        String sc3;

        String sc4;

        DB_Connection db;

        Connection cn = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        String userid = "";
        
        int resultid=1;

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        userid = context.getExternalContext().getSessionMap().get("UserID").toString();

        List<ExamMarkDivision> exmMark_Div_List;

        Iterator<StudentExamResult> itr;

        try {
            db = new DB_Connection();

            cn = db.getConnection();

            exmMark_Div_List = new ArrayList<ExamMarkDivision>();

            prst = cn.prepareStatement("select ExmSbj_ID, ShortCode, TotalMark, Acceptance, PassMark from exam_mark_division where ExmSbj_ID="
                    + "(select ExmSbj_ID FROM exam_subject_config where ExCnfID=? and InstituteId=?"
                    + " and SubjectID=(select SubjectID from subject where SubjectName=?)) and InstituteId=?");

            prst.setInt(1, exCnfID);

            prst.setString(2, instituteID);

            prst.setString(3, subjectName);

            prst.setString(4, instituteID);

            rs = prst.executeQuery();

            while (rs.next()) {
                exmMark_Div_List.add(new ExamMarkDivision(rs.getInt("ExmSbj_ID"), rs.getInt("ShortCode"), rs.getDouble("TotalMark"), rs.getDouble("Acceptance"), rs.getDouble("PassMark")));
            }

            System.out.println("Subject Mark division size:" + exmMark_Div_List.size());

            rs.close();

            prst.close();
            
            prst=cn.prepareStatement("select max(ResultID) from student_subject_mark");
            rs=prst.executeQuery();
            
            if(rs.next()){
              resultid=rs.getInt(1);
            }
            
            else{
               resultid=1;   
            }
           
            prst = cn.prepareStatement("insert into student_subject_mark(StudentID,SubjectID,ShortCode1,ShortCode2,ShortCode3,ShortCode4,ExCnfID,TeacherID,UserID,Date_Time,AcademicYear,InstituteID,ResultID) values(?,(select SubjectID from subject where SubjectName=?),?,?,?,?,?,?,?,?,?,?,?)");

            itr = examRsList.iterator();

            while (itr.hasNext()) {
                StudentExamResult exmResult = itr.next();

                prst.setString(1, exmResult.getStudentID());

                prst.setString(2, subjectName);

                prst.setString(3, exmResult.getShortcode1());

                prst.setString(4, exmResult.getShortcode2());

                prst.setString(5, exmResult.getShortcode3());

                prst.setString(6, exmResult.getShortcode4());

                prst.setInt(7, exmResult.getExamconfID());

                prst.setInt(8, teacherID);

                prst.setString(9, userid);

                prst.setDate(10, new java.sql.Date(new Date().getTime()));

               prst.setInt(11, 2014);
               
               prst.setString(12,instituteID);
               
               prst.setInt(13, resultid);
                        
               resultid++;
                
               prst.addBatch();

            }//End main while

            int[] i = prst.executeBatch();

            System.out.println("Number of student has given exam mark::" + i.length);

            return true;
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
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            subjectName = null;

            examRsList.clear();

            exmGrdList.clear();
        }

        return false;
    }

    /**
     *
     * @param exCnfID
     * @param scCnfID
     * @param exmGrdList
     */
    @Override
    public void generateMeritList(int exCnfID, StringBuilder scCnfID, List<ExamGrade> exmGrdList) {
        List<String> studentID = new ArrayList<String>();

        Iterator<String> id_itr;

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        PreparedStatement p = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        int subjectCount = 0;

        double sbj_bngl_FullMark = 0;

        double sbj_english_FullMark = 0;

        int tmpSbjCnt = 0;

        int tmpSbj1Cnt = 0;

        int optionalSbjID = 0;

        boolean fail_flag = false;

        double totalSumScore = 0;

        double totalSumGpa = 0;

        double temp_sbj_score = 0;

        double temp_sbj1_score = 0;

        double finalSumGpa = 0;

        double finalSumCGPA = 0;

        String finalGrade = "";

        //System.out.println(scCnfID.toString());
        /*-------------------------------------------------Get Student List where ScCnfID=Acyr,Class------------------------------------------------------------*/
        try {
            prst = con.prepareStatement("select StudentID FROM student_identification  where ClassConfigID IN(" + scCnfID.toString() + ")  and InstituteID='" + instituteID + "' ");

            //prst.setString(1,scCnfID.toString());
            rs = prst.executeQuery();

            while (rs.next()) {
                studentID.add(rs.getString("StudentID"));
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
            } catch (SQLException e) {
                System.out.println("I am not ok..Block-1");

                System.out.println(e);
            }
        }

        System.out.println("Total Student Found:" + studentID.size());

        /*----------------------------------------------------------------------------End Student List-----------------------------------------------------------*/
        try {
            id_itr = studentID.iterator();

            p = con.prepareStatement("insert into student_result_summary (ID,StudentID,ExcnfID,TotalMark,TotalGpa,CGPA,FinalGrade,InstituteID) values(null,?,?,?,?,?,?,?)");

            while (id_itr.hasNext()) {
                String std_id = id_itr.next();//individual studentID

                /*--------------------------------------------------------4th subject list and status checking-----------------------------------------------------------*/
                try {
                    prst = con.prepareStatement("select SubjectID,Status from student_4th_subject_wrap where StudentID=? ");

                    prst.setString(1, std_id);

                    rs = prst.executeQuery();

                    while (rs.next()) {
                        if (!rs.getBoolean("Status")) {
                            optionalSbjID = rs.getInt("SubjectID");//get Optional subject
                        }
                    }
                } catch (SQLException exp) {
                    System.out.println(exp);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (prst != null) {
                            prst.close();
                        }
                    } catch (SQLException e) {
                        System.out.println("I am not ok..(Block-2)");

                        System.out.println(e);
                    }
                }

                /*----------------------------------------------------4th subject list and status checking End-----------------------------------------------------------*/
                try {
                    prst = con.prepareStatement("select SubjectID,FinalScore,GradePoint,SbjFullMark from student_result where StudentID=? and ExCnfID=? and  InstituteID='" + instituteID + "' ");

                    prst.setString(1, std_id);

                    prst.setInt(2, exCnfID);

                    rs = prst.executeQuery();

                    while (rs.next()) {
                        if ((rs.getDouble("GradePoint") == 0) && (rs.getInt("SubjectID") != optionalSbjID)) {
                            fail_flag = true;

                            System.out.println("Fail Subject ID:" + rs.getInt("SubjectID"));
                        }

                        /**
                         * ***************************All Subject Block(Without
                         * Bangla & English) SubjectID=6,7,8,9 are b1,b2,E1,E2********************************************************
                         */
                        if ((rs.getInt("SubjectID") != 7) && (rs.getInt("SubjectID") != 8) && (rs.getInt("SubjectID") != 9) && (rs.getInt("SubjectID") != 10)) {
                            totalSumScore = totalSumScore + rs.getDouble("FinalScore");

                            /* ******************************Regular Subject Block*******************************************/
                            if (rs.getInt("SubjectID") != optionalSbjID) {
                                totalSumGpa = totalSumGpa + rs.getDouble("GradePoint");
                            } /**
                             * *****************************Regular Subject
                             * Block End******************************************
                             */
                            /* *****************************Optional Subject Block*******************************************/ else {

                                if (rs.getDouble("GradePoint") > 2) {
                                    totalSumGpa = totalSumGpa + (rs.getDouble("GradePoint") - 2);

                                    System.out.println("Optional Subject CGPA:" + ((rs.getDouble("GradePoint") - 2)));

                                    //subjectCount--;//optional subject not counted
                                    subjectCount--;
                                }
                            }

                            /**
                             * ***************************Optional Subject Block End*******************************************
                             */
                            subjectCount++;//count number of subject to get cgpa=(totalSumGpa)/subjectCount
                        } /**
                         * **************All Subject Except Bangla-1,2 &
                         * English-1,2 End**********************************************
                         */
                        /**
                         * **************Only Bangla-1,2 & English-1,2***************************************************************
                         */
                        else {
                            if ((rs.getInt("SubjectID") == 7) || (rs.getInt("SubjectID") == 8)) {
                                temp_sbj_score = temp_sbj_score + rs.getDouble("FinalScore");

                                tmpSbjCnt = 1;//count 2 subject as 1

                                sbj_bngl_FullMark = sbj_bngl_FullMark + rs.getDouble("SbjFullMark");
                            } else {
                                temp_sbj1_score = temp_sbj1_score + rs.getDouble("FinalScore");

                                tmpSbj1Cnt = 1;//count 2 subject as 1

                                sbj_english_FullMark = sbj_english_FullMark + rs.getDouble("SbjFullMark");
                            }
                        }

                    }//End while inner

                    if (tmpSbjCnt == 1) {
                        for (int i = 0; i < exmGrdList.size(); i++) {
                            if (exmGrdList.get(i).getGradeNumber() <= ((temp_sbj_score / sbj_bngl_FullMark) * 100)) {
                                totalSumGpa = totalSumGpa + exmGrdList.get(i).getPoint();

                                break;
                            }
                        }
                    }

                    if (tmpSbj1Cnt == 1) {
                        for (int i = 0; i < exmGrdList.size(); i++) {
                            if (exmGrdList.get(i).getGradeNumber() <= ((temp_sbj1_score / sbj_english_FullMark) * 100)) {
                                totalSumGpa = totalSumGpa + exmGrdList.get(i).getPoint();

                                break;
                            }
                        }
                    }

                    System.out.println("-------------------------************************************-----------------------------");

                    System.out.println("Student ID:" + std_id);

                    System.out.println("Bangla:" + temp_sbj_score);

                    System.out.println("English:" + temp_sbj1_score);

                    System.out.println("Number Of Subject:" + (subjectCount + tmpSbjCnt + tmpSbj1Cnt));

                    System.out.println("Final Total Mark:" + (totalSumScore + temp_sbj_score + temp_sbj1_score));

                    if (fail_flag)//if fails in any subject
                    {
                        //System.out.println("Total GPA:" + finalSumGpa);

                        //System.out.println("Total CGPA:" + finalSumCGPA);
                    } else {
                        //finalSumGpa = (totalSumGpa + getTemp_Sbj_Gpa(temp_sbj_score / 2) + getTemp_Sbj_Gpa(temp_sbj1_score / 2));

                        //finalSumCGPA = (totalSumGpa + getTemp_Sbj_Gpa(temp_sbj_score / 2) + getTemp_Sbj_Gpa(temp_sbj1_score / 2)) / (subjectCount + tmpSbjCnt + tmpSbj1Cnt);
                        finalSumGpa = totalSumGpa;

                        finalSumCGPA = (totalSumGpa / (subjectCount + tmpSbjCnt + tmpSbj1Cnt));

                        System.out.println("Total GPA:" + finalSumGpa);

                        System.out.println("Total CGPA:" + finalSumCGPA);

                    }

                    for (int i = 0; i < exmGrdList.size(); i++) {
                        if (exmGrdList.get(i).getPoint() <= finalSumCGPA) {
                            finalGrade = exmGrdList.get(i).getLetterGrade();

                            break;
                        }
                    }

                    p.setString(1, std_id);

                    p.setInt(2, exCnfID);

                    p.setDouble(3, (totalSumScore + temp_sbj_score + temp_sbj1_score));

                    p.setDouble(4, finalSumGpa);

                    p.setDouble(5, finalSumCGPA);

                    p.setString(6, finalGrade);

                    p.setString(7, instituteID);

                    p.addBatch();

                    totalSumScore = 0.0;

                    totalSumGpa = 0.0;

                    temp_sbj_score = 0.0;

                    temp_sbj1_score = 0.0;

                    subjectCount = 0;

                    tmpSbjCnt = 0;

                    tmpSbj1Cnt = 0;

                    finalSumGpa = 0;

                    finalSumCGPA = 0;
                } catch (SQLException ex) {
                    System.out.println("I am not ok..(BLOCK-3)");

                    System.out.println(ex);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (prst != null) {
                            prst.close();
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }

                optionalSbjID = 0;

                fail_flag = false;

            }//end main while

            int[] i = p.executeBatch();

            System.out.println("Final Result Student:" + i.length);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (p != null) {
                    p.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            exmGrdList.clear();

            scCnfID.setLength(0);
        }

    }//end function

    /**
     *
     * @param className
     * @return
     */
    @Override
    public StringBuilder scCnfID(String className) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        StringBuilder scCnfID = new StringBuilder();

        try {
            prst = con.prepareStatement("SELECT ScConfigID FROM classconfig where ClassID=(Select ClassID From class where ClassName=?)  and InstituteID='" + instituteID + "'");

            prst.setString(1, className);

            rs = prst.executeQuery();

            while (rs.next()) {
                scCnfID.append(rs.getString("ScConfigID"));

                scCnfID.append(",");
            }

            if (scCnfID.length() > 0) {
                scCnfID.setLength(scCnfID.length() - 1);
            }
        } catch (SQLException e) {
            System.out.println(e);

            System.out.println("I  am not ok here....");
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

            className = null;
        }

        return scCnfID;
    }

    /**
     *
     * @param exCnfID
     * @return
     */
    @Override
    public List<StudentMeritList> StudentMeritList(int exCnfID) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<StudentMeritList> stdMeritlist = new ArrayList<StudentMeritList>();

        try {

            prst = con.prepareStatement("Select sb.StudentID,sb.StudentName,srs.TotalMark, srs.TotalGpa, srs.CGPA, srs.FinalGrade"
                    + " from student_result_summary srs,student_basic_info sb where srs.StudentID=sb.StudentID and srs.InstituteID=sb.InstituteID and srs.InstituteID='" + instituteID + "' "
                    + " and srs.ExcnfID=?");

            prst.setInt(1, exCnfID);

            System.out.println("exCnfID :" + exCnfID);

            rs = prst.executeQuery();

            while (rs.next()) {
                stdMeritlist.add(new StudentMeritList(rs.getString("sb.StudentID"), rs.getString("sb.StudentName"), rs.getDouble("srs.TotalMark"), rs.getDouble("srs.TotalGpa"), rs.getDouble("srs.CGPA"), rs.getString("srs.FinalGrade")));
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

        return stdMeritlist;
    }

    /**
     *
     * @return
     */
    @Override
    public List<ExamGrade> examGradeList() {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<ExamGrade> exmGrdList = new ArrayList<ExamGrade>();

        try {
            prst = con.prepareStatement("SELECT LetterGrade, GradeNumber, Point FROM examgrade  where InstituteID='" + instituteID + "'");

            rs = prst.executeQuery();

            while (rs.next()) {
                exmGrdList.add(new ExamGrade(rs.getString("LetterGrade"), rs.getDouble("GradeNumber"), rs.getDouble("Point")));
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

        return exmGrdList;
    }

    @Override
    public List<String> subjectList(StudentSubjectMark sbj_cnf) {
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> sbjlist = new ArrayList<String>();

        FacesContext context = FacesContext.getCurrentInstance();

        String instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            String qr = "SELECT sbj.subjectName FROM subjectconfig s,subject sbj where s.AcYrID=? and s.DeptID=(select DepartmentID from department"
                    + " where departmentname=?) and s.ClassID=(select ClassID from class where ClassName=?) and s.SubjectID=sbj.SubjectID and s.InstituteID=? ";

            prst = con.prepareStatement(qr);

            prst.setInt(1, sbj_cnf.getAcyr());

            prst.setString(2, sbj_cnf.getDeptName());

            prst.setString(3, sbj_cnf.getClassName());

            prst.setString(4, instituteID);

            rs = prst.executeQuery();

            while (rs.next()) {
                
                sbjlist.add(rs.getString("sbj.subjectName"));
                
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

            sbj_cnf = null;
        }

        return sbjlist;
    }

    @Override
    public int editStudentResult(int exCnfID, String subjectName, List<ViewStudentResult> stdSubjMarkList, List<ExamGrade> exmGrdList) {

        DB_Connection db;

        Connection cn = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        int rowEffect = 0;

        try {
            db = new DB_Connection();

            cn = db.getConnection();

            for (int i = 0; i < stdSubjMarkList.size(); i++) {

                prst = cn.prepareStatement("update student_subject_mark set ShortCode1=?,ShortCode2=?,ShortCode3=?,ShortCode4=? "
                        + " where ResultID=? and ExCnfID=? and StudentID=? and SubjectID=? and InstituteID=?");

                prst.setString(1, stdSubjMarkList.get(i).getShortCode1());

                prst.setString(2, stdSubjMarkList.get(i).getShortCode2());

                prst.setString(3, stdSubjMarkList.get(i).getShortCode3());

                prst.setString(4, stdSubjMarkList.get(i).getShortCode4());

                prst.setInt(5, stdSubjMarkList.get(i).getResultID());

                prst.setInt(6, stdSubjMarkList.get(i).getExamConfigID());

                prst.setString(7, stdSubjMarkList.get(i).getStudentID());

                prst.setInt(8, stdSubjMarkList.get(i).getSubjectID());

                prst.setString(9, stdSubjMarkList.get(i).getInstituteID());

                prst.executeUpdate();

                rowEffect = 1;
            }

        } catch (SQLException ex) {
            System.out.println(ex);

            System.out.println("Student result update problem...");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prst != null) {
                    prst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            subjectName = null;

            stdSubjMarkList = null;

            //exmGrdList.clear();
            //exmMark_Div_List.clear();
        }

        return rowEffect;
    }

    @Override
    public List<ViewStudentResult> studentExamResult(int exCnfID, int scCnfID, String subjectName) {
        List<ViewStudentResult> studentResultList = new ArrayList<ViewStudentResult>();

        DB_Connection db;

        Connection cn = null;

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        String qr = "";

        int sbj_st = 0;

        try {
            db = new DB_Connection();

            cn = db.getConnection();

            prst = cn.prepareStatement("select status from subject where SubjectName=?");

            prst.setString(1, subjectName);

            rs = prst.executeQuery();

            if (rs.next()) {
                sbj_st = rs.getInt(1);
            }
            rs.close();

            prst.close();

            if (sbj_st == 0) {
                qr = "SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.ExCnfID, sr.SubjectID, sr.InstituteID "
                        + " FROM student_subject_mark sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID "
                        + "and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='" + instituteID + "' and sr.ExCnfID=?"
                        + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID IN(" + getScCnf_id_List(scCnfID) + ") order by sb.StudentRoll";
            } else if (sbj_st == 1)//for departmental elective subject..
            {
                qr = "SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.ExCnfID, sr.SubjectID, sr.InstituteID "
                        + " FROM student_subject_mark sr,teacher t,student_basic_info sb,student_identification si,student_4th_subject_wrap sw where "
                        + "sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.StudentID=sw.StudentID and sr.SubjectID=sw.SubjectID and sr.teacherID=t.teacherID "
                        + " and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='" + instituteID + "' and sr.ExCnfID=?"
                        + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll";
            } else if (sbj_st == 2)//for departmental subject
            {
                qr = "SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.ExCnfID, sr.SubjectID, sr.InstituteID "
                        + " FROM student_subject_mark sr,teacher t,student_basic_info sb,student_identification si where sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.teacherID=t.teacherID "
                        + " and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='" + instituteID + "' and sr.ExCnfID=?"
                        + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID=? order by sb.StudentRoll";
            } else if (sbj_st == 3) {
                qr = "SELECT sr.ResultID, sr.StudentID,sb.StudentName,sb.StudentRoll,sr.ShortCode1, sr.ShortCode2, sr.ShortCode3, sr.ShortCode4, sr.ExCnfID, sr.SubjectID, sr.InstituteID "
                        + " FROM student_subject_mark sr,teacher t,student_basic_info sb,student_identification si,student_4th_subject_wrap sw where "
                        + "sr.StudentID=sb.StudentID and sr.StudentID=si.StudentID and sr.StudentID=sw.StudentID and sr.SubjectID=sw.SubjectID and sr.teacherID=t.teacherID "
                        + " and sr.InstituteID=sb.InstituteID and sr.InstituteID=si.InstituteID and sr.InstituteID=t.InstituteID and sr.InstituteID='" + instituteID + "' and sr.ExCnfID=?"
                        + " and sr.SubjectID=(select SubjectID from subject where SubjectName=?) and si.ClassConfigID IN(" + getScCnf_id_List(scCnfID) + ") order by sb.StudentRoll";
            }
            prst = cn.prepareStatement(qr);

            prst.setInt(1, exCnfID);

            prst.setString(2, subjectName);

            if ((sbj_st == 1) || (sbj_st == 2)) {
                prst.setInt(3, scCnfID);
            }

            rs = prst.executeQuery();

            while (rs.next()) {
                studentResultList.add(new ViewStudentResult(rs.getInt("sr.ResultID"), rs.getString("sr.StudentID"), rs.getString("sb.StudentName"), rs.getInt("sb.StudentRoll"), rs.getString("sr.ShortCode1"), rs.getString("sr.ShortCode2"), rs.getString("sr.ShortCode3"), rs.getString("sr.ShortCode4"), rs.getInt("sr.ExCnfID"), rs.getInt("sr.SubjectID"), rs.getString("sr.InstituteID")));
            }

            System.out.println("Total Student:" + studentResultList.size());
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
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            subjectName = null;
        }

        return studentResultList;
    }
}
