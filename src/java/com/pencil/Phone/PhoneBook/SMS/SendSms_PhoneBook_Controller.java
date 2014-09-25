/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook.SMS;

import com.pencil.InstituteSetup.InstituteSetup;
import com.pencil.InstituteSetup.InstituteSetupService;
import com.pencil.InstituteSetup.InstituteSetupServiceImpl;
import com.pencil.Phone.PhoneBook.PhoneBook;
import com.pencil.Phone.PhoneBook.PhoneBookService;
import com.pencil.Phone.PhoneBook.PhoneBookServiceImpl;
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
public class SendSms_PhoneBook_Controller {


    private PhoneBook phoneBook;

    private List<PhoneBook> phoneBookList;

    private List<PhoneBook> phoneBook_filter_list;

    private List<PhoneBook> selectedPhoneBook;  
    
    private List<SmsTemplate> templateCategory;
    
    private List<String> templateCategoryList;

    private PhoneBookData phoneBook_data_model;

    private String message;
    
    private int smsBal;
    
    private InstituteSetup institute = new InstituteSetup();
    
    private int instituteId;
    
    private String tempCategory;
    
    private int tempid;
    
    
    SendSms_PhoneBook_Service serviceDao = new SendSms_PhoneBook_ServiceImpl();

    PhoneBookService phoneBookService = new PhoneBookServiceImpl();
    
    SMS_Service msgservice=new SMS_ServiceImpl();
    
    InstituteSetupService instituteService = new InstituteSetupServiceImpl();
    
    SmsTemplateService smsTempserviceDao = new SmsTemplateServiceImpl();
    
    SendSMSService getsmsdetailservicedao=new SendSMSServiceImpl();
   
   
    public SendSms_PhoneBook_Controller()
    {
        this.phoneBookList = phoneBookService.phBookList();
        
        this.templateCategory=smsTempserviceDao.getAllSmsTemplate();

        phoneBook_data_model = new PhoneBookData(this.phoneBookList);
        
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
    
    public String sendSms_2_PhoneBook()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.sendSms(this.selectedPhoneBook, this.getMessage(),this.getSmsBal()))
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully send sms to the selected PhoneBook."));
        }
        else 
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to send sms to the selected PhoneBook."));
        }
        
        this.selectedPhoneBook.clear();
        
        this.message=null;
        
        return "/Phone/SendSmsPhoneBook";
    }

    public PhoneBook getPhoneBook()
    {
        if(this.phoneBook == null)
        {
            this.phoneBook = new PhoneBook();
        }
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public void setPhoneBookList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public List<PhoneBook> getPhoneBook_filter_list() {
        return phoneBook_filter_list;
    }

    public void setPhoneBook_filter_list(List<PhoneBook> phoneBook_filter_list) {
        this.phoneBook_filter_list = phoneBook_filter_list;
    }

    public List<PhoneBook> getSelectedPhoneBook() {
        return selectedPhoneBook;
    }

    public void setSelectedPhoneBook(List<PhoneBook> selectedPhoneBook) {
        this.selectedPhoneBook = selectedPhoneBook;
    }

    public PhoneBookData getPhoneBook_data_model() {
        return phoneBook_data_model;
    }

    public void setPhoneBook_data_model(PhoneBookData phoneBook_data_model) {
        this.phoneBook_data_model = phoneBook_data_model;
    }

    public int getSmsBal() {
        return smsBal;
    }

    public void setSmsBal(int smsBal) {
        this.smsBal = smsBal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getTempid() {
        return tempid;
    }

    public void setTempid(int tempid) {
        this.tempid = tempid;
    }

    public String getTempCategory() {
        return tempCategory;
    }

    public void setTempCategory(String tempCategory) 
    {
        this.tempCategory = tempCategory;
    }

    public List<String> getTemplateCategoryList() {
         
        this.templateCategoryList=new ArrayList<>();
        
        for(SmsTemplate smstemp:templateCategory)
        {    
           this.templateCategoryList.add(smstemp.getSmsTemplateId()+"-"+smstemp.getSmsTemplateName());
        }
        return templateCategoryList;
    }

    public void setTemplateCategoryList(List<String> templateCategoryList) {
        this.templateCategoryList = templateCategoryList;
    }
    

}
