/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Category;

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
public class CategoryServiceImpl implements Serializable,CategoryService
{

    @Override
    public boolean createCategory(Category cate)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            prst= con.prepareStatement("insert into transectioncatagory values(null,?,?,?,?,now(),null)");
              
            prst.setString(1, institueID);
            
            prst.setString(2, cate.getTrCatagoryName());
             
            prst.setString(3, cate.getNote());
            
            prst.setString(4, cate.getTrType());
             
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
    public boolean updateCategory(Category cateObj)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try    
        {
            prst= con.prepareStatement("update transectioncatagory set TrCatagoryName=?, Note=?, TrType=?, CreateDate=now(), UserID=null where TrCatagoryID=? and where InstituteID=?");
       
            prst.setString(1, cateObj.getTrCatagoryName());
             
            prst.setString(2, cateObj.getNote());
            
            prst.setString(3, cateObj.getTrType());
            
            prst.setInt(4, cateObj.getTrCatagoryID());
            
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
    public List<Category> categoryList()
    {
      DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
     
    
        List<Category> category_list=new ArrayList<Category>();
        
        try
        {
            prst = con.prepareStatement("SELECT * FROM transectioncatagory where InstituteID=?");
            
            prst.setString(1, institueID);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                category_list.add(new Category(rs.getInt("TrCatagoryID"),rs.getString("TrCatagoryName"),rs.getString("Note"),rs.getString("TrType"),rs.getDate("CreateDate"),rs.getInt("UserID")));
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
        return category_list;
    }
    
    
}
