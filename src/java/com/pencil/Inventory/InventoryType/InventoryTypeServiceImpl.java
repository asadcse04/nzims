/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryType;

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
public class InventoryTypeServiceImpl implements Serializable,InventoryTypeService
{

    @Override
    public boolean createInventoryType(InventoryType inventorytype) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into inventorytype values(null,?,?,now(),null)");
                 
            prst.setString(1, inventorytype.getInventoryTypeName());
             
            prst.setString(2, inventorytype.getNote());
              
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
    public boolean updateInventoryType(InventoryType inventorytypeObj)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("update inventorytype set InventoryTypeName=?, Note=?, CreateDate=now(), UserID=null where InventoryTypeID=?");
       
            prst.setString(1, inventorytypeObj.getInventoryTypeName());
             
            prst.setString(2, inventorytypeObj.getNote());
            
            prst.setInt(3, inventorytypeObj.getInventoryTypeID());
            
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
    public List<InventoryType> InventoryTypeList()
    {
       DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
     
    
        List<InventoryType> inventory_type_list=new ArrayList<InventoryType>();
        
        try
        {
            prst = con.prepareStatement("SELECT * FROM inventorytype");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                inventory_type_list.add(new InventoryType(rs.getInt("InventoryTypeID"),rs.getString("InventoryTypeName"),rs.getString("Note"),rs.getDate("CreateDate"),rs.getInt("UserID")));
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
        return inventory_type_list;
    }
    
}
