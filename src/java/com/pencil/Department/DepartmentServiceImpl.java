/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Department;

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
public class DepartmentServiceImpl implements DepartmentService, Serializable 
{

    @Override
    public List<Department> departmentList()
    {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        ResultSet rs = null;

        List<Department> depertList = new ArrayList<Department>();

        try {

            prst = con.prepareStatement("select * from department");

            rs = prst.executeQuery();

            while (rs.next())
            {
                depertList.add(new Department(rs.getInt("DepartmentID"), rs.getString("DepartmentName"), rs.getString("Note")));
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

        return depertList;
    }

    @Override
    public boolean createDepartment(Department dept)
    {
        
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        int departmentid=0;
        
        try
        {
            prst=con.prepareStatement("select max(DepartmentID) from department");
            rs=prst.executeQuery();
            
            if(rs.next()){
                departmentid=rs.getInt(1)+1;
            }
            else{
                departmentid=1;
            }
            
            prst = con.prepareStatement("insert into department values (?,?,?)");

            prst.setInt(1, departmentid);
            
            prst.setString(2, dept.getDepartmentName());

            prst.setString(3, dept.getNote());

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
    public boolean updateDepartment(Department deptObj) 
    {

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;

        try {

            prst = con.prepareStatement("update department set DepartmentName=?, Note=? where DepartmentID=?");

            prst.setString(1, deptObj.getDepartmentName());

            prst.setString(2, deptObj.getNote());

            prst.setInt(3, deptObj.getDepartmentID());

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
