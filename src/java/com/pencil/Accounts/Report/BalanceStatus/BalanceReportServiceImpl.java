/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Report.BalanceStatus;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Riad
 */
public class BalanceReportServiceImpl {
    
   public List<BalanceReport> balanceList(){
    
        List<BalanceReport> list=new ArrayList<BalanceReport>();
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            prst = con.prepareStatement("select cashBalance,bankBalance,checkBalance,(cashBalance+bankBalance+checkBalance) as totalBalance from cash_summery where InstituteID=?");

            prst.setString(1, institueID);
            rs = prst.executeQuery();

            while (rs.next()) 
            {
                list.add(new BalanceReport(rs.getDouble(1), rs.getDouble(2), rs.getDouble(3),rs.getDouble(4)));

            }

            return list;

        } 
        
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        
        
        finally {
            try {
                
                if (rs != null) {

                    rs.close();

                }
                
                if (prst != null) {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e);
            }
        }
       
       return list;
       
   }
    
}
