/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student;

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
 * @author Mahfuj
 */
public class Student_Reg_Service_Impl implements Serializable, Student_Reg_Service {

    /**
     *
     * @param stdReg
     * @param scCnf_ID
     * @return
     */
    @Override
    public boolean completeStudentReg(Student_Registration stdReg, int scCnf_ID) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String studentID = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            prst = con.prepareStatement("select max(cast(StudentID  as unsigned)) as StudentID from student_basic_info where InstituteID=?");
            prst.setString(1, instituteID);

            rs = prst.executeQuery();

            while (rs.next()) {
                studentID = rs.getString("StudentID");
            }
            if (studentID == null) {
                studentID = "10000";
            }

            stdReg.setStudentID(String.valueOf(Long.parseLong(studentID) + 1));
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
                System.out.println(e);
            }
        }

        try {
            con.setAutoCommit(false);

            Long.parseLong(stdReg.getCntNo());

            Long.parseLong(stdReg.getGuardianContactNo());

            prst = con.prepareStatement("insert into student_basic_info values(?,?,?,?,?,?,?,?,?,?,null,?)");

            prst.setString(1, stdReg.getStudentID() + "-" + instituteID);

            prst.setString(2, stdReg.getStudentName());

            prst.setInt(3, stdReg.getStudentRoll());

            prst.setString(4, stdReg.getCntNo());

            prst.setString(5, stdReg.getGender());

            prst.setDate(6, new java.sql.Date(stdReg.getDob().getTime()));

            prst.setBoolean(7, true);

            prst.setString(8, instituteID + "_" + stdReg.getStudentID() + "_" + stdReg.getImgPath());

            prst.setString(9, stdReg.getReligion());

            prst.setString(10, stdReg.getBloodGroup());

            prst.setString(11, instituteID);

            //prst.setInt(11,Integer.parseInt(context.getExternalContext().getSessionMap().get("UserID").toString()));
            prst.execute();

            prst.close();

            prst = con.prepareStatement("insert into student_guardian_info values(?,?,?,?,?,?,?,?,?,?,?,?)");

            prst.setString(1, stdReg.getFatherName());

            prst.setString(2, stdReg.getMotherName());

            prst.setString(3, stdReg.getGuardianName());

            prst.setString(4, stdReg.getRelation());

            prst.setString(5, stdReg.getGuardianContactNo());

            prst.setString(6, stdReg.getStudentID() + "-" + instituteID);

            prst.setString(7, stdReg.getFatherOccupation());

            prst.setString(8, stdReg.getMotherOccupation());

            prst.setString(9, stdReg.getGuardianOccupation());

            prst.setDouble(10, stdReg.getGuardianSalary());

            prst.setString(11, stdReg.getGuardianEmail());

            prst.setString(12, instituteID);

            prst.execute();

            prst.close();

            prst = con.prepareStatement("insert into student_address_detail values(?,?,?,?)");

            prst.setString(1, stdReg.getPresentAddress());

            prst.setString(2, stdReg.getPermanentAddress());

            prst.setString(3, stdReg.getStudentID() + "-" + instituteID);

            prst.setString(4, instituteID);

            prst.execute();

            prst.close();

            prst = con.prepareStatement("insert into student_identification values(?,?,?,?)");

            prst.setInt(1, scCnf_ID);

            prst.setString(2, stdReg.getStudentID() + "-" + instituteID);

            prst.setString(3, instituteID);

            prst.setInt(4, stdReg.getStudentRoll());

            prst.execute();

            con.commit();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        } catch (NumberFormatException n) {
            System.out.println(n);
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            stdReg = null;
        }

        return false;
    }

    /**
     *
     * @param acyr
     * @param sc_class
     * @param sc_dept
     * @return
     */
    @Override
    public List<String> elective_SubjectList(int acyr, String sc_class, String sc_dept) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<String> sbjList = new ArrayList<String>();

        try {
            prst = con.prepareStatement("SELECT sbj.subjectName FROM subjectconfig s,subject sbj"
                    + " where s.SubjectID=sbj.SubjectID and s.ClassID=(select ClassID from class where ClassName=?) and"
                    + " s.DeptID=(select DepartmentID from department where DepartmentName=?) and sbj.Status=? and s.AcYrID=? and InstituteID=?");

            prst.setString(1, sc_class);

            prst.setString(2, sc_dept);

            prst.setBoolean(3, true);

            prst.setInt(4, acyr);

            prst.setString(5, instituteID);

            rs = prst.executeQuery();

            while (rs.next()) {
                sbjList.add(rs.getString("sbj.subjectName"));
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

            sc_class = null;

            sc_dept = null;
        }

        return sbjList;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Student_Registration> Student_cmplt_List() {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String instituteID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        instituteID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        List<Student_Registration> student_List = new ArrayList<Student_Registration>();

        try {
            prst = con.prepareStatement("SELECT sb.StudentID,sb.StudentName, sb.StudentRoll, sb.CntNo, sb.Gender, sb.DOB, sb.Status, sb.ImgPath, sb.Religion,sb.BloodGroup,sa.Present_Address, sa.Permanent_Address,\n"
                    + "	sg.FatherName,sg.FatherOccuptn,sg.MotherName,sg.MotherOccuptn,sg.GuardianName,sg.GuardianOccuptn,sg.GuardianIncome,sg.Relation,sg.ContactNo,sg.GuardianEmail,\n"
                    + "	acyr.AcYrID,d.DepartmentName,c.ClassName,s.ShiftName,sctn.SectionName\n"
                    + "	from student_basic_info sb,student_address_detail sa,student_guardian_info sg,classconfig scCnf,\n"
                    + "	student_identification si,academic_year acyr,department d,class c,shift s,section sctn \n"
                    + "	where sa.StudentID=sb.StudentID and sg.StudentID=sb.StudentID and si.StudentID=sb.StudentID \n"
                    + "	and si.ClassConfigID=scCnf.ScConfigID \n"
                    + "	and scCnf.AcYrID=acyr.AcYrID and scCnf.DeptID=d.DepartmentID and scCnf.ClassID=c.ClassID and scCnf.ShiftID=s.ShiftID \n"
                    + "	and scCnf.SectionID=sctn.SectionID \n"
                    + "	and sb.InstituteID=si.InstituteID\n"
                    + "	and si.InstituteID=scCnf.InstituteID\n"
                    + "	and scCnf.InstituteID=sctn.InstituteID\n"
                    + "	and sa.InstituteID=sg.InstituteID\n"
                    + "	and sg.InstituteID=si.InstituteID\n"
                    + "	and sb.InstituteID=?  order by sb.StudentID");

            prst.setString(1, instituteID);

            rs = prst.executeQuery();

            while (rs.next()) {
                student_List.add(new Student_Registration(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6), rs.getBoolean(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getDouble(19), rs.getString(20),
                        rs.getString(21), rs.getString(22), rs.getInt(23), rs.getString(24),
                        rs.getString(25), rs.getString(26), rs.getString(27)));
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
        return student_List;
    }

    @Override
    public List<Student_Registration> additionalInfoChak(Student_Registration std) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<Student_Registration> additionalChak = new ArrayList<Student_Registration>();

        try {

            prst = con.prepareStatement("select spe.ID,spe.InstituteName,spi.ID"
                    + " from student_previous_exam_info spe,student_previous_institute_info spi, student_basic_info sb"
                    + " where sb.StudentID = spi.StudentID and sb.StudentID = spe.StudentID and sb.StudentID = ?");

            prst.setString(1, std.getStudentID());

            rs = prst.executeQuery();

            while (rs.next()) {
                Student_Registration addstd = new Student_Registration();
                addstd.setPrev_Exam_ID(rs.getInt(1));
                addstd.setInstituteName(rs.getString(2));
                addstd.setPrev_institute_ID(rs.getInt(3));

                additionalChak.add(addstd);
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

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

        return additionalChak;
    }

    @Override
    public boolean additionalInfo(Student_Registration addtionalInfo, String StudentID) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {
            con.setAutoCommit(false);

            prst = con.prepareStatement("insert into student_previous_exam_info values(null,?,?,?,?,?,?,?,?,?,?)");

            prst.setString(1, addtionalInfo.getInstituteName());

            prst.setString(2, addtionalInfo.getEductn_board());

            prst.setString(3, addtionalInfo.getGroup());

            prst.setString(4, addtionalInfo.getExamRoll());

            prst.setString(5, addtionalInfo.getExamRegNo());

            prst.setString(6, addtionalInfo.getGrade());

            prst.setString(7, addtionalInfo.getCgpa());

            prst.setString(8, addtionalInfo.getPassingYear());

            prst.setString(9, StudentID);

            prst.setString(10, addtionalInfo.getP_examName());

            prst.execute();

            prst.close();

            prst = con.prepareStatement("insert into student_previous_institute_info values(null,?,?,?,?,?,?,?)");

            prst.setString(1, addtionalInfo.getCollegeName());

            prst.setString(2, addtionalInfo.getAcademicYear());

            prst.setString(3, addtionalInfo.getPrvs_edu_board());

            prst.setString(4, addtionalInfo.getPrvs_className());

            prst.setInt(5, addtionalInfo.getPrvs_classRoll());

            prst.setString(6, addtionalInfo.getPrvs_deptName());

            prst.setString(7, StudentID);

            prst.execute();

            prst.close();

            con.commit();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        } catch (NumberFormatException n) {
            System.out.println(n);
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            addtionalInfo = null;
        }

        return false;
    }

    @Override
    public boolean completeStudentUpdate(Student_Registration stdUpt) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        String SchoolID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        SchoolID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        try {
            con.setAutoCommit(false);

            Long.parseLong(stdUpt.getCntNo());

            Long.parseLong(stdUpt.getGuardianContactNo());

            prst = con.prepareStatement("update student_basic_info set StudentName=?, CntNo=?, Gender=?, DOB=?, Status=?, ImgPath=?, Religion=?,BloodGroup=?,UserID=? where StudentID=?");

            prst.setString(1, stdUpt.getStudentName());

            prst.setString(2, stdUpt.getCntNo());

            prst.setString(3, stdUpt.getGender());

            prst.setDate(4, new java.sql.Date(stdUpt.getDob().getTime()));

            prst.setBoolean(5, true);

            prst.setString(6, SchoolID + "_" + stdUpt.getStudentID() + "_" + stdUpt.getImgPath());

            prst.setString(7, stdUpt.getReligion());

            prst.setString(8, stdUpt.getBloodGroup());

            prst.setInt(9, 1);

            prst.setString(10, stdUpt.getStudentID());

            prst.execute();

            prst.close();

            prst = con.prepareStatement("update student_guardian_info set FatherName=?, MotherName=?, GuardianName=?, Relation=?, ContactNo=?, FatherOccuptn=?, MotherOccuptn=?, GuardianOccuptn=?, GuardianIncome=?, GuardianEmail=? where StudentID=? and InstituteID=?");

            prst.setString(1, stdUpt.getFatherName());

            prst.setString(2, stdUpt.getMotherName());

            prst.setString(3, stdUpt.getGuardianName());

            prst.setString(4, stdUpt.getRelation());

            prst.setString(5, stdUpt.getGuardianContactNo());

            prst.setString(6, stdUpt.getFatherOccupation());

            prst.setString(7, stdUpt.getMotherOccupation());

            prst.setString(8, stdUpt.getGuardianOccupation());

            prst.setDouble(9, stdUpt.getGuardianSalary());

            prst.setString(10, stdUpt.getGuardianEmail());

            prst.setString(11, stdUpt.getStudentID());

            prst.setString(12, SchoolID);

            prst.execute();

            prst.close();

            prst = con.prepareStatement("update student_address_detail set Present_Address=?, Permanent_Address=? where StudentID=? and InstituteID=?");

            prst.setString(1, stdUpt.getPresentAddress());

            prst.setString(2, stdUpt.getPermanentAddress());

            prst.setString(3, stdUpt.getStudentID());

            prst.setString(4, SchoolID);

            prst.execute();

            prst.close();

            con.commit();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        } catch (NumberFormatException n) {
            System.out.println(n);
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            stdUpt = null;
        }

        return false;
    }

    @Override
    public boolean updateAcademicInfo(Student_Registration stdReg, int scCnf_ID) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        String SchoolID = "";

        FacesContext context = FacesContext.getCurrentInstance();

        SchoolID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {

            prst = con.prepareStatement("update student_identification set ClassConfigID=? where StudentID=? and InstituteID=?");

            prst.setInt(1, scCnf_ID);

            prst.setString(2, stdReg.getStudentID());

            prst.setString(3, SchoolID);

            prst.executeUpdate();

            prst = con.prepareStatement("update student_basic_info set StudentRoll=? where StudentID=? and InstituteID=?");

            prst.setInt(1, stdReg.getStudentRoll());

            prst.setString(2, stdReg.getStudentID());

            prst.setString(3, SchoolID);

            prst.executeUpdate();

            return true;

        } catch (SQLException ex) {

            System.out.println(ex);

        } finally {

            try {

                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();

                }

            } catch (SQLException ex) {

                System.out.println(ex);
            }

        }
        return false;

    }
}
