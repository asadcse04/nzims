/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeCollection;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jahangiralamdiu
 */
public class FeeInvDetObj implements Serializable {
    
    private int feeInvDetID;
    
    private int feeInvoiceID;
    
    private int feeConfigID;
    
    private int monthID;
    
    private int academicyear;
    
    private String feectagoryname;
    
    private String feename;
    
    private double amount;
    
    private double concession;
    
    private String conPurpose;
    
    private double penalty;
    
    private String penPurpose;
    
    private double actualAmount;
    
    private double paidAmount;
    
    private double due;
    
    private Date payDate;
    
    private String studentID;
    
    private String paymentType;
    
    // Student Search Properties
    
    private int studentid;
    private String studentname;
    private int studentroll;
    private String gender;
    private String fathername;
    private String contactno;
    private int academicyearid;
    private String classname;
    private String departname;
    private String shiftname;
    private String sectionname;
    
    
    private String[] selectedmonths;
    
    private int arraysize=1;

    public FeeInvDetObj() {
        
    }
    
   // Student Search Controller
    
     public FeeInvDetObj(int studentid, String studentname, int studentroll, String gender, String fathername, String contactno, int academicyearid, String classname, String departname, String shiftname, String sectionname) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentroll = studentroll;
        this.gender = gender;
        this.fathername = fathername;
        this.contactno = contactno;
        this.academicyearid = academicyearid;
        this.classname = classname;
        this.departname = departname;
        this.shiftname = shiftname;
        this.sectionname = sectionname;
    }

    public FeeInvDetObj(int feeInvDetID, int feeInvoiceID, int feeConfigID, int monthID, int academicyear, String feectagoryname, String feename, double amount, double concession, String conPurpose, double penalty, String penPurpose, double actualAmount, double paidAmount, double due, Date payDate, String studentID, String paymentType) {
        this.feeInvDetID = feeInvDetID;
        this.feeInvoiceID = feeInvoiceID;
        this.feeConfigID = feeConfigID;
        this.monthID = monthID;
        this.academicyear = academicyear;
        this.feectagoryname = feectagoryname;
        this.feename = feename;
        this.amount = amount;
        this.concession = concession;
        this.conPurpose = conPurpose;
        this.penalty = penalty;
        this.penPurpose = penPurpose;
        this.actualAmount = actualAmount;
        this.paidAmount = paidAmount;
        this.due = due;
        this.payDate = payDate;
        this.studentID = studentID;
        this.paymentType = paymentType;
    }

    
    // Fee List Controller
    
    public FeeInvDetObj(String feename, double amount, double concession, double penalty, double actualAmount, double paidAmount, double due) {
        this.feename = feename;
        this.amount = amount;
        this.concession = concession;
        this.penalty = penalty;
        this.actualAmount = actualAmount;
        this.paidAmount = paidAmount;
        this.due = due;
    }
    
    
      
    

    
      public void processCalculation(){
        
        this.actualAmount=((this.amount*this.arraysize)-this.concession)+this.penalty;
        
        this.due=this.actualAmount-this.paidAmount;
            
      }
      
      public void resetField(){
       this.amount=0;
       this.concession=0;
       this.penalty=0;
       this.actualAmount=0;
       this.paidAmount=0;
       this.due=0;
       this.conPurpose="";
       this.penPurpose="";
      }

    
      public int getFeeInvDetID() {
        return feeInvDetID;
    }

    public void setFeeInvDetID(int feeInvDetID) {
        this.feeInvDetID = feeInvDetID;
    }

    public int getFeeInvoiceID() {
        return feeInvoiceID;
    }

    public void setFeeInvoiceID(int feeInvoiceID) {
        this.feeInvoiceID = feeInvoiceID;
    }

    public int getFeeConfigID() {
        return feeConfigID;
    }

    public void setFeeConfigID(int feeConfigID) {
        this.feeConfigID = feeConfigID;
    }

    public int getMonthID() {
        return monthID;
    }

    public void setMonthID(int monthID) {
        this.monthID = monthID;
    }

    public double getAmount(){
            return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getConcession() {
        return concession;
    }

    public void setConcession(double concession) {
        this.concession = concession;
    }

    public String getConPurpose() {
        return conPurpose;
    }

    public void setConPurpose(String conPurpose) {
        this.conPurpose = conPurpose;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public String getPenPurpose() {
        return penPurpose;
    }

    public void setPenPurpose(String penPurpose) {
        this.penPurpose = penPurpose;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }    

    /**
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return the academicyear
     */
    public int getAcademicyear() {
        return academicyear;
    }

    /**
     * @param academicyear the academicyear to set
     */
    public void setAcademicyear(int academicyear) {
        this.academicyear = academicyear;
    }

    /**
     * @return the feectagoryname
     */
    public String getFeectagoryname() {
        return feectagoryname;
    }

    /**
     * @param feectagoryname the feectagoryname to set
     */
    public void setFeectagoryname(String feectagoryname) {
        this.feectagoryname = feectagoryname;
    }

    /**
     * @return the feename
     */
    public String getFeename() {
        return feename;
    }

    /**
     * @param feename the feename to set
     */
    public void setFeename(String feename) {
        this.feename = feename;
    }

    
    
     /**
     * @return the studentid
     */
    public int getStudentid() {
        return studentid;
    }

    /**
     * @param studentid the studentid to set
     */
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    /**
     * @return the studentname
     */
    public String getStudentname() {
        return studentname;
    }

    /**
     * @param studentname the studentname to set
     */
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    /**
     * @return the studentroll
     */
    public int getStudentroll() {
        return studentroll;
    }

    /**
     * @param studentroll the studentroll to set
     */
    public void setStudentroll(int studentroll) {
        this.studentroll = studentroll;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the fathername
     */
    public String getFathername() {
        return fathername;
    }

    /**
     * @param fathername the fathername to set
     */
    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    /**
     * @return the contactno
     */
    public String getContactno() {
        return contactno;
    }

    /**
     * @param contactno the contactno to set
     */
    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    /**
     * @return the academicyearid
     */
    public int getAcademicyearid() {
        return academicyearid;
    }

    /**
     * @param academicyearid the academicyearid to set
     */
    public void setAcademicyearid(int academicyearid) {
        this.academicyearid = academicyearid;
    }

    /**
     * @return the classname
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param classname the classname to set
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     * @return the departname
     */
    public String getDepartname() {
        return departname;
    }

    /**
     * @param departname the departname to set
     */
    public void setDepartname(String departname) {
        this.departname = departname;
    }

    /**
     * @return the shiftname
     */
    public String getShiftname() {
        return shiftname;
    }

    /**
     * @param shiftname the shiftname to set
     */
    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    /**
     * @return the sectionname
     */
    public String getSectionname() {
        return sectionname;
    }

    /**
     * @param sectionname the sectionname to set
     */
    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }
    /**
     * @return the selectedmonths
     */
    public String[] getSelectedmonths() {
          return selectedmonths;
    }

    /**
     * @param selectedmonths the selectedmonths to set
     */
    public void setSelectedmonths(String[] selectedmonths) {
        this.selectedmonths = selectedmonths;
    }

    /**
     * @return the arraysize
     */
    public int getArraysize() {
        
        this.arraysize=1;
        
         if(this.selectedmonths.length>0){
            
            this.arraysize=this.selectedmonths.length;
        }
        return arraysize;
    }

    /**
     * @param arraysize the arraysize to set
     */
    public void setArraysize(int arraysize) {
        this.arraysize = arraysize;
    }
    
   
        
        
}
