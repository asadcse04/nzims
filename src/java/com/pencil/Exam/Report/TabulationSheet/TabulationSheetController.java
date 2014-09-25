/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.TabulationSheet;


import com.pencil.Presentation.Presentation;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SHOHUG.SQ
 */
@ManagedBean
@ViewScoped

public class TabulationSheetController implements Serializable{

    private TabulationSheet tabulationSheet;
    
    private TabulationSheetSQ sq;

    private List<TabulationSheetSQ> tabulationList;

    private int acyr;

    private int scCnfID;

    private int exCnfID;
    
    private String sub;

    private String deptName;

    private String className;

    private String shiftName;

    private String sectionName;

    private String examName;

    private List<String> acyrList;

    private List<String> classList;

    private List<String> deptList;

    private List<String> shiftList;

    private List<String> sectionList;

    private List<String> examList;

    TabulationSheetService dao = new TabulationSheetServiceImpl();

    Presentation pr = new Presentation();

    public TabulationSheetController() {

        this.acyrList = pr.infoList("acyr");

        this.examList = pr.infoList("exmNm");

    }

    public void scClassList() {
        this.classList = dao.listScClass(this.getAcyr());
    }

    public void departmentList() {
        this.deptList = dao.listScDept(this.getAcyr(), this.getClassName());
    }

    public void shiftNameList() {

        this.shiftList = dao.listScShift(this.getAcyr(), this.getDeptName(), this.getClassName());

    }

    public void section_List() {
        this.sectionList = dao.listScSection(this.getAcyr(), this.getDeptName(), this.getClassName(), this.getShiftName());
    }

    public void Sc_Cnf_ID() {
        this.scCnfID = dao.getScCnfID(this.getAcyr(), this.getDeptName(), this.getClassName(), this.getShiftName(), this.getSectionName());
    }

    public void Ex_Cnf_ID() {
        this.setExCnfID(dao.getExCnfID(this.getAcyr(), this.getClassName(), this.getExamName()));
    }

    public void showAll() {
        this.tabulationList = dao.AllList(this);
        
           }
    
    public void showReport(){
//        ReportConnection r = new ReportConnection();
//        r.showReport(null, this);
//        
        System.out.println("");
        
    }

    public TabulationSheet getTabulationSheet() {
        if (this.tabulationSheet == null) {
            this.tabulationSheet = new TabulationSheet();
        }
        return tabulationSheet;
    }

    public void setTabulationSheet(TabulationSheet tabulationSheet) {
        this.tabulationSheet = tabulationSheet;
    }

    public List<TabulationSheetSQ> getTabulationList() {
        return tabulationList;
    }

    public void setTabulationList(List<TabulationSheetSQ> tabulationList) {
        this.tabulationList = tabulationList;
    }

    public int getAcyr() {
        return acyr;
    }

    public void setAcyr(int acyr) {
        this.acyr = acyr;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<String> getAcyrList() {
        return acyrList;
    }

    public void setAcyrList(List<String> acyrList) {
        this.acyrList = acyrList;
    }

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    public List<String> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<String> deptList) {
        this.deptList = deptList;
    }

    public List<String> getShiftList() {
        return shiftList;
    }

    public void setShiftList(List<String> shiftList) {
        this.shiftList = shiftList;
    }

    public List<String> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<String> sectionList) {
        this.sectionList = sectionList;
    }

    public List<String> getExamList() {
        return examList;
    }

    public void setExamList(List<String> examList) {
        this.examList = examList;
    }

    public int getScCnfID() {
        return scCnfID;
    }

    public void setScCnfID(int scCnfID) {
        this.scCnfID = scCnfID;
    }

    public int getExCnfID() {
        
        return exCnfID;
    }

    public void setExCnfID(int exCnfID) {
        this.exCnfID = exCnfID;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public TabulationSheetSQ getSq() {
        if(this.sq==null){
            this.sq= new TabulationSheetSQ();
        }
        return sq;
    }

    public void setSq(TabulationSheetSQ sq) {
        this.sq = sq;
    }

}
