/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riad
 */
public class PhoneBookServiceImpl implements PhoneBookService{
    
 @Override
 public boolean addPhoneBook(PhoneBook phoneBook){
   
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        try {
            prst = con.prepareStatement("insert into phonebook values (null, ?, ?, ?, ?)");
            
            prst.setString(1, phoneBook.getContactName());
            
            prst.setString(2, phoneBook.getMobile());
            
            prst.setString(3, phoneBook.getNote());
            
            prst.setInt(4, phoneBook.getCategoryid());

            int add = prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
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

            } 
            
            catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return false;
        
     
 }
 
 @Override
 public List<String> phnCatList(){
     
     List<String> list=new ArrayList<String>();
      DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try {
            prst = con.prepareStatement("select CategoryID,CategoryName from phonebook_category");
             
            rs=prst.executeQuery();
            
            while(rs.next()){
             
                list.add(rs.getInt(1)+"-"+rs.getString(2));
            
            }
            
            return list;
          

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        
        finally {
            try {
                if (prst != null) {

                    prst.close();

                }
                
                 if (rs != null) {

                    rs.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            
            catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return list;
     
 }
 
 public List<PhoneBook> phBookList(){
     
    List<PhoneBook> phlist=new ArrayList<PhoneBook>();
     
    DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try {
            prst = con.prepareStatement("select * from phonebook");
             
            rs=prst.executeQuery();
            
            while(rs.next()){
             
                phlist.add(new PhoneBook(rs.getInt((1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
            
            }
            
            return phlist;
          

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        
        finally {
            try {
                if (prst != null) {

                    prst.close();

                }
                
                 if (rs != null) {

                    rs.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            
            catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return phlist;
      
 }
    
}
