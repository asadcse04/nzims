/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryStockIn;

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
 * @author SHOHUG-SQ
 */
public class InventoryStockInServiceImpl implements Serializable,InventoryStockInService {

    @Override
    public boolean createInventoryStockIn(InventoryStockIn inventoryStockIn, InventoryPayment inventoryPayment) {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
            
        try
        {
  
            prst = con.prepareStatement("");
//            
//            prst.setString(1, inventoryPayment.getStockType());
//            prst.setString(2, null);
//            
            rs = prst.executeQuery();
            
            
                        
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

        return false;
        
    }

    @Override
    public boolean updateInventoryStockIn(InventoryStockIn inventoryStockIn_obj) {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
               
        try
        {
  
            prst = con.prepareStatement("");
            
            rs = prst.executeQuery();
                                      
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

        return false;
        
    }

    @Override
    public List<InventoryStockIn> inventoryStockInList() {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<InventoryStockIn> invstocklist=new ArrayList<InventoryStockIn>();
        
        try
        {
  
            prst = con.prepareStatement("select ii.InventoryItemID, ii.InventoryItem, ii.Note, isg.SubGroupName, ii.CreateDate, ii.UserID from inventoryitem ii, inventory_sub_group isg"
                    + " where ii.SubGroupID = isg.SubGroupID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                invstocklist.add(new InventoryStockIn(rs.getInt("ii.InventoryItemID"),rs.getString("ii.InventoryItem"),rs.getString("ii.Note"),rs.getDate("ii.CreateDate"),rs.getString("isg.SubGroupName"),rs.getInt("ii.UserID")));
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

        return invstocklist;
    }
    }
    

