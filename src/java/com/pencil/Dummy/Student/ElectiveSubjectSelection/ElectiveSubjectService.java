/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ElectiveSubjectSelection;

import com.pencil.Dummy.Student.Student_Registration;
import java.util.List;

/**
 *
 * @author INSPIRON 5421
 */
public interface ElectiveSubjectService
{
    public boolean saveElectiveSubject(List<Student_Registration> selectedStudentArry,ElectiveSubject es);
}
