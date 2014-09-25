/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SubjectConfigure;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
public class SubjectConfigService_Impl implements Serializable,SubjectConfigService
{

    /**
     *
     * @param sbjCnf
     * @return
     */
    @Override
    public boolean saveSubjectConfig(SubjectConfig sbjCnf)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        Statement stmt = null;
        
        int schoolClassID = 0;
        
        int deptID = 0;
        
        String qr;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        
        for(int i=0;i<2;i++)
        {
            if(i==0)
            {
                qr="select ClassID from class where ClassName=?";
            }
            else
            {
                qr="select DepartmentID from department where DepartmentName=?";
            }
            
            try
            {
                prst = con.prepareStatement(qr);
                
                if(i==0)
                {
                   prst.setString(1,sbjCnf.getSchoolClassName()); 
                }
                else
                {
                   prst.setString(1,sbjCnf.getDeptName()); 
                }
                
                rs = prst.executeQuery();
                
                while(rs.next())
                {
                    if(i==0)
                    {
                        schoolClassID=rs.getInt("ClassID"); 
                    }
                    else
                    {
                        deptID=rs.getInt("DepartmentID");
                    }
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
                    if (rs != null)
                    {
                        rs.close();
                    }
                    if (prst != null) 
                    {
                        prst.close();
                    }
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }
            }
            
        }//End for
        
        try
        {
            Iterator<String> itr=sbjCnf.getSubjectList().iterator();
            
            stmt=con.createStatement();
            
            while(itr.hasNext())
            {
                stmt.addBatch("insert into subjectconfig values("+sbjCnf.getAcyrID()+","+deptID+","+schoolClassID+",(select SubjectID from subject where SubjectName='"+itr.next()+"'),'"+instituteid+"')"); 
                
            }
            
            stmt.executeBatch();
            
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
                if (stmt!=null)
                {
                    stmt.close();
                }
                if (con!=null) 
                {
                    con.close();
                }
            } 
            catch (SQLException e)
            {
                System.out.println(e);
            }
            
            sbjCnf=null;
        }
        
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public List<SubjectConfig> sbjconfigurationList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<SubjectConfig> sbjCnfList=new ArrayList<SubjectConfig>();
        
        try
        {
            prst = con.prepareStatement("SELECT s.AcYrID,d.DepartmentName,c.ClassName FROM subjectconfig s,department d,class c"
                    
                    + " where s.DeptID=d.DepartmentID and s.ClassID=c.ClassID group by  s.AcYrID,d.DepartmentName,c.ClassName");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                sbjCnfList.add(new SubjectConfig(rs.getInt("s.AcYrID"),rs.getString("c.ClassName"),rs.getString("d.DepartmentName")));
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
       
        return sbjCnfList;
    }

    /**
     *
     * @param sbj_cnf
     * @return
     */
    @Override
    public List<String> bookList(SubjectConfig sbj_cnf)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> sbjlist=new ArrayList<String>();
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        
        
        try
        {
            String qr="SELECT sbj.subjectName FROM subjectconfig s,subject sbj where s.AcYrID=? and s.DeptID=(select DepartmentID from department"
               
                + " where departmentname=?) and s.ClassID=(select ClassID from class where ClassName=?) and s.SubjectID=sbj.SubjectID and s.InstituteID=? ";
            
            prst = con.prepareStatement(qr);
            
            prst.setInt(1,sbj_cnf.getAcyrID());
            
            prst.setString(2,sbj_cnf.getDeptName());
            
            prst.setString(3,sbj_cnf.getSchoolClassName());
            
            prst.setString(4,instituteID);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                sbjlist.add(rs.getString("sbj.subjectName"));
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
            
            sbj_cnf=null;
        } 
        
        return sbjlist;
    }
}
