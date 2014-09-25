/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transaction.BankTransaction;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Riad
 */
public class BankTransection implements Serializable{
    
    private int banktrnId;
    private int bankId;
    private Date date;
    private String status;
    private double amount;
    private String amounttype;
    private String tranname;
    private String subheadname;
    private int subheadId;
    private String invoiceId;
    private String purpose;
    private String checkno;
    private String note;
    private String userId;
    
    public BankTransection(){
        
    }

    public BankTransection(int banktrnId, int bankId, Date date, String status, double amount, String amounttype, String tranname, String subheadname, int subheadId, String invoiceId, String purpose, String checkno, String note, String userId) {
        this.banktrnId = banktrnId;
        this.bankId = bankId;
        this.date = date;
        this.status = status;
        this.amount = amount;
        this.amounttype = amounttype;
        this.tranname = tranname;
        this.subheadname = subheadname;
        this.subheadId = subheadId;
        this.invoiceId = invoiceId;
        this.purpose = purpose;
        this.checkno = checkno;
        this.note = note;
        this.userId = userId;
    }
    
    

    /**
     * @return the banktrnId
     */
    public int getBanktrnId() {
        return banktrnId;
    }

    /**
     * @param banktrnId the banktrnId to set
     */
    public void setBanktrnId(int banktrnId) {
        this.banktrnId = banktrnId;
    }

    /**
     * @return the bankId
     */
    public int getBankId() {
        return bankId;
    }

    /**
     * @param bankId the bankId to set
     */
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the amounttype
     */
    public String getAmounttype() {
        return amounttype;
    }

    /**
     * @param amounttype the amounttype to set
     */
    public void setAmounttype(String amounttype) {
        this.amounttype = amounttype;
    }

    /**
     * @return the tranname
     */
    public String getTranname() {
        return tranname;
    }

    /**
     * @param tranname the tranname to set
     */
    public void setTranname(String tranname) {
        this.tranname = tranname;
    }

    /**
     * @return the subheadname
     */
    public String getSubheadname() {
        return subheadname;
    }

    /**
     * @param subheadname the subheadname to set
     */
    public void setSubheadname(String subheadname) {
        this.subheadname = subheadname;
    }

    /**
     * @return the subheadId
     */
    public int getSubheadId() {
        return subheadId;
    }

    /**
     * @param subheadId the subheadId to set
     */
    public void setSubheadId(int subheadId) {
        this.subheadId = subheadId;
    }

    /**
     * @return the invoiceId
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * @param invoiceId the invoiceId to set
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * @return the checkno
     */
    public String getCheckno() {
        return checkno;
    }

    /**
     * @param checkno the checkno to set
     */
    public void setCheckno(String checkno) {
        this.checkno = checkno;
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
