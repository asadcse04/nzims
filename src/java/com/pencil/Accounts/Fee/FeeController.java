/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Fee;

import com.pencil.Accounts.FeeCategory.FeeCategory;
import com.pencil.Accounts.FeeCategory.FeeCategoryService;
import com.pencil.Accounts.FeeCategory.FeeCategoryServiceImpl;
import com.pencil.Accounts.FeeHead.FeeHead;
import com.pencil.Accounts.FeeHead.FeeHeadService;
import com.pencil.Accounts.FeeHead.FeeHeadServiceImpl;
import com.pencil.Accounts.SubFeeHead.SubFeeHead;
import com.pencil.Accounts.SubFeeHead.SubFeeHeadService;
import com.pencil.Accounts.SubFeeHead.SubFeeHeadServiceImpl;
import com.pencil.Presentation.Presentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author jahangiralamdiu
 */
@ManagedBean
@ViewScoped
public class FeeController implements Serializable{
    
    private String feeCatName;
    
    private String feeHeadName;
    
    private Fee fee;
    
    private List<String> academicYearList;
    
     private List<FeeCategory> feeCategoryList;
     
     private List<String> feeCatNameList;
     
     private List<String> feeHeadNameList;
     
     private List<FeeHead> feeHeadList;
     
     private List<String> subFeeHeadNameList;
     
     private List<SubFeeHead> subFeeHeadList;
     
     Presentation pr = new Presentation();
     
     SubFeeHeadService subFeeServiceDao = new SubFeeHeadServiceImpl();
    
    FeeHeadService feeHeadServiceDao = new FeeHeadServiceImpl();
    
    FeeCategoryService feeCatService = new FeeCategoryServiceImpl();
    
    FeeService serviceDao = new FeeServiceImpl();

    public FeeController() {
        
        this.academicYearList = pr.infoList("acyr"); 
        
        this.feeCategoryList = feeCatService.getAllFeeCategory();
        
        feeHeadList = feeHeadServiceDao.getAllFeeHead();
        
        this.subFeeHeadList = subFeeServiceDao.getAllSubFeeHead();
    }
    
    public void createFee()
    {
        this.fee.setFeeID(Integer.parseInt(this.feeHeadName.split("-")[0]));
        
        System.out.println(" "+this.fee.getFeeID());
        
        System.out.println(" "+this.fee.getSubHeadNameList().size());
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addFee(this.fee))
        {
            context.addMessage(null, new FacesMessage("Successful", "Fee Category Added"));
            
            this.fee=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Fee Category is not added"));
        }
    }
    
    public void initFeeHeadNameList()
    {
        this.feeHeadNameList=null;
       
        this.feeHeadNameList = new ArrayList<String>();
        
         for(FeeHead feeHead : this.feeHeadList) 
        {
            if(feeHead.getFeeCategoryID()==Integer.parseInt(feeCatName.split("-")[0])) 
            {
                this.feeHeadNameList.add(feeHead.getFeeHeadID()+"-"+feeHead.getFeeHeadName());
            }
        }
         
        
    }

    
    public List<FeeCategory> getFeeCategoryList() {
        return feeCategoryList;
    }

    public void setFeeCategoryList(List<FeeCategory> feeCategoryList) {
        this.feeCategoryList = feeCategoryList;
    }

    public List<FeeHead> getFeeHeadList() {
        return feeHeadList;
    }

    public void setFeeHeadList(List<FeeHead> feeHeadList) {
        this.feeHeadList = feeHeadList;
    }

    public List<String> getFeeCatNameList() {
        
          this.feeCatNameList = new ArrayList<String>();
        
        for(FeeCategory feeCategory : feeCategoryList)
        {
            this.feeCatNameList.add(feeCategory.getCategoryID()+"-"+feeCategory.getCategoryName());
        
        }
        return feeCatNameList;
    }

    public void setFeeCatNameList(List<String> feeCatNameList) {
        this.feeCatNameList = feeCatNameList;
    }

    public String getFeeCatName() {
        return feeCatName;
    }

    public void setFeeCatName(String feeCatName) {
        this.feeCatName = feeCatName;
    }          

    public List<String> getFeeHeadNameList() {       
       
        return this.feeHeadNameList;
    }

    public void setFeeHeadNameList(List<String> feeHeadNameList) {
        this.feeHeadNameList = feeHeadNameList;
    }

    public String getFeeHeadName() {
        return feeHeadName;
    }

    public void setFeeHeadName(String feeHeadName) {
        this.feeHeadName = feeHeadName;
    }    
    
     public List<String> getSubFeeHeadNameList() 
    {
        
        this.subFeeHeadNameList = new ArrayList<String>();
        
        for(SubFeeHead subFeeHead : this.subFeeHeadList)
        {
            this.subFeeHeadNameList.add(subFeeHead.getSubFeeHeadName());
        }
        
        return this.subFeeHeadNameList;
    }

    public void setSubFeeHeadNameList(List<String> subFeeHeadNameList) {
        this.subFeeHeadNameList = subFeeHeadNameList;
    }  

    public List<SubFeeHead> getSubFeeHeadList() {     
        return subFeeHeadList;
    }

    public void setSubFeeHeadList(List<SubFeeHead> subFeeHeadList) {
        this.subFeeHeadList = subFeeHeadList;
    }

    public Fee getFee() {
        
        if(this.fee==null)
        {
            this.fee = new Fee();
        }
        return this.fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

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
