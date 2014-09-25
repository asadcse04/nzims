/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Gallery.Committee;

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
public class CommitteeServiceImpl implements CommitteeService {

    @Override
    public boolean saveCommittee(Committee committee) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        String ID = null;

        try {
            prst = con.prepareStatement("SELECT max(CAST(ID  AS UNSIGNED)) as ID FROM gallery_committee");

            rs = prst.executeQuery();

            while (rs.next()) {

                ID = rs.getString("ID");
            }

            if (ID == null) {

                ID = "8000";

            }

            committee.setId(String.valueOf(Long.parseLong(ID) + 1));

            prst = con.prepareStatement("insert into gallery_committee values(?,?,?,?,?,?,?,?)");

            prst.setString(1, committee.getId());

            prst.setString(2, committee.getDesignation());

            prst.setString(3, committee.getName());

            prst.setString(4, committee.getFathername());

            prst.setString(5, committee.getAddress());

            prst.setString(6, committee.getMobile());

            prst.setString(7, committee.getAbout());

            prst.setString(8, (String.valueOf(Long.parseLong(ID) + 1)) + "_" + committee.getImgpath());

            prst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
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
    public List<Committee> committeeList() {

        List<Committee> list = new ArrayList<Committee>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from gallery_committee");

            rs = prst.executeQuery();

            while (rs.next()) {
                list.add(new Committee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

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

    @Override
    public boolean updateCommittee(Committee committee_update) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update gallery_committee set Designation=?,Name=?,FatherName=?,Address=?,Mobile=?,About=?,imgpath=? where ID=?");

            prst.setString(1, committee_update.getDesignation());

            prst.setString(2, committee_update.getName());

            prst.setString(3, committee_update.getFathername());

            prst.setString(4, committee_update.getAddress());

            prst.setString(5, committee_update.getMobile());

            prst.setString(6, committee_update.getAbout());

            prst.setString(7, committee_update.getImgpath());

            prst.setString(8, committee_update.getId());

            int a = prst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {

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

}
