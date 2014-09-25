/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Section;

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
 * @author user
 */
public class SectionServiceImpl implements SectionService, Serializable
{
   
    @Override
    public List<Section> sectionList()
    { 
        List<Section> sectlist=new ArrayList<Section>();
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        int sectionid=0;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
       
            prst = con.prepareStatement("SELECT SectionID,SectionName,Note from section where InstituteID=?");
            prst.setString(1, institueID);
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                sectlist.add(new Section(rs.getInt("SectionID"),rs.getString("SectionName"),rs.getString("Note")));
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
        return sectlist;
    }

    @Override
    public boolean createSection(Section sect)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        ResultSet rs=null;
        
        int sectionid=0;
        
        String institueID=null;
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            prst=con.prepareStatement("select max(SectionID) from section where InstituteID=?");
            prst.setString(1, institueID);
            rs=prst.executeQuery();
           
            if(rs.next()){
               sectionid=rs.getInt(1)+1;
            }
            
            else{
                sectionid=1;
            }
            
            rs=null;
            
            prst= con.prepareStatement("insert into section values(?, ?, ?, ?)");
  
            prst.setInt(1, sectionid);
            
            prst.setString(2,sect.getSectionName());
             
            prst.setString(3, sect.getNote());
       
            prst.setString(4, institueID);
            
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
                if((prst.isClosed()==false) || (prst!=null))
                {
                    prst.close();
                }
                if((con.isClosed()==false) || (con!=null))
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
    public boolean updateSection(Section sectObj)
    {
           
          
     DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            prst= con.prepareStatement("update section set SectionName=?, Note=? where SectionID=? and InstituteID=?");
       
           
            prst.setString(1,sectObj.getSectionName());
             
            prst.setString(2, sectObj.getNote());
              
            prst.setInt(3, sectObj.getSectionID());
            
            prst.setString(4, institueID);
         
            
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
                if((prst.isClosed()==false) || (prst!=null))
                {
                    prst.close();
                }
                if((con.isClosed()==false) || (con!=null))
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
    
}


