/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.Expense;

import java.util.Date;

/**
 *
 * @author Mamun
 */
public class Expense {
    
    
     private int trnID;
    
    private Date trnDate;
    
    private String tranStatus;
    
    private String tranName;
    
    private double tranAmount;
    
    private int trSubHeadID;
    
    private String invoiceID;
    
    private String paymentType;
    
    private String attachedVoucherNo;
    
    private String note;
    
    private int bankID;
    
    private String bankName;
    
     private String checkNo;
    
    private String userId;
    
    public Expense(){
        
    }
    

    public Expense(int trnID, Date trnDate, String tranStatus, String tranName, double tranAmount, int trSubHeadID, String invoiceID, String paymentType, String attachedVoucherNo, String note, int bankID, String bankName, String checkNo, String userId) {
        this.trnID = trnID;
        this.trnDate = trnDate;
        this.tranStatus = tranStatus;
        this.tranName = tranName;
        this.tranAmount = tranAmount;
        this.trSubHeadID = trSubHeadID;
        this.invoiceID = invoiceID;
        this.paymentType = paymentType;
        this.attachedVoucherNo = attachedVoucherNo;
        this.note = note;
        this.bankID = bankID;
        this.bankName = bankName;
        this.checkNo = checkNo;
        this.userId = userId;
    }
    
   

    /**
     * @return the trnID
     */
    public int getTrnID() {
        return trnID;
    }

    /**
     * @param trnID the trnID to set
     */
    public void setTrnID(int trnID) {
        this.trnID = trnID;
    }

    /**
     * @return the trnDate
     */
    public Date getTrnDate() {
        return trnDate;
    }

    /**
     * @param trnDate the trnDate to set
     */
    public void setTrnDate(Date trnDate) {
        this.trnDate = trnDate;
    }

    /**
     * @return the tranStatus
     */
    public String getTranStatus() {
        return tranStatus;
    }

    /**
     * @param tranStatus the tranStatus to set
     */
    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }

    /**
     * @return the tranName
     */
    public String getTranName() {
        return tranName;
    }

    /**
     * @param tranName the tranName to set
     */
    public void setTranName(String tranName) {
        this.tranName = tranName;
    }

    /**
     * @return the tranAmount
     */
    public double getTranAmount() {
        return tranAmount;
    }

    /**
     * @param tranAmount the tranAmount to set
     */
    public void setTranAmount(double tranAmount) {
        this.tranAmount = tranAmount;
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
     * @return the invoiceID
     */
    public String getInvoiceID() {
        return invoiceID;
    }

    /**
     * @param invoiceID the invoiceID to set
     */
    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
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
     * @return the attachedVoucherNo
     */
    public String getAttachedVoucherNo() {
        return attachedVoucherNo;
    }

    /**
     * @param attachedVoucherNo the attachedVoucherNo to set
     */
    public void setAttachedVoucherNo(String attachedVoucherNo) {
        this.attachedVoucherNo = attachedVoucherNo;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the bankID
     */
    public int getBankID() {
        return bankID;
    }

    /**
     * @param bankID the bankID to set
     */
    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
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
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
    
    
    
}
