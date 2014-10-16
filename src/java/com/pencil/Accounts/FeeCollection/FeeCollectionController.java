/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCollection;

import com.pencil.Accounts.FeeCategory.FeeCategory;
import com.pencil.Accounts.FeeCategory.FeeCategoryService;
import com.pencil.Accounts.FeeCategory.FeeCategoryServiceImpl;
import com.pencil.Accounts.FeeConfig.SubFeeHeadDetail;
import com.pencil.Accounts.FeeHead.FeeHead;
import com.pencil.Accounts.FeeHead.FeeHeadService;
import com.pencil.Accounts.FeeHead.FeeHeadServiceImpl;
import com.pencil.Accounts.MonthConfig.MonthConfig;
import com.pencil.Accounts.MonthConfig.MonthConfigService;
import com.pencil.Accounts.MonthConfig.MonthConfigServiceImpl;
import com.pencil.Accounts.SubFeeHead.SubFeeHead;
import com.pencil.Accounts.SubFeeHead.SubFeeHeadService;
import com.pencil.Accounts.SubFeeHead.SubFeeHeadServiceImpl;
import com.pencil.Presentation.Presentation;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import com.pencil.SMS.SendSMS.SendSMSService;
import com.pencil.SMS.SendSMS.SendSMSServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
public class FeeCollectionController implements Serializable{
    
    private List<String> academicYearList;
  
    private List<FeeCategory> feeCategoryList; //This list includes all FeeCategory Objects
    
    private List<String> feeCatNameList; //This list includes only the fee Category Names
    
    private List<FeeHead> feeHeadList;
    
    private List<SubFeeHead> subFeeHeadList; // All Sub head List
    
    private List <SubFeeHeadDetail> subFeeHeadDetList;

    private List<String> feeHeadNameList;
    
    private List<MonthConfig> monConfList;
    
    private List<String> monthList;
    
    private List<FeeInvDetObj> studentlist;

    
    private String [] paymentTypes={"Cash","Bkash","Bank"};
       
    private FeeInvDetObj feeInvDetObj;
    
    private int instituteId;
    
    private int smsBal;
    
  
    
    Presentation pr = new Presentation();
    
    FeeHeadService feeHeadServiceDao = new FeeHeadServiceImpl();
    
    FeeCategoryService feeCatService = new FeeCategoryServiceImpl();
    
    SubFeeHeadService subHeadServiceDao = new SubFeeHeadServiceImpl();
    
    MonthConfigService monConfServiceDao=new MonthConfigServiceImpl();
    
    FeeCollectionService servicedao=new FeeCollectionServiceImpl();
    
    SMS_Service msgservice=new SMS_ServiceImpl();
    
    Map <String,FeeInvDetObj> map=new <String,FeeInvDetObj> HashMap();
    
     List<FeeInvDetObj> item=new ArrayList<>();

    
     public FeeCollectionController() 
    {
        this.academicYearList = pr.infoList("acyr"); 
        
        this.feeCategoryList = feeCatService.getAllFeeCategory();
        
        this.feeHeadList = feeHeadServiceDao.getAllFeeHead();
        
        this.subFeeHeadList = subHeadServiceDao.getAllSubFeeHead();
        
        this.monConfList=monConfServiceDao.getMonthConfigList();
        
        String instituteID="";
        
        FacesContext context=FacesContext.getCurrentInstance();
         
        instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        instituteId=Integer.valueOf(instituteID);
        
         this.smsBal=msgservice.getSmsCurrent_Ac_Balance(instituteId);
        
    }
  
    
    
    public void initFeeHeadNameList() //this method is used to generate feehead name list according to fee category
    {
        this.feeHeadNameList=null;
        
        this.monthList=null;
        
        this.feeHeadNameList = new ArrayList<String>();
        
        this.monthList=new ArrayList<String>();
        
        if(this.feeHeadList !=null && this.feeInvDetObj.getFeectagoryname() !=null)
        {
      
         for(FeeHead feeHead : this.feeHeadList) 
        {
            if(feeHead.getFeeCategoryID()==Integer.parseInt(this.feeInvDetObj.getFeectagoryname().split("-")[0])) 
            {
                this.feeHeadNameList.add(feeHead.getFeeHeadID()+"-"+feeHead.getFeeHeadName());
            }
        }
        
        }
        
        if(this.feeInvDetObj.getFeectagoryname().split("-")[1].equals("Monthly")){
         
            for(MonthConfig mc:this.monConfList){
           
                this.monthList.add(mc.getMonthName());
            
            }
        }
         
       
    }
    
    
    //.....................................Method for Student Info Setup.................................................//
   
    public void allInfoStudent(){
     
     FacesContext context=FacesContext.getCurrentInstance();
     
     this.studentlist=new ArrayList<>();
      
     this.studentlist=servicedao.getStudentAllinfo(this.feeInvDetObj.getStudentID());
     
     if(this.studentlist.size()< 1)
     
     {   
      
     context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Data not found",""));
         
     this.feeInvDetObj.setStudentname("");
     
     this.feeInvDetObj.setGender("");
     
     this.feeInvDetObj.setFathername("");
     
     this.feeInvDetObj.setContactno("");
     
     this.feeInvDetObj.setAcademicyearid(0);
     
     this.feeInvDetObj.setShiftname("");
     
     this.feeInvDetObj.setClassname("");
     
     this.feeInvDetObj.setSectionname("");
     
     this.feeInvDetObj.setStudentroll(0);
     
     this.feeInvDetObj.setDepartname("");
     
    
     }
     
     else{
         
     this.feeInvDetObj.setStudentname(this.studentlist.get(0).getStudentname());
     
     this.feeInvDetObj.setGender(this.studentlist.get(0).getGender());
     
     this.feeInvDetObj.setFathername(this.studentlist.get(0).getFathername());
     
     this.feeInvDetObj.setContactno(this.studentlist.get(0).getContactno());
     
     this.feeInvDetObj.setAcademicyearid(this.studentlist.get(0).getAcademicyearid());
     
     this.feeInvDetObj.setShiftname(this.studentlist.get(0).getShiftname());
     
     this.feeInvDetObj.setClassname(this.studentlist.get(0).getClassname());
     
     this.feeInvDetObj.setSectionname(this.studentlist.get(0).getSectionname());
     
     this.feeInvDetObj.setStudentroll(this.studentlist.get(0).getStudentroll());
     
     this.feeInvDetObj.setDepartname(this.studentlist.get(0).getDepartname());  
    
         
     }
 
 }
    
    public void feeAmount(){
        
       
         this.feeInvDetObj.setAmount(servicedao.getFeeAmount(this.feeInvDetObj));
       
        
        this.feeInvDetObj.processCalculation();
    }
    
    public void addFeeRecord(){
   
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(servicedao.saveFeeRecord(item, feeInvDetObj))
        {
            context.addMessage(null, new FacesMessage("Successful Fee Information Saved", ""));
            
            this.invoiceDetail().clear();
            
            this.map.clear();
            
            sendFeeSms();
            
            this.feeInvDetObj=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed,Fee Information is not Saved", ""));
        }
        
    }
    
    public void sendFeeSms()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (servicedao.sendSms(feeInvDetObj, smsBal))
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully send sms to the selected teachers."));
        }
        else 
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to send sms to the selected teachers."));
        }
  
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
    /**
     * @return the paymentTypes
     */
    public String[] getPaymentTypes() {
        return paymentTypes;
    }

    /**
     * @param paymentTypes the paymentTypes to set
     */
    public void setPaymentTypes(String[] paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
    /**
     * @return the feeInvDetObj
     */
    public FeeInvDetObj getFeeInvDetObj() {
        
        if(this.feeInvDetObj==null){
            
            this.feeInvDetObj=new FeeInvDetObj(); 
        }
        
        return this.feeInvDetObj;
    }

    /**
     * @param feeInvDetObj the feeInvDetObj to set
     */
    public void setFeeInvDetObj(FeeInvDetObj feeInvDetObj) {
        this.feeInvDetObj = feeInvDetObj;
    }
    
    
    
    public  void addFee(){
        
        map.put(this.feeInvDetObj.getFeename(), new FeeInvDetObj((Integer.parseInt(this.feeInvDetObj.getFeename().split("-")[0])),this.feeInvDetObj.getFeename().split("-")[1],this.feeInvDetObj.getAmount(),this.feeInvDetObj.getConcession(),this.feeInvDetObj.getPenalty(),this.feeInvDetObj.getActualAmount(),this.feeInvDetObj.getPaidAmount(),this.feeInvDetObj.getDue()));
       
    }
    
    
   
    
    public  List<FeeInvDetObj> invoiceDetail(){
        
        item.clear();
        
        item.addAll(map.values());
        
        return item;
    
    }
    
    public double countTotal(){
      double c=0.0d;
      
      Iterator<FeeInvDetObj> ite=item.iterator();
      
      while(ite.hasNext()){
          c+=ite.next().getPaidAmount();
      }
      
      this.feeInvDetObj.setTotalAmount(c);
      
      return c;
    }

    /**
     * @return the monConfList
     */
    public List<MonthConfig> getMonConfList() {
        return monConfList;
    }

    /**
     * @param monConfList the monConfList to set
     */
    public void setMonConfList(List<MonthConfig> monConfList) {
        this.monConfList = monConfList;
    }

    /**
     * @return the monthList
     */
    public List<String> getMonthList() {
        return monthList;
    }

    /**
     * @param monthList the monthList to set
     */
    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }

    /**
     * @return the studentlist
     */
    public List<FeeInvDetObj> getStudentlist() {
        return studentlist;
    }

    /**
     * @param studentlist the studentlist to set
     */
    public void setStudentlist(List<FeeInvDetObj> studentlist) {
        this.studentlist = studentlist;
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public int getSmsBal() {
        return smsBal;
    }

    public void setSmsBal(int smsBal) {
        this.smsBal = smsBal;
    }
    
    
    
    
  
    
     

}
