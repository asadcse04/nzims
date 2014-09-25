/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.GradeWiseReport;

import com.pencil.Presentation.Presentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Riad
 */

@ManagedBean
@ViewScoped
public class GradeWiseReportController implements Serializable{
    
    private GradeWiseReport gradeWiseReport;
    
    private List<String> academicYearList;
    
    private List<String> examNameList;
    
    private List<GradeWiseReport> gradeWiselist;
    
    private PieChartModel pieModel;
    
    Presentation pr = new Presentation();
    
    public GradeWiseReportService servicedao=new GradeWiseReportServiceImpl();

   
    private int totalstudent=0;
    private int aPlus=0;
    private int a=0;
    private int aMinus=0;
    private int b=0;
    private int c=0;
    private int d=0;
    private int f=0;

    
    
    public GradeWiseReportController() {
    
    this.academicYearList = pr.infoList("acyr");
    
    this.examNameList=servicedao.ExamNameList();

    }
    
    
    
    public void showGradeWiseReport(){
 
        this.gradeWiselist=new ArrayList<GradeWiseReport>();
        
        this.gradeWiselist.clear();
        
        this.gradeWiselist=servicedao.totalGradeList(gradeWiseReport);
        
        
       this.totalstudent=gradeWiselist.get(0).getTotalstudent();
       this.aPlus=gradeWiselist.get(0).getaPlus();
       this.a=gradeWiselist.get(0).getA();
       this.aMinus=gradeWiselist.get(0).getaMinus();
       this.b=gradeWiselist.get(0).getB();
       this.c=gradeWiselist.get(0).getC();
       this.d=gradeWiselist.get(0).getD();
       this.f=gradeWiselist.get(0).getF();
       
    
    }

    
    public GradeWiseReport getGradeWiseReport() {
        
        if(this.gradeWiseReport==null){
            
            this.gradeWiseReport=new GradeWiseReport();
        }
        return gradeWiseReport;
    }

    public void setGradeWiseReport(GradeWiseReport gradeWiseReport) {
        this.gradeWiseReport = gradeWiseReport;
    }

    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }

    public List<String> getExamNameList() {
        
        
        return examNameList;
    }

    public void setExamNameList(List<String> examNameList) {
        this.examNameList = examNameList;
    }

    public List<GradeWiseReport> getGradeWiselist() {
        
        return gradeWiselist;
    }

    public void setGradeWiselist(List<GradeWiseReport> gradeWiselist) {
        this.gradeWiselist = gradeWiselist;
    }

    
    public PieChartModel getPieModel() {
        
        this.pieModel=new PieChartModel();
        
        this.pieModel.clear();
        
        this.pieModel.set("A+", aPlus);
        this.pieModel.set("A", a);
        this.pieModel.set("A-", aMinus);
        this.pieModel.set("B", b);
        this.pieModel.set("C", c);
        this.pieModel.set("D", d);
        this.pieModel.set("F", f);
        
        
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
    

    
    
    
    
    public int getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(int totalstudent) {
        this.totalstudent = totalstudent;
    }

    public int getaPlus() {
        return aPlus;
    }

    public void setaPlus(int aPlus) {
        this.aPlus = aPlus;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getaMinus() {
        return aMinus;
    }

    public void setaMinus(int aMinus) {
        this.aMinus = aMinus;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    
    
    
 
    
    
    
}
