/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCollection;

import java.util.List;

/**
 *
 * @author jahangiralamdiu
 */
public interface FeeCollectionService {
  
    public List<FeeInvDetObj> getStudentAllinfo(String id);
    
    public double getFeeAmount(FeeInvDetObj feeInvDetObj);
    
    public boolean saveFeeRecord(List<FeeInvDetObj> listInvoice,FeeInvDetObj feeInvDetObj);
    
    public boolean sendSms(FeeInvDetObj feeInvDetObj, int smsBal);
}
