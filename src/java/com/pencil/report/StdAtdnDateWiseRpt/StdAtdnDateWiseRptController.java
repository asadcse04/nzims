/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.report.StdAtdnDateWiseRpt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class StdAtdnDateWiseRptController implements Serializable {

    private StdAtdnDateWiseRpt stdAtdnDateWiseRpt;

    private List<StdAtdnDateWiseRpt> stdAttendeceList;



    public StdAtdnDateWiseRptService servicedao = new StdAtdnDateWiseRptServiceImpl();

    public void showAttendence() {

        this.stdAttendeceList = new ArrayList<StdAtdnDateWiseRpt>();
        this.stdAttendeceList.clear();
        this.stdAttendeceList = servicedao.attendenceReport(stdAtdnDateWiseRpt);
    }

    public StdAtdnDateWiseRpt getStdAtdnDateWiseRpt() {

        if (this.stdAtdnDateWiseRpt == null) {

            this.stdAtdnDateWiseRpt = new StdAtdnDateWiseRpt();
        }
        return stdAtdnDateWiseRpt;
    }

    public void setStdAtdnDateWiseRpt(StdAtdnDateWiseRpt stdAtdnDateWiseRpt) {
        this.stdAtdnDateWiseRpt = stdAtdnDateWiseRpt;
    }

    public List<StdAtdnDateWiseRpt> getStdAttendeceList() {
        return stdAttendeceList;
    }

    public void setStdAttendeceList(List<StdAtdnDateWiseRpt> stdAttendeceList) {
        this.stdAttendeceList = stdAttendeceList;
    }



    public StdAtdnDateWiseRptService getServicedao() {
        return servicedao;
    }

    public void setServicedao(StdAtdnDateWiseRptService servicedao) {
        this.servicedao = servicedao;
    }

    
    
    
}
