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
import javax.faces.context.FacesContext;

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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try {
            
            con.setAutoCommit(false);
            
            prst = con.prepareStatement("insert into cash values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            prst.setString(1, institueID);
            
            prst.setDate(2, new java.sql.Date(new Date().getTime()));
            
            prst.setString(3, "Expense");
            
            prst.setString(4, expense.getTranName());
            
            prst.setDouble(5, expense.getTranAmount());
            
            prst.setInt(6, expense.getTrSubHeadID());
            
            prst.setString(7, expense.getInvoiceID());
            
            prst.setString(8, expense.getPaymentType());
            
            prst.setString(9, expense.getAttachedVoucherNo());
            
            prst.setString(10, expense.getNote());
            
            prst.setInt(11, expense.getBankID());
            
            prst.setString(12, expense.getBankName());
            
            prst.setString(13, expense.getCheckNo());
            
            prst.setString(14, null);
            
            int add = prst.executeUpdate();
            
             
            if(expense.getBankID() !=0)
            {
            
            prst=con.prepareStatement("update bank_account set TotalWithdraw=(TotalWithdraw+"+expense.getTranAmount()+"), Balance=(TotalDiposit-TotalWithdraw) where BankAcID="+expense.getBankID()+" and InstituteID=?");

            prst.setString(1, institueID);
            
            int up=prst.executeUpdate();
            
            
            prst=con.prepareStatement("insert into banktrn_details (BankID,Date,Status,Amount,AmountType,TrnName,SubheadName,SubheadID,CheckNo,InstituteID) values (?,?,?,?,?,?,?,?,?,?)");
            
            prst.setInt(1, expense.getBankID());
            
            prst.setDate(2, new java.sql.Date(new Date().getTime()));
            
            prst.setString(3, "Withdraw");
            
            prst.setDouble(4, expense.getTranAmount());
            
            prst.setString(5,"Check");
            
            prst.setString(6, "Bank Transection");
            
            prst.setString(7, expense.getTranName());
            
            prst.setInt(8, expense.getTrSubHeadID());
            
            prst.setString(9, expense.getCheckNo());
            
            prst.setString(10, institueID);
            
            int insertBankTranDetails=prst.executeUpdate();
            
            
           prst=con.prepareStatement("update cash_summery set bankOut=(bankOut+"+expense.getTranAmount()+"),bankBalance=(bankIn-bankOut) where InstituteID=?");
            
           prst.setString(1, institueID);
           
           int upcashsummurybank=prst.executeUpdate();  
            
            }
            
           
            if(expense.getPaymentType().equals("Cash")){
            
            prst=con.prepareStatement("update cash_summery set cashOut=(cashOut+"+expense.getTranAmount()+"),cashBalance=(cashIn-cashOut) where InstituteID=?");
            prst.setString(1, institueID);
            
            int upcashsummurycash=prst.executeUpdate();
                
            }
            
            
            if(expense.getPaymentType().equals("Check")){
            
            prst=con.prepareStatement("update cash_summery set checkOut=(checkOut+"+expense.getTranAmount()+"),checkBalance=(checkIn-checkOut) where InstituteID=?");
            prst.setString(1, institueID);
            int upcashsummurycash=prst.executeUpdate();
                
            }
            
            con.commit();
            
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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try {
            prst = con.prepareStatement("select TrCatagoryName from transectioncatagory where TrType=? and InstituteID=?");
            
            prst.setString(1, expense);
          
            prst.setString(2, institueID);
            
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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try {
            prst = con.prepareStatement("select TrSubHeadID,SubHeadName from transection_subhead where TrMainHeadID=(select TrMainHeadID from transection_mainhead where MainHeadName=? and InstituteID=?) and InstituteID=?");
            
            prst.setString(1, subhead);
            prst.setString(2,institueID );
            prst.setString(3, institueID);
            
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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try {
            prst = con.prepareStatement("select BankAcID,BankName from bank_account where InstituteID=?");
            prst.setString(1, institueID);
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