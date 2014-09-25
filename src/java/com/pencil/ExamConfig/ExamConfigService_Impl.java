/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamConfig;

import com.pencil.Connection.DB_Connection;
import com.pencil.DefaultMark.DefaultMarkDivision;
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
 * @author apple
 */
public class ExamConfigService_Impl implements Serializable,ExamConfigService
{

    /**
     *
     * @param exc
     * @return
     */
    @Override
    public boolean insertExamConfig(ExamConfig exc) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        int exCnfID;
        
        try
        {
            con.setAutoCommit(false);
            
            prst=con.prepareStatement("select max(ExCnfID) from exam_config where InstituteID=?");
            
            prst.setString(1, exc.getInstituteID());
            
            rs=prst.executeQuery();
           
            if(rs.next()){
               exCnfID=rs.getInt(1)+1;
            }
            
            else{
                exCnfID=1;
            }
            
            prst = con.prepareStatement("insert into exam_config values(?,?,(SELECT ClassID FROM class where ClassName=?),(select Exam_ID from exam where ExamName=? and instituteID=?),?)");
            
            prst.setInt(1,exCnfID);
            
            prst.setInt(2,exc.getAcyrID());
            
            prst.setString(3,exc.getClassName());
            
            prst.setString(4,exc.getExamName());
            
            prst.setString(5,exc.getInstituteID());
            
            prst.setString(6,exc.getInstituteID());
           
            prst.execute();
           
            con.commit();
            
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
            
            exc=null;
        }
        
        return false;
    }  

    /**
     *
     * @return
     */
    @Override
    public List<ExamConfig> examConfigList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<ExamConfig> configlist=new ArrayList<ExamConfig>();
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
  
            prst = con.prepareStatement("SELECT ec.ExCnfID,ec.AcYr,c.ClassName,e.ExamName FROM exam_config ec,class c,exam e"
                    + " where ec.ClassID=c.ClassID and ec.ExamID=e.Exam_ID and ec.InstituteID=e.InstituteID and ec.InstituteID=?");
            
            prst.setString(1, instituteID);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                configlist.add(new ExamConfig(rs.getInt("ec.ExCnfID"),rs.getInt("ec.AcYr"),rs.getString("c.ClassName"),rs.getString("e.ExamName")));  
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

        return configlist;
    }

    /**
     *
     * @param acyr
     * @param className
     * @return
     */
    @Override
    public List<String> examSubjectConfig(int acyr,String className) 
    {
        DB_Connection db=new DB_Connection(); 
       
        Connection cn=db.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> sbjlist=new ArrayList<String>();
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            prst=cn.prepareStatement("SELECT distinct s.SubjectName FROM subjectconfig sc,subject s where sc.AcYrID=? and sc.ClassID=(select ClassID from class where ClassName=?) and sc.SubjectID=s.SubjectID and sc.instituteid=?");
            
            prst.setInt(1,acyr);
            
            prst.setString(2,className);
            
            prst.setString(3,instituteID);
            
            rs=prst.executeQuery();
            
            while(rs.next())
            {
                sbjlist.add(rs.getString("s.SubjectName"));
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
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
                if(cn!=null)
                {
                    cn.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
        }
        
        return sbjlist;
    }

    /**
     *
     * @param subject
     * @param sbjmarkList
     * @param excnf_id
     * @return
     */
    @Override
    public boolean exam_Subject_Mark_distribution(List<String> subject, List<DefaultMarkDivision> sbjmarkList, int excnf_id)
    {
        DB_Connection db=new DB_Connection(); 
       
        Connection cn=db.getConnection();
        
        PreparedStatement prst=null;
        
        PreparedStatement pt=null;
        
        ResultSet rs=null;
        
        int exmSbj_ID;
        
        int emdID;
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {
            
            prst=cn.prepareStatement("select max(ExmSbj_ID) from exam_subject_config where InstituteID=?");
            
            prst.setString(1, instituteID);
            
            rs=prst.executeQuery();
           
            if(rs.next()){
               exmSbj_ID=rs.getInt(1)+1;
            }
            
            else{
                exmSbj_ID=1;
            }
            
            prst=cn.prepareStatement("select max(EmdID) from exam_mark_division where InstituteID=?");
            
            prst.setString(1, instituteID);
            
            rs=prst.executeQuery();
           
            if(rs.next()){
               emdID=rs.getInt(1)+1;
            }
            
            else{
                emdID=1;
            }
            
            prst=cn.prepareStatement("insert into exam_subject_config values(?,?,(select SubjectID from subject where SubjectName=?),?)");
            
           
            
            prst.setInt(2,excnf_id);
            
            prst.setString(4, instituteID);
            
            
            pt=cn.prepareStatement("insert into exam_mark_division values(?,(select max(ExmSbj_ID) from exam_subject_config where InstituteID=?),?,?,?,?,?)");
        
            for (int i = 0; i < subject.size(); i++) 
            {
                prst.setInt(1, exmSbj_ID);
                 
                prst.setString(3,subject.get(i));
                
                prst.execute();
                
                exmSbj_ID=exmSbj_ID+1;
                
                for(int j=0;j<sbjmarkList.size();j++)
                {
                    pt.setInt(1,emdID);
                    
                    pt.setString(2, instituteID);
                     
                    pt.setInt(3,sbjmarkList.get(j).getDmdId());
                    
                    pt.setDouble(4,sbjmarkList.get(j).getTotalMark());
                    
                    pt.setDouble(5,sbjmarkList.get(j).getAcceptance());
                    
                    pt.setDouble(6,sbjmarkList.get(j).getPassMark());
                    
                    pt.setString(7, instituteID);
                    
                    pt.execute();
                    
                    emdID=emdID+1;
                    
                }
            }
            
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {
                if(prst!=null)
                {
                    prst.close();
                }
                if(pt!=null)
                {
                    pt.close();
                }
                if(cn!=null)
                {
                    cn.close();
                }
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
            
            subject.clear();
            
            sbjmarkList.clear();
        }
      
        return false;
    }
    
}
