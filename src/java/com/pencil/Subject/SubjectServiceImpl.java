/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Subject;

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
 * @author user
 */
public class SubjectServiceImpl implements SubjectService, Serializable {

    @Override
    public List<Subject> subjectList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<Subject> subjectList = new ArrayList<Subject>();

        try {

            prst = con.prepareStatement("select * from subject");

            rs = prst.executeQuery();

            while (rs.next()) 
            {
                subjectList.add(new Subject(rs.getInt("SubjectID"), rs.getString("SubjectName"), rs.getInt("SubjectCode"), rs.getBoolean("Status"), rs.getString("Note")));
            }

            prst.close();

            con.close();

            rs.close();

        }
        catch (SQLException e) 
        {
            System.out.println(e);
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

        return subjectList;
    }

    @Override
    public boolean createSubject(Subject sbjt) {
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        try {

            prst = con.prepareStatement("insert into subject values (null,?,?,?,?)");

            prst.setString(1, sbjt.getSubjectName());

            prst.setInt(2, sbjt.getSubjectCode());

            prst.setBoolean(3, sbjt.getStatus());

            prst.setString(4, sbjt.getNote());
            
            prst.execute();

            prst.close();

            con.close();

            return true;
        }
        catch (SQLException e) 
        {
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

    @Override
    public boolean updateSubject(Subject sbjtObj) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update subject set SubjectName=?, SubjectCode=?, Status=?, Note=? where  SubjectID=?");

            prst.setString(1, sbjtObj.getSubjectName());

            prst.setInt(2, sbjtObj.getSubjectCode());

            prst.setBoolean(3, sbjtObj.getStatus());

            prst.setString(4, sbjtObj.getNote());

            prst.setInt(5, sbjtObj.getSubjectID());

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

}
