/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.SMS;

import com.pencil.Dummy.Student.Student_Registration;
import java.util.List;

/**
 *
 * @author AR Mamun
 */
public interface SendSms_Student_Service 
{
    public boolean sendSms(List<Student_Registration> selectedStudentArry, String message,int smsBal); 
}
