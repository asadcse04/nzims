/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.EmailBook;

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
public class EmailBookServiceImpl implements EmailBookService {

    @Override
    public boolean addEmailBook(EmailBook emailBook) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into email_book values (null, ?, ?, ?, ?)");

            prst.setString(1, emailBook.getContactName());

            prst.setString(2, emailBook.getEmailAddress());

            prst.setString(3, emailBook.getEmailNote());

            prst.setInt(4, emailBook.getCategoryId());

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
    public boolean updateEmailBook(EmailBook emailBook) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update email_book set Contact_Name=?, Email_Address=?, Note=?, Category_ID=?  where Contact_ID=?");

            prst.setString(1, emailBook.getContactName());

            prst.setString(2, emailBook.getEmailAddress());

            prst.setString(3, emailBook.getEmailNote());

            prst.setInt(4, emailBook.getCategoryId());

            prst.setInt(5, emailBook.getContactId());

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
    public List<EmailBook> getAllEmailBook() {

        List<EmailBook> emailBookAllList = new ArrayList<EmailBook>();


        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {

           prst = con.prepareStatement("select a.Contact_ID ,a.Contact_Name,a.Email_Address, a.Note,a.Category_ID,b.Category_Name from email_book a ,emailbook_category b  where a.Category_ID=b.Category_ID");

            rs = prst.executeQuery();

            while (rs.next()) {

                emailBookAllList.add(new EmailBook(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getString(6)));

            }
            return emailBookAllList;

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

        return emailBookAllList;

    }

}
