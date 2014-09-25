/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Gallery.Principle;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riad
 */
public class PrincipleServiceImpl implements PrincipleService 
{

    @Override
    public boolean savePrinciple(Principle principle) 
    {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String ID = null;

        try {
            prst = con.prepareStatement("SELECT max(CAST(ID  AS UNSIGNED)) as ID FROM gallery_principle");

            rs = prst.executeQuery();

            while (rs.next()) {

                ID = rs.getString("ID");
            }

            if (ID == null) {

                ID = "9000";

            }

            principle.setId(String.valueOf(Long.parseLong(ID) + 1));

            prst = con.prepareStatement("insert into gallery_principle values(?,?,?,?,?,?)");

            prst.setString(1, principle.getId());

            prst.setString(2, principle.getName());

            prst.setString(3, principle.getDuration());

            prst.setString(4, principle.getContribution());

            prst.setString(5, principle.getAbout());

            prst.setString(6, (String.valueOf(Long.parseLong(ID) + 1))+"_"+principle.getImgpath());

            prst.executeUpdate();

            return true;

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

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return false;

    }

    @Override
    public List<Principle> principleList() 
    {

        List<Principle> list = new ArrayList<Principle>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from gallery_principle");

            rs = prst.executeQuery();

            while (rs.next()) {
                list.add(new Principle(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }

            return list;

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

                if (prst != null) 
                {

                    prst.close();

                }

                if (con != null) {

                    con.close();
                }

            } 
            catch (SQLException e) 
            {

                System.out.println(e);
            }
        }

        return list;
    }

    @Override
    public boolean updatePrinciple(Principle principle_update) 
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update gallery_principle set Name=?,Duration=?,Contribution=?,About=?,imgpath=? where ID=?");

            prst.setString(1, principle_update.getName());

            prst.setString(2, principle_update.getDuration());

            prst.setString(3, principle_update.getContribution());

            prst.setString(4, principle_update.getAbout());

            prst.setString(5, principle_update.getImgpath());

            prst.setString(6, principle_update.getId());

            prst.executeUpdate();

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

}
