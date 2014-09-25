/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ClassTeacherAssign;

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
public class ClassTeacherAssignServiceImpl implements ClassTeacherAssignService{
  
 public boolean saveClassTeacherAssign(ClassTeacherAssign classTeacherAssign){
     
     DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try 
        {
            
            prst = con.prepareStatement("insert into class_teacher_assign values (?, ?, ?, ?)");
            prst.setString(1, classTeacherAssign.getTeacherid());
            prst.setString(2, instituteid);
            prst.setString(3, classTeacherAssign.getTeachername());
            prst.setInt(4, classTeacherAssign.getClassid());

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

public boolean updateClassTeacheAssign(ClassTeacherAssign classTeacherAssign) { 
 
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try 
        {
            
            prst = con.prepareStatement("update class_teacher_assign set ClassID=? where TeacherID=? and InstituteID=?");
            prst.setInt(1, classTeacherAssign.getClassid());
            prst.setString(2, classTeacherAssign.getTeacherid());
            prst.setString(3, instituteid);

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

public boolean deleteClassTeacheAssign(ClassTeacherAssign classTeacherAssign){

        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try 
        {
            
            prst = con.prepareStatement("delete from class_teacher_assign where TeacherID=? and InstituteID=? and ClassID=?");
            
             prst.setString(1, classTeacherAssign.getTeacherid());
             prst.setString(2, instituteid);
              prst.setInt(3, classTeacherAssign.getClassid());


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

public List<Integer> classlist(){
 
    List<Integer> list=new ArrayList<Integer>();
 
      DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try 
        {
            
            prst = con.prepareStatement("select ClassID from class");
            rs=prst.executeQuery();
       
            while(rs.next()){
                
                list.add(rs.getInt(1));
            }

            return list;

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
     
     return list;
 
 
}

public List<ClassTeacherAssign> classteacherAssignList(){
  
    List<ClassTeacherAssign> list=new ArrayList<ClassTeacherAssign>();
 
      DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        try 
        {
            
            prst = con.prepareStatement("select TeacherID,TeacherName,ClassID from class_teacher_assign");
            rs=prst.executeQuery();
       
            while(rs.next()){
                
                list.add(new ClassTeacherAssign(rs.getString(1),rs.getString(2),rs.getInt(3)));
            }

            return list;

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
     
     return list;
  
}


public List<ClassTeacherAssign> teacherList(){
  
  List<ClassTeacherAssign> list=new ArrayList<ClassTeacherAssign>();
 
      DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        ResultSet rs=null;
        
        String instituteid="";
        FacesContext context=FacesContext.getCurrentInstance();
        instituteid=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        try 
        {
            
            prst = con.prepareStatement("select TeacherID,TeacherName,ImgPath from teacher where InstituteID=?");
            prst.setString(1, instituteid);
            rs=prst.executeQuery();
       
            while(rs.next()){
                
                list.add(new ClassTeacherAssign(rs.getString(1),rs.getString(2),rs.getString(3)));
            }

            return list;

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
     
     return list;  
    
}


}
