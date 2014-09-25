/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.facility.library.BookPublication;

import com.pencil.Connection.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHOHUG-SQ
 */
public class PublicationServiceImpl implements PublicationService {

    @Override
    public boolean addPublication(Publication publication) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("insert into library_publication values (null, ?, ?, ?, ?, ?)");

            prst.setString(1, publication.getPublicationName());

            prst.setString(2, publication.getPublicationAddress());

            prst.setString(3, publication.getContactno());

            prst.setString(4, publication.getAboutPublication());

            prst.setString(5, publication.getPublicationnote());

            int add = prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
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

    @Override
    public boolean updatePublication(Publication publication) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {
            prst = con.prepareStatement("update library_publication set Publication_Name=?, Publication_Address=?, ContactNo=?, About=?, Note=? where Publication_ID=?");

            prst.setString(1, publication.getPublicationName());

            prst.setString(2, publication.getPublicationAddress());

            prst.setString(3, publication.getContactno());

            prst.setString(4, publication.getAboutPublication());

            prst.setString(5, publication.getPublicationnote());

            prst.setInt(6, publication.getPublicationId());

            int add = prst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
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

    @Override
    public List<Publication> getAllPublication() {

        List<Publication> publicationAllList = new ArrayList<Publication>();

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        try {
            prst = con.prepareStatement("select * from library_publication");

            rs = prst.executeQuery();

            while (rs.next()) {
                publicationAllList.add(new Publication(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }
            return publicationAllList;

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

        return publicationAllList;
    }

}
