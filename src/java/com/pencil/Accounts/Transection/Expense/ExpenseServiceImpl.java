/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Expense;

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
 * @author Mamun
 */
public class ExpenseServiceImpl implements ExpenseService {
    
    public boolean expenseCash(Expense expense)
     
     {
     
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        try {
            prst = con.prepareStatement("insert into cash values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            prst.setDate(1, new java.sql.Date(new Date().getTime()));
            
            prst.setString(2, "Expense");
            
            prst.setString(3, expense.getTranName());
            
            prst.setDouble(4, expense.getTranAmount());
            
            prst.setInt(5, expense.getTrSubHeadID());
            
            prst.setString(6, expense.getInvoiceID());
            
            prst.setString(7, expense.getPaymentType());
            
            prst.setString(8, expense.getAttachedVoucherNo());
            
            prst.setString(9, expense.getNote());
            
            prst.setInt(10, expense.getBankID());
            
            prst.setString(11, expense.getBankName());
            
            prst.setString(12, expense.getCheckNo());
            
            prst.setString(13, null);
            
            int add = prst.executeUpdate();
            
             
            if(expense.getBankID() !=0)
            {
            
            prst=con.prepareStatement("update bank_account set TotalWithdraw=(TotalWithdraw+"+expense.getTranAmount()+"), Balance=(TotalDiposit-TotalWithdraw) where BankAcID="+expense.getBankID()+"");

            int up=prst.executeUpdate();
            
            
            prst=con.prepareStatement("insert into banktrn_details (BankID,Date,Status,Amount,AmountType,TrnName,SubheadName,SubheadID,CheckNo) values (?,?,?,?,?,?,?,?,?)");
            
            prst.setInt(1, expense.getBankID());
            
            prst.setDate(2, new java.sql.Date(new Date().getTime()));
            
            prst.setString(3, "Withdraw");
            
            prst.setDouble(4, expense.getTranAmount());
            
            prst.setString(5,"Check");
            
            prst.setString(6, "Bank Transection");
            
            prst.setString(7, expense.getTranName());
            
            prst.setInt(8, expense.getTrSubHeadID());
            
            prst.setString(9, expense.getCheckNo());
            
            int insertBankTranDetails=prst.executeUpdate();
            
            
           prst=con.prepareStatement("update cash_summery set bankOut=(bankOut+"+expense.getTranAmount()+"),bankBalance=(bankIn-bankOut) where ID=1");
            
           int upcashsummurybank=prst.executeUpdate();  
            
            }
            
           
            if(expense.getPaymentType().equals("Cash")){
            
            prst=con.prepareStatement("update cash_summery set cashOut=(cashOut+"+expense.getTranAmount()+"),cashBalance=(cashIn-cashOut) where ID=1");
            
            int upcashsummurycash=prst.executeUpdate();
                
            }
            
            
            if(expense.getPaymentType().equals("Check")){
            
            prst=con.prepareStatement("update cash_summery set checkOut=(checkOut+"+expense.getTranAmount()+"),checkBalance=(checkIn-checkOut) where ID=1");
            
            int upcashsummurycash=prst.executeUpdate();
                
            }
            
            
            
            return true;
            
        }

            

      
        catch (SQLException ex) 
        
        {
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

    
     
     public List<String> transactionCatList(String expense){
       
        List<String> trlist=new ArrayList<String>();
         
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try {
            prst = con.prepareStatement("select TrCatagoryName from transectioncatagory where TrType=?");
            
            prst.setString(1, expense);
          
            rs=prst.executeQuery();
        
        while(rs.next()){
            
        trlist.add(rs.getString(1));
        
        }
        
        
        
        } 
        
        catch (SQLException ex) 
        
        {
            System.out.println(ex);
        } 
        
        finally {
            
            try 
            {
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
        
    
         
         return trlist;
         
     }
     
     public List<String> transactionSubHeadList(String subhead){
         
         List<String> subheadlist=new ArrayList<String>();
         
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try {
            prst = con.prepareStatement("select TrSubHeadID,SubHeadName from transection_subhead where TrMainHeadID=(select TrMainHeadID from transection_mainhead where MainHeadName=?)");
            
            prst.setString(1, subhead);
          
            rs=prst.executeQuery();
        
        while(rs.next()){
            
        subheadlist.add(rs.getInt(1)+"-"+rs.getString(2));
        
        }
        
        
        
        } 
        
        catch (SQLException ex) 
        
        {
            System.out.println(ex);
        } 
        
        finally {
            
            try 
            {
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
         
         return subheadlist;
     }
     
     public List<String> bankIdList(){
         
       List<String> bankidlist=new ArrayList<String>();
     
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try {
            prst = con.prepareStatement("select BankAcID,BankName from bank_account");
            
            rs=prst.executeQuery();
        
            while(rs.next()){
            
            bankidlist.add(rs.getInt(1)+"-"+rs.getString(2));
        
           }
            
            
        
           return bankidlist;
        
        } 
        
        catch (SQLException ex) 
        
        {
            System.out.println(ex);
        } 
        
        finally {
            
            try 
            {
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
     
     
     return bankidlist;
     }
    

}