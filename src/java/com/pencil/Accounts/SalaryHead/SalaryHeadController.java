

package com.pencil.Accounts.SalaryHead;

import com.pencil.Accounts.SalaryCategory.SalaryCategory;
import com.pencil.Accounts.SalaryCategory.SalaryCategoryService;
import com.pencil.Accounts.SalaryCategory.SalaryCategoryServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mamun
 */
@ManagedBean
@ViewScoped
public class SalaryHeadController {

    private SalaryHead salaryHead;
    
    private List<SalaryHead> salaryHeadList;
    
    private String salaryHeadName;
    
    private List<String> salaryHeadNameList;    
    
    private List<SalaryCategory> salaryCategoryList;    
        
    SalaryHeadService serviceDao = new SalaryHeadServiceImpl();    
        
    SalaryCategoryService salaryCatService = new SalaryCategoryServiceImpl();

    public SalaryHeadController() 
    {
        this.salaryCategoryList = salaryCatService.getAllSalaryCategory();        
        
    }
    
    public void createSalaryHead()
    {
          FacesContext context = FacesContext.getCurrentInstance();
          
          this.salaryHead.setSalaryCategoryID(Integer.parseInt(salaryHeadName.split("-")[0]));
        
        if(serviceDao.addSalaryHead(this.salaryHead))
        {
            context.addMessage(null, new FacesMessage("Successful", "Salary Head Added"));
            
            this.salaryHead=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Salary Head is not added"));
        }
    }

    public SalaryHead getSalaryHead() 
    {
        if(this.salaryHead==null)
        {
            this.salaryHead = new SalaryHead();
        }
        return this.salaryHead;
    }

    public void setSalaryHead(SalaryHead salaryHead) {
        this.salaryHead = salaryHead;
    }

    public List<SalaryHead> getSalaryHeadList() 
    {
        this.salaryHeadList=serviceDao.getAllSalaryHead();
        return this.salaryHeadList;
    }

    public void setSalaryHeadList(List<SalaryHead> salaryHeadList) {
        this.salaryHeadList = salaryHeadList;
    }

    public String getSalaryHeadName() {
        return salaryHeadName;
    }

    public void setSalaryHeadName(String salaryHeadName) {
        this.salaryHeadName = salaryHeadName;
    } 

    public List<SalaryCategory> getSalaryCategoryList() {
        return salaryCategoryList;
    }

    public void setSalaryCategoryList(List<SalaryCategory> salaryCategoryList) {
        this.salaryCategoryList = salaryCategoryList;
    }

    public List<String> getSalaryHeadNameList() 
    {
        this.salaryHeadNameList = new ArrayList<String>();
        
        for(SalaryCategory salaryCategory : salaryCategoryList)
        {
            this.salaryHeadNameList.add(salaryCategory.getCategoryID()+"-"+salaryCategory.getCategoryName());
        
        }
        return this.salaryHeadNameList;
    }

    public void setSalaryHeadNameList(List<String> salaryHeadNameList) {
        this.salaryHeadNameList = salaryHeadNameList;
    }
       
               
}