/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Accounts.Report.Cash;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mamun
 */
@ManagedBean
@ViewScoped
public class CashReportController implements Serializable {

    private CashReport cashReport;
    
    private double totalIncome=0.0;
    private double totalExpense=0.0;

    private List<CashReport> listCash;

    public CashReportService servicedao = new CashReportServiceImpl();

    public CashReportController() {

        

    }
    
    public void showCash(){
        
        this.listCash = servicedao.listCash(cashReport);
         this.totalExpense=0.0;
         this.totalIncome=0.0;
        for(CashReport cr:listCash){
            
            if(cr.getTrnStatus().toString().startsWith("E"))
            {
            cr.setExpense(cr.getTrnAmount());
           
            this.totalExpense+=cr.getExpense();
            cr.setIncome(0); 
            }
            
            else
            {
                 cr.setIncome(cr.getTrnAmount());
                 
                 this.totalIncome=totalIncome+cr.getIncome();
                 cr.setExpense(0);  
            }
            
        }
        
    }

    public List<CashReport> getListCash() {
        return listCash;
    }

    public void setListCash(List<CashReport> listCash) {
        this.listCash = listCash;
    }

    public CashReport getCashReport() {
        if (this.cashReport == null) {
            this.cashReport = new CashReport();
        }
        return cashReport;
    }

    public void setCashReport(CashReport cashReport) {
        this.cashReport = cashReport;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }
    
    

}
