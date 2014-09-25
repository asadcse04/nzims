/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.AttendenceSmsTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class AttendenceSmsTemplateController implements Serializable {
  
private AttendenceSmsTemplate attendenceSmsTemplate;

public AttendenceSmsTemplateService serviceDao=new AttendenceSmsTemplateServiceImpl();

public List<AttendenceSmsTemplate> templeteList;





public void saveSms(){
     
    FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.savaMessage(attendenceSmsTemplate))
        {
            context.addMessage(null, new FacesMessage("Successful", "SMS Template is Added"));
            
            this.attendenceSmsTemplate=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "SMS Template is not added"));
        }
}


public void updateSms(){
     
    FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateMessage(attendenceSmsTemplate))
        {
            context.addMessage(null, new FacesMessage("Successful,SMS Template is Updated", ""));
            
            this.attendenceSmsTemplate=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "SMS Template is not Updated"));
        }
}



public AttendenceSmsTemplate getAttendenceSmsTemplate() {
    
    if(this.attendenceSmsTemplate==null){
        
        this.attendenceSmsTemplate=new AttendenceSmsTemplate();
    }
        return attendenceSmsTemplate;
    }

    public void setAttendenceSmsTemplate(AttendenceSmsTemplate attendenceSmsTemplate) {
        this.attendenceSmsTemplate = attendenceSmsTemplate;
    }

    public List<AttendenceSmsTemplate> getTempleteList() {
        
        this.templeteList=new ArrayList<>();
        this.templeteList.clear();
        this.templeteList=serviceDao.smsList();
        return templeteList;
    }

    public void setTempleteList(List<AttendenceSmsTemplate> templeteList) {
        this.templeteList = templeteList;
    }


    

}
