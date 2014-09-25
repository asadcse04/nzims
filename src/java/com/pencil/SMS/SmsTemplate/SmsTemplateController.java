/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS.SmsTemplate;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mamun
 */
@ManagedBean
@ViewScoped


public class SmsTemplateController {
   
    private SmsTemplate smsTemplate;
    
    private List<SmsTemplate> smsTemplateList;
    
    SmsTemplateService serviceDao = new SmsTemplateServiceImpl();

    public SmsTemplateController() {
    }
    
    public void addSmsTemplate() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addSmsTemplate(this.smsTemplate))
        {
            context.addMessage(null, new FacesMessage("Successful", "SMS Template is Added"));
            
            this.smsTemplate=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "SMS Template is not added"));
        }
    }

    public SmsTemplate getSmsTemplate() {
        
        if(this.smsTemplate==null) 
        {
            this.smsTemplate = new SmsTemplate();
        }
        
        return smsTemplate;
    }

    
    public void setSmsTemplate(SmsTemplate smsTemplate) 
    {
        
        this.smsTemplate = smsTemplate;
    }

    
    public List<SmsTemplate> getSmsTemplateList() 
    {
        this.smsTemplateList = serviceDao.getAllSmsTemplate();
        
        return smsTemplateList;
    }

    
    public void setSmsTemplateList(List<SmsTemplate> smsTemplateList) 
    {
        this.smsTemplateList = smsTemplateList;
    }
    
    
   }