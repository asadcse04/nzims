/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS.SendSMS;

import com.pencil.SMS.SmsTemplate.SmsTemplate;
import com.pencil.SMS.SmsTemplate.SmsTemplateService;
import com.pencil.SMS.SmsTemplate.SmsTemplateServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class SendSMSController {
    
    private int tempid;
    
    private SendSMS sendSMS;

    SmsTemplateService tempservicedao=new  SmsTemplateServiceImpl();
    
    SendSMSService servicedao=new SendSMSServiceImpl();
    
    private List<SmsTemplate> smsTemplate;
    
    private List<String> smsTemplateList;
    
    private String smsCategoryName;
    
    private String detailsms;
    
   
    
    
    
    public SendSMSController(){
        
      this.smsTemplate=tempservicedao.getAllSmsTemplate();
    
    }
    
  public void getSmsdetail()
  
  {
      
      this.tempid=Integer.parseInt(smsCategoryName.split("-")[0]);
      
      this.detailsms=servicedao.getSMSTemplateDetailByID(this.tempid);
  
  }
    /**
     * @return the smsTemplate
     */
    public List<SmsTemplate> getSmsTemplate() {
        return smsTemplate;
    }

    /**
     * @param smsTemplate the smsTemplate to set
     */
    public void setSmsTemplate(List<SmsTemplate> smsTemplate) {
        this.smsTemplate = smsTemplate;
    }

    /**
     * @return the smsTemplateList
     */
    public List<String> getSmsTemplateList() {
       
        this.smsTemplateList=new ArrayList<String>();
        
        
        for(SmsTemplate sm:getSmsTemplate()){
           this.smsTemplateList.add(sm.getSmsTemplateId()+"-"+sm.getSmsTemplateName());
        }
        
        return this.smsTemplateList;
    }

    /**
     * @param smsTemplateList the smsTemplateList to set
     */
    public void setSmsTemplateList(List<String> smsTemplateList) {
        this.smsTemplateList = smsTemplateList;
    }

    /**
     * @return the smsCategoryName
     */
    public String getSmsCategoryName() {
        return smsCategoryName;
    }

    /**
     * @param smsCategoryName the smsCategoryName to set
     */
    public void setSmsCategoryName(String smsCategoryName) {
        this.smsCategoryName = smsCategoryName;
    }

    /**
     * @return the tempid
     */
    public int getTempid() {
        return tempid;
    }

    /**
     * @param tempid the tempid to set
     */
    public void setTempid(int tempid) {
        this.tempid = tempid;
    }

    /**
     * @return the sendSMS
     */
    public SendSMS getSendSMS() {
        
        if(this.sendSMS==null){
          this.sendSMS=new SendSMS();
          
        }
        return this.sendSMS;
    }

    /**
     * @param sendSMS the sendSMS to set
     */
    public void setSendSMS(SendSMS sendSMS) {
        this.sendSMS = sendSMS;
    }

    /**
     * @return the detailsms
     */
    public String getDetailsms() {
        return detailsms;
    }

    /**
     * @param detailsms the detailsms to set
     */
    public void setDetailsms(String detailsms) {
        this.detailsms = detailsms;
    }


    
   }
