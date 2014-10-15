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
import javax.faces.context.FacesContext;

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
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            prst= con.prepareStatement("insert into transection_mainhead values(null,?,?,?,(select TrCatagoryID from transectioncatagory where TrCatagoryName=? and InstituteID=?),now(),null)");
             
            prst.setString(1, institueID);
            prst.setString(2, mh.getMainHeadName());
            prst.setString(3, mh.getNote());
            prst.setString(4, mh.getTrCatagoryName());
            prst.setString(5, institueID); 
            
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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {        
            prst= con.prepareStatement("update transection_mainhead set MainHeadName=?,Note=?,TrCatagoryID=(select TrCatagoryID from transectioncatagory where TrCatagoryName=? and InstituteID=?),CreateDate=now(),UserID=null where TrMainHeadID=? and InstituteID=?");
      
            prst.setString(1,mhobj.getMainHeadName());
            
            prst.setString(2,mhobj.getNote());
            
            prst.setString(3,mhobj.getTrCatagoryName());
            
            prst.setString(4, institueID);
            
            prst.setInt(5,mhobj.getTrMainHeadID());
            
            prst.setString(6, institueID);
            
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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<MainHead> main_head_list=new ArrayList<MainHead>();
        
        try
        {
              prst = con.prepareStatement("select tmh.TrMainHeadID, tmh.MainHeadName, tmh.Note, tc.TrCatagoryName, tmh.CreateDate, tmh.UserID from transection_mainhead tmh, transectioncatagory tc\n" +
                                           " where tmh.TrCatagoryID = tc.TrCatagoryID and tmh.InstituteID=tc.InstituteID and tmh.InstituteID=?");
            
            
              prst.setString(1, institueID);
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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<String> catelist=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct TrCatagoryName from transectioncatagory where TrType=? and InstituteID=?");
            
            prst.setString(1,trType);
            prst.setString(2, institueID);
            
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
