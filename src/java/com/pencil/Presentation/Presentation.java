/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Presentation;

//import com.mysql.jdbc.PreparedStatement;
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
 * @author Mahfuj
 */
public class Presentation implements Serializable
{
    public List<String> infoList(String data)
    {
        DB_Connection o=new DB_Connection();  
        
        Connection con=o.getConnection();
        
        List<String> dtlist=new ArrayList<String>();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String sql = null;
        
        String clnm = null;
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
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
        else if(data.equals("shift"))
        {
            sql="select ShiftName from shift"; 
           
            clnm="ShiftName";
        }
        else if(data.equals("section"))
        {
            sql="select SectionName from section where instituteID="+instituteID+" "; 
           
            clnm="SectionName";
        }
        else if(data.equals("subject"))
        {
            sql="select SubjectName from subject"; 
           
            clnm="SubjectName";
        }
        else if(data.equals("clsRm"))
        {
            sql="select RoomNo from classroom where instituteID="+instituteID+" "; 
           
            clnm="RoomNo";
        }
        
        else if(data.equals("w.day"))
        {
            sql="select DayName from officialday"; 
           
            clnm="DayName";
        }
        else if(data.equals("exmNm"))
        {
            sql="select ExamName from exam where instituteID="+instituteID+" "; 
           
            clnm="ExamName";
        }
        
        try
        {
            prst=con.prepareStatement(sql);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                dtlist.add(rs.getString(clnm));
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
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
        }
        
        return dtlist;    
    }
}
