/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Exam.Report.InstituteGrade;

import com.pencil.Exam.Report.InstitutePassFail.InstituteReportService;
import com.pencil.Exam.Report.InstitutePassFail.InstituteReportServiceImpl;
import com.pencil.Presentation.Presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SHOHUG-SQ
 */
@ManagedBean
@ViewScoped
public class GradeReportController implements Serializable{
    
    private GradeReport gradeReport;
    
    private List<GradeReport> gradeReportList;
    
    GradeReportService dao = new GradeReportServiceImpl();
    
    InstituteReportService inDao= new InstituteReportServiceImpl();
    
    private List<String> academicYearList;

    private List<String> examNameList;
    
    Presentation pr = new Presentation();

    public GradeReportController() {
        this.academicYearList = pr.infoList("acyr");
        this.examNameList = inDao.ExamNameList();
    }
    
    
    public void showGradeView(){
        
        this.gradeReportList=new ArrayList<GradeReport>();
        this.gradeReportList.clear();
        this.gradeReportList=dao.gradeList(gradeReport);
        
    }

    public GradeReport getGradeReport() {
        if(this.gradeReport==null){
            this.gradeReport=new GradeReport();
        }
        return gradeReport;
    }

    public void setGradeReport(GradeReport gradeReport) {
        this.gradeReport = gradeReport;
    }

    public List<GradeReport> getGradeReportList() {
        return gradeReportList;
    }

    public void setGradeReportList(List<GradeReport> gradeReportList) {
        this.gradeReportList = gradeReportList;
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
    
    
    
}
