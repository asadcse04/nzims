/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.BankGroup;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface BankGroupService {
   
    public boolean addBankGroup(BankGroup bankGroup);
    
    public List<BankGroup> getAllBankGroup(); 
}
