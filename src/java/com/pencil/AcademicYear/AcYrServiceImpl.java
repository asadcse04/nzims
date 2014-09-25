/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.AcademicYear;

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
 * @author user
 */
public class AcYrServiceImpl implements AcYrService,Serializable
{
   
    @Override
    public List<AcademicYear> academicYrList()
    {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
     
    
        List<AcademicYear> acyrlist=new ArrayList<AcademicYear>();
        
        try
        {
            prst = con.prepareStatement("SELECT * FROM academic_year ");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                acyrlist.add(new AcademicYear(rs.getInt("AcYrID"),rs.getDate("StartTime"),rs.getDate("EndTime"),rs.getString("Note")));
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
        }
        return acyrlist;
    }

    @Override
    public boolean createAcYr(AcademicYear acyr)
    {
       DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into academic_year values(?, ?, ?, ?)");
                  
            prst.setInt(1, acyr.getAcYrID());
             
            prst.setDate(2, new java.sql.Date(acyr.getStartTime().getTime()));
            
            prst.setDate(3, new java.sql.Date(acyr.getEndTime().getTime()));
             
            prst.setString(4, acyr.getNote());
              
            
            prst.execute();
               
            prst.close();
               
            con.close();
               
            return true;  
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                if((prst.isClosed()==false) || (prst!=null))
                {
                    prst.close();
                }
                if((con.isClosed()==false) || (con!=null))
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
    public boolean updateAcYr(AcademicYear acyrObj)
    {
     
     DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("update academic_year set StartTime=?, EndTime=?, Note=? where AcYrID=?");
       
            prst.setDate(1, new java.sql.Date(acyrObj.getStartTime().getTime()));
            
            prst.setDate(2, new java.sql.Date(acyrObj.getEndTime().getTime()));
             
            prst.setString(3, acyrObj.getNote());
            
            prst.setInt(4,acyrObj.getAcYrID());
         
            
            prst.execute();
               
            prst.close();
               
            con.close();
               
            return true;  
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                if((prst.isClosed()==false) || (prst!=null))
                {
                    prst.close();
                }
                if((con.isClosed()==false) || (con!=null))
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
    
}
