/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentReg;

import java.util.List;

/**
 *
 * @author salim
 */
public interface StudentRegService 
{
     public List<StudentReg> getStudent_insertList();
     
     public boolean quickStudentReg( int scCnf_ID, List<StudentReg> stdList,StudentReg studentReg);
}
