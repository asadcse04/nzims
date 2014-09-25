/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.SMS;

import com.pencil.Dummy.Student.Student_Registration;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author jahangiralamdiu
 */
public class StudentDataModel extends ListDataModel<Student_Registration> implements SelectableDataModel<Student_Registration>,Serializable
{

    /**
     *
     */
    public StudentDataModel() {
    }

    /**
     *
     * @param list
     */
    public StudentDataModel(List<Student_Registration> list) {
        super(list);
    }

    /**
     *
     * @param studentID
     * @return
     */
    @Override
    public Student_Registration getRowData(String studentID)
    {           
        List<Student_Registration> studentData = (List<Student_Registration>) getWrappedData();  
          
        for(Student_Registration student : studentData)
        {     
            if(student.getStudentID().equals(studentID))
            {
                return student;    
            }
        }          
        return null; 
    }

    /**
     *
     * @param student
     * @return
     */
    @Override
    public Object getRowKey(Student_Registration student)
    {  
        return student.getStudentID();
    }
    
}