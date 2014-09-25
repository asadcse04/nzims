/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/** 
 *
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class StudentListController implements Serializable
{
    private Student_Registration student;
    
    private List<Student_Registration> studentList;
    
    private List<Student_Registration> student_Filter_List;
    
    Student_Reg_Service serviceDao=new Student_Reg_Service_Impl();

    /**
     * Creates a new instance of StudentListController
     */
    public StudentListController()
    {
        this.studentList=serviceDao.Student_cmplt_List();
    }

    /**
     * @return the student
     */
    public Student_Registration getStudent()
    {
        if(this.student==null)
        {
            this.student=new Student_Registration();
        }
        return this.student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student_Registration student) {
        this.student = student;
    }

    /**
     * @return the studentList
     */
    public List<Student_Registration> getStudentList() {
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(List<Student_Registration> studentList) {
        this.studentList = studentList;
    }

    /**
     * @return the student_Filter_List
     */
    public List<Student_Registration> getStudent_Filter_List() {
        return student_Filter_List;
    }

    /**
     * @param student_Filter_List the student_Filter_List to set
     */
    public void setStudent_Filter_List(List<Student_Registration> student_Filter_List) {
        this.student_Filter_List = student_Filter_List;
    }
}
