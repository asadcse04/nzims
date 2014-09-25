/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.DefaultMark;

import java.io.Serializable;


/**
 *
 * @author apple
 */

public class DefaultMarkDivision implements Serializable
{ 
    private int dmdId;
  
    private String shortCode;
   
    private String title;
    
    private int totalMark;
    
    private double acceptance;
    
    private double passMark;

    public DefaultMarkDivision() 
    {
        
    }

    public DefaultMarkDivision(int dmdId, String shortCode, String title, int totalMark, double acceptance, double passMark) {
        this.dmdId = dmdId;
        this.shortCode = shortCode;
        this.title = title;
        this.totalMark = totalMark;
        this.acceptance = acceptance;
        this.passMark = passMark;
    }

    public int getDmdId() {
        return dmdId;
    }

    public void setDmdId(int dmdId) {
        this.dmdId = dmdId;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public double getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(double acceptance) {
        this.acceptance = acceptance;
    }

    public double getPassMark() {
        return passMark;
    }

    public void setPassMark(double passMark) {
        this.passMark = passMark;
    }

   
}
