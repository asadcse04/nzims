/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Expense;

import java.util.List;

/**
 *
 * @author Mamun
 */
public interface ExpenseService {
    
    public boolean expenseCash(Expense expense);
    
    public List<String> transactionCatList(String expense);
    
    public List<String> transactionSubHeadList(String subhead);
    
    public List<String> bankIdList();
    
}
