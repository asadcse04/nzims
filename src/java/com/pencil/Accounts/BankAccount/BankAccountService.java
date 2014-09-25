/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.BankAccount;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface BankAccountService {
   
    public boolean addBankAccount(BankAccount bankAccount);
    
    public List<BankAccount> getAllBankAccount();
}
