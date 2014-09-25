

package com.pencil.Accounts.BankAccount;

import com.pencil.Accounts.BankGroup.BankGroup;
import com.pencil.Accounts.BankGroup.BankGroupService;
import com.pencil.Accounts.BankGroup.BankGroupServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class BankAccountController implements Serializable{
    
     private BankAccount bankAccount;
    
    private List<BankAccount> bankAccountList;
    
    private String bankAccountName;
    
    private List<String> bankAccountNameList;    
    
    private List<BankGroup> bankGroupList;    
        
    BankAccountService serviceDao = new BankAccountServiceImpl();    
        
    BankGroupService bankgroupService = new BankGroupServiceImpl();

    public BankAccountController() 
    {
        this.bankGroupList = bankgroupService.getAllBankGroup();        
        
    }
    
    public void createBankAccount()
    
    {
          FacesContext context = FacesContext.getCurrentInstance();
          
          this.bankAccount.setBankAcGroupID(Integer.parseInt(bankAccountName.split("-")[0]));
        
        if(serviceDao.addBankAccount(this.bankAccount))
        
    {
            context.addMessage(null, new FacesMessage("Successful", "Bank Account Added"));
            
            this.bankAccount=null;
    }
        
      else
    {
     context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Bank Account is not added"));
    }
    
    }

    public BankAccount getBankAccount() 
    {
        if(this.bankAccount==null)
        {
            this.bankAccount = new BankAccount();
        }
        return this.bankAccount;
    }

    
    
    
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<BankAccount> getBankAccountList() 
    {
        this.bankAccountList=serviceDao.getAllBankAccount();
        return this.bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    } 

    public List<BankGroup> getBankGroupList() {
        return bankGroupList;
    }

    public void setBankGroupList(List<BankGroup> bankGroupList) {
        this.bankGroupList = bankGroupList;
    }

    public List<String> getBankAccountNameList() 
    {
        this.bankAccountNameList = new ArrayList<String>();
        
        for(BankGroup bankGroup : bankGroupList)
        {
            this.bankAccountNameList.add(bankGroup.getBankGroupID()+"-"+bankGroup.getBankGroupName());
        
        }
        return this.bankAccountNameList;
    }

    public void setBankAccountNameList(List<String> bankAccountNameList) {
        this.bankAccountNameList = bankAccountNameList;
    }
       
               
}