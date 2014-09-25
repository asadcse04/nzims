/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.StudentAttendance;

import com.pencil.Connection.DB_Connection;
import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.InstituteSetup.InstituteSetup;
import com.pencil.InstituteSetup.InstituteSetupService;
import com.pencil.InstituteSetup.InstituteSetupServiceImpl;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import com.pencil.ScClassConfig.ScClassConfig;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
public class StudentAttendance_Service_Impl implements Serializable,StudentAttendance_Service
{
    @Override
    public List<StudentAttendanceReport> attendanceReport(Date from, Date to,StringBuilder scCnf)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        CallableStatement cs = null;
        
        ResultSet rs = null;
        
        List<StudentAttendanceReport> attnd_rpt_list=new ArrayList<StudentAttendanceReport>();
        
        try
        {
            cs = con.prepareCall("{call st_attendance_report(?,?,?)}");
            
            cs.setString(1,scCnf.toString().replace(",","|"));
            
            cs.setDate(2,new java.sql.Date(from.getTime()));
            
            cs.setDate(3,new java.sql.Date(to.getTime()));
            
            cs.execute();
            
            rs = cs.getResultSet();
            
            while(rs.next())
            {
                attnd_rpt_list.add(new StudentAttendanceReport(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
            }
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
                if(cs!=null) 
                { 
                    cs.close(); 
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
            
            from=null;
            
            to=null;
            
            scCnf=null;
        } 
        return attnd_rpt_list;
    }
    
    

    @Override
    public boolean saveAttendance(StudentAttendance sa)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs;
        
        int i=0;
        
        try 
        {
            prst=con.prepareStatement("select 1 from student_attendence where AttendanceDate=? and StudentID=?");
            
            prst.setDate(1,new java.sql.Date(sa.getAttendance_date().getTime()));
            
            prst.setString(2,sa.getStudentID());
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                i++;
            }
            
            rs.close();
            
            prst.close();
            
            if(i<1)
            {
                prst = con.prepareStatement("insert into  student_attendence values(?,?,?,?)");
                
                prst.setDate(1,new java.sql.Date(sa.getAttendance_date().getTime()));
                
                prst.setBoolean(2,sa.isAbsent());
                
                prst.setString(3,sa.getRemarks());
                
                prst.setString(4,sa.getStudentID());
                
                prst.execute();
                
                return true;
            }
            else
            {
                prst = con.prepareStatement("update student_attendence set Absent=?, Note=? where AttendanceDate=? and StudentID=?");
                
                prst.setBoolean(1,sa.isAbsent());
                
                prst.setString(2,sa.getRemarks());
                
                prst.setDate(3,new java.sql.Date(sa.getAttendance_date().getTime()));
                
                prst.setString(4,sa.getStudentID());
                
                prst.execute();
                
                return true;
            }          
        }
        catch(SQLException e)
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
            
            sa=null;
        }
        
        return false;
    }

    @Override
    public int completeAttendance(Date ad, List<Student_Registration> studentList,StringBuilder scCnf,int smsBalnc,boolean sms_with_attendance)
    {
        List<String> studentID=new ArrayList<String>();
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        Statement stmt = null;
        
        ResultSet rs = null;
               
        StringBuilder std_list_id=new StringBuilder();
        
        int rc=0;//response code
        
        System.out.println(scCnf.toString());
        
        try
        {
            prst=con.prepareStatement("select distinct sa.StudentID FROM student_attendence sa,student_identification si where si.StudentID=sa.StudentID "
                    + "and si.ClassConfigID IN('"+scCnf.toString()+"') and sa.AttendanceDate=?");
           
            //prst.setString(1,scCnf.toString());
            
            prst.setDate(1,new java.sql.Date(ad.getTime()));
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                studentID.add(rs.getString("StudentID"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
            
            System.out.println("I am not ok block-1......................");
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
            }
            catch(SQLException e)
            {
                System.out.println(e);
                
                System.out.println("I am not ok block-2");
            }
        }
  
        try
        {
            stmt=con.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println(e);
            
            System.out.println("I am not ok block-3");
        }
        
   
        
        
        
        //if(!studentID.isEmpty())
        //{
        for (int i = 0; i < studentID.size(); i++)
        {
            for (int j = 0; j < studentList.size(); j++)
            {
                if (studentID.get(i).equals(studentList.get(j).getStudentID()))
                {
                    studentList.remove(j);
                }
            }//End inner For

                //System.out.println("Absent Student:"+studentID.get(i));
            std_list_id.append(studentID.get(i));

            std_list_id.append(" ");

        }
        
        //End Outer For
        //}
        
        
       Iterator<Student_Registration> itr=studentList.iterator();
        
        while(itr.hasNext())
        {
            Student_Registration sr=itr.next();
            
            try
            {
//            stmt.addBatch("insert into student_attendence values('"+new java.sql.Date(ad.getTime())+"',"+false+",'"+5+"','"+sr.getStudentID()+"')");
                if(sr.isAbsent()){
                    
                    stmt.addBatch("insert into student_attendence(AttendanceDate,Absent,Note,Period,StudentID) values('"+new java.sql.Date(ad.getTime())+"',"+true+",'"+sr.getNote()+"','"+sr.getPeriod()+"','"+sr.getStudentID()+"')");
                    
                    std_list_id.append(sr.getStudentID());

                    std_list_id.append(",");
                }
                else
                    stmt.addBatch("insert into student_attendence(AttendanceDate,Absent,Note,Period,StudentID) values('"+new java.sql.Date(ad.getTime())+"',"+false+",'"+"present"+"','"+5+"','"+sr.getStudentID()+"')");
            }
            catch(SQLException e)
            {
                System.out.println(e);
                
                System.out.println("I am not ok block-4");
            }    
        }
        
        try
        {
            stmt.executeBatch();
            
            if(!sms_with_attendance)
            {
                if (std_list_id.length() > 0)
                {
                    std_list_id.setLength(std_list_id.length() - 1);

                    rc = getStudentGuardianNumber(std_list_id, smsBalnc);
                } 
                else
                {
                    rc = 100;
                }
            }
            else
            {
                rc=150;
            } 
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                if(stmt!=null)
                {
                    stmt.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
                
                System.out.println("I am not ok block-5");
            }
            
            studentID.clear();
        
            studentList.clear();
        
            scCnf.setLength(0);
        }
        
        return rc;
    }
    
    
    public int getStudentGuardianNumber(StringBuilder stdList,int smsBal) 
    {
        System.out.println("smsbalance::"+smsBal);
        
        System.out.println(stdList.length());
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        Connection cn=o.getSms_db_Connection();
        
        PreparedStatement prst = null;
        
        CallableStatement cs = null;
        
        ResultSet rs = null;

        ResultSet rs1 = null;
        
        
        
        String instituteID="";
        
        String message="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        int instituteId=Integer.valueOf(instituteID);
        
        try{
           prst=con.prepareStatement("select message from attendence_message where institute_id=?");
           prst.setString(1, instituteID);
           rs1=prst.executeQuery();
           
           if(rs1.next()){
           message=rs1.getString(1);
           }
            }
        catch(SQLException e){
            System.out.println(""+e); 
        }
        
//        InstituteSetupService instituteService = new InstituteSetupServiceImpl();
//        
//        InstituteSetup institute = new InstituteSetup();
//        
//        institute = instituteService.instituteSetup();
//        
//        int instituteId = Integer.valueOf(institute.getInstituteID());
        
            
        SMS_Service smsService=new SMS_ServiceImpl();
             
        int count=0;
        
        String[] std_arry=stdList.toString().split("\\,");
        
        int responseCode;
        
        //int std_arry_lenth=std_arry.length;
        

        try
        {
            if(smsBal!=0)
            {
                prst = con.prepareStatement("SELECT sb.StudentName, sg.ContactNo FROM student_guardian_info sg,student_basic_info sb where sg.StudentID=sb.StudentID and sb.StudentID=?");

                for (String studentid : std_arry)
                {
                    prst.setString(1, studentid);

                    rs = prst.executeQuery();


                    if ((rs.next()) && (count <= smsBal))
                    {
                       
                        
                        
                        if (smsService.sendIndividual_Sms(rs.getString("sg.ContactNo"), "Student Name:'"+ rs.getString("sb.StudentName")+"'"+message+"'") == 200)
                         {
                         count++;
                         }

                      //  count++;
                    }
                }//end for 

                cs = cn.prepareCall("{call smsCntManage(?,?)}");

                cs.setInt(1, count);

                //cs.setInt(2, 1); //school id
                
                 cs.setInt(2, instituteId); //school id

                cs.execute();
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
                if (rs != null)
                {
                    rs.close();
                }
                
                 if (rs1 != null)
                {
                    rs1.close();
                }
                 
             
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
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            
            stdList.setLength(0);
        }
        
        System.out.println("Count attendence sms:"+count);
        
        System.out.println("Student:"+std_arry.length);
        
        if(smsBal!=0)
        {
            if (count == std_arry.length)
            {
                responseCode = 200;
            } 
            else 
            {
                responseCode = 111;
            }
        }
        else
        {
            responseCode = 150;
        }
       
        std_arry=null;
        
        count=0;
        
        return responseCode;
    }

    @Override
    public List<ScClassConfig> scClassConfiguration_List()
    {
         DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID="";

        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<ScClassConfig> scCnfList=new ArrayList<ScClassConfig>();

        try
        {
          
            
          prst = con.prepareStatement("SELECT scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName,count(si.StudentID) as TotalStudentCount" 
                    +" FROM classconfig scCnf,class c,shift s,section sctn,student_identification si where scCnf.ClassID=c.ClassID and"
                    +" scCnf.InstituteID=sctn.InstituteID and sctn.InstituteID=si.InstituteID" 
                    +" and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.ScConfigID=si.ClassConfigID and si.InstituteID='"+instituteID+"' group by scCnf.AcYrID,c.ClassName,s.ShiftName,sctn.SectionName order by scCnf.ScConfigID");
            
          rs = prst.executeQuery();
              
            while(rs.next())
            {
                scCnfList.add(new ScClassConfig(rs.getInt("scCnf.AcYrID"),rs.getString("c.ClassName"),rs.getString("s.ShiftName"),rs.getString("sctn.SectionName"),rs.getInt("TotalStudentCount")));
            }
      
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
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        }
      
        return scCnfList;
    }
    
}
