/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig.Routine;

import com.pencil.Connection.DB_Connection;
import com.pencil.ScClassConfig.Routine.ViewRoutine.OutLookRoutine;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahfuj
 */
public class ClassRoutineServiceImpl implements Serializable,ClassRoutineService
{

    /**
     *
     * @param cr
     * @param dayName
     * @param prdName
     * @param tchrid
     * @return
     */
    @Override
    public boolean save_Assign_Subject_Tchr(ClassRoutine cr, String dayName , String prdName, String tchrid)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        ResultSet rs=null;
        
        int i=0;
        
        try
        {
            prst = con.prepareStatement("SELECT 1 FROM routine_wrapper where DayName=? and"
                    + " PeriodID=(select periodID from period where periodName=? and shiftID=(select shiftID from shift where shiftName=?)) and"
                    + " ShiftID=(select shiftID from shift where shiftName=?) and TeacherID=?");
            
            prst.setString(1,dayName);
            
            prst.setString(2,prdName);
            
            prst.setString(3,cr.getShiftName());
            
            prst.setString(4,cr.getShiftName());
            
            prst.setString(5,tchrid);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                i=i+1;
            }
            
            rs.close();
            
            prst.close();
            
            if(i<1)
            {
                prst = con.prepareStatement("insert into routine_wrapper values(?,?,(select periodID from period where "
                    + "periodName=? and shiftID=(select shiftID from shift where shiftName=?)),(select shiftID from shift where shiftName=?),"
                    + "?,(select subjectID from subject where subjectName=?),?)");
            
                prst.setInt(1,cr.getScClassCnfID());
            
                prst.setString(2,dayName);
            
                prst.setString(3,prdName);
            
                prst.setString(4,cr.getShiftName());
            
                prst.setString(5,cr.getShiftName());
            
                prst.setString(6,tchrid);
            
                prst.setString(7,cr.getSubject());
            
                prst.setString(8,cr.getNote());
            
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
            
            cr = null;

            dayName = null;

            prdName = null;

            tchrid = null;
        }
        
        return false;
    }

    /**
     *
     * @param ClassCnfID
     * @param day
     * @param shift
     * @return
     */
    @Override
    public List<ClassRoutineUpdate> viewRoutine(int ClassCnfID,String day,String shift)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<ClassRoutineUpdate> routineList=new ArrayList<ClassRoutineUpdate>();
        
        try
        {
            prst = con.prepareStatement("select p.PeriodName, p.StartTime, p.EndTime, sbj.SubjectName, rw.SubjectNote,rw.TeacherID,t.TeacherName"
                    + " from routine_wrapper rw, subject sbj, teacher t, period p where rw.ClassCnfID=? and rw.DayName =? and"
                    + " (rw.PeriodID = p.PeriodID and rw.ShiftID = p.ShiftID) and rw.SubjectID = sbj.SubjectID and rw.TeacherID = t.TeacherID order by p.PeriodName");
            
            prst.setInt(1,ClassCnfID);
            
            prst.setString(2,day);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                routineList.add(new ClassRoutineUpdate(ClassCnfID,day,rs.getString("p.PeriodName"),rs.getString("p.StartTime"),rs.getString("p.EndTime"),shift,rs.getString("sbj.SubjectName"),rs.getString("rw.SubjectNote"),rs.getString("rw.TeacherID"),rs.getString("t.TeacherName")));
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
                if(con!=null) 
                { 
                    con.close(); 
                }  
            } 
            catch(SQLException e) 
            { 
                System.out.println(e); 
            }
            
            day = null;

            shift = null;
        } 
        
        return routineList;
    }

    /**
     *
     * @param crUpdate
     * @param flag
     * @return
     */
    @Override
    public boolean updateRoutine(ClassRoutineUpdate crUpdate,boolean flag)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        ResultSet rs = null;
        
        int count=0;
        
        int limit=1;
        
        if(flag==true)
        {
            limit=2;
        }
        
        try
        {
            prst = con.prepareStatement("SELECT 1 FROM routine_wrapper where DayName=? and"
                    + " PeriodID=(select periodID from period where periodName=? and shiftID=(select shiftID from shift where shiftName=?)) and"
                    + " ShiftID=(select shiftID from shift where shiftName=?) and TeacherID=?");
            
            prst.setString(1,crUpdate.getDay());
            
            prst.setString(2,crUpdate.getPeriodName());
            
            prst.setString(3,crUpdate.getShiftName());
            
            prst.setString(4,crUpdate.getShiftName());
            
            prst.setString(5,crUpdate.getTeacherID());
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                count=count+1;
            }
            
            rs.close();
            
            prst.close();
            
            if(count<limit)
            {
                prst = con.prepareStatement("update routine_wrapper set TeacherID=?, SubjectID=(select SubjectID from subject where SubjectName=?), SubjectNote=? where ClassCnfID=? and DayName=? and"
                        + " PeriodID=(select periodID from period where periodName=? and shiftID=(select shiftID from shift where shiftName=?))"
                        + " and ShiftID=(select shiftID from shift where shiftName=?)");
                
                prst.setString(1,crUpdate.getTeacherID());
                
                prst.setString(2,crUpdate.getSubjectName());
                
                prst.setString(3,crUpdate.getSubjectNote());
                
                prst.setInt(4,crUpdate.getSc_cnf_id());
                
                prst.setString(5,crUpdate.getDay());
            
                prst.setString(6,crUpdate.getPeriodName());
            
                prst.setString(7,crUpdate.getShiftName());
            
                prst.setString(8,crUpdate.getShiftName());
                
                prst.execute();
            
                return true; 
            }
            else
            {
                return false;
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
                if(con!=null) 
                { 
                    con.close(); 
                } 
                
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
            
            crUpdate=null;
        }
        
        return false;
    }

    /**
     *
     * @param ClassCnfID
     * @return
     */
    @Override
    public List<OutLookRoutine> OutLookCompleteRoutine(int ClassCnfID)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        CallableStatement cs = null;
        
        ResultSet rs = null;
        
        List<OutLookRoutine> routineList=new ArrayList<OutLookRoutine>();
        
        try
        {
            cs = con.prepareCall("{call view_class_routine(?)}");
            
            cs.setInt(1,ClassCnfID);
            
            cs.execute();
            
            rs = cs.getResultSet();
            
            while(rs.next())
            {
                routineList.add(new OutLookRoutine(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
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
        } 
        
        return routineList;
    }  
}
