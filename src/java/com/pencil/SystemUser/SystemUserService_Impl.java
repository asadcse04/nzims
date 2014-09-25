/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SystemUser;

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
 * @author Mahfuj
 */
public class SystemUserService_Impl implements Serializable,SystemUserService
{

    /**
     *
     * @param usr
     * @return
     */
    @Override
    public boolean createUser(SystemUser usr)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        try
        {
            Long.parseLong(usr.getMobileNo());
            
            prst=con.prepareStatement("insert into system_user values(null,?,?,?,?,?,?,?,?)");
                
            prst.setString(1,usr.getFullName()); 
            
            prst.setString(2,usr.getUserName()); 
            
            prst.setString(3,usr.getPassword()); 
            
            prst.setString(4,usr.getMobileNo()); 
            
            prst.setString(5,usr.getEmail()); 
            
            prst.setString(6,usr.getRole());
            
            prst.setBoolean(7,true);
            
            prst.setString(8,usr.getImgPath()); 
                
            prst.execute();
            
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(NumberFormatException n)
        {
            System.out.println(n);
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
            
            usr=null;
        }
        return false;
    }

    /**
     *
     * @param usr
     * @return
     */
    @Override
    public boolean updateUser(SystemUser usr)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        try
        {
            Long.parseLong(usr.getMobileNo());
            
            prst=con.prepareStatement("update system_user set FullName=?, UserName=?, Password=?, MobileNo=?, Email=?, Role=?, Status=?, ImgPath=? where UserID=?");
                
            prst.setString(1,usr.getFullName()); 
            
            prst.setString(2,usr.getUserName()); 
            
            prst.setString(3,usr.getPassword()); 
            
            prst.setString(4,usr.getMobileNo()); 
            
            prst.setString(5,usr.getEmail()); 
            
            prst.setString(6,usr.getRole());
            
            prst.setBoolean(7,usr.isStatus());
            
            prst.setString(8,usr.getImgPath()); 
            
            prst.setInt(9,usr.getUserID());
                
            prst.execute();
              
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(NumberFormatException n)
        {
            System.out.println(n);
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
            
            usr=null;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public List<SystemUser> userList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
            
        ResultSet rs = null;
        
        List<SystemUser> listUser=new ArrayList<SystemUser>();
        
        try
        {
            prst = con.prepareStatement("Select *from system_user order by UserID");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                listUser.add(new SystemUser(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBoolean(8),rs.getString(9)));
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
        return listUser;
    }
}
