/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeConfig;

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
public class FeeConfigController implements Serializable{
    
    private FeeConfig feeConfigObj;
    
    private List<String> academicYearList;
    
    private ClassDeptDataList classDeptDataList; //This list contains all class and department name
    
    private List<ClassDeptObj> selectedClassDeptList; //This list contains only the class and dept after check box selection
    
    private List<FeeCategory> feeCategoryList; //This list includes all FeeCategory Objects
    
    private List<String> feeCatNameList; //This list includes only the fee Category Names
    
    private List<FeeHead> feeHeadList;
    
    private List<SubFeeHead> subFeeHeadList; // All Sub head List
    
    private List <SubFeeHeadDetail> subFeeHeadDetList;
    
    private List<ClassDeptObj> classDeptList;
       
    private List<String> feeHeadNameList;
       
    private String feeCatName;
    
    private String feeHeadName;
    
    private String academicYear;
    
    
    
    FeeConfigService serviceDao = new FeeConfigServiceImpl();
    
    Presentation pr = new Presentation();
    
    FeeHeadService feeHeadServiceDao = new FeeHeadServiceImpl();
    
    FeeCategoryService feeCatService = new FeeCategoryServiceImpl();
    
    SubFeeHeadService subHeadServiceDao = new SubFeeHeadServiceImpl();

    public FeeConfigController() 
    
    {
        this.academicYearList = pr.infoList("acyr"); 
        
        this.feeCategoryList = feeCatService.getAllFeeCategory();
        
        this.feeHeadList = feeHeadServiceDao.getAllFeeHead();
        
        this.subFeeHeadList = subHeadServiceDao.getAllSubFeeHead();
        
        this.classDeptDataList = new ClassDeptDataList(serviceDao.getClassDeptList());
        
    }
    
   
    
    public void calculate()
    {
        
    }
    
    public void saveFeeConfig()
    {
        System.out.println(" " + this.getClassDeptList().size());
        
        this.getFeeConfigObj().setFeeConfigID(Integer.parseInt(this.feeCatName.split("-")[0]));
        
        this.getFeeConfigObj().setFeeHeadID(Integer.parseInt(this.feeHeadName.split("-")[0]));
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.saveFeeConfig(this.feeConfigObj, this.subFeeHeadDetList, this.selectedClassDeptList))
        {
            context.addMessage(null, new FacesMessage("Successful", "Fee Configuration Added"));
            
            this.feeConfigObj=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Fee Configuration is not added"));
        }
        
        
    }
    
    public void initFeeHeadNameList() //this method is used to generate feehead name list according to fee category
    {
        this.feeHeadNameList=null;
        
        this.feeHeadNameList = new ArrayList<String>();
        
        if(this.feeHeadList !=null && this.feeCatName!=null)
        
         for(FeeHead feeHead : this.feeHeadList) 
        {
            if(feeHead.getFeeCategoryID()==Integer.parseInt(feeCatName.split("-")[0])) 
            {
                this.feeHeadNameList.add(feeHead.getFeeHeadID()+"-"+feeHead.getFeeHeadName());
            }
        }
    }
    
       public FeeConfig getFeeConfigObj() 
    {
        if(this.feeConfigObj == null)
        {
            this.feeConfigObj = new FeeConfig();
        }
        return feeConfigObj;
    }
    
    public void initSubHeadNameList()
    {
        this.feeConfigObj.setFeeHeadID(Integer.parseInt(this.feeHeadName.split("-")[0]));
     
        this.subFeeHeadDetList = null;
        
        this.subFeeHeadDetList = serviceDao.getSubHeadDetail(this.feeConfigObj,this.classDeptDataList);
        
        System.out.println("head name"+this.feeHeadName);
        System.out.println("cat name"+this.feeCatName);
        //System.out.println("ac year id "+this.selectedClassDeptList.get(0).getAcademicYear());
        
    }

 

    public void setFeeConfigObj(FeeConfig feeConfigObj) {
        this.feeConfigObj = feeConfigObj;
    }
    
    
    public String getFeeCatName() {
        return feeCatName;
    }

    public void setFeeCatName(String feeCatName) {
        this.feeCatName = feeCatName;
    }

    public String getFeeHeadName() {
        return feeHeadName;
    }

    public void setFeeHeadName(String feeHeadName) {
        this.feeHeadName = feeHeadName;
    }      

   
    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }

    public List<FeeCategory> getFeeCategoryList() {
        return feeCategoryList;
    }

    public void setFeeCategoryList(List<FeeCategory> feeCategoryList) {
        this.feeCategoryList = feeCategoryList;
    }

    public List<String> getFeeCatNameList() 
    {
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

    public List<FeeHead> getFeeHeadList() {
        return feeHeadList;
    }

    public void setFeeHeadList(List<FeeHead> feeHeadList) {
        this.feeHeadList = feeHeadList;
    }

    public List<String> getFeeHeadNameList() {
        return feeHeadNameList;
    }

    public void setFeeHeadNameList(List<String> feeHeadNameList) {
        this.feeHeadNameList = feeHeadNameList;
    } 

    public List<SubFeeHead> getSubFeeHeadList() {
        return subFeeHeadList;
    }

    public void setSubFeeHeadList(List<SubFeeHead> subFeeHeadList) {
        this.subFeeHeadList = subFeeHeadList;
    }       

    public List<SubFeeHeadDetail> getSubFeeHeadDetList() {
        return subFeeHeadDetList;
    }

    public void setSubFeeHeadDetList(List<SubFeeHeadDetail> subFeeHeadDetList) {
        this.subFeeHeadDetList = subFeeHeadDetList;
    }

    public List<ClassDeptObj> getClassDeptList() 
    {
        this.classDeptList = serviceDao.getClassDeptList();
        return classDeptList;
    }

    public void setClassDeptList(List<ClassDeptObj> classDeptList) {
        this.classDeptList = classDeptList;
    }

    public ClassDeptDataList getClassDeptDataList() {
        
        return classDeptDataList;
    }
    
    public void setClassDeptDataList(ClassDeptDataList classDeptDataList) {
        this.classDeptDataList = classDeptDataList;
    }

    public List<ClassDeptObj> getSelectedClassDeptList() {
        return selectedClassDeptList;
    }

    public void setSelectedClassDeptList(List<ClassDeptObj> selectedClassDeptList) {
        this.selectedClassDeptList = selectedClassDeptList;
    }

  

 

    
    


}
