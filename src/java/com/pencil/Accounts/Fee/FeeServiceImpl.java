/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Fee;

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
 * @author jahangiralamdiu
 */
public class FeeServiceImpl implements FeeService {
    
    public boolean addFee(Fee fee) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();
        
        PreparedStatement pstm=null;
        
        Statement stmt = null;
        
        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        
        try 
        {
            int stdfeeid=0;
            
            pstm=con.prepareStatement("select max(StudentFeeID) from student_fee where InstituteID=?");
            pstm.setString(1, institueID);
            rs=pstm.executeQuery();
            
            if(rs.next())
            {
                stdfeeid=rs.getInt(1)+1;
            }
            else
            {
              stdfeeid=1; 
            }
            
            pstm=null;
            
            int feeID = fee.getFeeID();
            
            int acyearid=fee.getAcyearid();
            
            pstm=con.prepareStatement("insert into student_fee values("+stdfeeid+","+acyearid+","+feeID+","+institueID+")");
            
            int a=pstm.executeUpdate();
            
            stmt=con.createStatement();
            
            Iterator itr = fee.getSubHeadNameList().iterator();
            
            while(itr.hasNext())
            {
             stmt.addBatch("insert into student_subfee_config values((select StudentFeeID from student_fee where AcYrID="+acyearid+" and FeeHeadID="+feeID+" and InstituteID="+institueID+"),(select SubFeeHeadID from student_sub_fee_head where SubFeeName='"+itr.next()+"' and InstituteID="+institueID+"),"+institueID+")");
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
