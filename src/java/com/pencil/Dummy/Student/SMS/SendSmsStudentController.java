/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student.SMS;

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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author INSPIRON 5421
 */
@ManagedBean
@ViewScoped
/**
 *
 * @author AR Mamun
 */
public class SendSmsStudentController implements Serializable
{

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
    

    SendSms_Student_Service  serviceDao = new SendSms_Student_ServiceImpl();
    
    Student_Reg_Service studentService=new Student_Reg_Service_Impl();
    
    SMS_Service msgservice=new SMS_ServiceImpl();
    
    InstituteSetupService instituteService = new InstituteSetupServiceImpl();
    
    SmsTemplateService smsTempserviceDao = new SmsTemplateServiceImpl();
    
   SendSMSService getsmsdetailservicedao=new SendSMSServiceImpl();

    /**
     *
     */
    public SendSmsStudentController() 
    {   
        this.studentList=studentService.Student_cmplt_List();
        
        this.templateCategory=smsTempserviceDao.getAllSmsTemplate();
     
        
        student_data_model = new StudentDataModel(this.studentList);
        
        String instituteID="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        instituteId=Integer.valueOf(instituteID);
        
        this.smsBal=msgservice.getSmsCurrent_Ac_Balance(instituteId); //schoolid
        
//        institute = instituteService.instituteSetup();
//        
//        if(institute!=null){
//            
//        instituteId= Integer.valueOf(institute.getInstituteID());       
//        
//        }     
         
       // this.smsBal=msgservice.getSmsCurrent_Ac_Balance(1);//schoolid
    }

    /**
     *
     * @return
     */
    
    
     public void getSmsdetail()
  
  {
      
      this.tempid=Integer.parseInt(tempCategory.split("-")[0]);
      
      this.message=getsmsdetailservicedao.getSMSTemplateDetailByID(this.tempid);
  
  }
    
    
    
    
    
    public String sendSms_2_Guardian()
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
        
        return "/Dummy/Student/BulkSms/SendSmsStudent";
    }

    /**
     *
     * @return
     */
    public Student_Registration getStudent()
    { 
        if(this.student==null)
        {
            this.student=new Student_Registration();
        }
        return this.student;
    }

    /**
     *
     * @param student
     */
    public void setStudent(Student_Registration student) {
        this.student = student;
    }
    /**
     * @return the student_data_model
     */
    public StudentDataModel getStudent_data_model() {
        return student_data_model;
    }

    /**
     * @param student_data_model the student_data_model to set
     */
    public void setStudent_data_model(StudentDataModel student_data_model) {
        this.student_data_model = student_data_model;
    }

    /**
     * @return the studentList
     */
    public List <Student_Registration> getStudentList() {
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(List <Student_Registration> studentList) {
        this.studentList = studentList;
    }

    /**
     * @return the student_Filter_List
     */
    public List<Student_Registration> getStudent_Filter_List() {
        return student_Filter_List;
    }

    /**
     * @param student_Filter_List the student_Filter_List to set
     */
    public void setStudent_Filter_List(List<Student_Registration> student_Filter_List) {
        this.student_Filter_List = student_Filter_List;
    }

    /**
     * @return the selectedStudentArry
     */
    public List <Student_Registration> getSelectedStudentArry() {
        return selectedStudentArry;
    }

    /**
     * @param selectedStudentArry the selectedStudentArry to set
     */
    public void setSelectedStudentArry(List <Student_Registration> selectedStudentArry) {
        this.selectedStudentArry = selectedStudentArry;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the smsBal
     */
    public int getSmsBal() {
        return smsBal;
    }

    /**
     * @param smsBal the smsBal to set
     */
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
