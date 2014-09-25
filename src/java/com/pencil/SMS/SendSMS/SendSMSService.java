/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS.SendSMS;

import com.pencil.SMS.SmsTemplate.SmsTemplate;
import java.util.List;

/**
 *
 * @author Riad
 */
public interface SendSMSService {
    
    public String getSMSTemplateDetailByID(int template);
    
    public List<SmsTemplate> getAllSmsTemplate();


}
