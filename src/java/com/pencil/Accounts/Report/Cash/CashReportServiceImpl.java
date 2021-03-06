/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Accounts.Report.Cash;

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
 * @author Mamun
 */
public class CashReportServiceImpl implements CashReportService {

    public List<CashReport> listCash(CashReport cashReport) {

        List<CashReport> list=new ArrayList<CashReport>();
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;
        
        String institueID="";
        FacesContext context=FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();

        try {
            prst = con.prepareStatement("select * from cash where TrnDate between ? and ?  and InstituteID=?");

            prst.setDate(1, new java.sql.Date(cashReport.getFromdate().getTime()));
            prst.setDate(2, new java.sql.Date(cashReport.getTodate().getTime()));
            prst.setString(3, institueID);
            rs = prst.executeQuery();

            while (rs.next()) {
                list.add(new CashReport(rs.getInt(1), rs.getDate(3), rs.getString(4), rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));

            }

            return list;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
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
