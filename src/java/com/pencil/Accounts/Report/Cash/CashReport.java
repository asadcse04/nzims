/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Report.Cash;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mamun
 */
public class CashReport implements Serializable{
 
    
    private int TrnID;
    private Date TrnDate;
    private String TrnStatus;
    private String TrnName;
    private double TrnAmount;
    private int trSubHeadID;
    private String InvoiceID;
    private String PaymentType;
    private String AttachedVoucher;
    private String Note;
    private String BankID;
    private String BankName;
    private String checkNo;
    private String userid;
    
    private double income;
    private double expense;

    private Date fromdate;
    private Date todate;
    
    
    
     public CashReport() {
    }

    public CashReport(int TrnID, Date TrnDate, String TrnStatus, String TrnName, double TrnAmount, int trSubHeadID, String InvoiceID, String PaymentType, String AttachedVoucher, String Note, String BankID, String BankName, String checkNo, String userid) {
        this.TrnID = TrnID;
        this.TrnDate = TrnDate;
        this.TrnStatus = TrnStatus;
        this.TrnName = TrnName;
        this.TrnAmount = TrnAmount;
        this.trSubHeadID = trSubHeadID;
        this.InvoiceID = InvoiceID;
        this.PaymentType = PaymentType;
        this.AttachedVoucher = AttachedVoucher;
        this.Note = Note;
        this.BankID = BankID;
        this.BankName = BankName;
        this.checkNo = checkNo;
        this.userid = userid;
    }

    /**
     * @return the TrnID
     */
    public int getTrnID() {
        return TrnID;
    }

    /**
     * @param TrnID the TrnID to set
     */
    public void setTrnID(int TrnID) {
        this.TrnID = TrnID;
    }

    /**
     * @return the TrnDate
     */
    public Date getTrnDate() {
        return TrnDate;
    }

    /**
     * @param TrnDate the TrnDate to set
     */
    public void setTrnDate(Date TrnDate) {
        this.TrnDate = TrnDate;
    }

    /**
     * @return the TrnStatus
     */
    public String getTrnStatus() {
        return TrnStatus;
    }

    /**
     * @param TrnStatus the TrnStatus to set
     */
    public void setTrnStatus(String TrnStatus) {
        this.TrnStatus = TrnStatus;
    }

    /**
     * @return the TrnName
     */
    public String getTrnName() {
        return TrnName;
    }

    /**
     * @param TrnName the TrnName to set
     */
    public void setTrnName(String TrnName) {
        this.TrnName = TrnName;
    }

    /**
     * @return the TrnAmount
     */
    public double getTrnAmount() {
        return TrnAmount;
    }

    /**
     * @param TrnAmount the TrnAmount to set
     */
    public void setTrnAmount(double TrnAmount) {
        this.TrnAmount = TrnAmount;
    }

    /**
     * @return the trSubHeadID
     */
    public int getTrSubHeadID() {
        return trSubHeadID;
    }

    /**
     * @param trSubHeadID the trSubHeadID to set
     */
    public void setTrSubHeadID(int trSubHeadID) {
        this.trSubHeadID = trSubHeadID;
    }

    /**
     * @return the InvoiceID
     */
    public String getInvoiceID() {
        return InvoiceID;
    }

    /**
     * @param InvoiceID the InvoiceID to set
     */
    public void setInvoiceID(String InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    /**
     * @return the PaymentType
     */
    public String getPaymentType() {
        return PaymentType;
    }

    /**
     * @param PaymentType the PaymentType to set
     */
    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }

    /**
     * @return the AttachedVoucher
     */
    public String getAttachedVoucher() {
        return AttachedVoucher;
    }

    /**
     * @param AttachedVoucher the AttachedVoucher to set
     */
    public void setAttachedVoucher(String AttachedVoucher) {
        this.AttachedVoucher = AttachedVoucher;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

    /**
     * @return the BankID
     */
    public String getBankID() {
        return BankID;
    }

    /**
     * @param BankID the BankID to set
     */
    public void setBankID(String BankID) {
        this.BankID = BankID;
    }

    /**
     * @return the BankName
     */
    public String getBankName() {
        return BankName;
    }

    /**
     * @param BankName the BankName to set
     */
    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    /**
     * @return the checkNo
     */
    public String getCheckNo() {
        return checkNo;
    }

    /**
     * @param checkNo the checkNo to set
     */
    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    
    @Transient
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Transient
    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    /**
     * @return the fromdate
     */
    public Date getFromdate() {
        return fromdate;
    }

    /**
     * @param fromdate the fromdate to set
     */
    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    /**
     * @return the todate
     */
    public Date getTodate() {
        return todate;
    }

    /**
     * @param todate the todate to set
     */
    public void setTodate(Date todate) {
        this.todate = todate;
    }

   
}
