/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.attendance.report.PresentReport;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Riad
 */
public class PresentReport implements Serializable {
    
   
    private int twototal;
    private int twopresent;
    private int threetotal;
    private int threepresent;
    private int fourtotal;
    private int fourpresent;
    private int fivetotal;
    private int fivepresent;
    private int sixtotal;
    private int sixpresent;
    private int saventotal;
    private int savenpresent;
    private int eighttotal;
    private int eightpresent;
    private int ninetotal;
    private int ninepresent;
    private int tentotal;
    private int tenpresent;
    
    
    private Date date;

    public PresentReport() {
    }

    public PresentReport(int twototal, int twopresent, int threetotal, int threepresent, int fourtotal, int fourpresent, int fivetotal, int fivepresent, int sixtotal, int sixpresent, int saventotal, int savenpresent, int eighttotal, int eightpresent, int ninetotal, int ninepresent, int tentotal, int tenpresent) {
        this.twototal = twototal;
        this.twopresent = twopresent;
        this.threetotal = threetotal;
        this.threepresent = threepresent;
        this.fourtotal = fourtotal;
        this.fourpresent = fourpresent;
        this.fivetotal = fivetotal;
        this.fivepresent = fivepresent;
        this.sixtotal = sixtotal;
        this.sixpresent = sixpresent;
        this.saventotal = saventotal;
        this.savenpresent = savenpresent;
        this.eighttotal = eighttotal;
        this.eightpresent = eightpresent;
        this.ninetotal = ninetotal;
        this.ninepresent = ninepresent;
        this.tentotal = tentotal;
        this.tenpresent = tenpresent;
    }

    public int getTwototal() {
        return twototal;
    }

    public void setTwototal(int twototal) {
        this.twototal = twototal;
    }

    public int getTwopresent() {
        return twopresent;
    }

    public void setTwopresent(int twopresent) {
        this.twopresent = twopresent;
    }

    public int getThreetotal() {
        return threetotal;
    }

    public void setThreetotal(int threetotal) {
        this.threetotal = threetotal;
    }

    public int getThreepresent() {
        return threepresent;
    }

    public void setThreepresent(int threepresent) {
        this.threepresent = threepresent;
    }

    public int getFourtotal() {
        return fourtotal;
    }

    public void setFourtotal(int fourtotal) {
        this.fourtotal = fourtotal;
    }

    public int getFourpresent() {
        return fourpresent;
    }

    public void setFourpresent(int fourpresent) {
        this.fourpresent = fourpresent;
    }

    public int getFivetotal() {
        return fivetotal;
    }

    public void setFivetotal(int fivetotal) {
        this.fivetotal = fivetotal;
    }

    public int getFivepresent() {
        return fivepresent;
    }

    public void setFivepresent(int fivepresent) {
        this.fivepresent = fivepresent;
    }

    public int getSixtotal() {
        return sixtotal;
    }

    public void setSixtotal(int sixtotal) {
        this.sixtotal = sixtotal;
    }

    public int getSixpresent() {
        return sixpresent;
    }

    public void setSixpresent(int sixpresent) {
        this.sixpresent = sixpresent;
    }

    public int getSaventotal() {
        return saventotal;
    }

    public void setSaventotal(int saventotal) {
        this.saventotal = saventotal;
    }

    public int getSavenpresent() {
        return savenpresent;
    }

    public void setSavenpresent(int savenpresent) {
        this.savenpresent = savenpresent;
    }

    public int getEighttotal() {
        return eighttotal;
    }

    public void setEighttotal(int eighttotal) {
        this.eighttotal = eighttotal;
    }

    public int getEightpresent() {
        return eightpresent;
    }

    public void setEightpresent(int eightpresent) {
        this.eightpresent = eightpresent;
    }

    public int getNinetotal() {
        return ninetotal;
    }

    public void setNinetotal(int ninetotal) {
        this.ninetotal = ninetotal;
    }

    public int getNinepresent() {
        return ninepresent;
    }

    public void setNinepresent(int ninepresent) {
        this.ninepresent = ninepresent;
    }

    public int getTentotal() {
        return tentotal;
    }

    public void setTentotal(int tentotal) {
        this.tentotal = tentotal;
    }

    public int getTenpresent() {
        return tenpresent;
    }

    public void setTenpresent(int tenpresent) {
        this.tenpresent = tenpresent;
    }

    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    
    
   
    
}
