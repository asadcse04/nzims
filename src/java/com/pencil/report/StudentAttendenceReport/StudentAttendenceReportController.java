/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.report.StudentAttendenceReport;

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
public class StudentAttendenceReportController implements Serializable {

    private StudentAttendenceReport studentAttendenceReport;

    public StudentAttendenceReportService servicedao = new StudentAttendenceReportServiceImpl();

    private List<StudentAttendenceReport> tottalPresentAbsent;

    private List<StudentAttendenceReport> tottalCompletePresentAbsent;
    
    private PieChartModel pieModel;
    

    private int totalstudent;
    private int totalpresent;
    private int totalabsent;

    private double presentprecentage = 0;
    private double absentpercentage = 0;

    public void showAttendence() {

        this.tottalPresentAbsent = new ArrayList<StudentAttendenceReport>();
        this.tottalPresentAbsent.clear();
        this.tottalCompletePresentAbsent = new ArrayList<StudentAttendenceReport>();
        this.tottalCompletePresentAbsent.clear();
        
        totalpresent=0;
        totalabsent=0;
        
        this.tottalPresentAbsent = servicedao.AttendenceList(studentAttendenceReport);

        if(!tottalPresentAbsent.isEmpty())
        {
            
            this.totalstudent = tottalPresentAbsent.get(0).getTotalstudent();
            this.totalpresent = tottalPresentAbsent.get(0).getPresent();
            this.totalabsent = tottalPresentAbsent.get(0).getAbcent();

            try {
                this.presentprecentage =(float)(totalpresent * 100) / totalstudent;
            } catch (Exception e) {
                this.presentprecentage = 0;
            }

            try {
                this.absentpercentage =(float)(totalabsent * 100) / totalstudent;
            } catch (Exception f) {
                this.absentpercentage = 0;
            }         
            this.tottalCompletePresentAbsent.add(new StudentAttendenceReport(totalstudent, totalpresent, presentprecentage, totalabsent, absentpercentage));
            
        }
        

    }

    public StudentAttendenceReport getStudentAttendenceReport() {

        if (this.studentAttendenceReport == null) {

            this.studentAttendenceReport = new StudentAttendenceReport();
        }
        return studentAttendenceReport;
    }

    public void setStudentAttendenceReport(StudentAttendenceReport studentAttendenceReport) {
        this.studentAttendenceReport = studentAttendenceReport;
    }

    public StudentAttendenceReportService getServicedao() {
        return servicedao;
    }

    public void setServicedao(StudentAttendenceReportService servicedao) {
        this.servicedao = servicedao;
    }

    public List<StudentAttendenceReport> getTottalPresentAbsent() {
        return tottalPresentAbsent;
    }

    public void setTottalPresentAbsent(List<StudentAttendenceReport> tottalPresentAbsent) {
        this.tottalPresentAbsent = tottalPresentAbsent;
    }

    public List<StudentAttendenceReport> getTottalCompletePresentAbsent() {
        return tottalCompletePresentAbsent;
    }

    public void setTottalCompletePresentAbsent(List<StudentAttendenceReport> tottalCompletePresentAbsent) {
        this.tottalCompletePresentAbsent = tottalCompletePresentAbsent;
    }

    public PieChartModel getPieModel() {
        
         this.pieModel=new PieChartModel();
        
         this.pieModel.clear();

         this.pieModel.set("Present",totalpresent);
         
         this.pieModel.set("Absent", totalabsent);
  
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

    public int getTotalpresent() {
        return totalpresent;
    }

    public void setTotalpresent(int totalpresent) {
        this.totalpresent = totalpresent;
    }

    public int getTotalabsent() {
        return totalabsent;
    }

    public void setTotalabsent(int totalabsent) {
        this.totalabsent = totalabsent;
    }

    public double getPresentprecentage() {
        return presentprecentage;
    }

    public void setPresentprecentage(double presentprecentage) {
        this.presentprecentage = presentprecentage;
    }

    public double getAbsentpercentage() {
        return absentpercentage;
    }

    public void setAbsentpercentage(double absentpercentage) {
        this.absentpercentage = absentpercentage;
    }

}
