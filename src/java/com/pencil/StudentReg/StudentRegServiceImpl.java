/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentReg;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author salim
 */
public class StudentRegServiceImpl implements Serializable,StudentRegService
{

    @Override
    public boolean quickStudentReg(int scCnf_ID, List<StudentReg> studentList)
   {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        try
        {
        con.setAutoCommit(false);
        
        for (StudentReg stdreg : studentList) {

               Long.parseLong(stdreg.getGuardianContactNo());
               
               prst=con.prepareStatement("insert into student_basic_info (StudentID,StudentName,StudentRoll,Gender,Status) values(?,?,?,?,?)");
               
               prst.setString(1, String.valueOf(stdreg.getStudentId()));
               prst.setString(2, stdreg.getStudentName());   
               prst.setInt(3, stdreg.getStudentRoll());
               prst.setString(4, stdreg.getGender());
               prst.setBoolean(5,true);
               
               prst.execute();
               prst.close();
         
               
               prst=con.prepareStatement("insert into student_guardian_info (FatherName,ContactNo,StudentID) values(?,?,?)");
            
               prst.setString(1,stdreg.getFatherName());
               prst.setString(2,stdreg.getGuardianContactNo());
               prst.setString(3,String.valueOf(stdreg.getStudentId()));
               
               prst.execute();
               prst.close();
               
               prst=con.prepareStatement("insert into student_identification (ClassConfigID,StudentID) values(?,?)");
            
               prst.setInt(1,scCnf_ID);
               prst.setString(2,String.valueOf(stdreg.getStudentId()));
            
               prst.execute();
               prst.close();
               
          
        }
        
        con.commit();
       
        return true; 

        }
        catch(SQLException | NumberFormatException e)
        {
            System.out.println(e);
        }
        finally
        { 
            try
            {
                if(prst!=null) 
                { 
                    prst.close(); 
                } 
                if(con!=null)
                { 
                    con.close(); 
                } 
            } 
            catch(SQLException e) 
            { 
                System.out.println(e); 
            }

        } 
        
      return false;
    }

    @Override
    public List<StudentReg> getStudent_insertList()
    {

        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        ResultSet rs=null;
        
        int StudentId=0;
        
        List<StudentReg> student_List=new ArrayList<StudentReg>();
        
        String qr ="SELECT max(CAST(StudentID  AS UNSIGNED)) as StudentID from student_basic_info";
        try{
            prst = con.prepareStatement(qr);
 
            rs = prst.executeQuery();
           
           StudentReg sReg = new StudentReg();
           
            while (rs.next())
            {        
                StudentId=rs.getInt("StudentID");
               
            }
             if(StudentId==0)
            {
                StudentId=10000;
            }
            
            sReg.setStudentId((StudentId)+1);  
            
            student_List.add(sReg);
           
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        { 
            try
            { 
                if(rs!=null) 
                { 
                    rs.close(); 
                } 
                if(prst!=null) 
                { 
                    prst.close(); 
                } 
                if(con!=null) 
                { 
                    con.close(); 
                } 
            } 
            catch(SQLException e) 
            { 
                System.out.println(e); 
            }

        } 
        
        return student_List;
   }


    
}
