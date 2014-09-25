/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.facility.library.BookSubCategory;


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
public class BookSubCategoryImpl implements BookSubCategoryService {

    @Override
    public boolean addBookSubCategory(BookSubCategory bookSubCategory) {
            
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into library_book_subcategory values (null, ?, ?, ?)");
            
            prst.setString(1, bookSubCategory.getBookSubCategoryName());
            
            prst.setString(2, bookSubCategory.getBookSubCategorynote());

           prst.setInt(3, bookSubCategory.getBookCategoryId());
           
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

    
    public boolean updateBookSubCategory(BookSubCategory bookSubCategory) {
        
      DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update library_book_subcategory set SubCategory_Name=?, Note=?,Bookcategory_ID=? where BookSubCategory_ID=?");

            prst.setString(1, bookSubCategory.getBookSubCategoryName());

            prst.setString(2, bookSubCategory.getBookSubCategorynote());

            prst.setInt(3, bookSubCategory.getBookCategoryId());
            
          prst.setInt(4, bookSubCategory.getBookSubCategoryId());

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
    public List<BookSubCategory> getAllBookSubCategory() {
        
        
          List <BookSubCategory> bookSubCategoryAllList = new ArrayList<BookSubCategory>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from library_book_subcategory");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                 bookSubCategoryAllList.add(new BookSubCategory(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
                 
                 
            }
            return bookSubCategoryAllList;

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
       
       return bookSubCategoryAllList;
    }
    
    
    
    
}
