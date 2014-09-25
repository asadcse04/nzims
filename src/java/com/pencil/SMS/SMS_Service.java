/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SMS;

/**
 *
 * @author INSPIRON 5421
 */
public interface SMS_Service
{
     public int sendBulkSms(StringBuilder contactNo,String smsbody);
     
     public int sendIndividual_Sms(String contactNo,String smsbody);
     
     public int getSmsCurrent_Ac_Balance(int school_id);
}
