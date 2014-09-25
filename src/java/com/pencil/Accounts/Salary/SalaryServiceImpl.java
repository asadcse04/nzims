/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Salary;

import com.pencil.Accounts.Fee.*;
import com.pencil.Accounts.FeeCategory.FeeCategory;
import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.faces.context.FacesContext;

/**
 *
 * @author riad
 */
public class SalaryServiceImpl implements SalaryService {
    
    public boolean addSalary(Salary salary) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        Statement stmt = null;
        
        PreparedStatement pstm=null;
        
        ResultSet rs=null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try 
        {
            int salaryid=1;
           
            pstm=con.prepareStatement("select distinct max(SalaryID) from salarycreate where InstituteID=?");
            
            pstm.setString(1, institueID);
            
            rs=pstm.executeQuery();
            
            if(rs.next()){
                
                salaryid=rs.getInt(1)+1;
            }
            
            pstm=con.prepareStatement("insert into salarycreate values(?,?,?,?)");
            
            pstm.setInt(1, salaryid);
            pstm.setInt(2, salary.getAcYearId());
            pstm.setInt(3, salary.getSalaryHeadID());
            pstm.setString(4, institueID);
            
            int a=pstm.executeUpdate();
            
            
                        
            stmt=con.createStatement();
            
            Iterator itr = salary.getSubHeadNameList().iterator();
            
            while(itr.hasNext())
            {
              stmt.addBatch("insert into salary_subhead_config values("+salaryid+",(select SalarySubHeadID from salary_sub_head where SalarySubHeadName='"+itr.next()+"'),"+institueID+")");
            }
            
            stmt.executeBatch();

            return true;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
        finally 
        {
            try 
            {
                
                 if (rs != null) 
                {

                    rs.close();

                }
                 
                  if (pstm != null) 
                {

                    pstm.close();

                }
                  
                if (stmt != null) 
                {

                    stmt.close();

                }

                if (con != null) 
                {

                    con.close();
                }

            } 
            catch (SQLException e) 
            {

                System.out.println(e);
            }
        }
        
        return false;
    }
}
