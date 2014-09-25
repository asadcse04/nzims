/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.TabulationSheet;

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
public class TabulationSheetServiceImpl implements TabulationSheetService, Serializable {

    // ----------------------- Class List ------------------------------------//
    @Override
    public List<String> listScClass(int acyrID) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> listClass = new ArrayList<String>();

        try {
            prst = con.prepareStatement("select distinct c.className from class c,subjectconfig sf where sf.classID=c.classID and sf.AcYrID=?");

            prst.setInt(1, acyrID);

            rs = prst.executeQuery();

            while (rs.next()) {
                listClass.add(rs.getString("c.className"));
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

        return listClass;
    }

    /*---------------------------------Department List------------------------*/
    @Override
    public List<String> listScDept(int acyrID, String className) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> listdept = new ArrayList<String>();

        try {
            prst = con.prepareStatement("select distinct d.departmentName from department d,subjectconfig sf where sf.DeptID=d.DepartmentID and sf.AcYrID=?"
                    + " and sf.classID=(select ClassID from class where ClassName=?)");

            prst.setInt(1, acyrID);

            prst.setString(2, className);

            rs = prst.executeQuery();

            while (rs.next()) {
                listdept.add(rs.getString("d.departmentName"));
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

            className = null;
        }

        return listdept;
    }

    /*-------------------------------Shift List-------------------------------*/
    @Override
    public List<String> listScShift(int acyrID, String deptName, String className) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> list_shift = new ArrayList<String>();

        try {
            prst = con.prepareStatement("select distinct s.ShiftName FROM classconfig c,academic_year a,department d,class cl,shift s"
                    + " where c.ShiftID=s.ShiftID and c.AcYrID=? and c.DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and c.ClassID=(select ClassID from class where ClassName=?)");

            prst.setInt(1, acyrID);

            prst.setString(2, deptName);

            prst.setString(3, className);

            rs = prst.executeQuery();

            while (rs.next()) {
                list_shift.add(rs.getString("s.ShiftName"));
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
            deptName = null;

            className = null;
        }

        return list_shift;
    }

    /*-----------------------------Section List-------------------------------*/
    @Override
    public List<String> listScSection(int acyrID, String deptName, String className, String shift) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> list_section = new ArrayList<String>();

        try {
            prst = con.prepareStatement("select distinct s.SectionName from classconfig c,academic_year a,department d,class cl,shift sf,section s"
                    + " where c.SectionID=s.SectionID and c.AcYrID=? and c.DeptID=(select DepartmentID from department where DepartmentName=?)"
                    + " and c.ClassID=(select ClassID from class where ClassName=?) and c.ShiftID=(select ShiftID from shift where ShiftName=?)");

            prst.setInt(1, acyrID);

            prst.setString(2, deptName);

            prst.setString(3, className);

            prst.setString(4, shift);

            rs = prst.executeQuery();

            while (rs.next()) {
                list_section.add(rs.getString("s.SectionName"));
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

            deptName = null;

            className = null;

            shift = null;
        }

        return list_section;
    }

    /*-----------------------------Class conf ID-------------------------------*/
    @Override
    public int getScCnfID(int acyr, String deptName, String className, String shiftName, String sectionName) {
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

            prst.setInt(1, acyr);

            prst.setString(2, deptName);

            prst.setString(3, className);

            prst.setString(4, shiftName);

            prst.setString(5, sectionName);

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

            deptName = null;

            className = null;

            shiftName = null;

            sectionName = null;
        }
        return scCnfID;
    }

    /*-----------------------------Exam conf ID-------------------------------*/
    @Override
    public int getExCnfID(int acyr, String className, String ExamName) {
        int exCnfId = 0;

        DB_Connection o;

        Connection con = null;

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        
        String instituteid="";
        FacesContext context = FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
       

        try {
            o = new DB_Connection();

            con = o.getConnection();

            prst = con.prepareStatement("select ExCnfID from exam_config where AcYr=? and ClassID=(select ClassID from class where ClassName=?) and ExamID=(select Exam_ID from exam where ExamName=? and InstituteID=?)");

            prst.setInt(1, acyr);

            prst.setString(2, className);

            prst.setString(3, ExamName);
            
            prst.setString(4, instituteid);

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

    /*-----------------------------Tabutation Sheet List----------------------*/

    @Override
    public List<TabulationSheetSQ> AllList(TabulationSheetController controller) {

        List<TabulationSheetSQ> tabuList = new ArrayList<TabulationSheetSQ>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String instituteid="";
        FacesContext context = FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {

            prst = con.prepareStatement("select * from student_tabulation where \n"
                    + " studentid in (select StudentID from student_identification where ClassConfigID = ? ) and instituteid=? ");

            prst.setInt(1, controller.getScCnfID());
            prst.setString(2, instituteid);

            rs = prst.executeQuery();

            while (rs.next()) {
                tabuList.add(new TabulationSheetSQ(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19),
                        rs.getString(20),
                        rs.getString(21),
                        rs.getString(22),
                        rs.getString(23),
                        rs.getString(24),
                        rs.getString(25),
                        rs.getString(26),
                        rs.getString(27),
                        rs.getString(28),
                        rs.getString(29),
                        rs.getString(30),
                        rs.getString(31),
                        rs.getString(32),
                        rs.getString(33),
                        rs.getString(34),
                        rs.getString(35),
                        rs.getString(36),
                        rs.getString(37),
                        rs.getString(38),
                        rs.getString(39),
                        rs.getString(40),
                        rs.getString(41),
                        rs.getString(42),
                        rs.getString(43),
                        rs.getString(44),
                        rs.getString(45),
                        rs.getString(46),
                        rs.getString(47),
                        rs.getString(48),
                        rs.getString(49),
                        rs.getString(50),
                        rs.getString(51),
                        rs.getString(52),
                        rs.getString(53),
                        rs.getString(54),
                        rs.getString(55),
                        rs.getString(56),
                        rs.getString(57),
                        rs.getString(58),
                        rs.getString(59),
                        rs.getString(60),
                        rs.getString(61),
                        rs.getString(62),
                        rs.getString(63),
                        rs.getString(64),
                        rs.getString(65),
                        rs.getString(66),
                        rs.getString(67),
                        rs.getString(68),
                        rs.getString(69),
                        rs.getString(70),
                        rs.getString(71),
                        rs.getString(72),
                        rs.getString(73),
                        rs.getString(74),
                        rs.getString(75),
                        rs.getString(76),
                        rs.getString(77),
                        rs.getString(78),
                        rs.getString(79),
                        rs.getString(80),
                        rs.getString(81),
                        rs.getString(82),
                        rs.getString(83),
                        rs.getString(84),
                        rs.getString(85),
                        rs.getString(86),
                        rs.getString(87),
                        rs.getString(88),
                        rs.getString(89),
                        rs.getString(90),
                        rs.getString(91),
                        rs.getString(92),
                        rs.getString(93),
                        rs.getString(94),
                        rs.getString(95),
                        rs.getString(96),
                        rs.getString(97),
                        rs.getString(98),
                        rs.getString(99),
                        rs.getString(100),
                        rs.getString(101),
                        rs.getString(102),
                        rs.getString(103),
                        rs.getString(104),
                        rs.getString(105),
                        rs.getString(106),
                        rs.getString(107),
                        rs.getString(108),
                        rs.getString(109),
                        rs.getString(110),
                        rs.getString(111),
                        rs.getString(112),
                        rs.getString(113),
                        rs.getString(114),
                        rs.getString(115),
                        rs.getString(116),
                        rs.getString(117),
                        rs.getString(118),
                        rs.getString(119),
                        rs.getString(120),
                        rs.getString(121),
                        rs.getString(122),
                        rs.getString(123),
                        rs.getString(124),
                        rs.getString(125),
                        rs.getString(126),
                        rs.getString(127),
                        rs.getString(128),
                        rs.getString(129),
                        rs.getString(130),
                        rs.getString(131),
                        rs.getString(132),
                        rs.getString(133),
                        rs.getString(134),
                        rs.getString(135),
                        rs.getString(136),
                        rs.getString(137),
                        rs.getString(138),
                        rs.getString(139),
                        rs.getString(140),
                        rs.getString(141),
                        rs.getString(142),
                        rs.getString(143),
                        rs.getString(144)));
                        
            }

            return tabuList;

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
        return tabuList;
    }

}
