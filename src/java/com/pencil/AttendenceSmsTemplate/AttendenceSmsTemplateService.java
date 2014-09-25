/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.AttendenceSmsTemplate;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface AttendenceSmsTemplateService {
  
   public boolean savaMessage(AttendenceSmsTemplate attendenceSmsTemplate);
   
   public boolean updateMessage(AttendenceSmsTemplate attendenceSmsTemplate);
   
   public List<AttendenceSmsTemplate> smsList();
   
}
