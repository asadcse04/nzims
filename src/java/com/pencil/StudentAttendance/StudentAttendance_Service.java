/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.StudentAttendance;

import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.ScClassConfig.ScClassConfig;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Mahfuj
 */
public interface StudentAttendance_Service
{
    List<ScClassConfig> scClassConfiguration_List();
    
    List<StudentAttendanceReport> attendanceReport(Date from,Date to,StringBuilder scCnf);
    
    public boolean saveAttendance(StudentAttendance sa);
    
    public int completeAttendance(Date ad,ScClassConfig scClassConfig,List<Student_Registration> studentList,StringBuilder scnf,int smsBalnc,boolean sms_with_attendance);
    
    public int checkAttendance(Date ad,StringBuilder scCnf);
}
