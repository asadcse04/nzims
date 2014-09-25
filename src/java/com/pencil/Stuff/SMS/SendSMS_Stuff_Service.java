/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Stuff.SMS;

import com.pencil.Stuff.Stuff_Reg;
import java.util.List;

/**
 *
 * @author salim
 */
public interface SendSMS_Stuff_Service
{
    public boolean sendSms(List<Stuff_Reg> selectedStuffArry, String message,int smsBal);  
}
