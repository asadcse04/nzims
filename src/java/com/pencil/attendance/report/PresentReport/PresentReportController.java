/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.attendance.report.PresentReport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class PresentReportController implements Serializable {

    private PresentReport presentReport;

    private PieChartModel pieModel;

    private List<PresentReport> presentList;

    public PresentReportService serviceDao = new PresentReportServiceImpl();

    private float twopercentage = 0;
    private float threepercentage = 0;
    private float fourpercentage = 0;
    private float fivepercentage = 0;
    private float sixpercentage = 0;
    private float savenpercentage = 0;
    private float eightpercentage = 0;
    private float ninepercentage = 0;
    private float tenpercentage = 0;

    public void showPresent() {
        this.presentList = new ArrayList<PresentReport>();
        this.presentList.clear();
        this.presentList = serviceDao.searchPresent(presentReport);

        try {
            this.twopercentage = (float) (presentList.get(0).getTwopresent() * 100) / presentList.get(0).getTwototal();
        } catch (ArithmeticException e) {
            this.twopercentage = 0;
        }

        try {
            this.threepercentage = (float) (presentList.get(0).getThreepresent() * 100) / presentList.get(0).getThreetotal();
        } catch (ArithmeticException e) {
            this.threepercentage = 0;
        }

        try {
            this.fourpercentage = (float) (presentList.get(0).getFourpresent() * 100) / presentList.get(0).getFourtotal();
        } catch (ArithmeticException e) {
            this.fourpercentage = 0;
        }

        try {
            this.fivepercentage = (float) (presentList.get(0).getFivepresent() * 100) / presentList.get(0).getFivetotal();
        } catch (ArithmeticException e) {
            this.fivepercentage = 0;
        }

        try {
            this.sixpercentage = (float) (presentList.get(0).getSixpresent() * 100) / presentList.get(0).getSixtotal();
        } catch (ArithmeticException e) {
            this.sixpercentage = 0;
        }

        try {
            this.savenpercentage = (float) (presentList.get(0).getSavenpresent() * 100) / presentList.get(0).getSaventotal();
        } catch (ArithmeticException e) {
            this.savenpercentage = 0;
        }

        try {
            this.eightpercentage = (float) (presentList.get(0).getEightpresent() * 100) / presentList.get(0).getEighttotal();
        } catch (ArithmeticException e) {
            this.eightpercentage = 0;
        }

        try {
            this.ninepercentage = (float) (presentList.get(0).getNinepresent() * 100) / presentList.get(0).getNinetotal();
        } catch (ArithmeticException e) {
            this.ninepercentage = 0;
        }

        try {
            this.tenpercentage = (float) (presentList.get(0).getTenpresent() * 100) / presentList.get(0).getTentotal();
        } catch (ArithmeticException e) {
            this.tenpercentage = 0;
        }

     
    }

    public PresentReport getPresentReport() {

        if (this.presentReport == null) {
            this.presentReport = new PresentReport();
        }

        return presentReport;
    }

    public void setPresentReport(PresentReport presentReport) {
        this.presentReport = presentReport;
    }

    public PieChartModel getPieModel() {

        this.pieModel=new PieChartModel();
        
        this.pieModel.clear();
        
        this.pieModel.set("Two", twopercentage);
        this.pieModel.set("Three", threepercentage);
        this.pieModel.set("Four", fourpercentage);
        this.pieModel.set("Five", fivepercentage);
        this.pieModel.set("Six", sixpercentage);
        this.pieModel.set("Saven", savenpercentage);
        this.pieModel.set("Eight", eightpercentage);
        this.pieModel.set("Nine", ninepercentage);
        this.pieModel.set("Ten", tenpercentage);


        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }


    public float getTwopercentage() {
        return twopercentage;
    }

    public void setTwopercentage(float twopercentage) {
        this.twopercentage = twopercentage;
    }

    public float getThreepercentage() {
        return threepercentage;
    }

    public void setThreepercentage(float threepercentage) {
        this.threepercentage = threepercentage;
    }

    public float getFourpercentage() {
        return fourpercentage;
    }

    public void setFourpercentage(float fourpercentage) {
        this.fourpercentage = fourpercentage;
    }

    public float getFivepercentage() {
        return fivepercentage;
    }

    public void setFivepercentage(float fivepercentage) {
        this.fivepercentage = fivepercentage;
    }

    public float getSixpercentage() {
        return sixpercentage;
    }

    public void setSixpercentage(float sixpercentage) {
        this.sixpercentage = sixpercentage;
    }

    public float getSavenpercentage() {
        return savenpercentage;
    }

    public void setSavenpercentage(float savenpercentage) {
        this.savenpercentage = savenpercentage;
    }

    public float getEightpercentage() {
        return eightpercentage;
    }

    public void setEightpercentage(float eightpercentage) {
        this.eightpercentage = eightpercentage;
    }

    public float getNinepercentage() {
        return ninepercentage;
    }

    public void setNinepercentage(float ninepercentage) {
        this.ninepercentage = ninepercentage;
    }

    public float getTenpercentage() {
        return tenpercentage;
    }

    public void setTenpercentage(float tenpercentage) {
        this.tenpercentage = tenpercentage;
    }

    public List<PresentReport> getPresentList() {
        return presentList;
    }

    public void setPresentList(List<PresentReport> presentList) {
        this.presentList = presentList;
    }

}
