/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff;

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
 * @author SHOHUG-SQ
 */
public class Stuff_Reg_ServiceImpl implements Serializable, Stuff_Reg_Service
{
    @Override
    public boolean saveStuff(Stuff_Reg stuff)
    {
        
        DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement  prst = null;
        
        ResultSet rs = null;
        
        String SchoolID="";
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        SchoolID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        int stuffID = 0;
        
         try {
           prst = con.prepareStatement("select max(StuffID) as StuffID from stuff where InstituteID=?");
           
           prst.setString(1, SchoolID);
           
            rs = prst.executeQuery();

            if (rs.next()) 
            {
                stuffID = rs.getInt("StuffID");
            }
            if (stuffID ==0)
            {
                stuffID = 60000;
                
            }

            stuff.setStuffID(stuffID+1);
        }

        catch (SQLException e)
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
        try
        {
            con.setAutoCommit(false);
            
            Long.parseLong(stuff.getContactNo());
            
            prst = con.prepareStatement("insert into stuff values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            prst.setInt(1,stuff.getStuffID());
               
            prst.setString(2,stuff.getName());
                 
            prst.setString(3,stuff.getGender());
            
            prst.setDate(4,new java.sql.Date(stuff.getDob().getTime()));
            
            prst.setString(5,stuff.getFatherName());
            
            prst.setString(6,stuff.getMotherName());
            
            prst.setString(7,stuff.getQualification());
            
            prst.setString(8,stuff.getPassedFrom());
            
            prst.setString(9,stuff.getBloodGroup());
            
            prst.setString(10,stuff.getMaritalStatus());
            
            prst.setString(11,stuff.getReligion());

            prst.setString(12,(stuffID+1)+"_"+stuff.getImgPath());
            
            prst.setString(13, SchoolID);
            
            
            
            int a= prst.executeUpdate();
            
            System.out.println("a="+ a);
            
            prst.close();
            
            
            prst = con.prepareStatement("insert into stuff_contact_info values(?,?,?,?,(select max(StuffID) from stuff where InstituteID=?),?)");
            
            prst.setString(1,stuff.getContactNo());
            
            prst.setString(2,stuff.getEmail());
            
            prst.setString(3,stuff.getPresentAddress());
            
            prst.setString(4,stuff.getPermanentAddress());
            
            prst.setString(5, SchoolID);
            
            prst.setString(6, SchoolID);
            
            int b=prst.executeUpdate();
            
            prst.close();
            
            con.commit();

            con.close();
            
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
                if (rs != null) {
                    rs.close();
                }
                if (prst != null) {
                    prst.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
        
        return false;
    }

    @Override
    public boolean updateStuff(Stuff_Reg stuffup)
    {
        DB_Connection o=new DB_Connection();    
   
        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String SchoolID="";
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        SchoolID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try {
            con.setAutoCommit(false);

            Long.parseLong(stuffup.getContactNo());
            
           prst = con.prepareStatement("update stuff set StuffName=?, Gender=?, DOB=?, FatherName=?, MotherName=?, Qualification=?, PassedFrom=?, BloodGroup=?, MaritalStatus=?, Religion=?, ImgPath=? where StuffID=? and InstituteID=?");
           
           prst.setString(1, stuffup.getName());

            prst.setString(2, stuffup.getGender());

            prst.setDate(3, new java.sql.Date(stuffup.getDob().getTime()));

            prst.setString(4, stuffup.getFatherName());

            prst.setString(5, stuffup.getMotherName());

            prst.setString(6, stuffup.getQualification());

            prst.setString(7, stuffup.getPassedFrom());

            prst.setString(8, stuffup.getBloodGroup());

            prst.setString(9, stuffup.getMaritalStatus());

            prst.setString(10, stuffup.getReligion());

            prst.setString(11, stuffup.getImgPath());
            
            prst.setInt(12, stuffup.getStuffID());
            
            prst.setString(13, SchoolID);

            prst.execute();

            prst.close();
            
            prst = con.prepareStatement("update stuff_contact_info set ContactNo=?, Email=?, PresentAddress=?, PermanentAddress=? where StuffID=? and InstituteID=?");
            
            prst.setString(1, stuffup.getContactNo());

            prst.setString(2, stuffup.getEmail());

            prst.setString(3, stuffup.getPresentAddress());

            prst.setString(4, stuffup.getPermanentAddress());
            
            prst.setInt(5, stuffup.getStuffID());
            
            prst.setString(6, SchoolID);
            
            prst.execute();

            prst.close();

            con.commit();

            con.close();

            return true;
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        finally 
        {
            try 
            {
                if (rs != null) {
                    rs.close();
                }
                if (prst != null) {
                    prst.close();
                }
                if (con != null) {
                    con.close();
                }
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
 
        return false;
        
    }

    @Override
    public List<Stuff_Reg> stuffList()
    {
       DB_Connection o=new DB_Connection(); 
       
       Connection con=o.getConnection();
        
       PreparedStatement prst=null;
        
       ResultSet rs=null;
       
        String SchoolID="";
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        SchoolID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
       List<Stuff_Reg> stuffList=new ArrayList<Stuff_Reg>();
        
       String sql="select s.StuffID,s.StuffName,s.Gender,s.DOB,s.FatherName,s.MotherName,s.Qualification,s.PassedFrom,\n" +
"               s.BloodGroup,s.MaritalStatus,s.Religion,s.ImgPath,sc.ContactNo,sc.Email,sc.PresentAddress,sc.PermanentAddress\n" +
"                from stuff s,stuff_contact_info sc where s.InstituteID=sc.InstituteID and  sc.StuffID=s.StuffID and s.InstituteID=?";
       
        try
        {
          prst=con.prepareStatement(sql);
          
          prst.setString(1, SchoolID);
            
          rs = prst.executeQuery();
            
           while(rs.next())
           {
               stuffList.add(new Stuff_Reg(
                       rs.getInt("StuffID"),
                       rs.getString("StuffName"),
                       rs.getString("Gender"),
                       rs.getDate("DOB"),
                       rs.getString("FatherName"),
                       rs.getString("MotherName"),
                       rs.getString("Qualification"),
                       rs.getString("PassedFrom"),
                       rs.getString("BloodGroup"),
                       rs.getString("MaritalStatus"),
                       rs.getString("Religion"),
                       rs.getString("ImgPath"),
                       rs.getString("ContactNo"),
                       rs.getString("Email"),
                       rs.getString("PresentAddress"),
                       rs.getString("PermanentAddress")));
           }
           
        } 
        catch (Exception e){
        
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
        
        return stuffList;
        }
    
}
