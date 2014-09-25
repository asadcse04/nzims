/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transaction.BankTransaction;

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
public class BankTransectionServiceImpl implements BankTransectionService{

  
    @Override
    public boolean addBankDetails(BankTransection bankTransaction){    //this method is complex. author is Riyad. mobile:01672408287 
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        
        try 
        {
            prst = con.prepareStatement("insert into banktrn_details values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            prst.setInt(1,bankTransaction.getBankId());
            
            prst.setDate(2, new java.sql.Date(new Date().getTime()));
            
            prst.setString(3, bankTransaction.getStatus());
            
            prst.setDouble(4,bankTransaction.getAmount());
            
            prst.setString(5, bankTransaction.getAmounttype());
            
            prst.setString(6,"Bank Transection");
            
            prst.setString(7, bankTransaction.getSubheadname());
            
            prst.setInt(8, bankTransaction.getSubheadId());
            
            prst.setString(9, bankTransaction.getInvoiceId());
            
            prst.setString(10, bankTransaction.getPurpose());
            
            prst.setString(11, bankTransaction.getCheckno());
            
            prst.setString(12, bankTransaction.getNote());
            
            prst.setString(13, bankTransaction.getUserId());

            int add = prst.executeUpdate();
            
            
            if(bankTransaction.getStatus().equals("Deposit") && bankTransaction.getAmounttype().equals("Cash"))
            
            {
              
            prst=con.prepareStatement("update bank_account set TotalDiposit=(TotalDiposit+"+bankTransaction.getAmount()+"), Balance=(TotalDiposit-TotalWithdraw) where BankAcID="+bankTransaction.getBankId()+"");
            int updip=prst.executeUpdate();
            
            
            prst=con.prepareStatement("insert into cash (TrnDate,TrnStatus,TrnName,TrnAmount,PaymentType,Note,BankID,CheckNo) values(?,?,?,?,?,?,?,?)");
            
            prst.setDate(1, new java.sql.Date(new Date().getTime()));
            prst.setString(2, "Expense");
            prst.setString(3, "Bank Transection");
            prst.setDouble(4, bankTransaction.getAmount());
            prst.setString(5, "Bank");
            prst.setString(6, bankTransaction.getNote());
            prst.setInt(7, bankTransaction.getBankId());
            prst.setString(8, bankTransaction.getCheckno());
            
            int insrtcashincome=prst.executeUpdate();
            
            
            
            prst=con.prepareStatement("update cash_summery set cashOut=(cashOut+"+bankTransaction.getAmount()+"),bankIn=(bankIn+"+bankTransaction.getAmount()+"),cashBalance=(cashIn-cashOut),bankBalance=(bankIn-bankOut) where ID=1");
            
            int upcashsummerydepositcash=prst.executeUpdate();
           
            
            }
            
            
            
            if(bankTransaction.getStatus().equals("Deposit") && bankTransaction.getAmounttype().equals("Check"))
            
            {
              
            prst=con.prepareStatement("update bank_account set TotalDiposit=(TotalDiposit+"+bankTransaction.getAmount()+"), Balance=(TotalDiposit-TotalWithdraw) where BankAcID="+bankTransaction.getBankId()+"");
            int updip=prst.executeUpdate();
            
            
            prst=con.prepareStatement("insert into cash (TrnDate,TrnStatus,TrnName,TrnAmount,PaymentType,Note,BankID,CheckNo) values(?,?,?,?,?,?,?,?)");
            
            prst.setDate(1, new java.sql.Date(new Date().getTime()));
            prst.setString(2, "Expense");
            prst.setString(3, "Bank Transection");
            prst.setDouble(4, bankTransaction.getAmount());
            prst.setString(5, "Check");
            prst.setString(6, bankTransaction.getNote());
            prst.setInt(7, bankTransaction.getBankId());
            prst.setString(8, bankTransaction.getCheckno());
            
            int insrtcashincome=prst.executeUpdate();
            
            
            
            prst=con.prepareStatement("update cash_summery set checkOut=(checkOut+"+bankTransaction.getAmount()+"),bankIn=(bankIn+"+bankTransaction.getAmount()+"),checkBalance=(checkIn-checkOut),bankBalance=(bankIn-bankOut) where ID=1");
            
            int upcashsummerydepositcheck=prst.executeUpdate();
            
//         
           
            }
            
            
            if(bankTransaction.getStatus().equals("Withdraw") && bankTransaction.getAmounttype().equals("Cash")){
                
            prst=con.prepareStatement("update bank_account set TotalWithdraw=(TotalWithdraw+"+bankTransaction.getAmount()+"), Balance=(TotalDiposit-TotalWithdraw) where BankAcID="+bankTransaction.getBankId()+"");
            int upwith=prst.executeUpdate();
            
            
            
            prst=con.prepareStatement("insert into cash (TrnDate,TrnStatus,TrnName,TrnAmount,PaymentType,Note,BankID,CheckNo) values(?,?,?,?,?,?,?,?)");
            
            prst.setDate(1, new java.sql.Date(new Date().getTime()));
           
            prst.setString(2, "Income");
           
            prst.setString(3, "Bank Transection");
            
            prst.setDouble(4, bankTransaction.getAmount());
            
            prst.setString(5, "Cash");
            
            prst.setString(6, bankTransaction.getNote());
           
            prst.setInt(7, bankTransaction.getBankId());
            
            prst.setString(8, bankTransaction.getCheckno());
            
            int insrtcashexpense=prst.executeUpdate();
            
            prst=con.prepareStatement("update cash_summery set cashIn=(cashIn+"+bankTransaction.getAmount()+"),bankOut=(bankOut+"+bankTransaction.getAmount()+"),cashBalance=(cashIn-cashOut),bankBalance=(bankIn-bankOut) where ID=1");
            
            int upcashsummerydepositcheck=prst.executeUpdate();
            
//        
            
           }
            

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

            } 
            
            catch (SQLException e) {

                System.out.println(e);
            }
        }
            
        return false;          
    }                                   //  <!----this method is complex. author is Riyad. mobile:01672408287--- >
    
    
    @Override
    public List<String> bankIdNameList(){
        
         List<String> list=new ArrayList<String>();
        
         DB_Connection o = new DB_Connection();

         Connection con = o.getConnection();

         PreparedStatement prst = null;
         
         ResultSet rs=null;
        
        try 
        {
            prst = con.prepareStatement("select BankAcID,BankName from bank_account");           

            rs=prst.executeQuery();
            
            while(rs.next()){
                
            list.add(rs.getInt(1)+"-"+rs.getString(2));
            
            }
           

           return list; 

        } 
        
        catch (SQLException ex) {
            
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

            } catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return list; 
        
    }
    
   
    
    @Override
        
    public String acById(int bankid){
        
         String a="";
       
         DB_Connection o = new DB_Connection();

         Connection con = o.getConnection();

         PreparedStatement prst = null;
         
         ResultSet rs=null;
        
        try 
        {
            prst = con.prepareStatement("select AcNumber from bank_account where BankAcID=?");           
            prst.setInt(1, bankid);
            
            rs=prst.executeQuery();
            
            while(rs.next()){
                
              a=rs.getString(1);
            
            }
           

           return a; 

        } 
        
        catch (SQLException ex) {
            
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

            } catch (SQLException e) {

                System.out.println(e);
            }
        }
        
        return a; 
        
    }
    
}
