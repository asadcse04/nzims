/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student;

import java.util.List;

/**
 *
 * @author Mahfuj 
 */
public interface Student_Reg_Service
{
    public boolean completeStudentReg(Student_Registration stdReg,int scCnf_ID);
    
    public boolean additionalInfo(Student_Registration addtionalInfo,String StudentID);
    
    public List<Student_Registration>additionalInfoChak(Student_Registration std);
    
    public boolean completeStudentUpdate(Student_Registration stdUpt);
    
    public boolean updateAcademicInfo(Student_Registration stdReg,int scCnf_ID);
    
    public List<String> elective_SubjectList(int acyr,String sc_class,String sc_dept);
    
    public List<Student_Registration> Student_cmplt_List();
}
