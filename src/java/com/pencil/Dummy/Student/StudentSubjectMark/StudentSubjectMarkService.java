/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.StudentSubjectMark;


import com.pencil.ScClassConfig.ScClassConfig;
import java.util.List;

/**
 *
 * @author apple
 */
public interface StudentSubjectMarkService 
{
    public int getExCnfID(int acyr,String className,String ExamName);
    
    public List<StudentExamResult> getStudent_insertResult(StudentSubjectMark studentSubjectMark);
    
    public StringBuilder scCnfID(String className);  
    
    public List<StudentSubjectMark> scClassSubMarkInsert_List_ed();
    
    public boolean insertStudentExamScore(int exCnfID,String subjectName,int teacherID,List<StudentExamResult> examRsList,List<ExamGrade> exmGrdList);
    
    public void generateMeritList(int exCnfID,StringBuilder scCnfID,List<ExamGrade> exmGrdList);
    
    public List<StudentMeritList> StudentMeritList(int exCnfID);
    
    public List<ExamGrade> examGradeList();
    
    public int editStudentResult(int exCnfID,String subjectName,List<ViewStudentResult> examRsList,List<ExamGrade> exmGrdList);
    
    public List<ViewStudentResult> studentExamResult(int exCnfID,int scCnfID,String subjectName);
    
    StringBuilder scClassConfig_ID_List(StudentSubjectMark scCnf);
    
    public int ScCnfID(StudentSubjectMark list);
    
    public List<String> subjectList(StudentSubjectMark sbj_cnf);
}
