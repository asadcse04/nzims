/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.FeeConfig;

import com.pencil.Accounts.SubFeeHead.SubFeeHead;
import java.io.Serializable;

/**
 *
 * @author jahangiralamdiu
 */
public class SubFeeHeadDetail extends SubFeeHead implements Serializable {
    
    private double acceptence;
    
    private double amount;

    public SubFeeHeadDetail() 
    {
    }

    public SubFeeHeadDetail(int subFeeHeadID, String subFeeHeadName, String note) 
    {
        super(subFeeHeadID, subFeeHeadName, note);
    }

    public double getAcceptence() {
        return acceptence;
    }

    public void setAcceptence(double acceptence) {
        this.acceptence = acceptence;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
        
       
    
    
}
