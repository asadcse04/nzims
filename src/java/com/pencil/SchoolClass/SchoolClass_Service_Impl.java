/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SchoolClass;

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
public class SchoolClass_Service_Impl implements SchoolClass_Service, Serializable {

    @Override
    public List<SchoolClass> schoolclassList() {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
       

        List<SchoolClass> schoolList = new ArrayList<SchoolClass>();

        try {

            prst = con.prepareStatement("select * from class");

            rs = prst.executeQuery();
            
            while (rs.next())
            {                
                schoolList.add(new SchoolClass(rs.getInt("ClassID"), rs.getString("ClassName"), rs.getString("Note")));
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
                if(rs!=null)
                {
                    rs.close();
                }
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

        return schoolList;
    }

    @Override
    public boolean createSchoolClass(SchoolClass sclass)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        int classid=0;
        try {
            
            prst=con.prepareStatement("select max(ClassID) from class");
            rs=prst.executeQuery();
           if(rs.next()){
               classid=rs.getInt(1)+1;
           }
           else{
               classid=1;
           }

            prst = con.prepareStatement("insert into class values (?,?,?)");

            prst.setInt(1, classid);
            prst.setString(2, sclass.getClassName());

            prst.setString(3, sclass.getNote());

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
                 if (rs != null) 
                {
                    rs.close();
                }
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

    @Override
    public boolean updateSchoolClass(SchoolClass sclassObj) {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update class set ClassName=?, Note=? where ClassID=? ");

            prst.setString(1, sclassObj.getClassName());

            prst.setString(2, sclassObj.getNote());

            prst.setInt(3, sclassObj.getClassID());

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
