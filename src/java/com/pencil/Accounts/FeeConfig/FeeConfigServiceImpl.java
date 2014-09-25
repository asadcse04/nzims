/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Accounts.FeeConfig;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author jahangiralamdiu
 */
public class FeeConfigServiceImpl implements FeeConfigService {

    @Override
    public boolean saveFeeConfig(FeeConfig feeConfigObj, List <SubFeeHeadDetail> subFeeHeadDetList, List<ClassDeptObj> classDeptList) {
       
            DB_Connection o = new DB_Connection();

            Connection con = o.getConnection();

            PreparedStatement prst = null;
            
            ResultSet rs=null;
            
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
            

            try 
            {
                int feeassignid=1;
                
                prst=con.prepareStatement("select distinct max(FeeAssignID) from student_fee_assign where InstituteID=?");
                prst.setString(1, institueID);
                rs=prst.executeQuery();
                
                if(rs.next()){
                  
                    feeassignid=rs.getInt(1)+1;
                }
                
               prst=null;
                
               con.setAutoCommit(false);
                
           
            prst=con.prepareStatement("insert into student_fee_assign values(?,(select StudentFeeID from student_fee where AcYrID=? and FeeHeadID=? and InstituteID=?),?,(select ClassID from class where ClassName=?),(select DepartmentID from department where DepartmentName=?),?,?,?)");
   
            for(ClassDeptObj classDeptObj : classDeptList) 
            {
          
                prst.setInt(1, feeassignid);
                
                prst.setInt(2, classDeptObj.getAcademicYear());
                
                prst.setInt(3, feeConfigObj.getFeeHeadID());
                
                prst.setString(4, institueID);
                
                prst.setInt(5, classDeptObj.getAcademicYear());
                
                prst.setString(6, classDeptObj.getClassName());
                
                prst.setString(7, classDeptObj.getDepartmentName());
                
                prst.setString(8, institueID);
                
                prst.setDouble(9, feeConfigObj.getAmount());
                
                prst.setString(10, feeConfigObj.getNote());
                           
                prst.addBatch();
            
            }
            
            int[] update = prst.executeBatch();
            
            con.commit();
            
            
            int feeDetailid=1;
                
                prst=con.prepareStatement("select distinct max(FeeDetailsID) from student_fee_details where InstituteID=?");
                prst.setString(1, institueID);
                rs=prst.executeQuery();
                
                if(rs.next()){
                  
                    feeDetailid=rs.getInt(1)+1;
                }
                
               prst=null;
     
            
            prst=con.prepareStatement("insert into student_fee_details values(?,?,?,?,?,?)");
       
            for(SubFeeHeadDetail subFeeHeadDetail:subFeeHeadDetList){
             
                prst.setInt(1, feeDetailid);
                prst.setInt(2, feeassignid);
                prst.setInt(3, subFeeHeadDetail.getSubFeeHeadID());
                prst.setString(4, institueID);
                prst.setDouble(5, subFeeHeadDetail.getAcceptence());
                prst.setDouble(6, (subFeeHeadDetail.getAcceptence()* feeConfigObj.getAmount()/100));
            
                prst.addBatch();
            }
            
            int[] updateStFeDt=prst.executeBatch();
            
            con.commit();
                
            
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

            return false;
        }
    
    @Override
    public List<SubFeeHeadDetail> getSubHeadDetail(FeeConfig feeConfig,ClassDeptDataList classDeptDataList)
    {
      List<SubFeeHeadDetail> subHeadDetailList = new ArrayList<SubFeeHeadDetail>();
      
      DB_Connection o = new DB_Connection();

            Connection con = o.getConnection();

            PreparedStatement prst = null;
            
            ResultSet rs = null;
            
             String institueID="";
             FacesContext context=FacesContext.getCurrentInstance();
             institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
          
            int ac=feeConfig.getAcyearid();
            
            int headid=feeConfig.getFeeHeadID();
            
            
            try 
            {
                prst = con.prepareStatement("select sfh.SubFeeHeadID,sfh.SubFeeName,sfh.Note from student_sub_fee_head sfh,student_subfee_config ssfc where sfh.InstituteID=ssfc.InstituteID and sfh.SubFeeHeadID=ssfc.SubFeeID and ssfc.StudentFeeID=(select StudentFeeID from student_fee where AcYrID=? and FeeHeadID=? and InstituteID=?) and sfh.InstituteID=?");
               
                prst.setInt(1, classDeptDataList.iterator().next().getAcademicYear());
                prst.setInt(2, feeConfig.getFeeHeadID());
                prst.setString(3, institueID);
                prst.setString(4, institueID);
                
                rs = prst.executeQuery();
                
                while(rs.next())
                {
                    subHeadDetailList.add(new SubFeeHeadDetail(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
                
                return subHeadDetailList;
     
            } 
            
            catch (SQLException ex) 
            {
                System.out.println(ex);
            } 
            
            finally 
            {
                try 
                {
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
      
        return subHeadDetailList;
           
    }
    
    @Override
    public List<ClassDeptObj> getClassDeptList()
    {
        
     List<ClassDeptObj> classDeptList = new ArrayList<ClassDeptObj>();
      
      DB_Connection o = new DB_Connection();

            Connection con = o.getConnection();

            PreparedStatement prst = null;
            
            ResultSet rs = null;
            
            ResultSet rs2 = null;

            try 
            {
                prst = con.prepareStatement("select distinct ClassID as ClassID, AcYrID, DeptID from classconfig");        
                
                rs = prst.executeQuery();
                
                while(rs.next())
                {
                    prst=con.prepareStatement("Select cl.ClassName, dp.DepartmentName from class cl, department dp where cl.ClassID=? and dp.DepartmentID=?");
                    
                    prst.setInt(1, rs.getInt("ClassID"));
                    
                    prst.setInt(2, rs.getInt("DeptID"));
                    
                    rs2 = prst.executeQuery();
                    
                   if(rs2.next())
                   {
                     classDeptList.add(new ClassDeptObj(rs.getInt("AcYrID"), rs2.getString("cl.ClassName"), rs2.getString("dp.DepartmentName")));
                   }
                }
                
                return classDeptList;
     
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex);
            } 
            finally 
            {
                try 
                {
                    if (rs != null) {

                        rs.close();

                    }
                    
                    if (rs2 != null) {

                        rs2.close();

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
        return classDeptList;
    }

    
}
