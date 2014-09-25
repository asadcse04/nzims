/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.BankAccount;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Riad
 */
public class BankAccountServiceImpl implements BankAccountService{
    

    @Override
    public boolean addBankAccount(BankAccount bankAccount) 
    
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
       
        
        try 
        {
            prst = con.prepareStatement("insert into bank_account values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            prst.setString(1, bankAccount.getBankName());
            
            prst.setString(2, bankAccount.getRemarkSymbol());
            
            prst.setString(3, bankAccount.getAcName());
            
            prst.setString(4, bankAccount.getAcNumber());
            
            prst.setString(5, bankAccount.getAcType());
            
            prst.setString(6, bankAccount.getAddress());
            
            prst.setString(7, bankAccount.getBranch());
            
            prst.setDouble(8, bankAccount.getStartingBalance());
            
            prst.setString(9, bankAccount.getNote());
            
            prst.setInt(10, bankAccount.getBankAcGroupID());
            
            prst.setDate(11, new java.sql.Date(new Date().getTime()));
            
            prst.setDouble(12, bankAccount.getStartingBalance());
            
            prst.setDouble(13, bankAccount.getTotalWithdraw());
            
            prst.setDouble(14, bankAccount.getStartingBalance()-bankAccount.getTotalWithdraw());

            int add = prst.executeUpdate();
            
           
            return true;

        } 
        
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        
        finally 
        {
            try 
            {
                if (prst != null) 
                {

                    prst.close();

                }
                           

                if (con != null) 
                {

                    con.close();
                }

            } 
            catch (SQLException e) 
            {

                System.out.println(e);
            }
        } 
        return false;
    }

    @Override
    public List<BankAccount> getAllBankAccount() 
    
    {
  
       List <BankAccount> bankAccountList = new ArrayList<BankAccount>();
       
       DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try 
        {
            prst = con.prepareStatement("select * from bank_account");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
            bankAccountList.add(new BankAccount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),  rs.getString(8),rs.getDouble(9),rs.getString(10), rs.getInt(11), new Date(rs.getDate(12).getTime()),rs.getDouble(13),rs.getDouble(14),rs.getDouble(15)));

            }

            return bankAccountList;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        finally 
        {
            try 
            {
                
                if (rs != null) 
                {

                    rs.close();

                }
                
                if (prst != null) 
                {

                    prst.close();

                }

                if (con != null) 
                {

                    con.close();
                }

            } 
            catch (SQLException e) 
            {
                System.out.println(e);
            }
        }
       
       return bankAccountList;
    }
    
}
