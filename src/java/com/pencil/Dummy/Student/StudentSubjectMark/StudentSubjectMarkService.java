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
    
    public List<StudentSubjectMark> getStudent_insertResult(StudentSubjectMark studentSubjectMark,int examconfigid);
    
    public StringBuilder scCnfID(String className);  
    
    public List<StudentSubjectMark> scClassSubMarkInsert_List_ed();
    
    public boolean insertStudentExamScore(int exCnfID,String subjectName,int teacherID,List<StudentSubjectMark> examRsList,List<ExamGrade> exmGrdList);
    
    public void generateMeritList(int exCnfID,StringBuilder scCnfID,List<ExamGrade> exmGrdList);
    
    public List<StudentMeritList> StudentMeritList(int exCnfID);
    
    public List<ExamGrade> examGradeList();
    
    public int editStudentResult(int exCnfID,String subjectName,List<StudentSubjectMark> examRsList,List<ExamGrade> exmGrdList);
    
    public List<StudentSubjectMark> getUpdateSubjectMarkList(int exCnfID,StudentSubjectMark studentSubjectMark);
    
    StringBuilder scClassConfig_ID_List(StudentSubjectMark scCnf);
    
    public int ScCnfID(StudentSubjectMark list);
    
    public List<String> subjectList(StudentSubjectMark sbj_cnf);
    
    public boolean processStuduntExamResult(int exCnfID, String subjectName, int teacherID, List<StudentSubjectMark> examRsList, List<ExamGrade> exmGrdList,int acyear);
    
    

}
