/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryGroup;

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
public class InventoryGroupServiceImpl implements Serializable,InventoryGroupService
{

    @Override
    public boolean createInventoryGroup(InventoryGroup invgroup)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into inventorygroup values(null,?,?,now(),(select InventoryCategoryID from inventorycategory where InventoryCategoryName=?),null)");
            
            prst.setString(1,invgroup.getInventoryGroupName());
            
            prst.setString(2,invgroup.getNote());
            
            prst.setString(3,invgroup.getInventoryCatagoryName());
            
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
    public boolean updateInventoryGroup(InventoryGroup invgroupObj) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("update inventorygroup set InventoryGroupName=?,Note=?,CreateDate=now(),InventoryCatagoryID=(select InventoryCatagoryID from inventorycategory where InventoryCategoryName=?),UserID=null where InventoryGroupID=?");
      
            prst.setString(1,invgroupObj.getInventoryGroupName());
            
            prst.setString(2,invgroupObj.getNote());
            
            prst.setString(3,invgroupObj.getInventoryCatagoryName());
            
            prst.setInt(4,invgroupObj.getInventoryGroupID());
            
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
    public List<InventoryGroup> inventoryGroupList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<InventoryGroup> invgrouplist=new ArrayList<InventoryGroup>();
        
        try
        {
  
            prst = con.prepareStatement("select ig.InventoryGroupID, ig.InventoryGroupName, ig.Note, ig.CreateDate, icn.InventoryCategoryName, ig.UserID from inventorygroup ig, inventorycategory icn"
                    + " where ig.InventoryCatagoryID = icn.InventoryCategoryID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                invgrouplist.add(new InventoryGroup(rs.getInt("ig.InventoryGroupID"),rs.getString("ig.InventoryGroupName"),rs.getString("ig.Note"),rs.getDate("ig.CreateDate"),rs.getString("icn.InventoryCategoryName"),rs.getInt("ig.UserID")));
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

        return invgrouplist;
    }
    
}
