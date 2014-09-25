/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Student.information.AttendanceInfo;

import java.util.List;

/**
 *
 * @author SHOHUG.SQ
 */
public interface AttendanceInfoService {
    
    public List<AttendanceInfo> attenList(AttendanceInfo attendanceInfo, AttendanceInfoController aic);
    
    public List<AttendanceInfo> attenListCount(AttendanceInfo attendanceInfo, AttendanceInfoController aic);
    
    public AttendanceInfo getStudentAllinfo(String stdID);
    
}
