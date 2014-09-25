/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Inventory.InventoryStockIn;

/**
 *
 * @author SHOHUG-SQ
 */
public class InventoryPayment {
    private String stockType;
    
    private String stockNote;
    
    private String paymentType;
    
    private String donnerName;
    
    private String bankName;
    
    private String voucherNo;
    
    private String note;

    public InventoryPayment() {
    }

    public InventoryPayment(String stockType, String stockNote, String paymentType, String donnerName, String bankName, String voucherNo, String note) {
        this.stockType = stockType;
        this.stockNote = stockNote;
        this.paymentType = paymentType;
        this.donnerName = donnerName;
        this.bankName = bankName;
        this.voucherNo = voucherNo;
        this.note = note;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getStockNote() {
        return stockNote;
    }

    public void setStockNote(String stockNote) {
        this.stockNote = stockNote;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDonnerName() {
        return donnerName;
    }

    public void setDonnerName(String donnerName) {
        this.donnerName = donnerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
