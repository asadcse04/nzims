/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentBasicView;

import com.pencil.Connection.DB_Connection;
import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.ScClassConfig.ScClassConfig;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mastermind
 */
public class StudentBasicViewServiceImpl implements StudentBasicViewService,Serializable
{

    @Override
    public List<Student_Registration> studentList(ScClassConfig scCnf)
    {
      DB_Connection o=new DB_Connection(); 
       
        Connection con=o.getConnection();
        
        PreparedStatement prst = null;
        
        ResultSet rs = null;
        
        String instituteID="";

        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        List<Student_Registration> stdList=new ArrayList<Student_Registration>();
       
        List<Integer> scCnfId_List =new ArrayList<Integer>();
        
        try
        {    
            prst = con.prepareStatement("SELECT scCnf.ScConfigID FROM classconfig scCnf,class c,shift s,section sctn where scCnf.ClassID=c.ClassID and scCnf.InstituteID=sctn.InstituteID and scCnf.InstituteID='"+instituteID+"'"
                    + " and scCnf.ShiftID=s.ShiftID and scCnf.SectionID=sctn.SectionID and scCnf.ClassID=(SELECT ClassID FROM class where ClassName=?)"
                    + " and scCnf.ShiftID=(SELECT ShiftID FROM shift where ShiftName=?) and scCnf.SectionID=(SELECT SectionID FROM section where SectionName=?)");
       
            prst.setString(1,scCnf.getClassName());
            
            prst.setString(2,scCnf.getShiftName());
            
            prst.setString(3,scCnf.getSectionName());
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                scCnfId_List.add(rs.getInt("scCnf.ScConfigID"));
            }
            
            rs.close();
            
            prst.close();
            
            
            String qr=implode_scCnfID(scCnfId_List,",");
            
            
            prst = con.prepareStatement("SELECT si.StudentID,s.StudentName,s.StudentRoll,s.Gender,g.FatherName,g.ContactNo FROM student_identification si,student_basic_info s,student_guardian_info g where"
                    + " si.StudentID=s.StudentID and si.StudentID=g.StudentID and si.InstituteID=s.InstituteID and si.InstituteID=g.InstituteID and si.InstituteID='"+instituteID+"'"
                    + " and si.ClassConfigID IN("+qr+") order by s.StudentRoll");
            
            rs = prst.executeQuery();
            
            while(rs.next())
            {
                stdList.add(new Student_Registration(rs.getString("si.StudentID"),rs.getString("s.StudentName"),rs.getInt("s.StudentRoll"),rs.getString("s.Gender"),rs.getString("g.FatherName"),rs.getString("g.ContactNo")));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(prst!=null)
                {
                    prst.close();
                }
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
        }
        
        return stdList;
    }
    
    
    private String implode_scCnfID(List<Integer> input, String glueString)
    {
        String output = "";
        
        int i=1;
        
        Iterator<Integer> itr=input.iterator();
        
        if (input.size()> 0)
        {
            StringBuilder sb = new StringBuilder();
	 
            while(itr.hasNext())
            {
		sb.append(itr.next());
                
                if(input.size()!=i)
                {
                    sb.append(glueString);
                }
                i++;
            }
            
            output = sb.toString();    
        }
        
        return output;
    }

    
}
