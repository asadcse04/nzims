/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.InstitutePassFail;

import com.pencil.Presentation.Presentation;
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

public class InstituteReportController {

    private InstituteReport instituteWiseReport;

    private List<InstituteReport> studentList;

    private List<String> academicYearList;

    private List<String> examNameList;

    InstituteReportService dao = new InstituteReportServiceImpl();

    Presentation pr = new Presentation();

    public InstituteReportController() {

        this.academicYearList = pr.infoList("acyr");

        this.examNameList = dao.ExamNameList();
    }

    public void tableData() {

        this.studentList = new ArrayList<InstituteReport>();
        this.studentList.clear();
        this.studentList = dao.totalPassFail(instituteWiseReport);
    }

    public InstituteReport getInstituteWiseReport() {
        if (this.instituteWiseReport == null) {
            this.instituteWiseReport = new InstituteReport();
        }
        return instituteWiseReport;
    }

    public void setInstituteWiseReport(InstituteReport instituteWiseReport) {
        this.instituteWiseReport = instituteWiseReport;
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
    
    public List<InstituteReport> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<InstituteReport> studentList) {
        this.studentList = studentList;
    }

}
