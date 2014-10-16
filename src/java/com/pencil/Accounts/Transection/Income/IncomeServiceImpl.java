/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Income;

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
 * @author Riad
 */
public class IncomeServiceImpl implements IncomeService{
    
     @Override
     public boolean incomeCash(Income income)                             // author of this menthod Riyad
     
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
            
            prst.setString(3, "Income");
            
            prst.setString(4, income.getTranName());
            
            prst.setDouble(5, income.getTranAmount());
            
            prst.setInt(6, income.getTrSubHeadID());
            
            prst.setString(7, income.getInvoiceID());
            
            prst.setString(8, income.getPaymentType());
            
            prst.setString(9, income.getAttachedVoucherNo());
            
            prst.setString(10, income.getNote());
            
            prst.setInt(11, income.getBankID());
            
            prst.setString(12, income.getBankName());
            
            prst.setString(13, income.getCheckNo());
            
            prst.setString(14, null);
            
            int add = prst.executeUpdate();
            
            
            if(income.getBankID() !=0)
            {
            
            prst=con.prepareStatement("update bank_account set TotalDiposit=(TotalDiposit+"+income.getTranAmount()+"), Balance=(TotalDiposit-TotalWithdraw) where BankAcID="+income.getBankID()+" and InstituteID=?");

            prst.setString(1, institueID);
            
            int up=prst.executeUpdate();
            
            
            
            prst=con.prepareStatement("insert into banktrn_details (BankID,InstituteID,Date,Status,Amount,AmountType,TrnName,SubheadName,SubheadID) values (?,?,?,?,?,?,?,?,?)");
            
            prst.setInt(1, income.getBankID());
            
            prst.setString(2, institueID);
            
            prst.setDate(3, new java.sql.Date(new Date().getTime()));
            
            prst.setString(4, "Deposit");
            
            prst.setDouble(5, income.getTranAmount());
            
            prst.setString(6,"Cash");
            
            prst.setString(7, "Bank Transection");
            
            prst.setString(8, income.getTranName());
            
            prst.setInt(9, income.getTrSubHeadID());
            
            int insertBankTranDetails=prst.executeUpdate();
            
            
            
            
            prst=con.prepareStatement("update cash_summery set bankIn=(bankIn+"+income.getTranAmount()+"),bankBalance=(bankIn-bankOut) where InstituteID=?");
            prst.setString(1, institueID);
            int upcashsummurybank=prst.executeUpdate();
            
            }
            
            
            
            if(income.getPaymentType().equals("Cash")){
            
            prst=con.prepareStatement("update cash_summery set cashIn=(cashIn+"+income.getTranAmount()+"),cashBalance=(cashIn-cashOut) where InstituteID=?");
            prst.setString(1, institueID);
            int upcashsummurycash=prst.executeUpdate();
                
            }
            
             if(income.getPaymentType().equals("Check")){
            
            prst=con.prepareStatement("update cash_summery set checkIn=(checkIn+"+income.getTranAmount()+"),checkBalance=(checkIn-checkOut) where InstituteID=?");
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
    
     
     public List<String> transactionCatList(String income){
       
        List<String> trlist=new ArrayList<String>();
         
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        ResultSet rs=null;
        
        try {
            prst = con.prepareStatement("select TrCatagoryName from transectioncatagory where TrType=? and InstituteID=?");
            
            prst.setString(1, income);
            prst.setString(2,institueID);
            
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
            
            prst.setString(2, institueID);
            
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
     
     @Override
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
            
            System.out.println("list size "+ bankidlist.size());
        
           return bankidlist;
        
        } 
        
        catch (SQLException ex) 
        
        {
            System.out.println("value not found");
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
