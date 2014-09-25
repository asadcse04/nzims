/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Subject;

import java.util.List;

/**
 *
 * @author user
 */
public interface SubjectService
{
    public boolean createSubject(Subject sbjt);
    
    public boolean updateSubject(Subject sbjtObj);
    
    List<Subject> subjectList();
}
