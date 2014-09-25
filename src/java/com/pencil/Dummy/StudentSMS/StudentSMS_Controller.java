/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.StudentSMS;

import com.pencil.Dummy.Student.SMS.SendSms_Student_Service;
import com.pencil.Dummy.Student.SMS.SendSms_Student_ServiceImpl;
import com.pencil.Dummy.Student.SMS.StudentDataModel;
import com.pencil.Dummy.Student.Student_Reg_Service;
import com.pencil.Dummy.Student.Student_Reg_Service_Impl;
import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.InstituteSetup.InstituteSetup;
import com.pencil.InstituteSetup.InstituteSetupService;
import com.pencil.InstituteSetup.InstituteSetupServiceImpl;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import com.pencil.SMS.SendSMS.SendSMSService;
import com.pencil.SMS.SendSMS.SendSMSServiceImpl;
import com.pencil.SMS.SmsTemplate.SmsTemplate;
import com.pencil.SMS.SmsTemplate.SmsTemplateService;
import com.pencil.SMS.SmsTemplate.SmsTemplateServiceImpl;
import java.util.ArrayList;
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
public class StudentSMS_Controller {

    private Student_Registration student;
    
    private StudentDataModel student_data_model;
     
    private List <Student_Registration> studentList;
    
    private List<Student_Registration> student_Filter_List;
    
    private List <Student_Registration> selectedStudentArry;
    
    private List<SmsTemplate> templateCategory;
    
    private List<String> templateCategoryList;

    
    private String message;
    
    private int smsBal;
    
    private InstituteSetup institute = new InstituteSetup();
    
    private int instituteId;
    
    private String tempCategory;
    
    private int tempid;
    

    StudentSMS_Service  serviceDao = new StudentSMS_ServiceImpl();
    
    Student_Reg_Service studentService=new Student_Reg_Service_Impl();
    
    SMS_Service msgservice=new SMS_ServiceImpl();
    
    InstituteSetupService instituteService = new InstituteSetupServiceImpl();
    
    SmsTemplateService smsTempserviceDao = new SmsTemplateServiceImpl();
    
   SendSMSService getsmsdetailservicedao=new SendSMSServiceImpl();
    
    public StudentSMS_Controller() 
    {
        this.studentList=studentService.Student_cmplt_List();
        
        this.templateCategory=smsTempserviceDao.getAllSmsTemplate();
     
        
        student_data_model = new StudentDataModel(this.studentList);
        
        String instituteID="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        instituteId=Integer.valueOf(instituteID);
        
        this.smsBal=msgservice.getSmsCurrent_Ac_Balance(instituteId); 
    }
    
    public void getSmsdetail() {

        this.tempid = Integer.parseInt(tempCategory.split("-")[0]);

        this.message = getsmsdetailservicedao.getSMSTemplateDetailByID(this.tempid);

    }
    
      public String sendSms_2_Student()
     {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.sendSms(this.selectedStudentArry,this.message,this.smsBal))
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully send sms."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to send sms."));
        }
        
        this.selectedStudentArry.clear();
        
        this.message=null;
        
        return "Registration/Student/BulkSmsForStudent/SendSmsForStudentImpl";
    }
   
      
      
    public Student_Registration getStudent() 
    {
        if (this.student == null) 
        {
            this.student = new Student_Registration();
        }
        return this.student;
    }


    public void setStudent(Student_Registration student) {
        this.student = student;
    }

    public StudentDataModel getStudent_data_model() {
        return student_data_model;
    }


    public void setStudent_data_model(StudentDataModel student_data_model) {
        this.student_data_model = student_data_model;
    }


    public List <Student_Registration> getStudentList() {
        return studentList;
    }


    public void setStudentList(List <Student_Registration> studentList) {
        this.studentList = studentList;
    }

    
    public List<Student_Registration> getStudent_Filter_List() {
        return student_Filter_List;
    }


    public void setStudent_Filter_List(List<Student_Registration> student_Filter_List) {
        this.student_Filter_List = student_Filter_List;
    }


    public List <Student_Registration> getSelectedStudentArry() {
        return selectedStudentArry;
    }

    public void setSelectedStudentArry(List <Student_Registration> selectedStudentArry) {
        this.selectedStudentArry = selectedStudentArry;
    }

 
    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public int getSmsBal() {
        return smsBal;
    }

    public void setSmsBal(int smsBal) {
        this.smsBal = smsBal;
    }

    public List<SmsTemplate> getTemplateCategory() {
        return templateCategory;
    }

    public void setTemplateCategory(List<SmsTemplate> templateCategory) {
        this.templateCategory = templateCategory;
    }

    public List<String> getTemplateCategoryList() {
        
        this.templateCategoryList=new ArrayList<>();
        
        for(SmsTemplate smstemp:templateCategory){
            
            this.templateCategoryList.add(smstemp.getSmsTemplateId()+"-"+smstemp.getSmsTemplateName());
        }
        return templateCategoryList;
    }

    public void setTemplateCategoryList(List<String> templateCategoryList) {
        this.templateCategoryList = templateCategoryList;
    }

   
    public String getTempCategory() {
        return tempCategory;
    }

    public void setTempCategory(String tempCategory) {
        this.tempCategory = tempCategory;
    }
    

    public int getTempid() {
        return tempid;
    }

    public void setTempid(int tempid) {
        this.tempid = tempid;
    }

}
