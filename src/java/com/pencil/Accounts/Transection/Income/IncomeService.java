/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Income;

import java.util.List;

/**
 *
 * @author Riad
 */
public interface IncomeService {
    
    public boolean incomeCash(Income income);
    
    public List<String> transactionCatList(String income);
    
    public List<String> transactionSubHeadList(String subhead);
    
    public List<String> bankIdList();
    
}
