/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transaction.BankTransaction;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface BankTransectionService {
    
    public boolean addBankDetails(BankTransection bankTransaction);
    
    public List<String> bankIdNameList();
    
    public String acById(int bankid);
    
}
