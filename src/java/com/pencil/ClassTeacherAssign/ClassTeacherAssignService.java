/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ClassTeacherAssign;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface ClassTeacherAssignService {
    
public boolean saveClassTeacherAssign(ClassTeacherAssign classTeacherAssign);

public boolean updateClassTeacheAssign(ClassTeacherAssign classTeacherAssign);

public boolean deleteClassTeacheAssign(ClassTeacherAssign classTeacherAssign);

public List<Integer> classlist();

public List<ClassTeacherAssign> classteacherAssignList();

public List<ClassTeacherAssign> teacherList();

}
