/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.InstituteSetup;

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
 * @author Mastermind
 */
public class InstituteSetupServiceImpl implements InstituteSetupService,Serializable
{

    @Override
    public boolean saveInstitute(InstituteSetup instituteSetup) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst=null;
        
        String instituteID="";
        
        FacesContext context=FacesContext.getCurrentInstance();
        
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try
        {          
            prst = con.prepareStatement("update institute_setup set Address=?,ESTB=?,ContactNo=?,Email=?,WebSite=?,EINNo=?,Code=?,Slogan=?,Note=?,Logo=?,BackGroundImg=?,InstituteFullName=?,AcademicYear=? where InstituteID=?");

            prst.setString(1,instituteSetup.getAddress());
            
            prst.setString(2,instituteSetup.getEstb());
            
            prst.setString(3,instituteSetup.getContactNo());
            
            prst.setString(4,instituteSetup.getEmail());
            
            prst.setString(5,instituteSetup.getWebSite());
            
            prst.setString(6,instituteSetup.getEinNo());
            
            prst.setString(7,instituteSetup.getCode());
 
            prst.setString(8,instituteSetup.getSlogan());
             
            prst.setString(9,instituteSetup.getNote());
            
            prst.setString(10,instituteSetup.getImgPath());
            
            prst.setString(11,instituteSetup.getBackgroundImgPath());
            
            prst.setString(12,instituteSetup.getInstituteFullName());
            
            prst.setString(13, instituteSetup.getAcdemicyear());
            
            prst.setString(14, instituteID);
            
            prst.execute();
           
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
    public boolean updateInstitute(InstituteSetup instituteSetupObj) 
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
//         try
//        {
//            prst = con.prepareStatement("update institute_setup set InstituteID=(select InstituteID from  institute_basic where InstituteName=?), Address=?, ESTB=?, ContactNo=?, Email=?, WebSite=?, EINNo=?, Code=?, InstituteType=?, EducationArea=?, BranchName=?, Slogan=?, Note=?, FooterDisplay=?, Logo=? where ID=? ");
//             
//            prst.setString(1,instituteSetupObj.getInstituteName());
//            
//            prst.setString(2,instituteSetupObj.getInstituteFullName());
//                 
//            prst.setString(3,instituteSetupObj.getAddress());
//            
//            prst.setString(4,instituteSetupObj.getEstb());
//            
//            prst.setString(5,instituteSetupObj.getContactNo());
//            
//            prst.setString(6,instituteSetupObj.getEmail());
//            
//            prst.setString(7,instituteSetupObj.getWebSite());
//            
//            prst.setString(8,instituteSetupObj.getEinNo());
//            
//            prst.setString(9,instituteSetupObj.getCode());
// 
//            prst.setString(10,instituteSetupObj.getSlogan());
//             
//            prst.setString(11,instituteSetupObj.getNote());
//            
//            prst.setString(12,instituteSetupObj.getImgPath());
//            
//            prst.setString(13,instituteSetupObj.getBackgroundImgPath());
//            
//            prst.execute();
//             
//            prst.close();
//
//            con.close();
//             
//            return true; 
//             
//           }
//            catch(SQLException e)
//           {
//            System.out.println(e);
//           }
//          finally
//          {
//            try
//            {
//                if(prst!=null)
//                {
//                    prst.close();
//                }
//                if(con!=null)
//                {
//                    con.close();
//                }
//            }
//            catch(SQLException e)
//            {
//                System.out.println(e);
//            }
//        }
         
          return false;
    }

    @Override
    public List<InstituteSetup> instituteSetupList()
    {
        List<InstituteSetup> instituteList=new ArrayList<InstituteSetup>();
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        
        
         try
          {
            prst = con.prepareStatement("select * from institute_setup ORDER BY InstituteID DESC LIMIT 1");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                instituteList.add(new InstituteSetup(rs.getString("InstituteID"),rs.getString("InstituteName"),rs.getString("InstituteFullName"), rs.getString("Address"), rs.getString("ESTB"), rs.getString("ContactNo"), rs.getString("Email"), rs.getString("WebSite"), rs.getString("EINNo"), rs.getString("Code"), rs.getString("Slogan"), rs.getString("Note"), rs.getString("Logo"), rs.getString("BackGroundImg"),rs.getString("AcademicYear")));
            }

            rs.close();
            
            prst.close();
            
            con.close();
          } 
          catch (SQLException e)
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
        
         return instituteList;
    }   
    
    @Override
    public InstituteSetup instituteSetup()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        
        InstituteSetup instituteSetup=new InstituteSetup();
         try
          {
            prst = con.prepareStatement("select * from institute_setup ORDER BY InstituteID DESC LIMIT 1");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                instituteSetup=new InstituteSetup(rs.getString("InstituteID"),rs.getString("InstituteName"), rs.getString("InstituteFullName"), rs.getString("Address"), rs.getString("ESTB"), rs.getString("ContactNo"), rs.getString("Email"), rs.getString("WebSite"), rs.getString("EINNo"), rs.getString("Code"), rs.getString("Slogan"), rs.getString("Note"), rs.getString("Logo"), rs.getString("BackGroundImg"),rs.getString("AcademicYear"));
            }

            rs.close();
            
            prst.close();
            
            con.close();
          } 
          catch (SQLException e)
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
        
         return instituteSetup;
    }   

    
    @Override
    public InstituteSetup getInstituteById(String id)
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        
        InstituteSetup instituteSetup=new InstituteSetup();
         try
          {
            prst = con.prepareStatement("select * from institute_setup where instituteId=? ORDER BY InstituteID DESC LIMIT 1");
            
            prst.setString(1, id);
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                instituteSetup=new InstituteSetup(rs.getString("InstituteID"),rs.getString("InstituteName"), rs.getString("InstituteFullName"), rs.getString("Address"), rs.getString("ESTB"), rs.getString("ContactNo"), rs.getString("Email"), rs.getString("WebSite"), rs.getString("EINNo"), rs.getString("Code"), rs.getString("Slogan"), rs.getString("Note"), rs.getString("Logo"), rs.getString("BackGroundImg"),rs.getString("AcademicYear"));
            }

            rs.close();
            
            prst.close();
            
            con.close();
          } 
          catch (SQLException e)
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
        
         return instituteSetup;
    }   
    
    @Override
    public List<String> instituteNameList()
    {
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst=null;
        
        ResultSet rs=null;
        
        List<String> insNameList=new ArrayList<String>();
        
        try
        {
            prst = con.prepareStatement("select InstituteName from test.institute_basic");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                insNameList.add(rs.getString("InstituteName"));
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
        
        return insNameList;
    }

    
}
