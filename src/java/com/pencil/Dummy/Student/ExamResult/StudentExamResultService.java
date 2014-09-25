/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult;

import java.util.List;

/**
 *
 * @author apple
 */
public interface StudentExamResultService 
{
    public int getExCnfID(int acyr,String className,String ExamName);
    
    public List<StudentExamResult> getStudent_insertResult(int scCnfID,String subjectName);
    
    public StringBuilder scCnfID(String className);  
    
    public boolean insertStudentExamScore(int exCnfID,String subjectName,int teacherID,List<StudentExamResult> examRsList,List<ExamGrade> exmGrdList);
    
    public void generateMeritList(int exCnfID,StringBuilder scCnfID,List<ExamGrade> exmGrdList);
    
    public List<StudentMeritList> StudentMeritList(int exCnfID);
    
    public List<ExamGrade> examGradeList();
    
    public int editStudentResult(int exCnfID,String subjectName,ViewStudentResult stdExmRs,List<ExamGrade> exmGrdList);
    
    public List<ViewStudentResult> studentExamResult(int exCnfID,int scCnfID,String subjectName);
}
