/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Teacher.SMS;

import com.pencil.Dummy.Teacher.Teacher;
import com.pencil.Dummy.Teacher.TeacherService;
import com.pencil.Dummy.Teacher.TeacherServiceImpl;
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
 * @author jahangiralamdiu
 */
public class SendSmsTeacherController implements Serializable
{

    private Teacher teacher;

    private List<Teacher> teacharList;

    private List<Teacher> teachar_filter_list;

    private List<Teacher> selectedTeacher;  //the list of teacher after selection
    
    private List<SmsTemplate> templateCategory;
    
    private List<String> templateCategoryList;

    private TeacherDataModel teacher_data_model;

    private String message;
    
    private int smsBal;
    
    private InstituteSetup institute = new InstituteSetup();
    
    private int instituteId;
    
    private String tempCategory;
    
    private int tempid;
    

    SendSms_Teacher_Service serviceDao = new SendSms_Teacher_ServiceImpl();

    TeacherService teacherService = new TeacherServiceImpl();
    
    SMS_Service msgservice=new SMS_ServiceImpl();
    
    InstituteSetupService instituteService = new InstituteSetupServiceImpl();
    
   SmsTemplateService smsTempserviceDao = new SmsTemplateServiceImpl();
    
   SendSMSService getsmsdetailservicedao=new SendSMSServiceImpl();

    /**
     *
     */
    public SendSmsTeacherController()
    {
        this.teacharList = teacherService.teacherList();
        
        this.templateCategory=smsTempserviceDao.getAllSmsTemplate();

        teacher_data_model = new TeacherDataModel(this.teacharList);
        
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
    
    
    public String sendSms_2_Teacher()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.sendSms(this.selectedTeacher, this.getMessage(),this.getSmsBal()))
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully send sms to the selected teachers."));
        }
        else 
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to send sms to the selected teachers."));
        }
        
        this.selectedTeacher.clear();
        
        this.message=null;
        
        return "/Dummy/Teacher/BulkSms/SendSmsTeacher";
    }

    /**
     *
     * @return
     */
    public Teacher getTeacher()
    {
        if (this.teacher == null)
        {
            this.teacher = new Teacher();
        }
        return this.teacher;
    }

    /**
     *
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     *
     * @return
     */
    public List<Teacher> getTeacharList() {
        return teacharList;
    }

    /**
     *
     * @param teacharList
     */
    public void setTeacharList(List<Teacher> teacharList) {
        this.teacharList = teacharList;
    }

    /**
     * @return the teachar_filter_list
     */
    public List<Teacher> getTeachar_filter_list() {
        return teachar_filter_list;
    }

    /**
     * @param teachar_filter_list the teachar_filter_list to set
     */
    public void setTeachar_filter_list(List<Teacher> teachar_filter_list) {
        this.teachar_filter_list = teachar_filter_list;
    }

    /**
     * @return the selectedTeacher
     */
    public List<Teacher> getSelectedTeacher() {
        return selectedTeacher;
    }

    /**
     * @param selectedTeacher the selectedTeacher to set
     */
    public void setSelectedTeacher(List<Teacher> selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    /**
     * @return the teacher_data_model
     */
    public TeacherDataModel getTeacher_data_model() {
        return teacher_data_model;
    }

    /**
     * @param teacher_data_model the teacher_data_model to set
     */
    public void setTeacher_data_model(TeacherDataModel teacher_data_model) {
        this.teacher_data_model = teacher_data_model;
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
    public void setMessage(String message)
    {
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
    
    
    
    
   
}
