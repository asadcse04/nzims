/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryCategory;

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
public class InventoryCategoryServiceImpl implements Serializable,InventoryCategoryService
{

    @Override
    public boolean createInventoryCategory(InventoryCategory invcata) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into inventorycategory values(null,?,?,now(),(select InventoryTypeID from inventorytype where InventoryTypeName=?),null)");
            
            prst.setString(1,invcata.getInventoryCategoryName());
            
            prst.setString(2,invcata.getNote());
     
            prst.setString(3,invcata.getInventoryTypeName());
            
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
    public boolean updateInventoryCategory(InventoryCategory invcataObj)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("update inventorycategory set InventoryCategoryName=?,Note=?,CreateDate=now(),InventoryTypeID=(select InventoryTypeID from inventorytype where InventoryTypeName=?),UserID=null where InventoryCategoryID=?");
      
            prst.setString(1,invcataObj.getInventoryCategoryName());
            
            prst.setString(2,invcataObj.getNote());
            
            prst.setString(3,invcataObj.getInventoryTypeName());
            
            prst.setInt(4,invcataObj.getInventoryCategoryID());
            
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
    public List<String> inventoryTypeNameList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> invTypeList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("select InventoryTypeName from inventorytype");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                invTypeList.add(rs.getString("InventoryTypeName"));
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
        
        return invTypeList;
    }

    @Override
    public List<InventoryCategory> inventoryCategoryList() 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<InventoryCategory> catagorylist=new ArrayList<InventoryCategory>();
        
        try
        {
  
            prst = con.prepareStatement("select ic.InventoryCategoryID, ic.InventoryCategoryName, ic.Note, ic.CreateDate, ic.UserID, it.InventoryTypeName, ic.InventoryTypeID from inventorycategory ic,inventorytype it"
                    + " where ic.InventoryTypeID=it.InventoryTypeID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                catagorylist.add(new InventoryCategory(rs.getInt("ic.InventoryCategoryID"),rs.getString("ic.InventoryCategoryName"),rs.getString("ic.Note"),rs.getDate("ic.CreateDate"),rs.getString("it.InventoryTypeName"),rs.getInt("ic.InventoryTypeID"),rs.getInt("ic.UserID")));
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

        return catagorylist;
    }
    
}
