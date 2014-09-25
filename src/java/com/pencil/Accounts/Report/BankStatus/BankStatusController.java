/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Report.BankStatus;

import com.pencil.Accounts.BankAccount.BankAccount;
import com.pencil.Accounts.BankAccount.BankAccountService;
import com.pencil.Accounts.BankAccount.BankAccountServiceImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class BankStatusController {
    
    private List<BankAccount> bankAccountList;
    
    private PieChartModel pieModel;
    
    private double totalbalance=0.0;
    
    BankAccountService bankAccountServiceDao=new BankAccountServiceImpl();
    
    
    
    
    public BankStatusController(){
        
        this.bankAccountList=bankAccountServiceDao.getAllBankAccount();
        
    }
    
    
    
    

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

 
    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }


    public PieChartModel getPieModel() {
        
            this.pieModel = new PieChartModel();
   
         for(BankAccount b:bankAccountList){
          
            pieModel.set(b.getBankName(),b.getBlance());
        }
        
        
        return pieModel;
    }

   
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

  
    public double getTotalbalance() {
        
        for(BankAccount b:bankAccountList){
            
            this.totalbalance=totalbalance+b.getBlance();
        }
       
        return totalbalance;
    }

  
    public void setTotalbalance(double totalbalance) {
        this.totalbalance = totalbalance;
    }
    
    
    
  
    
}
