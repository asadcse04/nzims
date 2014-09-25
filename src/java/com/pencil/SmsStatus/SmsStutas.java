/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.SmsStatus;

import java.io.Serializable;

/**
 *
 * @author SHOHUG.SQ
 */
public class SmsStutas implements Serializable{
    
    private int smsRemain;
    
    private String expireDate;
    
    private int status;
    
    private String statusType;

    public SmsStutas() {
    }
        
    public SmsStutas(int smsRemain, String expireDate, int status) {
        this.smsRemain = smsRemain;
        this.expireDate = expireDate;
        this.status = status;
    }

    public int getSmsRemain() {
        return smsRemain;
    }

    public void setSmsRemain(int smsRemain) {
        this.smsRemain = smsRemain;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusType() {
        if(this.status==0){
            this.statusType="Inactive";
        }else{
            this.statusType="Active";
        }
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }
    
    
    
    
}
