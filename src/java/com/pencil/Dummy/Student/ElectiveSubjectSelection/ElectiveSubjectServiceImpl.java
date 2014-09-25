/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ElectiveSubjectSelection;

import com.pencil.Connection.DB_Connection;
import com.pencil.Dummy.Student.Student_Registration;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author INSPIRON 5421
 */
public class ElectiveSubjectServiceImpl implements ElectiveSubjectService,Serializable
{

    /**
     *
     * @param selectedStudentArry
     * @param es
     * @return
     */
    @Override
    public boolean saveElectiveSubject(List<Student_Registration> selectedStudentArry, ElectiveSubject es)
    {
        DB_Connection o = new DB_Connection();

        Connection con = o.getConnection();

        PreparedStatement prst = null;
        
        try
        {
            con.setAutoCommit(false);

            prst=con.prepareStatement("insert into student_4th_subject_wrap values(?,(Select SubjectID from subject where SubjectName=?),?)");
            
            if(es.getClassName().equals("Nine"))
            {
                for(Student_Registration student : selectedStudentArry)
                {
                    for (int i=0; i<2; i++)
                    {
                        if (i == 0) 
                        {
                            prst.setString(1, student.getStudentID());

                            prst.setString(2, es.getCmpl_1_sbjName());

                            prst.setBoolean(3, true);
                        } 
                        else
                        {
                            prst.setString(1, student.getStudentID());

                            prst.setString(2, es.getOptn_1_sbjName());

                            prst.setBoolean(3, false);
                        }
                        
                        prst.addBatch();
                    }
                }
            }
            if(es.getClassName().equals("Eleven"))
            {
                for(Student_Registration student : selectedStudentArry)
                {
                    for (int i=0; i<4; i++)
                    {
                        if (i == 0) 
                        {
                            prst.setString(1, student.getStudentID());

                            prst.setString(2, es.getCmpl_1_sbjName());

                            prst.setBoolean(3, true);
                        } 
                        else if(i==1)
                        {
                            prst.setString(1,student.getStudentID());

                            prst.setString(2,es.getOptn_1_sbjName());

                            prst.setBoolean(3, false);
                        }
                        else if(i==2)
                        {
                            prst.setString(1,student.getStudentID());

                            prst.setString(2,es.getCmpl_2_sbjName());

                            prst.setBoolean(3,true);
                        }
                        
                        else if(i==3)
                        {
                            prst.setString(1,student.getStudentID());

                            prst.setString(2,es.getOptn_2_sbjName());

                            prst.setBoolean(3,false);
                        }
                        
                        prst.addBatch();
                    }
                }
            }
            
            int [] update = prst.executeBatch();
            
            con.commit();
            
            System.out.println("Total Student To Select 4th Subject:" + update.length);

            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
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
            catch (SQLException ex)
            {
                System.out.println(ex);
            }
            
            selectedStudentArry.clear();
            
            es=null;
        }
        return false;
    }
    
}
