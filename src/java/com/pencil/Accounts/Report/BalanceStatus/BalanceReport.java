/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Report.BalanceStatus;

import java.io.Serializable;

/**
 *
 * @author Riad
 */
public class BalanceReport implements Serializable{
    
    private double cashBalance;
    
    private double bankBalance;
    
    private double checkBalance;
    
    private double totalBalance;

    public BalanceReport() {
    }

    public BalanceReport(double cashBalance, double bankBalance, double checkBalance, double totalBalance) {
        this.cashBalance = cashBalance;
        this.bankBalance = bankBalance;
        this.checkBalance = checkBalance;
        this.totalBalance = totalBalance;
    }

    /**
     * @return the cashBalance
     */
    public double getCashBalance() {
        return cashBalance;
    }

    /**
     * @param cashBalance the cashBalance to set
     */
    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    /**
     * @return the bankBalance
     */
    public double getBankBalance() {
        return bankBalance;
    }

    /**
     * @param bankBalance the bankBalance to set
     */
    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    /**
     * @return the checkBalance
     */
    public double getCheckBalance() {
        return checkBalance;
    }

    /**
     * @param checkBalance the checkBalance to set
     */
    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    /**
     * @return the totalBalance
     */
    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     * @param totalBalance the totalBalance to set
     */
    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }
    
    
    
    
}
