/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff.SMS;

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
import com.pencil.Stuff.Stuff_Reg;
import com.pencil.Stuff.Stuff_Reg_Service;
import com.pencil.Stuff.Stuff_Reg_ServiceImpl;
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
public class SendSMS_Stuff_Controller {

    private Stuff_Reg stuff_Reg;

    private List<Stuff_Reg> stuffList;

    private List<Stuff_Reg> stuff_filter_list;

    private List<Stuff_Reg> selectedStuff;  //the list of teacher after selection
    
    private List<SmsTemplate> templateCategory;
    
    private List<String> templateCategoryList;

    private StuffDataModel stuff_data_model;

    private String message;
    
    private int smsBal;
    
    private InstituteSetup institute = new InstituteSetup();
    
    private int instituteId;
    
    private String tempCategory;
    
    private int tempid;
    
    SendSMS_Stuff_Service serviceDao = new SendSMS_Stuff_ServiceImpl();

    Stuff_Reg_Service stuffService = new Stuff_Reg_ServiceImpl();
    
    SMS_Service msgservice=new SMS_ServiceImpl();
    
    InstituteSetupService instituteService = new InstituteSetupServiceImpl();
    
   SmsTemplateService smsTempserviceDao = new SmsTemplateServiceImpl();
    
   SendSMSService getsmsdetailservicedao=new SendSMSServiceImpl();
   
   
    public SendSMS_Stuff_Controller() 
    {
        
        this.stuffList = stuffService.stuffList();
        
        this.templateCategory=smsTempserviceDao.getAllSmsTemplate();

        stuff_data_model = new StuffDataModel(this.stuffList);
        
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

    
    public String sendSms_2_Stuff()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.sendSms(this.selectedStuff, this.getMessage(),this.getSmsBal()))
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully send sms to the selected Stuff."));
        }
        else 
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to send sms to the selected Stuff."));
        }
        
        this.selectedStuff.clear();
        
        this.message=null;
        
        return "/Dummy/Stuff/BulkSms/SendSmsStuff";
    }

    /**
     *
     * @return
     */
    public Stuff_Reg getStuff_Reg() 
    {
        if(this.stuff_Reg == null)
        {
            this.stuff_Reg = new Stuff_Reg();
        }
        return stuff_Reg;
    }

    public void setStuff_Reg(Stuff_Reg stuff_Reg) {
        this.stuff_Reg = stuff_Reg;
    }

  

    public List<Stuff_Reg> getStuffList() {
        return stuffList;
    }

    public void setStuffList(List<Stuff_Reg> stuffList) {
        this.stuffList = stuffList;
    }

    public List<Stuff_Reg> getStuff_filter_list() {
        return stuff_filter_list;
    }

    public void setStuff_filter_list(List<Stuff_Reg> stuff_filter_list) {
        this.stuff_filter_list = stuff_filter_list;
    }
   
    public List<Stuff_Reg> getSelectedStuff() {
        return selectedStuff;
    }

    public void setSelectedStuff(List<Stuff_Reg> selectedStuff) {
        this.selectedStuff = selectedStuff;
    }

    public StuffDataModel getStuff_data_model() {
        return stuff_data_model;
    }

    public void setStuff_data_model(StuffDataModel stuff_data_model) {
        this.stuff_data_model = stuff_data_model;
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
