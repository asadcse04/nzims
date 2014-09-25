/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCollection;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jahangiralamdiu
 */
public class FeeCollectionServiceImpl implements FeeCollectionService {
    
    @Override
    public List<FeeInvDetObj> getStudentAllinfo(int id){
    
      List<FeeInvDetObj> feereceivelist=new ArrayList<FeeInvDetObj>();
       
      DB_Connection o = new DB_Connection();

      Connection con = o.getConnection();

      PreparedStatement prst = null;

      ResultSet rs = null;
      
      try{
          
        String query="SELECT sb.StudentID,sb.StudentName, sb.StudentRoll,sb.Gender,sg.FatherName,sg.ContactNo,acyr.AcYrID,\n" +
                     "c.ClassName,d.DepartmentName,s.ShiftName,sctn.SectionName\n" +
                     "from student_basic_info sb,student_guardian_info sg,classconfig scCnf,\n" +
                     "student_identification si,academic_year acyr,\n" +
                     "department d,class c,shift s,section sctn\n" +
                     "where sg.StudentID=sb.StudentID and si.StudentID=sb.StudentID and\n" +
                     "si.ClassConfigID=scCnf.ScConfigID and scCnf.AcYrID=acyr.AcYrID and \n" +
                     "scCnf.DeptID=d.DepartmentID and\n" +
                     "scCnf.ClassID=c.ClassID and scCnf.ShiftID=s.ShiftID and \n" +
                     "scCnf.SectionID=sctn.SectionID and sb.StudentID=?";
        
        prst=con.prepareStatement(query);
        
        prst.setInt(1, id);
        
        rs=prst.executeQuery();
        
        while(rs.next()){
          
       feereceivelist.add(new FeeInvDetObj(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)));
            System.out.println(""+rs.getString(2));
        }
        
        return feereceivelist;   
      }
      catch(SQLException e){
      }
      
      finally
      {
          try{
             
              if(prst !=null){
                  prst.close();
              }
              
              if(con !=null){
                  con.close();
              }
          }
          
          catch(SQLException sql){
          }
      }
      
      return feereceivelist;
    }
    
    public double getFeeAmount(FeeInvDetObj feeInvDetObj){
        
      double amount=0.0;
       
      DB_Connection o = new DB_Connection();

      Connection con = o.getConnection();

      PreparedStatement prst = null;

      ResultSet rs = null;
      
       System.out.println("academic year "+feeInvDetObj.getAcademicyear());
//        System.out.println("Feeid "+feeInvDetObj.getFeename());
//        System.out.println("ac year "+feeInvDetObj.getAcademicyearid());
//        System.out.println("class name  "+feeInvDetObj.getClassname());
//        System.out.println("dept name "+feeInvDetObj.getDepartname());
      
      try{
          
        String query="select Amount from student_fee_assign where StudentFeeID=(select StudentFeeID from student_fee\n" +
                     "where AcYrID=? and FeeHeadID=?) and AcYrID=? and Class=(select ClassID from \n" +
                     "class where ClassName=?) and Dept=(select DepartmentID from department where \n" +
                     "DepartmentName=?);";
        
        prst=con.prepareStatement(query);
        
        prst.setInt(1, feeInvDetObj.getAcademicyearid());
        prst.setInt(2, Integer.parseInt(feeInvDetObj.getFeename().split("-")[0]));
        prst.setInt(3, feeInvDetObj.getAcademicyearid());
        prst.setString(4, feeInvDetObj.getClassname());
        prst.setString(5, feeInvDetObj.getDepartname());
        
        rs=prst.executeQuery();
        
        while(rs.next()){
          
            amount=rs.getInt(1);
        }
        
        return amount;   
      }
      catch(SQLException e){
      }
      
      finally
      {
          try{
              
              if(rs !=null){
                  rs.close();
              }
             
              if(prst !=null){
                  prst.close();
              }
              
              if(con !=null){
                  con.close();
              }
          }
          
          catch(SQLException sql){
          }
      }
      
      return amount;
    }
    
}
