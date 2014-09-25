/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Salary;

import com.pencil.Accounts.SalaryCategory.SalaryCategory;
import com.pencil.Accounts.SalaryCategory.SalaryCategoryService;
import com.pencil.Accounts.SalaryCategory.SalaryCategoryServiceImpl;
import com.pencil.Accounts.SalaryHead.SalaryHead;
import com.pencil.Accounts.SalaryHead.SalaryHeadService;
import com.pencil.Accounts.SalaryHead.SalaryHeadServiceImpl;
import com.pencil.Accounts.SubSalaryHead.SubSalaryHead;
import com.pencil.Accounts.SubSalaryHead.SubSalaryHeadService;
import com.pencil.Accounts.SubSalaryHead.SubSalaryHeadServiceImpl;
import com.pencil.Presentation.Presentation;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean

@ViewScoped

/**
 *
 * @author jahangiralamdiu
 */
public class SalaryController {
    
    private String salaryCatName;
    
    private String salaryHeadName;
    
    private Salary salary;
    
    
    
     private List<SalaryCategory> salaryCategoryList;
     
     private List<String> salaryCatNameList;
     
     private List<String> salaryHeadNameList;
     
     private List<SalaryHead> salaryHeadList;
     
     private List<String> subSalaryHeadNameList;
     
     private List<SubSalaryHead> subSalaryHeadList;
     
     private List<String> academicYearList;
     
     SubSalaryHeadService subSalaryServiceDao = new SubSalaryHeadServiceImpl();
    
    SalaryHeadService salaryHeadServiceDao = new SalaryHeadServiceImpl();
    
    SalaryCategoryService salaryCatService = new SalaryCategoryServiceImpl();
   
    Presentation pr = new Presentation();
    
    SalaryService serviceDao = new SalaryServiceImpl();

    public SalaryController() {
        
        this.academicYearList = pr.infoList("acyr");
        
        this.salaryCategoryList = salaryCatService.getAllSalaryCategory();
        
        salaryHeadList = salaryHeadServiceDao.getAllSalaryHead();
        
        this.subSalaryHeadList = subSalaryServiceDao.getAllSubSalaryHead();
    }
    
    public void createSalary()
    {
        this.salary.setSalaryHeadID(Integer.parseInt(this.salaryHeadName.split("-")[0]));
        
        System.out.println(" "+this.salary.getSalaryHeadID());
        
        System.out.println(" "+this.salary.getSubHeadNameList().size());
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addSalary(this.salary))
        {
            context.addMessage(null, new FacesMessage("Successful", "Salary Category Added"));
            
            this.salary=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Salary Category is not added"));
        }
    }
    
    public void initSalaryHeadNameList()
    {
        this.salaryHeadNameList=null;
        
        this.salaryHeadNameList = new ArrayList<String>();
        
         for(SalaryHead salaryHead : this.salaryHeadList) 
        {
            if(salaryHead.getSalaryCategoryID()==Integer.parseInt(salaryCatName.split("-")[0])) 
            {
                this.salaryHeadNameList.add(salaryHead.getSalaryHeadID()+"-"+salaryHead.getSalaryHeadName());
            }
        }
    }

    
     public List<SalaryCategory> getSalaryCategoryList() {
        return salaryCategoryList;
    }

    public void setSalaryCategoryList(List<SalaryCategory> salaryCategoryList) {
        this.salaryCategoryList = salaryCategoryList;
    }

    public List<SalaryHead> getSalaryHeadList() {
        return salaryHeadList;
    }

    public void setSalaryHeadList(List<SalaryHead> salaryHeadList) {
        this.salaryHeadList = salaryHeadList;
    }

    public List<String> getSalaryCatNameList() {
        
          this.salaryCatNameList = new ArrayList<String>();
        
        for(SalaryCategory salaryCategory : salaryCategoryList)
        {
            this.salaryCatNameList.add(salaryCategory.getCategoryID()+"-"+salaryCategory.getCategoryName());
        
        }
        return salaryCatNameList;
    }

    public void setSalaryCatNameList(List<String> salaryCatNameList) {
        this.salaryCatNameList = salaryCatNameList;
    }

    public String getSalaryCatName() {
        return salaryCatName;
    }

    public void setSalaryCatName(String salaryCatName) {
        this.salaryCatName = salaryCatName;
    }          

    public List<String> getSalaryHeadNameList() {       
       
        return this.salaryHeadNameList;
    }

    public void setSalaryHeadNameList(List<String> salaryHeadNameList) {
        this.salaryHeadNameList = salaryHeadNameList;
    }

    public String getSalaryHeadName() {
        return salaryHeadName;
    }

    public void setSalaryHeadName(String salaryHeadName) {
        this.salaryHeadName = salaryHeadName;
    }    
    
     public List<String> getSubSalaryHeadNameList() 
    {
        
        this.subSalaryHeadNameList = new ArrayList<String>();
        
        for(SubSalaryHead subSalaryHead : this.subSalaryHeadList)
        {
            this.subSalaryHeadNameList.add(subSalaryHead.getSubSalaryHeadName());
        }
        
        return this.subSalaryHeadNameList;
    }

    public void setSubSalaryHeadNameList(List<String> subSalaryHeadNameList) {
        this.subSalaryHeadNameList = subSalaryHeadNameList;
    }  

    public List<SubSalaryHead> getSubSalaryHeadList() {     
        return subSalaryHeadList;
    }

    public void setSubSalaryHeadList(List<SubSalaryHead> subSalaryHeadList) {
        this.subSalaryHeadList = subSalaryHeadList;
    }

    public Salary getSalary() {
        
        if(this.salary==null)
        {
            this.salary = new Salary();
        }
        return this.salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
    
    
    
    
//    public List<SalaryCategory> getFeeCategoryList() {
//        return feeCategoryList;
//    }
//
//    public void setFeeCategoryList(List<FeeCategory> feeCategoryList) {
//        this.feeCategoryList = feeCategoryList;
//    }
//
//    public List<FeeHead> getFeeHeadList() {
//        return feeHeadList;
//    }
//
//    public void setFeeHeadList(List<FeeHead> feeHeadList) {
//        this.feeHeadList = feeHeadList;
//    }
//
//    public List<String> getFeeCatNameList() {
//        
//          this.feeCatNameList = new ArrayList<String>();
//        
//        for(FeeCategory feeCategory : feeCategoryList)
//        {
//            this.feeCatNameList.add(feeCategory.getCategoryID()+"-"+feeCategory.getCategoryName());
//        
//        }
//        return feeCatNameList;
//    }
//
//    public void setFeeCatNameList(List<String> feeCatNameList) {
//        this.feeCatNameList = feeCatNameList;
//    }
//
//    public String getFeeCatName() {
//        return feeCatName;
//    }
//
//    public void setFeeCatName(String feeCatName) {
//        this.feeCatName = feeCatName;
//    }          
//
//    public List<String> getFeeHeadNameList() {       
//       
//        return this.feeHeadNameList;
//    }
//
//    public void setFeeHeadNameList(List<String> feeHeadNameList) {
//        this.feeHeadNameList = feeHeadNameList;
//    }
//
//    public String getFeeHeadName() {
//        return feeHeadName;
//    }
//
//    public void setFeeHeadName(String feeHeadName) {
//        this.feeHeadName = feeHeadName;
//    }    
//    
//     public List<String> getSubFeeHeadNameList() 
//    {
//        
//        this.subFeeHeadNameList = new ArrayList<String>();
//        
//        for(SubFeeHead subFeeHead : this.subFeeHeadList)
//        {
//            this.subFeeHeadNameList.add(subFeeHead.getSubFeeHeadName());
//        }
//        
//        return this.subFeeHeadNameList;
//    }
//
//    public void setSubFeeHeadNameList(List<String> subFeeHeadNameList) {
//        this.subFeeHeadNameList = subFeeHeadNameList;
//    }  
//
//    public List<SubFeeHead> getSubFeeHeadList() {     
//        return subFeeHeadList;
//    }
//
//    public void setSubFeeHeadList(List<SubFeeHead> subFeeHeadList) {
//        this.subFeeHeadList = subFeeHeadList;
//    }
//
//    public Salary getFee() {
//        
//        if(this.fee==null)
//        {
//            this.fee = new Salary();
//        }
//        return this.fee;
//    }
//
//    public void setFee(Salary fee) {
//        this.fee = fee;
//    }

    /**
     * @return the academicYearList
     */
    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    /**
     * @param academicYearList the academicYearList to set
     */
    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }
    
        
}
