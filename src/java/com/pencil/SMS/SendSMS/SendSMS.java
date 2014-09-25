/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS.SendSMS;

import com.pencil.Phone.PhoneBook.PhoneBook;
import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class SendSMS implements Serializable{
  
    private int smsTemplateId;
    
    private String smsTemplateName;
    
    private String smsTemplateDescription;
    
   
    
    public SendSMS(){
        
    }
    
    public SendSMS(int smsTemplateId,String smsTemplateName,String smsTemplateDescription){
      
        this.smsTemplateId=smsTemplateId;
        this.smsTemplateName=smsTemplateName;
        this.smsTemplateDescription=smsTemplateDescription;
    }

    /**
     * @return the smsTemplateId
     */
    public int getSmsTemplateId() {
        return smsTemplateId;
    }

    /**
     * @param smsTemplateId the smsTemplateId to set
     */
    public void setSmsTemplateId(int smsTemplateId) {
        this.smsTemplateId = smsTemplateId;
    }

    /**
     * @return the smsTemplateName
     */
    public String getSmsTemplateName() {
        return smsTemplateName;
    }

    /**
     * @param smsTemplateName the smsTemplateName to set
     */
    public void setSmsTemplateName(String smsTemplateName) {
        this.smsTemplateName = smsTemplateName;
    }

    /**
     * @return the smsTemplateDescription
     */
    public String getSmsTemplateDescription() {
        return smsTemplateDescription;
    }

    /**
     * @param smsTemplateDescription the smsTemplateDescription to set
     */
    public void setSmsTemplateDescription(String smsTemplateDescription) {
        this.smsTemplateDescription = smsTemplateDescription;
    }

   


}
