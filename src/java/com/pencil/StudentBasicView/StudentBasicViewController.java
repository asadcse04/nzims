/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentBasicView;

import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.ScClassConfig.ScClassConfig;
import com.pencil.StudentAttendance.StudentAttendance_Service;
import com.pencil.StudentAttendance.StudentAttendance_Service_Impl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mastermind
 */
@ManagedBean
@ViewScoped
public class StudentBasicViewController {

  private List<Student_Registration> studentBasicViewList;
  
   private ScClassConfig classConfig;
   
   private List<ScClassConfig> school_configList;
   
   StudentAttendance_Service attendanceServiceDao=new StudentAttendance_Service_Impl();
   
   StudentBasicViewService serviceDao = new StudentBasicViewServiceImpl();
  
    public StudentBasicViewController()
    {
          this.school_configList=attendanceServiceDao.scClassConfiguration_List();
          
    }

     public void student_List(ScClassConfig scCnf)
    {
        setClassConfig(scCnf);
        
        setStudentBasicViewList(serviceDao.studentList(scCnf));
    }
     
    public List<Student_Registration> getStudentBasicViewList() {
        return studentBasicViewList;
    }

    public void setStudentBasicViewList(List<Student_Registration> studentBasicViewList) {
        this.studentBasicViewList = studentBasicViewList;
    }

    public ScClassConfig getClassConfig()
    {
         if(this.classConfig==null)
        {
            this.classConfig=new ScClassConfig();
        }
        return classConfig;
    }

    public void setClassConfig(ScClassConfig classConfig) {
        this.classConfig = classConfig;
    }

    public List<ScClassConfig> getSchool_configList() {
        return school_configList;
    }

    public void setSchool_configList(List<ScClassConfig> school_configList) {
        this.school_configList = school_configList;
    }
    
    
}
