/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventorySubGroup;

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
public class InventorySubGroupServiceImpl implements Serializable,InventorySubGroupService
{

    @Override
    public boolean createInventorySubGroup(InventorySubGroup inv_subgroup)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into inventory_sub_group values(null,?,?,(select InventoryGroupID from inventorygroup where InventoryGroupName=?),now(),null)");
            
            prst.setString(1,inv_subgroup.getSubGroupName());
            
            prst.setString(2,inv_subgroup.getNote());
            
            prst.setString(3,inv_subgroup.getInventoryGroupName());
            
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
    public boolean updateInventorySubGroup(InventorySubGroup inv_subgroupObj)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("update inventory_sub_group set SubGroupName=?,Note=?,InventoryGroupID=(select InventoryGroupID from inventorygroup where InventoryGroupName=?),CreateDate=now(),UserID=null where SubGroupID=?");
      
            prst.setString(1,inv_subgroupObj.getSubGroupName());
            
            prst.setString(2,inv_subgroupObj.getNote());
            
            prst.setString(3,inv_subgroupObj.getInventoryGroupName());
            
            prst.setInt(4,inv_subgroupObj.getSubGroupID());
            
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
    public List<InventorySubGroup> inventorySubGroupList() 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<InventorySubGroup> invsubgrouplist=new ArrayList<InventorySubGroup>();
        
        try
        {
  
            prst = con.prepareStatement("select isg.SubGroupID, isg.SubGroupName, isg.Note, ig.InventoryGroupName, isg.CreateDate, isg.UserID from inventory_sub_group isg, inventorygroup ig"
                    + " where isg.InventoryGroupID = ig.InventoryGroupID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                invsubgrouplist.add(new InventorySubGroup(rs.getInt("isg.SubGroupID"),rs.getString("isg.SubGroupName"),rs.getString("isg.Note"),rs.getDate("isg.CreateDate"),rs.getString("ig.InventoryGroupName"),rs.getInt("isg.UserID")));
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

        return invsubgrouplist;
    }
    
    
    
}
