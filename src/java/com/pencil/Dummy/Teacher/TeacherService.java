/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Teacher;

import java.util.List;


/**
 *
 * @author user
 */
public interface TeacherService 
{
    public boolean saveTeacher(Teacher tchr);
    
    public List<Teacher> teacherList(); 
    
    public boolean updateTeacher(Teacher tchr);
    
}
