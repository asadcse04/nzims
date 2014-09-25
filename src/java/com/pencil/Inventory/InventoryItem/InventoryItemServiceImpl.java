/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryItem;

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
public class InventoryItemServiceImpl implements Serializable,InventoryItemService
{

    @Override
    public boolean createInventoryItem(InventoryItem inv_item) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        try
        {
            prst= con.prepareStatement("insert into inventoryitem values(null,?,?,(select SubGroupID from inventory_sub_group where SubGroupName=?),"
                    + "now(),null,0.0,0.0,0.0,0.0,0.0,0.0)");
            
            prst.setString(1,inv_item.getInventoryItem());
            
            prst.setString(2,inv_item.getNote());
            
            prst.setString(3,inv_item.getSubGroupName());
            
            prst.execute();
               
            prst.close();
            
//            prst= con.prepareStatement("insert into inventory_status values (null,(select InventoryItemID from inventoryitem where InventoryItem=?),?,0.0,0.0,0.0)");
//            
//            prst.setString(1, inv_item.getInventoryItem());
//            
//            prst.setString(2, inv_item.getInventoryItem());
//            
//            prst.execute();
//            
//            prst.close();
            
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
    public boolean updateInventoryItem(InventoryItem inv_itemObj)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InventoryItem> inventoryItemList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<InventoryItem> invitemlist=new ArrayList<InventoryItem>();
        
        try
        {
  
            prst = con.prepareStatement("select ii.InventoryItemID, ii.InventoryItem, ii.Note, isg.SubGroupName, ii.CreateDate, ii.UserID from inventoryitem ii, inventory_sub_group isg"
                    + " where ii.SubGroupID = isg.SubGroupID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                invitemlist.add(new InventoryItem(rs.getInt("ii.InventoryItemID"),rs.getString("ii.InventoryItem"),rs.getString("ii.Note"),rs.getDate("ii.CreateDate"),rs.getString("isg.SubGroupName"),rs.getInt("ii.UserID")));
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

        return invitemlist;
    }
    
}
