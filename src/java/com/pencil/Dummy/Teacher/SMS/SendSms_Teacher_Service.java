/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  com.pencil.Dummy.Teacher.SMS;

import com.pencil.Dummy.Teacher.Teacher;
import java.util.List;

/**
 *
 * @author jahangiralamdiu
 */
public interface SendSms_Teacher_Service 
{  
    public boolean sendSms(List<Teacher> selectedTchrArry, String message,int smsBal);  
}
