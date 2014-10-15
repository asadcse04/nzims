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
import javax.faces.context.FacesContext;

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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            prst= con.prepareStatement("insert into transection_subhead values(null,?,?,?,(select TrMainHeadID from transection_mainhead where MainHeadName=? and InstituteID=?),now(),null)");
             
            prst.setString(1, institueID);
            prst.setString(2, sh.getSubHeadName());
            prst.setString(3, sh.getNote());
            prst.setString(4, sh.getTrMainHeadName());
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
    public boolean updateSubHead(SubHead shobj) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {                    
            prst= con.prepareStatement("update transection_subhead set SubHeadName=?,Note=?,TrMainHeadID=(select TrMainHeadID from transection_mainhead where MainHeadName=? and InstituteID=?),CreateDate=now(),UserID=null where TrSubHeadID=? and InstituteID=?");
      
            prst.setString(1,shobj.getSubHeadName());
            
            prst.setString(2,shobj.getNote());
            
            prst.setString(3,shobj.getTrMainHeadName());
            
            prst.setString(4, institueID);
            
            prst.setInt(5,shobj.getTrSubHeadID());
            
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
    public List<SubHead> subHeadList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<SubHead> sub_head_list=new ArrayList<SubHead>();
        
        try
        {         
              prst = con.prepareStatement("select tsh.TrSubHeadID, tsh.SubHeadName, tsh.Note, tmh.MainHeadName, tsh.CreateDate, tsh.UserID from transection_subhead tsh, transection_mainhead tmh\n" +
                                          "where tsh.TrMainHeadID = tmh.TrMainHeadID and tsh.InstituteID=tmh.InstituteID and tmh.InstituteID=?");
            
            
              prst.setString(1, institueID);
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
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<String> mainHead_list=new ArrayList<String>();
        
        try
        { 
            prst = con.prepareStatement("select distinct mh.MainHeadName from transection_mainhead mh,transectioncatagory tc where tc.TrCatagoryID=mh.TrCatagoryID and tc.InstituteID=mh.InstituteID and tc.TrCatagoryName=? and mh.InstituteID=?");
            
            prst.setString(1,trCategoryName);
            prst.setString(2, institueID);
            
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
