/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult.MeritPosition;

import com.pencil.Dummy.Student.ExamResult.StudentMeritList;
import com.pencil.SMS.SMS_Service;
import java.util.List;

/**
 *
 * @author apple
 */
public interface MeritPositionService
{
    public boolean class_Wise_Merit_position(int excnfid,List<StudentMeritList> sml);
    
    public boolean shift_Wise_Merit_position(int excnfid,int acyrid,String className);
    
    public boolean section_Wise_Merit_position(int excnfid,StringBuilder scCnf_id_list);
    
    public List<StudentMeritList> prepareStudent_list_to_send_result_sms(int excnf_id);
    
    public boolean send_Student_result_Sms(List<StudentMeritList>  studentList,SMS_Service smsC);
}
