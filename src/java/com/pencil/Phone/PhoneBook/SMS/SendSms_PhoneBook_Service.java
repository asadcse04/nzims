/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Phone.PhoneBook.SMS;

import com.pencil.Phone.PhoneBook.PhoneBook;
import java.util.List;

/**
 *
 * @author salim
 */
public interface SendSms_PhoneBook_Service 
{
     public boolean sendSms(List<PhoneBook> selectedPhnBookArry, String message,int smsBal); 
}
