/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.DesignationAssign;

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
public class DesignationAssignServiceImpl implements DesignationAssignService, Serializable {

    @Override
    public boolean AddDesignation(DesignationAssign designationAssign) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("insert into designation_assign values (null,?,(Select DesignationID from designation where DesignationName=?),?)");

            prst.setInt(1, designationAssign.getTeacherID());

            prst.setString(2, designationAssign.getDesignationName());

            prst.setString(3, designationAssign.getNote());

            prst.execute();

            prst.close();

            con.close();

            return true;
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
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    @Override
    public boolean UpdateDesignation(DesignationAssign designationAssign) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<DesignationAssign> teacherList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<DesignationAssign> addList = new ArrayList<DesignationAssign>();

        try {

            prst = con.prepareStatement("select t.TeacherID, t.TeacherName, t.Gender, tc.ContactNo from teacher t, teacher_contact_info tc where t.TeacherID=tc.TeacherID ");

            rs = prst.executeQuery();

            while (rs.next()) {
                addList.add(new DesignationAssign(rs.getInt("TeacherID"), rs.getString("TeacherName"), rs.getString("Gender"), rs.getString("ContactNo")));
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

        return addList;
    }

    @Override
    public List<String> categoryList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> cateList = new ArrayList<String>();

        try {
            prst = con.prepareStatement("SELECT distinct DesignationCategoryName from designation_category");

            rs = prst.executeQuery();

            while (rs.next()) {
                cateList.add(rs.getString(1));
            }
            return cateList;
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

        return cateList;
    }

    @Override
    public List<String> designationList(String categoryName) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<String> nameList = new ArrayList<String>();

        try {
            prst = con.prepareStatement("SELECT distinct hb.DesignationName from designation hb, designation_category hc where hc.DesignationCategoryID=hb.DesignationCategoryID  and hc.DesignationCategoryName=?");

            prst.setString(1, categoryName);

            rs = prst.executeQuery();

            while (rs.next()) {
                nameList.add(rs.getString(1));
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

        return nameList;
    }

}
