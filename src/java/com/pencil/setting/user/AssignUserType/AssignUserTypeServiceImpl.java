/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.setting.user.AssignUserType;

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
 * @author SHOHUG-SQ
 */
public class AssignUserTypeServiceImpl implements AssignUserTypeService, Serializable {

    @Override
    public boolean addUserType(AssignUserType assignUserType) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();
        
        String schoolid="";
        
        FacesContext context=FacesContext.getCurrentInstance();
        schoolid=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("insert into users values (?,?)");

            prst.setString(1, assignUserType.getUserName()+"-"+schoolid);

            prst.setString(2, assignUserType.getPassword());
            
            prst.execute();
            
            prst = con.prepareStatement("insert into user_roles values (?,?)");
            
            prst.setString(1, assignUserType.getUserName()+"-"+schoolid);
            
            prst.setString(2, assignUserType.getUserType());


            prst.execute();

            prst.close();

            con.close();

            return true;
        } 
        catch (SQLException e)
        {
            System.out.println(e);
        } 
        finally {
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
    public List<AssignUserType> userList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<AssignUserType> addList = new ArrayList<AssignUserType>();

        try {

            prst = con.prepareStatement("select t.TeacherID, t.TeacherName, t.Gender, tc.ContactNo from teacher t, teacher_contact_info tc\n"
                    + " where t.TeacherID=tc.TeacherID and t.TeacherID not in (select user_name from users)");

            rs = prst.executeQuery();

            while (rs.next()) {
                addList.add(new AssignUserType(rs.getInt("TeacherID"), rs.getString("TeacherName"), rs.getString("Gender"), rs.getString("ContactNo")));
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
    public List<AssignUserType> mobileList(AssignUserType mobileList) {
        DB_Connection db = new DB_Connection();

        Connection con = db.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<AssignUserType> mobile = new ArrayList<AssignUserType>();

        try {

            prst = con.prepareStatement("");

            rs = prst.executeQuery();

            while (rs.next()) {

                AssignUserType mob = new AssignUserType();

                mob.setContactNo(rs.getString(1));

                mobile.add(mob);

            }

            return mobile;

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

        return mobile;

    }

}
