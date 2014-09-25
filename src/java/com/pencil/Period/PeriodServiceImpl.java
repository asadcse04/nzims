/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Period;

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
 * @author Mamun
 */
public class PeriodServiceImpl implements PeriodService,Serializable
{
    @Override
    public List<Period> periodList() 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<Period> prdlist=new ArrayList<Period>();
        
        try
        {
            prst = con.prepareStatement("select p.PeriodID, p.PeriodName, p.StartTime, p.EndTime, s.ShiftName from period p,shift s"
                    + " where p.ShiftID=s.ShiftID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                prdlist.add(new Period(rs.getInt("p.PeriodID"),rs.getString("p.PeriodName"),rs.getString("p.StartTime"),rs.getString("p.EndTime"),rs.getString("s.ShiftName")));
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

        return prdlist;
    }

    @Override
    public boolean createPeriod(Period prd)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into period values(null,?,?,?,(select ShiftID from shift where ShiftName=?))");
            
            prst.setString(1,prd.getPeriodName());
            
            prst.setString(2,prd.getStartTime());
            
            prst.setString(3,prd.getEndTime());
            
            prst.setString(4,prd.getShiftName());
            
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
    public boolean updatePeriod(Period prdObj)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("update period set PeriodName=?,StartTime=?,EndTime=?,ShiftID=(select ShiftID from shift where ShiftName=?) where PeriodID=?");
       
            prst.setString(1,prdObj.getPeriodName());
            
            prst.setString(2,prdObj.getStartTime());
            
            prst.setString(3,prdObj.getEndTime());
            
            prst.setString(4,prdObj.getShiftName());
            
            prst.setInt(5,prdObj.getPeriodID());
            
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
    public List<String> shiftNameList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> shftNmList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("select ShiftName from shift");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                shftNmList.add(rs.getString("ShiftName"));
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
        
        return shftNmList;
    }
    
}
