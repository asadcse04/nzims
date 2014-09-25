/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.library.BookCategory;

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
public class BookCategoryServiceImpl implements BookCategoryService{

    @Override
    public boolean addBookCategory(BookCategory bookCategory) {
                
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into library_book_category values (null, ?, ?)");
            
            prst.setString(1, bookCategory.getBookCategoryName());
            
            prst.setString(2, bookCategory.getBookCategorynote());

         
            int add = prst.executeUpdate();

            return true;

        } 
        catch (SQLException ex) {
            System.out.println(ex);
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
    public boolean updateBookCategory(BookCategory bookCategory) {
        
      DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update library_book_category set Category_Name=?, Note=? where BookCategory_ID=?");

            prst.setString(1, bookCategory.getBookCategoryName());

            prst.setString(2, bookCategory.getBookCategorynote());

          prst.setInt(3, bookCategory.getBookCategoryId());

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
    public List<BookCategory> getAllBookCategory() {
        
          List <BookCategory> bookCategoryAllList = new ArrayList<BookCategory>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from library_book_category");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                 bookCategoryAllList.add(new BookCategory(rs.getInt(1),rs.getString(2),rs.getString(3)));
                 
                 
            }
            return bookCategoryAllList;

        } 
        catch (SQLException ex) {
            
            System.out.println(ex);
        } 
        finally {
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
       
       return bookCategoryAllList;
    }

    
    
    
    
    
    
}
