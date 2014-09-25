/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS.SmsTemplate;

import java.util.List;

/**
 *
 * @author Mamun
 */
public interface SmsTemplateService {

    public boolean addSmsTemplate(SmsTemplate smsTemplate);
    
    public List<SmsTemplate> getAllSmsTemplate();
    
}
