/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Expense;

import com.pencil.Accounts.Transection.SubHead.SubHeadService;
import com.pencil.Accounts.Transection.SubHead.SubHeadServiceImpl;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Riyad
 */
@ManagedBean
@ViewScoped
public class ExpenseController {

    
     private Expense expense;
    
    private List<String> catlist;
    
    private List<String> mainhdlist;
    
    private List<String> subheadlist;
    
    private List<String> bankIdList;
    
    private String[] paymenttype={"Cash","Check","Bank"};
    
    
    private String catagoryname;
    
    private String headname;
    
    private String subheadname;
     
    private String bankid;
    

   

    
  public ExpenseService servicedao= new ExpenseServiceImpl();
  
  public SubHeadService subheadservicedao=new SubHeadServiceImpl();
    
    
    
    public ExpenseController()
    
    {
     
        this.catlist=servicedao.transactionCatList("Expense");
    
    }
    
    
    public void addExpenseCash() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        this.expense.setTranName(this.subheadname.split("-")[1]);
        
        this.expense.setTrSubHeadID(Integer.parseInt(this.subheadname.split("-")[0]));
        
        this.expense.setBankID(Integer.parseInt(this.bankid.split("-")[0]));
        
        if(servicedao.expenseCash(this.expense))
        {
            context.addMessage(null, new FacesMessage("Successful", "Expense Transection Added"));
            
            this.expense=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Expense Transection is not added"));
        }
        
    }
    
    
    public Expense getExpense() {
        
        if(this.expense == null){
           
            this.expense=new Expense();
        }
        return expense;
    }

   
    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    
 
    
    
    public List<String> getCatlist() 
    {
        
        return catlist;
    }

    
    
    public void setCatlist(List<String> catlist) 
    {
        this.catlist = catlist;
    }

   
    
    
    
    public String getCatagoryname() {
        return catagoryname;
    }

    
    public void setCatagoryname(String catagoryname) {
        this.catagoryname = catagoryname;
    }

    /**
     * @return the headname
     */
    public String getHeadname() {
        return headname;
    }

    /**
     * @param headname the headname to set
     */
    public void setHeadname(String headname) {
        this.headname = headname;
    }

    /**
     * @return the mainhdlist
     */
    public List<String> getMainhdlist() {
        
        this.mainhdlist=subheadservicedao.mainHead_List(this.catagoryname);
        
        return mainhdlist;
    }

    /**
     * @param mainhdlist the mainhdlist to set
     */
    public void setMainhdlist(List<String> mainhdlist) {
        this.mainhdlist = mainhdlist;
    }

   
    
    public List<String> getSubheadlist() {
        
        this.subheadlist=servicedao.transactionSubHeadList(this.headname);
        
        return subheadlist;
    }

    
    
    public void setSubheadlist(List<String> subheadlist) {
       
        this.subheadlist = subheadlist;
    }

   
   
    public String getSubheadname() {
        return subheadname;
    }

   
    public void setSubheadname(String subheadname) {
        this.subheadname = subheadname;
    }

   
    
    public String[] getPaymenttype() {
        return paymenttype;
    }

   
    
    public void setPaymenttype(String[] paymenttype) {
        this.paymenttype = paymenttype;
    }
    
    public void bankIdWithName(){
          
        this.bankIdList=null;
        
        if(this.expense.getPaymentType().equals("Bank")){
          
        this.bankIdList=servicedao.bankIdList();
       
        }
    }

   
    public List<String> getBankIdList() {
        
 
        return this.bankIdList;
    }

   
    public void setBankIdList(List<String> bankIdList) {
        this.bankIdList = bankIdList;
    }

    /**
     * @return the bankid
     */
    public String getBankid() {
        return bankid;
    }

    /**
     * @param bankid the bankid to set
     */
    public void setBankid(String bankid) {
        this.bankid = bankid;
    }
}
