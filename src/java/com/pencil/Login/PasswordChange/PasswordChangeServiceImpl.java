/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Login.PasswordChange;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author SHOHUG.SQ
 */
public class PasswordChangeServiceImpl implements PasswordChangeService, Serializable {

    @Override
    public boolean updatePassword(PasswordChange passwordChange) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement(" update users set user_pass = ? where user_name = ? ");

            prst.setString(1, passwordChange.getRepetPass());

            prst.setString(2, passwordChange.getUserID());

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

            } catch (SQLException e) {

                System.out.println(e);
            }
        }

        return false;

    }

    @Override
    public boolean currentPassword(PasswordChange passwordChange) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

            prst = con.prepareStatement("select user_pass from users where user_name =? and user_pass=?");

            prst.setString(1, passwordChange.getUserID());

            prst.setString(2, passwordChange.getCurrentPassword());

            rs = prst.executeQuery();

            if (rs.next()) {
                return true;
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

        return false;

    }

    @Override
    public List<String> checkPassword(PasswordChange passwordChange) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
