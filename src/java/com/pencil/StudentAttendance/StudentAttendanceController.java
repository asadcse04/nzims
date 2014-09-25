/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentAttendance;

import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.InstituteSetup.InstituteSetupService;
import com.pencil.InstituteSetup.InstituteSetupServiceImpl; 
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import com.pencil.ScClassConfig.ScClassConfig;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author salim
 */
@ManagedBean
@ViewScoped
public class StudentAttendanceController {

  
    private StudentAttendance student_attendance;
    
    private List<Student_Registration> studentList;
    
    
    private StudentAttendanceReport attendanceReport;
    
    private List<StudentAttendanceReport> attdn_reportList;
    
    private List<StudentAttendanceReport> attdn_Filter_reportList;
    
    
    private ScClassConfig classConfig;
    
    private StringBuilder scCnf_id_List;
    
    private List<ScClassConfig> school_configList;
    
    private List<ScClassConfig> school_configList_filter;
    
    
    StudentAttendance_Service serviceDao=new StudentAttendance_Service_Impl();
    
    Sc_ClassConfigService scCnfService=new Sc_ClassCofigService_Impl();
    
    SMS_Service smsService=new SMS_ServiceImpl();
    
    InstituteSetupService instituteService = new InstituteSetupServiceImpl();
    
    
    private QrOption queryOption;
    
    private boolean renderCall;
    
    private int sms_bal;
    
    private boolean sms_with_attendance;

    /**
     * Creates a new instance of StudentAttendanceController
     */
    public StudentAttendanceController()
    {
        this.school_configList=scCnfService.scClassConfiguration_List_ed();
        
        
         String instituteID="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        int instituteId=Integer.valueOf(instituteID);
        
         this.sms_bal = smsService.getSmsCurrent_Ac_Balance(instituteId);//Schoolid:1 
         
        
//        InstituteSetup institute = new InstituteSetup();
//        
//        institute = instituteService.instituteSetup();
//        
//        int instituteId = Integer.valueOf(institute.getInstituteID());
              
//        this.sms_bal = smsService.getSmsCurrent_Ac_Balance(1);//Schoolid:1
        
        System.out.println(this.sms_bal);
    }
    
    /**
     *
     * @param scCnf
     */
    public void student_List(ScClassConfig scCnf)
    {
        setClassConfig(scCnf);
        
        setScCnf_id_List(scCnfService.scClassConfig_ID_List(scCnf));
        
        setStudentList(scCnfService.studentList(this.getScCnf_id_List()));
    }
    
    /**
     *
     * @param scCnf
     */
    public void student_attendance_Report(ScClassConfig scCnf)
    {
        setClassConfig(scCnf);
        
        setScCnf_id_List(scCnfService.scClassConfig_ID_List(scCnf));
    }
   
    /**
     *
     */
    public void printReport()
    {
        if(this.queryOption.getFrom()!=null && this.queryOption.getTo()!=null)
        {
            if(this.isRenderCall())
            {
                this.setRenderCall(false);
            }
            else
            {
                setAttdn_reportList(serviceDao.attendanceReport(this.queryOption.getFrom(),this.queryOption.getTo(),this.getScCnf_id_List()));
                
                this.setRenderCall(true);
            }
        }
    }
   
    /**
     *
     * @param dt
     */
    public void AttendanceDate(Date dt)
    {
        this.student_attendance.setAttendance_date(dt);
    }
    
    /**
     *
     * @param sr
     * @param i
     */
    public synchronized void Absent(Student_Registration sr,int i)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        boolean flag = false;
        
        this.student_attendance.setStudentID(sr.getStudentID());
        
        if(this.student_attendance.getAttendance_date()!=null)
        {
             if(i==0)
             {
              flag=this.serviceDao.saveAttendance(student_attendance);
             }
             else
             {
                 if(this.student_attendance.getRemarks().equals("Application")) 
                 { 
                     this.student_attendance.setRemarks("Application");
                
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }
                 else if(this.student_attendance.getRemarks().equals("Incomplete")){
                     
                     this.student_attendance.setRemarks("Incomplete");
                
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }
                 
                 else if(this.student_attendance.getRemarks().equals("Leave"))
                 {
                     this.student_attendance.setRemarks("Leave");
                     
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }  
                 
                 else if(this.student_attendance.getRemarks().equals("4"))
                 {
                     this.student_attendance.setAbsent(true);
                
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }
                  else if(this.student_attendance.getRemarks().equals("3"))
                 {
                     this.student_attendance.setAbsent(true);
                
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }
                  
                   else if(this.student_attendance.getRemarks().equals("2"))
                 {
                     this.student_attendance.setAbsent(true);
                
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }
                   
                    else if(this.student_attendance.getRemarks().equals("1"))
                 {
                     this.student_attendance.setAbsent(true);
                
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }
                    
                           
                    
               
                 else if(this.student_attendance.getRemarks().equals(""))
                 {
                     this.student_attendance.setAbsent(false);
                
                     this.student_attendance.setRemarks(null);
                 
                     flag=this.serviceDao.saveAttendance(student_attendance);
                 }
             }
             
             this.student_attendance.setAbsent(false);
        
             this.student_attendance.setRemarks("");
        
        }//Date null check End!!!!
       
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please select Date & take attendance..",""));
        }
        
        if(flag)
        {
            context.addMessage(null, new FacesMessage("Successful","End Execution...."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to execute.. !",""));
        }
    }

    /**
     *
     * @return
     */
    public String finishAttendance()
    {
        setScCnf_id_List(scCnfService.scClassConfig_ID_List(this.getClassConfig()));
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(this.student_attendance.getAttendance_date()!=null && !this.studentList.isEmpty())
        {
            if(serviceDao.completeAttendance(this.student_attendance.getAttendance_date(),this.studentList,this.getScCnf_id_List(),this.sms_bal,this.sms_with_attendance)==200)
            {
                context.addMessage(null, new FacesMessage("Successful Take attendance succesfully with sending text sms..",""));
            }
            else if(serviceDao.completeAttendance(this.student_attendance.getAttendance_date(),this.studentList,this.getScCnf_id_List(),this.sms_bal,this.sms_with_attendance)==150)
            {
                context.addMessage(null, new FacesMessage("Successful Take attendance succesfully but no text sms send for the attendance..",""));
            }
            else if(serviceDao.completeAttendance(this.student_attendance.getAttendance_date(),this.studentList,this.getScCnf_id_List(),this.sms_bal,this.sms_with_attendance)==100)
            {
                context.addMessage(null, new FacesMessage("Successful Take attendance succesfully with no absent student..",""));
            }
            else if(serviceDao.completeAttendance(this.student_attendance.getAttendance_date(),this.studentList,this.getScCnf_id_List(),this.sms_bal,this.sms_with_attendance)==111)
            {
                context.addMessage(null, new FacesMessage("Successful Take attendance succesfully but sms_count !=cntno count..",""));
            }
            else if(serviceDao.completeAttendance(this.student_attendance.getAttendance_date(),this.studentList,this.getScCnf_id_List(),this.sms_bal,this.sms_with_attendance)==0)
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to take attendance.. !",""));
            }
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please select Date & take attendance..",""));
        }
        
        this.getScCnf_id_List().setLength(0);
        
        this.classConfig=null;
        
        this.studentList.clear();
        
       // return "index.xhtml";
        return "/Attendance/TakeAttendance/AttendencePage.xhtml";
    }
    
    /**
     * @return the school_configList
     */
    public List<ScClassConfig> getSchool_configList() {
        return school_configList;
    }

    /**
     * @param school_configList the school_configList to set
     */
    public void setSchool_configList(List<ScClassConfig> school_configList) {
        this.school_configList = school_configList;
    }

    /**
     * @return the studentList
     */
    public List<Student_Registration> getStudentList() {
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(List<Student_Registration> studentList) {
        this.studentList = studentList;
    }

    /**
     * @return the school_configList_filter
     */
    public List<ScClassConfig> getSchool_configList_filter() {
        return school_configList_filter;
    }

    /**
     * @param school_configList_filter the school_configList_filter to set
     */
    public void setSchool_configList_filter(List<ScClassConfig> school_configList_filter) {
        this.school_configList_filter = school_configList_filter;
    }

    /**
     * @return the student_attendance
     */
    public StudentAttendance getStudent_attendance()
    {
        if(this.student_attendance==null)
        {
            this.student_attendance=new StudentAttendance();
        }
        return student_attendance;
    }

    /**
     * @param student_attendance the student_attendance to set
     */
    public void setStudent_attendance(StudentAttendance student_attendance) {
        this.student_attendance = student_attendance;
    }

    /**
     * @return the attendanceReport
     */
    public StudentAttendanceReport getAttendanceReport()
    {
        if(this.attendanceReport==null)
        {
            this.attendanceReport=new StudentAttendanceReport();
        }
        return this.attendanceReport;
    }

    /**
     * @param attendanceReport the attendanceReport to set
     */
    public void setAttendanceReport(StudentAttendanceReport attendanceReport) {
        this.attendanceReport = attendanceReport;
    }

    /**
     * @return the attdn_reportList
     */
    public List<StudentAttendanceReport> getAttdn_reportList() {
        return attdn_reportList;
    }

    /**
     * @param attdn_reportList the attdn_reportList to set
     */
    public void setAttdn_reportList(List<StudentAttendanceReport> attdn_reportList) {
        this.attdn_reportList = attdn_reportList;
    }

    /**
     * @return the renderCall
     */
    public boolean isRenderCall() {
        return renderCall;
    }

    /**
     * @param renderCall the renderCall to set
     */
    public void setRenderCall(boolean renderCall) {
        this.renderCall = renderCall;
    }

    /**
     * @return the queryOption
     */
    public QrOption getQueryOption()
    {
        if(this.queryOption==null)
        {
            this.queryOption=new QrOption();
        }
        return this.queryOption;
    }

    /**
     * @param queryOption the queryOption to set
     */
    public void setQueryOption(QrOption queryOption) {
        this.queryOption = queryOption;
    }

    /**
     * @return the attdn_Filter_reportList
     */
    public List<StudentAttendanceReport> getAttdn_Filter_reportList() {
        return attdn_Filter_reportList;
    }

    /**
     * @param attdn_Filter_reportList the attdn_Filter_reportList to set
     */
    public void setAttdn_Filter_reportList(List<StudentAttendanceReport> attdn_Filter_reportList) {
        this.attdn_Filter_reportList = attdn_Filter_reportList;
    }

    /**
     * @return the scCnf_id_List
     */
    public StringBuilder getScCnf_id_List() {
        return scCnf_id_List;
    }

    /**
     * @param scCnf_id_List the scCnf_id_List to set
     */
    public void setScCnf_id_List(StringBuilder scCnf_id_List) {
        this.scCnf_id_List = scCnf_id_List;
    }

    /**
     * @return the classConfig
     */
    public ScClassConfig getClassConfig() {
        return classConfig;
    }

    /**
     * @param classConfig the classConfig to set
     */
    public void setClassConfig(ScClassConfig classConfig) {
        this.classConfig = classConfig;
    }

    /**
     * @return the sms_bal
     */
    public int getSms_bal() {
        return sms_bal;
    }

    /**
     * @param sms_bal the sms_bal to set
     */
    public void setSms_bal(int sms_bal) {
        this.sms_bal = sms_bal;
    }

    /**
     * @return the sms_with_attendance
     */
    public boolean isSms_with_attendance() {
        return sms_with_attendance;
    }

    /**
     * @param sms_with_attendance the sms_with_attendance to set
     */
    public void setSms_with_attendance(boolean sms_with_attendance) {
        this.sms_with_attendance = sms_with_attendance;
    }
}
