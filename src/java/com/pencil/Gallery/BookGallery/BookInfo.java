/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.gallery.BookGallery;

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
public class BookInfo implements Serializable{
    
    public List<String> BookInfoList(String data)
    {
        DB_Connection o=new DB_Connection();  
        
        Connection con=o.getConnection();
        
        List<String> dtlist=new ArrayList<String>();
        
        PreparedStatement prst;
        
        ResultSet rs;
        
        String sql = null;
        
        String clnm = null;
        
        if(data.equals("acyr"))
        {
            sql="select AcYrID from academic_year"; 
           
            clnm="AcYrID";
        }
        else if(data.equals("Scl_class"))
        {
            sql="select ClassName from class"; 
           
            clnm="ClassName";
        }
        else if(data.equals("dept"))
        {
            sql="select DepartmentName from department"; 
           
            clnm="DepartmentName";
        }
        
        else if(data.equals("subject"))
        {
            sql="select SubjectName from subject"; 
           
            clnm="SubjectName";
        }
        
        
        
        try
        {
            prst=con.prepareStatement(sql);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                dtlist.add(rs.getString(clnm));
            }
            rs.close();
            
            prst.close();
            
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return dtlist;   
        
    }
    
}
