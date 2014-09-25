/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeHead;

import com.pencil.Accounts.FeeCategory.FeeCategory;
import com.pencil.Accounts.FeeCategory.FeeCategoryService;
import com.pencil.Accounts.FeeCategory.FeeCategoryServiceImpl;
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
 * @author Mamun
 */
public class FeeHeadController {
    
    private FeeHead feeHead;
    
    private List<FeeHead> feeHeadList;
    
    private String feeHeadName;
    
    private List<String> feeHeadNameList;    
    
    private List<FeeCategory> feeCategoryList;    
        
    FeeHeadService serviceDao = new FeeHeadServiceImpl();    
        
    FeeCategoryService feeCatService = new FeeCategoryServiceImpl();

    public FeeHeadController() 
    {
        this.feeCategoryList = feeCatService.getAllFeeCategory();        
        
    }
    
    public void createFeeHead()
    {
          FacesContext context = FacesContext.getCurrentInstance();
          
          this.feeHead.setFeeCategoryID(Integer.parseInt(feeHeadName.split("-")[0]));
        
        if(serviceDao.addFeeHead(this.feeHead))
        {
            context.addMessage(null, new FacesMessage("Successful", "Fee Head Added"));
            
            this.feeHead=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Fee Head is not added"));
        }
    }

    public FeeHead getFeeHead() 
    {
        if(this.feeHead==null)
        {
            this.feeHead = new FeeHead();
        }
        return this.feeHead;
    }

    public void setFeeHead(FeeHead feeHead) {
        this.feeHead = feeHead;
    }

    public List<FeeHead> getFeeHeadList() 
    {
        this.feeHeadList=serviceDao.getAllFeeHead();
        return this.feeHeadList;
    }

    public void setFeeHeadList(List<FeeHead> feeHeadList) {
        this.feeHeadList = feeHeadList;
    }

    public String getFeeHeadName() {
        return feeHeadName;
    }

    public void setFeeHeadName(String feeHeadName) {
        this.feeHeadName = feeHeadName;
    } 

    public List<FeeCategory> getFeeCategoryList() {
        return feeCategoryList;
    }

    public void setFeeCategoryList(List<FeeCategory> feeCategoryList) {
        this.feeCategoryList = feeCategoryList;
    }

    public List<String> getFeeHeadNameList() 
    {
        this.feeHeadNameList = new ArrayList<String>();
        
        for(FeeCategory feeCategory : feeCategoryList)
        {
            this.feeHeadNameList.add(feeCategory.getCategoryID()+"-"+feeCategory.getCategoryName());
        
        }
        return this.feeHeadNameList;
    }

    public void setFeeHeadNameList(List<String> feeHeadNameList) {
        this.feeHeadNameList = feeHeadNameList;
    }
       
               
}
