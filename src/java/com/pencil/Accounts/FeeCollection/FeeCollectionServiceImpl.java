/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Accounts.FeeCollection;

import com.pencil.Connection.DB_Connection;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author jahangiralamdiu
 */
public class FeeCollectionServiceImpl implements FeeCollectionService {

    @Override
    public List<FeeInvDetObj> getStudentAllinfo(String id) {

        List<FeeInvDetObj> feereceivelist = new ArrayList<FeeInvDetObj>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String institueID = "";
        FacesContext context = FacesContext.getCurrentInstance();
        institueID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {

            String query = "SELECT sb.StudentID,sb.StudentName, sb.StudentRoll,sb.Gender,sg.FatherName,sg.ContactNo,acyr.AcYrID,\n"
                    + " c.ClassName,d.DepartmentName,s.ShiftName,sctn.SectionName\n"
                    + " from student_basic_info sb,student_guardian_info sg,classconfig scCnf,\n"
                    + " student_identification si,academic_year acyr,\n"
                    + " department d,class c,shift s,section sctn\n"
                    + " where sg.StudentID=sb.StudentID and sb.InstituteID=sg.InstituteID and sb.InstituteID=scCnf.InstituteID \n"
                    + " and sb.InstituteID=si.InstituteID and sb.InstituteID=sctn.InstituteID and si.StudentID=sb.StudentID and\n"
                    + " si.ClassConfigID=scCnf.ScConfigID and scCnf.AcYrID=acyr.AcYrID and \n"
                    + " scCnf.DeptID=d.DepartmentID and\n"
                    + " scCnf.ClassID=c.ClassID and scCnf.ShiftID=s.ShiftID and \n"
                    + " scCnf.SectionID=sctn.SectionID and sb.InstituteID=? and sb.StudentID=?";

            prst = con.prepareStatement(query);

            prst.setString(1, institueID);

            prst.setString(2, id);

            rs = prst.executeQuery();

            while (rs.next()) {

                feereceivelist.add(new FeeInvDetObj(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                System.out.println("" + rs.getString(2));
            }

            return feereceivelist;
        } catch (SQLException e) {
        } finally {
            try {

                if (prst != null) {
                    prst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException sql) {
            }
        }

        return feereceivelist;
    }

    public double getFeeAmount(FeeInvDetObj feeInvDetObj) {

        double amount = 0.0;

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        System.out.println("academic year " + feeInvDetObj.getAcademicyear());
//        System.out.println("Feeid "+feeInvDetObj.getFeename());
//        System.out.println("ac year "+feeInvDetObj.getAcademicyearid());
//        System.out.println("class name  "+feeInvDetObj.getClassname());
//        System.out.println("dept name "+feeInvDetObj.getDepartname());

        try {

            String query = "select Amount from student_fee_assign where StudentFeeID=(select StudentFeeID from student_fee\n"
                    + "where AcYrID=? and FeeHeadID=?) and AcYrID=? and Class=(select ClassID from \n"
                    + "class where ClassName=?) and Dept=(select DepartmentID from department where \n"
                    + "DepartmentName=?);";

            prst = con.prepareStatement(query);

            prst.setInt(1, feeInvDetObj.getAcademicyearid());
            prst.setInt(2, Integer.parseInt(feeInvDetObj.getFeename().split("-")[0]));
            prst.setInt(3, feeInvDetObj.getAcademicyearid());
            prst.setString(4, feeInvDetObj.getClassname());
            prst.setString(5, feeInvDetObj.getDepartname());

            rs = prst.executeQuery();

            while (rs.next()) {

                amount = rs.getInt(1);
            }

            return amount;
        } catch (SQLException e) {
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
            } catch (SQLException sql) {
            }
        }

        return amount;
    }

    public boolean saveFeeRecord(List<FeeInvDetObj> listInvoice, FeeInvDetObj feeInvDetObj) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement pstm = null;

        ResultSet rs = null;

        String institueID = "";
        FacesContext context = FacesContext.getCurrentInstance();
        institueID = context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            int invoiceid = 0;
            int invoicedetail=0;

            pstm = con.prepareStatement("select max(InvoiceID) from student_fee_invoice where InstituteID=?");
            pstm.setString(1, institueID);
            rs = pstm.executeQuery();

            if (rs.next()) {
                if (rs.getInt(1)> 0) {
                    invoiceid = rs.getInt(1)+1;
                } else {
                    invoiceid = 1;
                }
            }
            
            pstm = con.prepareStatement("select max(InvoiceDetailID) from student_fee_invoice_detail where InstituteID=?");
            pstm.setString(1, institueID);
            rs = pstm.executeQuery();

            if (rs.next()) {
                if (rs.getInt(1)> 0) {
                    invoicedetail = rs.getInt(1)+1;
                } else {
                    invoicedetail = 1;
                }
            }
         

            con.setAutoCommit(false);

            pstm = con.prepareStatement("insert into student_fee_invoice values(?,?,(select ClassID from class where ClassName=?),?,?,?)");
            pstm.setInt(1, invoiceid);
            pstm.setString(2, feeInvDetObj.getStudentID());
            pstm.setString(3, feeInvDetObj.getClassname());
            pstm.setDouble(4, feeInvDetObj.getTotalAmount());
            pstm.setDate(5, new java.sql.Date(new Date().getTime()));
            pstm.setString(6, institueID);
            
            pstm.execute();
            
            pstm=con.prepareStatement("update cash_summery set cashIn=cashIn+?,cashBalance=cashIn-cashOut where InstituteID=?");
            pstm.setDouble(1, feeInvDetObj.getTotalAmount());
            pstm.setString(2, institueID);
            
            pstm.execute();
            
            pstm=con.prepareStatement("insert into student_fee_invoice_detail values(?,?,?,(select ClassID from class where ClassName=?),?,?,?,?)");
           
            for(FeeInvDetObj fi: listInvoice){
                
             pstm.setInt(1, invoicedetail);
             pstm.setInt(2, invoiceid);
             pstm.setString(3, feeInvDetObj.getStudentID());
             pstm.setString(4, feeInvDetObj.getClassname());
             pstm.setInt(5, fi.getFeeid());
             pstm.setDate(6, new java.sql.Date(new Date().getTime()));
             pstm.setDouble(7, fi.getPaidAmount());
             pstm.setString(8, institueID);
            
             pstm.addBatch();
            
             invoicedetail++;
            }
            pstm.executeBatch();

            con.commit();
            
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {

                if (rs != null) {

                    rs.close();

                }

                if (pstm != null) {

                    pstm.close();

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
    
    
    public boolean sendSms(FeeInvDetObj feeInvDetObj, int smsBal){
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();
        
        Connection cn = o.getSms_db_Connection();

        PreparedStatement prst = null;
        
        CallableStatement cs = null;
        
        SMS_Service smsService=new SMS_ServiceImpl();
        
        String instituteID="";
        String InstituteName="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        InstituteName=context.getExternalContext().getSessionMap().get("SchoolFullName").toString();
        
        
        int instituteId=Integer.valueOf(instituteID);

        int count=0;

         try
        {
            if(smsBal!=0)
            {
            
            smsService.sendIndividual_Sms(feeInvDetObj.getContactno(), "Student Name :"+feeInvDetObj.getStudentname()+" "+feeInvDetObj.getTotalAmount()+" Taka received cordially from "+InstituteName+"");
              
            count=1;
 
            cs = cn.prepareCall("{call smsCntManage(?,?)}");

            cs.setInt(1, count);
                
            cs.setInt(2, instituteId); 

            cs.execute();
            
            return true;
            }
        }
        catch(SQLException ex)
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
                    if (cs != null)
                    {
                        cs.close();
                    }
                    if (con != null)
                    {
                        con.close();
                    }
                } 
                catch (SQLException ex)
                {
                    System.out.println(ex);
                }

              
            }
    
 
        return false;
        }


}