/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Report.BalanceStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.chart.PieChartModel;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class BalanceReportController implements Serializable{
    
    private PieChartModel pieModel;
    
    private List<BalanceReport> balanceList=new ArrayList<BalanceReport>();
    
    BalanceReportServiceImpl servicedao=new BalanceReportServiceImpl();
    
    
    public BalanceReportController(){
        
        this.balanceList=servicedao.balanceList();
        
        this.pieModel = new PieChartModel();
  
        this.pieModel.set("Cash",balanceList.get(0).getCashBalance());
    
        this.pieModel.set("Bank",balanceList.get(0).getBankBalance());
        
        this.pieModel.set("Check",balanceList.get(0).getCheckBalance());
        
        
    
    }

    /**
     * @return the pieModel
     */
    public PieChartModel getPieModel() {
        return pieModel;
    }

    /**
     * @param pieModel the pieModel to set
     */
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    /**
     * @return the balanceList
     */
    public List<BalanceReport> getBalanceList() {
        return balanceList;
    }

    /**
     * @param balanceList the balanceList to set
     */
    public void setBalanceList(List<BalanceReport> balanceList) {
        this.balanceList = balanceList;
    }

    
    
    
}
