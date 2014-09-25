/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.EmailBookCategory;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sis
 */
public class EmailBookCategoryServiceImpl implements EmailBookCategoryService {

    @Override
    public boolean addEmailBookCategory(EmailBookCategory emailBookCategory) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into emailbook_category values (null, ?, ?)");

            prst.setString(1, emailBookCategory.getCategoryName());

            prst.setString(2, emailBookCategory.getCategoryNote());

            int add = prst.executeUpdate();

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
    public boolean updateEmailBookCategory(EmailBookCategory emailBookCategory) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update emailbook_category set Category_Name=?, Note=? where Category_ID=?");

            prst.setString(1, emailBookCategory.getCategoryName());

            prst.setString(2, emailBookCategory.getCategoryNote());

            prst.setInt(3, emailBookCategory.getCategoryId());

            int b = prst.executeUpdate();

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
    public List<EmailBookCategory> getAllEmailBookCategory() {

        List<EmailBookCategory> emailBookCategoryAllList = new ArrayList<EmailBookCategory>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from emailbook_category");

            rs = prst.executeQuery();

            while (rs.next()) {

                emailBookCategoryAllList.add(new EmailBookCategory(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }
            return emailBookCategoryAllList;

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

        return emailBookCategoryAllList;

    }

}
