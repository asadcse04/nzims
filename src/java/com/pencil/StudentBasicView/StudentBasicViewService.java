/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentBasicView;

import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.ScClassConfig.ScClassConfig;
import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface StudentBasicViewService 
{
    List<Student_Registration> studentList(ScClassConfig scCnf);
}
