/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam;

import java.util.List;

/**
 *
 * @author Mahfuj
 */
public interface ExamService
{
    public boolean createExam(Exam exam);
    
    public boolean updateExam(Exam examObj);
    
    List<Exam> examList();
    
    List<Exam> examList( String instituteid);
}
