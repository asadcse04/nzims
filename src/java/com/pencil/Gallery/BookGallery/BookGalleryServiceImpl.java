/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.gallery.BookGallery;

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
public class BookGalleryServiceImpl implements BookGalleryService, Serializable {

    @Override
    public boolean addBookGallery(BookGallery bookGallery) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        int ID = 0;

        try {
            prst = con.prepareStatement("select max(BookGalleryID) as ID from book_gallery");

            rs = prst.executeQuery();

            while (rs.next()) {

                ID = rs.getInt("ID");
            }

            if (ID == 0) {

                ID = 1;

            }

            prst = con.prepareStatement("insert into book_gallery values (null,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            prst.setInt(1, bookGallery.getAcYear());

            prst.setString(2, bookGallery.getClassName());

            prst.setString(3, bookGallery.getDepartmentName());

            prst.setString(4, bookGallery.getSubjectName());

            prst.setString(5, bookGallery.getCode());

            prst.setString(6, bookGallery.getBookName());

            prst.setString(7, bookGallery.getTopic());

            prst.setString(8, bookGallery.getAuthor());

            prst.setString(9, bookGallery.getPublication());

            prst.setString(10, bookGallery.getEdition());

            prst.setDouble(11, bookGallery.getPrice());

            prst.setString(12, bookGallery.getNote());

            prst.setString(13, ((ID + 1) + "_" + bookGallery.getImagePath()));

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
    public boolean updBookGellery(BookGallery bookGallery) {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update book_gallery set AcYrID=?, ClassName=?, DeptName=?, SubjectName=?, Code=?, BookName=?, Topic=?, Author=?, Publication=?, Edition=?, Price=?, Note=?, ImgPath=? where BookGalleryID=?");

            prst.setInt(1, bookGallery.getAcYear());

            prst.setString(2, bookGallery.getClassName());

            prst.setString(3, bookGallery.getDepartmentName());

            prst.setString(4, bookGallery.getSubjectName());

            prst.setString(5, bookGallery.getCode());

            prst.setString(6, bookGallery.getBookName());

            prst.setString(7, bookGallery.getTopic());

            prst.setString(8, bookGallery.getAuthor());

            prst.setString(9, bookGallery.getPublication());

            prst.setString(10, bookGallery.getEdition());

            prst.setDouble(11, bookGallery.getPrice());

            prst.setString(12, bookGallery.getNote());
            
            prst.setString(13, bookGallery.getImagePath());

            prst.setInt(14, bookGallery.getBookGalleryID());

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
    public List<BookGallery> bookGalleryList() {

        List<BookGallery> bookAllList = new ArrayList<BookGallery>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from book_gallery");

            rs = prst.executeQuery();

            while (rs.next()) {

                bookAllList.add(new BookGallery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getDouble(12), rs.getString(13), rs.getString(14)));

            }
            return bookAllList;

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

        return bookAllList;
    }

    @Override
    public List<String> departmentName(String className) {
        
        List<String> bookAllList = new ArrayList<String>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select DepartmentName from department where DepartmentID in (select distinct DeptID from  classconfig cf where cf.ClassID=(select distinct ClassID from class where ClassName=?) )");

            prst.setString(1, className);
            rs = prst.executeQuery();

            while (rs.next()) {

             //   bookAllList.add(new BookGallery(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getDouble(12), rs.getString(13), rs.getString(14)));

            }
            return bookAllList;

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

        return bookAllList;
    }

    @Override
    public List<String> subjectName(String deptName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
