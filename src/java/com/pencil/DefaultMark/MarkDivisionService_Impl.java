/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.DefaultMark;

import com.pencil.Connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mahfuj
 */
public class MarkDivisionService_Impl implements Serializable, MarkDivisionService {

    @Override
    public boolean create_d_MarkDivision(DefaultMarkDivision dmd)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("insert into default_mark_division values (null,?,?,?,?,?)");

            prst.setString(1, dmd.getShortCode());

            prst.setString(2, dmd.getTitle());
            
            prst.setInt(3, dmd.getTotalMark());
            
            prst.setDouble(4, dmd.getAcceptance());
            
            prst.setDouble(5, dmd.getPassMark());

            prst.execute();

            prst.close();

            con.close();

            return true;
        }
        
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try 
            {

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
        return false;
    }

 
    @Override
    public boolean update_d_MarkDivision(DefaultMarkDivision dmdObj) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update default_mark_division set ShortCode=?, Title=?, TotalMark=?, Acceptance=?, PassMark=? where  dmd_id=?");

            prst.setString(1, dmdObj.getShortCode());

            prst.setString(2, dmdObj.getTitle());

            prst.setInt(3, dmdObj.getTotalMark());
            
            prst.setDouble(4, dmdObj.getAcceptance());
            
            prst.setDouble(5, dmdObj.getPassMark());
            
            prst.setInt(6, dmdObj.getDmdId());

            prst.execute();

            prst.close();

            con.close();

            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        finally
        {
            try {

                if (prst != null) 
                {
                    prst.close();
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

    /**
     *
     * @return
     */
    @Override
    public List<DefaultMarkDivision> d_MarkDivisionList() 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<DefaultMarkDivision> dmdList = new ArrayList<DefaultMarkDivision>();

        try {

            prst = con.prepareStatement("select * from default_mark_division");

            rs = prst.executeQuery();

            while (rs.next())
            {
                dmdList.add(new DefaultMarkDivision(rs.getInt("dmd_id"),rs.getString("ShortCode"), rs.getString("Title"), rs.getInt("TotalMark"), rs.getDouble("Acceptance"), rs.getDouble("PassMark")));
            }

            prst.close();

            con.close();
            
            rs.close();

        }
        catch (SQLException e) 
        {
            System.out.println(e);
        } 
        finally
        {
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

        return dmdList;
    }
}
