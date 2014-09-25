/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryConfig;

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
public class InventoryConfigServiceImpl implements Serializable,InventoryConfigService
{

    @Override
    public List<String> listInvCategory(String inventoryTypeName)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> InvCatalist=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("SELECT distinct ic.InventoryCategoryName from inventorycategory ic,inventorytype it where it.InventoryTypeID=ic.InventoryTypeID and it.InventoryTypeName=?");
            
            prst.setString(1,inventoryTypeName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                InvCatalist.add(rs.getString("ic.InventoryCategoryName"));
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
        
        return InvCatalist;
    }

    @Override
    public List<String> listInvGroup(String inventoryCategoryName)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> InvGrouplist=new ArrayList<String>();
        
        try
        {
          
            prst = con.prepareStatement("SELECT distinct ig.InventoryGroupName from inventorygroup ig,inventorycategory ica where ica.InventoryCategoryID=ig.InventoryCatagoryID and ica.InventoryCategoryName=?");
            
            prst.setString(1,inventoryCategoryName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                InvGrouplist.add(rs.getString("ig.InventoryGroupName"));
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
        
        return InvGrouplist;
    }

    @Override
    public List<String> listInvSubGroup(String inventoryGroupName) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> InvGrouplist=new ArrayList<String>();
        
        try
        {
          
            prst = con.prepareStatement("SELECT distinct sg.SubGroupName from inventory_sub_group sg,inventorygroup ig where ig.InventoryGroupID=sg.InventoryGroupID and ig.InventoryGroupName=?");
            
            prst.setString(1,inventoryGroupName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                InvGrouplist.add(rs.getString("sg.SubGroupName"));
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
        
        return InvGrouplist;
    }

    @Override
    public List<String> listInvItem(String subGroupName) {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> InvItemlist=new ArrayList<String>();
        
        try
        {
          
            prst = con.prepareStatement("SELECT distinct ii.InventoryItem from inventoryitem ii,inventory_sub_group sg where sg.SubGroupID=ii.SubGroupID and sg.SubGroupName=?");
            
            prst.setString(1,subGroupName);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                InvItemlist.add(rs.getString("ii.InventoryItem"));
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
        
        return InvItemlist;
    }
    
}
