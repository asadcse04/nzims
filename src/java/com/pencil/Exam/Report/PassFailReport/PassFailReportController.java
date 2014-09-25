/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.PassFailReport;

import com.pencil.Presentation.Presentation;
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
public class PassFailReportController {
    
    private PassFailReport passFailReport;
    
    private List<String> academicYearList;
    
    private List<String> examNameList;
    
    private List<PassFailReport> passfailList;
    
    private List<PassFailReport> finalpassfailList;
    
    private PieChartModel pieModel;
    
    

   
    public PassFailReportService servicedao=new PassFailReportServiceImpl();
    
    Presentation pr = new Presentation();

    private int totalstudent=0;
    private int totalpass=0;
    private double passpercentage=0;
    private int totalfail=0;
    private double failpercentage=0;

    
    
    
    public PassFailReportController() {
        
    this.academicYearList = pr.infoList("acyr"); 
    
    this.examNameList=servicedao.ExamNameList();
        

    }
    
    
    public void showPassFail(){
        
        this.passfailList=new ArrayList<PassFailReport>();
         
         this.passfailList.clear();
         
         this.passfailList=servicedao.totalPassFail(passFailReport);
         
         this.totalpass=passfailList.get(0).getTotalpass();
         
         this.totalfail=passfailList.get(0).getTotalfail();
         
         this.totalstudent=totalpass+totalfail;
         
         
         try{
           
             this.passpercentage=(totalpass*100)/totalstudent;
             this.failpercentage=(totalfail*100)/totalstudent;
  
         }
         catch(Exception ep){
            
            this.passpercentage=0;
            this.failpercentage=0;
         }
         
          
         try{
             this.failpercentage=(totalfail*100)/totalstudent;
         }
         catch(Exception ef){
            this.failpercentage=0;
         }
         
         this.finalpassfailList=new ArrayList<PassFailReport>();
         
         this.finalpassfailList.clear();
         
         this.finalpassfailList.add(new PassFailReport(totalstudent,totalfail,failpercentage,totalpass,passpercentage));
         
         

    }


    public PassFailReport getPassFailReport() {
        
        if(this.passFailReport==null){
            this.passFailReport=new PassFailReport();
        }
        return passFailReport;
    }

    public void setPassFailReport(PassFailReport passFailReport) {
        this.passFailReport = passFailReport;
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

    public int getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(int totalstudent) {
        this.totalstudent = totalstudent;
    }

    public int getTotalpass() {
        return totalpass;
    }

    public void setTotalpass(int totalpass) {
        this.totalpass = totalpass;
    }

    public double getPasspercentage() {
        return passpercentage;
    }

    public void setPasspercentage(double passpercentage) {
        this.passpercentage = passpercentage;
    }

    public int getTotalfail() {
        return totalfail;
    }

    public void setTotalfail(int totalfail) {
        this.totalfail = totalfail;
    }

    public double getFailpercentage() {
        return failpercentage;
    }

    public void setFailpercentage(double failpercentage) {
        this.failpercentage = failpercentage;
    }
    
    

     public List<PassFailReport> getPassfailList() {
                          
        return passfailList;
    }

    public void setPassfailList(List<PassFailReport> passfailList) {
        this.passfailList = passfailList;
    }

    public List<PassFailReport> getFinalpassfailList() {
        return finalpassfailList;
    }

    public void setFinalpassfailList(List<PassFailReport> finalpassfailList) {
        this.finalpassfailList = finalpassfailList;
    }
    
    
    

    public PieChartModel getPieModel() {
        
        
         this.pieModel=new PieChartModel();
         
         this.pieModel.clear();
         
         this.pieModel.set("Pass",totalpass);
         
         this.pieModel.set("Fail", totalfail);
  
         return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
    
    
    
}
