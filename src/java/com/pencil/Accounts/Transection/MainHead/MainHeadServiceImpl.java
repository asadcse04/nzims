/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.MainHead;

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
 * @author Mastermind
 */
public class MainHeadServiceImpl implements Serializable,MainHeadService
{

    @Override
    public boolean createMainHead(MainHead mh)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into transection_mainhead values(null,?,?,(select TrCatagoryID from transectioncatagory where TrCatagoryName=?),now(),null)");
                 
            prst.setString(1, mh.getMainHeadName());
             
            prst.setString(2, mh.getNote());
            
            prst.setString(3, mh.getTrCatagoryName());
             
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
    public boolean updateMainHead(MainHead mhobj)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {        
            prst= con.prepareStatement("update transection_mainhead set MainHeadName=?,Note=?,TrCatagoryID=(select TrCatagoryID from transectioncatagory where TrCatagoryName=?),CreateDate=now(),UserID=null where TrMainHeadID=?");
      
            prst.setString(1,mhobj.getMainHeadName());
            
            prst.setString(2,mhobj.getNote());
            
            prst.setString(3,mhobj.getTrCatagoryName());
            
            prst.setInt(4,mhobj.getTrMainHeadID());
            
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
    public List<MainHead> mainHeadList() 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<MainHead> main_head_list=new ArrayList<MainHead>();
        
        try
        {
              prst = con.prepareStatement("select tmh.TrMainHeadID, tmh.MainHeadName, tmh.Note, tc.TrCatagoryName, tmh.CreateDate, tmh.UserID from transection_mainhead tmh, transectioncatagory tc"
                    + " where tmh.TrCatagoryID = tc.TrCatagoryID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                main_head_list.add(new MainHead(rs.getInt("tmh.TrMainHeadID"),rs.getString("tmh.MainHeadName"),rs.getString("tmh.Note"),rs.getString("tc.TrCatagoryName"),rs.getDate("tmh.CreateDate"),rs.getInt("tmh.UserID")));
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

        return main_head_list;
    }

    @Override
    public List<String> category_List(String trType)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> catelist=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct TrCatagoryName from transectioncatagory where TrType=?");
            
            prst.setString(1,trType);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                catelist.add(rs.getString("TrCatagoryName"));
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
        
        return catelist;
    }
    
}
