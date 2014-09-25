/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookAuthor;

import com.pencil.Connection.DB_Connection;
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
public class AuthorServiceImpl implements AuthorService {

    @Override
    public boolean addAuthor(Author author) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into library_author values (null, ?, ?, ?, ?)");

            prst.setString(1, author.getAuthorName());

            prst.setString(2, author.getAboutAuthor());

            prst.setString(3, author.getAuthornote());

            prst.setString(4, author.getAuthorImg());

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
    public boolean updateAuthor(Author author) {

       
      DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update library_author set Author_Name=?,About_Author=?, Note=?,Image_Path=? where Author_ID=?");

            prst.setString(1, author.getAuthorName());

            prst.setString(2, author.getAboutAuthor());

          prst.setString(3, author.getAuthornote());

           prst.setString(4, author.getAuthorImg());
          
           prst.setInt(5, author.getAuthorId());
           
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
    public List<Author> getAllAuthor() {

        List<Author> allAuthorList = new ArrayList<Author>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from library_author");

            rs = prst.executeQuery();

            while (rs.next()) {
                
                allAuthorList.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }
            return allAuthorList;

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

        return allAuthorList;
    }

 

}
