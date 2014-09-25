/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.BankAccount;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Riad
 */
public class BankAccount implements Serializable{
   
    private int bankAcID;
    private String bankName;
    private String remarkSymbol;
    private String acName;
    private String acNumber;
    private String acType;
    private String address;
    private String branch;
    private double startingBalance;
    private String note;
    private int bankAcGroupID;
    private Date createDate;
    private double totalDiposit;
    private double totalWithdraw;
    private double blance;
    
    public BankAccount(){
        
    }

    public BankAccount(int bankAcID, String bankName, String remarkSymbol, String acName, String acNumber, String acType, String address, String branch, double startingBalance, String note, int bankAcGroupID, Date createDate, double totalDiposit, double totalWithdraw, double blance) {
        this.bankAcID = bankAcID;
        this.bankName = bankName;
        this.remarkSymbol = remarkSymbol;
        this.acName = acName;
        this.acNumber = acNumber;
        this.acType = acType;
        this.address = address;
        this.branch = branch;
        this.startingBalance = startingBalance;
        this.note = note;
        this.bankAcGroupID = bankAcGroupID;
        this.createDate = createDate;
        this.totalDiposit = totalDiposit;
        this.totalWithdraw = totalWithdraw;
        this.blance = blance;
    }
    
   

    /**
     * @return the bankAcID
     */
    public int getBankAcID() {
        return bankAcID;
    }

    /**
     * @param bankAcID the bankAcID to set
     */
    public void setBankAcID(int bankAcID) {
        this.bankAcID = bankAcID;
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
     * @return the remarkSymbol
     */
    public String getRemarkSymbol() {
        return remarkSymbol;
    }

    /**
     * @param remarkSymbol the remarkSymbol to set
     */
    public void setRemarkSymbol(String remarkSymbol) {
        this.remarkSymbol = remarkSymbol;
    }

    /**
     * @return the acName
     */
    public String getAcName() {
        return acName;
    }

    /**
     * @param acName the acName to set
     */
    public void setAcName(String acName) {
        this.acName = acName;
    }

    /**
     * @return the acNumber
     */
    public String getAcNumber() {
        return acNumber;
    }

    /**
     * @param acNumber the acNumber to set
     */
    public void setAcNumber(String acNumber) {
        this.acNumber = acNumber;
    }

    /**
     * @return the acType
     */
    public String getAcType() {
        return acType;
    }

    /**
     * @param acType the acType to set
     */
    public void setAcType(String acType) {
        this.acType = acType;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the startingBalance
     */
    public double getStartingBalance() {
        return startingBalance;
    }

    /**
     * @param startingBalance the startingBalance to set
     */
    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
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
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the bankAcGroupID
     */
    public int getBankAcGroupID() {
        return bankAcGroupID;
    }

    /**
     * @param bankAcGroupID the bankAcGroupID to set
     */
    public void setBankAcGroupID(int bankAcGroupID) {
        this.bankAcGroupID = bankAcGroupID;
    }

    /**
     * @return the totalDiposit
     */
    public double getTotalDiposit() {
        return totalDiposit;
    }

    /**
     * @param totalDiposit the totalDiposit to set
     */
    public void setTotalDiposit(double totalDiposit) {
        this.totalDiposit = totalDiposit;
    }

    /**
     * @return the totalWithdraw
     */
    public double getTotalWithdraw() {
        return totalWithdraw;
    }

    /**
     * @param totalWithdraw the totalWithdraw to set
     */
    public void setTotalWithdraw(double totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }

    /**
     * @return the blance
     */
    public double getBlance() {
        return blance;
    }

    /**
     * @param blance the blance to set
     */
    public void setBlance(double blance) {
        this.blance = blance;
    }
    
    
    
}
