/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student.ExamResult.MeritPosition;

import com.pencil.Connection.DB_Connection;
import com.pencil.Dummy.Student.ExamResult.StudentMeritList;
import com.pencil.InstituteSetup.InstituteSetupService;
import com.pencil.InstituteSetup.InstituteSetupServiceImpl;
import com.pencil.SMS.SMS_Service;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author apple
 */
public class MeritPositionServiceImpl implements Serializable, MeritPositionService {

    InstituteSetupService instituteService = new InstituteSetupServiceImpl();

    @Override
    public boolean class_Wise_Merit_position(int excnfid, List<StudentMeritList> sml) {
        Iterator<StudentMeritList> itr;

        DB_Connection db;

        Connection cn = null;

        PreparedStatement prst = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        itr = sml.iterator();

        while (itr.hasNext()) {
            StudentMeritList sm = itr.next();

            if (sm.getCGPA() == 0) {
                itr.remove();
            }
        }

        try {
            db = new DB_Connection();

            cn = db.getConnection();

            prst = cn.prepareStatement("update student_result_summary set ClassPosition=? where StudentID=? and ExcnfID=? and InstituteID=?");

            for (int i = 0; i < sml.size(); i++) {
                prst.setInt(1, (i + 1));

                prst.setString(2, sml.get(i).getStudentID());

                prst.setInt(3, excnfid);
                
                prst.setString(4, instituteID);

                prst.addBatch();
            }

            int j[] = prst.executeBatch();

            System.out.println("Total row update in classPosition ::" + j.length);

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
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

        return false;
    }

    @Override
    public boolean shift_Wise_Merit_position(int excnfid, int acyrid, String className) {
        List<Integer> shiftList = new ArrayList<Integer>();

        StringBuilder scCnf_id = new StringBuilder();

        boolean flag = false;

        DB_Connection db;

        Connection cn = null;

        PreparedStatement prst = null;

        PreparedStatement p = null;

        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            db = new DB_Connection();

            cn = db.getConnection();

            prst = cn.prepareStatement("select distinct ShiftID from classconfig where AcYrID=? and "
                    + "ClassID=(select ClassID from class where ClassName=?) and InstituteID=?");

            prst.setInt(1, acyrid);

            prst.setString(2, className);
            
            prst.setString(3, instituteID);

            rs = prst.executeQuery();

            while (rs.next()) {
                shiftList.add(rs.getInt("ShiftID"));
            }

            rs.close();

            prst.close();

            for (int i = 0; i < shiftList.size(); i++) {
                prst = cn.prepareStatement("select ScConfigID from classconfig where AcYrID=? and  ClassID=(select ClassID from class where ClassName=?) and InstituteID=?"
                        + " and ShiftID=?");

                prst.setInt(1, acyrid);

                prst.setString(2, className);

                prst.setInt(3, shiftList.get(i));
                
                prst.setString(4, instituteID);

                rs = prst.executeQuery();

                while (rs.next()) {
                    scCnf_id.append(rs.getInt("ScConfigID"));

                    scCnf_id.append(",");
                }

                rs.close();

                prst.close();

                if (scCnf_id.length() > 0) {
                    scCnf_id.setLength(scCnf_id.length() - 1);

                    prst = cn.prepareStatement("select srs.StudentID from student_result_summary srs,student_identification si"
                            + " where srs.StudentID=si.StudentID and srs.InstituteID=si.InstituteID and srs.InstituteID='"+instituteID+"' and si.ClassConfigID IN(" + scCnf_id.toString() + ") and "
                            + " srs.ExcnfID=? and srs.CGPA<>0 order by srs.TotalMark desc");

                    prst.setInt(1, excnfid);

                    rs = prst.executeQuery();

                    p = cn.prepareStatement("update student_result_summary set ShiftPosition=? where StudentID=? and ExcnfID=? and InstituteID='"+instituteID+"'");

                    while (rs.next()) {
                        p.setInt(1, rs.getRow());

                        p.setString(2, rs.getString("srs.StudentID"));

                        p.setInt(3, excnfid);

                        p.addBatch();
                    }

                    int j[] = p.executeBatch();

                    System.out.println("Total row update in shift ::" + j.length);

                    //rs.close();
                    //prst.close();
                    p.clearBatch();

                    scCnf_id.setLength(0);

                    flag = true;

                }//end if

            }//End for loop

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
                if (p != null) {
                    p.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return flag;
    }

    @Override
    public boolean section_Wise_Merit_position(int excnfid, StringBuilder scCnf_id_list) {
        String[] sc_cnf_arry = null;

        boolean flag = false;

        DB_Connection db;

        Connection cn = null;

        PreparedStatement prst = null;

        PreparedStatement p = null;

        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            sc_cnf_arry = scCnf_id_list.toString().split(",");

            db = new DB_Connection();

            cn = db.getConnection();

            prst = cn.prepareStatement("select srs.StudentID from student_result_summary srs,student_identification si"
                    + " where srs.StudentID=si.StudentID and srs.InstituteID=si.InstituteID and srs.InstituteID='"+instituteID+"' and si.ClassConfigID=? and "
                    + " srs.ExcnfID=? and srs.CGPA<>0 order by srs.TotalMark desc");

            for (int i = 0; i < sc_cnf_arry.length; i++) {
                //System.out.println("sccnf::Elements::"+sc_cnf_arry[i]);

                prst.setInt(1, Integer.parseInt(sc_cnf_arry[i]));

                prst.setInt(2, excnfid);

                rs = prst.executeQuery();

                p = cn.prepareStatement("update student_result_summary set SectionPosition=? where StudentID=? and ExcnfID=? and InstituteID='"+instituteID+"' ");

                while (rs.next()) {
                    p.setInt(1, rs.getRow());

                    p.setString(2, rs.getString("srs.StudentID"));

                    p.setInt(3, excnfid);

                    p.addBatch();
                }

                int j[] = p.executeBatch();

                System.out.println("Total row update in section ::" + j.length);

                //rs.close();
                //prst.close();
                p.clearBatch();

                flag = true;

            }//end for
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
                if (p != null) {
                    p.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return flag;
    }

    @Override
    public List<StudentMeritList> prepareStudent_list_to_send_result_sms(int excnf_id) {
        DB_Connection db;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<StudentMeritList> stdlist = new ArrayList<StudentMeritList>();

        try {
            db = new DB_Connection();

            con = db.getConnection();

            prst = con.prepareStatement("Select sb.StudentID,sb.StudentRoll,sg.ContactNo,srs.TotalMark,srs.CGPA,srs.FinalGrade,srs.Status,srs.ClassPosition,"
                    + "srs.ShiftPosition,srs.SectionPosition"
                    + " from student_result_summary srs,student_basic_info sb,student_guardian_info sg where srs.StudentID=sb.StudentID"
                    + " and sg.StudentID=sb.StudentID and srs.InstituteID=sb.InstituteID and srs.InstituteID=sg.InstituteID and srs.InstituteID='"+instituteID+"' and srs.ExcnfID=?"
                    + " order by srs.TotalMark desc");

            prst.setInt(1, excnf_id);

            rs = prst.executeQuery();

            while (rs.next()) {
                stdlist.add(new StudentMeritList(rs.getString("sb.StudentID"), rs.getInt("sb.StudentRoll"), rs.getString("sg.ContactNo"), modifyDec(rs.getDouble("srs.TotalMark")), rs.getDouble("srs.CGPA"), rs.getString("srs.FinalGrade"), rs.getString("Status"), rs.getInt("srs.ClassPosition"), rs.getInt("srs.ShiftPosition"), rs.getInt("srs.SectionPosition")));
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

        return stdlist;
    }

    @Override
    public boolean send_Student_result_Sms(List<StudentMeritList> studentList, SMS_Service smsC) {
        
        String instituteID="";
        
        String instituteName="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        instituteName=context.getExternalContext().getSessionMap().get("SchoolName").toString();
        
        int instituteId=Integer.valueOf(instituteID);
        
        int smsCount = 0;

        StringBuilder smsBody = new StringBuilder();

        Iterator<StudentMeritList> itr = studentList.iterator();

        boolean flag = false;

        int smsBal = smsC.getSmsCurrent_Ac_Balance(instituteId);//schoolid

        //int smsBal=smsC.getSmsCurrent_Ac_Balance(1);//schoolid
        if (smsBal != 0) {
            while (itr.hasNext()) {
                StudentMeritList sml = itr.next();

                smsBody.append("Student ID-");

                smsBody.append(sml.getStudentID());

                smsBody.append("::");

                smsBody.append("Roll-");

                smsBody.append(sml.getStudentRoll());

                smsBody.append("::");

                smsBody.append("Total Mark-");

                smsBody.append(sml.getTotalMark());

                smsBody.append("::");

                smsBody.append("CGPA-");

                smsBody.append(sml.getCGPA());

                smsBody.append("::");

                smsBody.append("Grade-");

                smsBody.append(sml.getFinalGrade());

                smsBody.append(" ");

                smsBody.append("::Merit Position::");

                smsBody.append(" ");

                smsBody.append("CP-");

                smsBody.append(sml.getcP());

                smsBody.append("::");

                smsBody.append("SP-");

                smsBody.append(sml.getsP());

                smsBody.append("::");

                smsBody.append("SecP-");

                smsBody.append(sml.getSecP());

                smsBody.append(" ");

                smsBody.append(" ");

                smsBody.append(instituteName);

                //smsBody.append("Narsingdi Govt. Girls' School");

                /*System.out.println("SMS Body::"+smsBody.toString());
            
                 System.out.println("SMS Body Lenth::"+smsBody.length());
            
                 System.out.println("--------------------------------");*/
                if (smsC.sendIndividual_Sms(sml.getGrdnCn(), smsBody.toString()) == 200) {
                    smsCount = smsCount + 1;
                }

                smsBody.setLength(0);

                if (smsCount <= smsBal) {
                    break;
                }
            }//end while

            System.out.println("Result SMS Send::" + smsCount);

            if (smsCount == studentList.size()) {
                flag = true;
            }

            studentList.clear();
        }

        return flag;
    }

    public double modifyDec(double d) {
        double num = Math.round(d * 100);

        return num / 100;
    }
}
