/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transaction.BankTransaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Riad
 */

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped

public class BankTransectionController {
    
    private BankTransection bankTransection;
    
    private List<String> bankidnamelist;
    
    private String[] transactiontype={"Deposit","Withdraw"};
    
    private String[] amounttype={"Cash","Check"};
    
    private String bankIdName;
    
    private String accountnumber;
    
    private List<String> amounttypeList=new ArrayList<String>();

    
    BankTransectionService servicedao=new BankTransectionServiceImpl();
    
    
    public BankTransectionController(){
        
       this.bankidnamelist=servicedao.bankIdNameList();
    
    }
    
    
    public void changeAmountType()
    
    {
        
        this.amounttypeList=null;
       
       
        if(this.bankTransection.getStatus().equals("Deposit")){
       
           this.amounttypeList=Arrays.asList(amounttype);
       }
       
       
       if(this.bankTransection.getStatus().equals("Withdraw")){
           
           this.amounttypeList=Arrays.asList("Cash");
       }
        
    }
    
    
    public void addbankTrnDetail(){
     
        FacesContext context = FacesContext.getCurrentInstance();
        
        this.bankTransection.setBankId(Integer.parseInt(this.bankIdName.split("-")[0]));
        
        if(servicedao.addBankDetails(this.bankTransection))
        {
            context.addMessage(null, new FacesMessage("Successful", "Bank Transection Added"));
            
            this.bankTransection=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Bank Transection is not added"));
        }
    
    }
    
    
    
    
    
    public void acNum(){
        
    this.accountnumber=servicedao.acById(Integer.parseInt(this.bankIdName.split("-")[0]));
    
    
    }
    
    
    
    public BankTransection getBankTransection() {
        
        if(this.bankTransection==null)
        {
          this.bankTransection=new BankTransection();  
        }
        
        return this.bankTransection;
    }

    
    public void setBankTransection(BankTransection bankTransection) {
        this.bankTransection = bankTransection;
    }
    
    
    
    public List<String> getBankidnamelist() {
        return bankidnamelist;
    }

    
    public void setBankidnamelist(List<String> bankidnamelist) {
        this.bankidnamelist = bankidnamelist;
    }

    
    public String[] getTransactiontype() {
        return transactiontype;
    }

   
    public void setTransactiontype(String[] transactiontype) {
        this.setTransactiontype(transactiontype);
    }

    
    public String[] getAmounttype() {
        return amounttype;
    }

    /**
     * @param amounttype the amounttype to set
     */
    public void setAmounttype(String[] amounttype) {
        this.amounttype = amounttype;
    }

    /**
     * @return the bankIdName
     */
    public String getBankIdName() {
        return bankIdName;
    }

    /**
     * @param bankIdName the bankIdName to set
     */
    public void setBankIdName(String bankIdName) {
        this.bankIdName = bankIdName;
    }

    /**
     * @return the accountnumber
     */
    public String getAccountnumber() {
        return accountnumber;
    }

    /**
     * @param accountnumber the accountnumber to set
     */
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    /**
     * @return the amounttypeList
     */
    public List<String> getAmounttypeList() {
        return amounttypeList;
    }

    /**
     * @param amounttypeList the amounttypeList to set
     */
    public void setAmounttypeList(List<String> amounttypeList) {
        this.amounttypeList = amounttypeList;
    }

 
 

   
   

    
}
