/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Student.information.StResultInfo;

import com.pencil.Presentation.Presentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SHOHUG.SQ
 */
@ManagedBean
@ViewScoped

public class StResultInfoController implements Serializable {

    private StResultInfo stResultInfo;

    private List<StResultInfo> stResultList;

    private List<StResultInfo> resultSummary;

    private String acYr;

    private String examName;

    private List<String> acyrList;

    private List<String> examList;

    Presentation pr = new Presentation();

    StResultInfoService dao = new StResultInfoServiceImpl();

    public StResultInfoController() {
        this.acyrList = pr.infoList("acyr");

        this.examList = pr.infoList("exmNm");

    }

    public void stResult() {
        this.stResultList = new ArrayList<StResultInfo>();
        this.stResultList.clear();
        this.stResultList = dao.resultList(this);

        this.resultSummary = new ArrayList<StResultInfo>();
        this.resultSummary.clear();
        this.resultSummary = dao.finalGrade(this);
    }

    public StResultInfo getStResultInfo() {
        if (this.stResultInfo == null) {
            this.stResultInfo = new StResultInfo();
        }
        return stResultInfo;
    }

    public void setStResultInfo(StResultInfo stResultInfo) {
        this.stResultInfo = stResultInfo;
    }

    public List<StResultInfo> getStResultList() {
        return stResultList;
    }

    public void setStResultList(List<StResultInfo> stResultList) {
        this.stResultList = stResultList;
    }

    public List<StResultInfo> getResultSummary() {
        return resultSummary;
    }

    public void setResultSummary(List<StResultInfo> resultSummary) {
        this.resultSummary = resultSummary;
    }

    public String getAcYr() {
        return acYr;
    }

    public void setAcYr(String acYr) {
        this.acYr = acYr;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public List<String> getAcyrList() {
        return acyrList;
    }

    public void setAcyrList(List<String> acyrList) {
        this.acyrList = acyrList;
    }

    public List<String> getExamList() {
        return examList;
    }

    public void setExamList(List<String> examList) {
        this.examList = examList;
    }

    public Presentation getPr() {
        return pr;
    }

    public void setPr(Presentation pr) {
        this.pr = pr;
    }

}
