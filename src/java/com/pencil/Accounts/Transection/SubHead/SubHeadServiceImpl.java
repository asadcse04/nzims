/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.SubHead;

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
public class SubHeadServiceImpl implements Serializable,SubHeadService
{

    @Override
    public boolean createSubHead(SubHead sh) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into transection_subhead values(null,?,?,(select TrMainHeadID from transection_mainhead where MainHeadName=?),now(),null)");
                 
            prst.setString(1, sh.getSubHeadName());
             
            prst.setString(2, sh.getNote());
            
            prst.setString(3, sh.getTrMainHeadName());
             
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
    public boolean updateSubHead(SubHead shobj) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {                    
            prst= con.prepareStatement("update transection_subhead set SubHeadName=?,Note=?,TrMainHeadID=(select TrMainHeadID from transection_mainhead where MainHeadName=?),CreateDate=now(),UserID=null where TrSubHeadID=?");
      
            prst.setString(1,shobj.getSubHeadName());
            
            prst.setString(2,shobj.getNote());
            
            prst.setString(3,shobj.getTrMainHeadName());
            
            prst.setInt(4,shobj.getTrSubHeadID());
            
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
    public List<SubHead> subHeadList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<SubHead> sub_head_list=new ArrayList<SubHead>();
        
        try
        {         
              prst = con.prepareStatement("select tsh.TrSubHeadID, tsh.SubHeadName, tsh.Note, tmh.MainHeadName, tsh.CreateDate, tsh.UserID from transection_subhead tsh, transection_mainhead tmh"
                    + " where tsh.TrMainHeadID = tmh.TrMainHeadID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                sub_head_list.add(new SubHead(rs.getInt("tsh.TrSubHeadID"),rs.getString("tsh.SubHeadName"),rs.getString("tsh.Note"),rs.getString("tmh.MainHeadName"),rs.getDate("tsh.CreateDate"),rs.getInt("tsh.UserID")));
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

        return sub_head_list;
    }

    @Override
    public List<String> mainHead_List(String trCategoryName) 
    {
       DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> mainHead_list=new ArrayList<String>();
        
        try
        { 
            prst = con.prepareStatement("SELECT distinct mh.MainHeadName from transection_mainhead mh,transectioncatagory tc where tc.TrCatagoryID=mh.TrCatagoryID and TrCatagoryName=?");
            
            prst.setString(1,trCategoryName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                mainHead_list.add(rs.getString("mh.MainHeadName"));
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
        
        return mainHead_list;
    }
    
}
