/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam.Report.BasicView;

import com.pencil.Presentation.Presentation;
import com.pencil.SubjectConfigure.SubjectConfig;
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

public class BasicReportController implements Serializable {

    private BasicReport basicReport;
    private List<BasicReport> classDetList;
    BasicReportService dao = new BasicReportServiceImlp();

    Presentation pr = new Presentation();

    private SubjectConfig sbjConfig;

    private int scCnfID;

    private int exCnfID;

    private List<String> examList;

    private List<String> subjectList;

    private List<BasicReport> subject_report_List;

    private List<BasicReport> details_List;

    private List<BasicReport> exam_passfail_List;

    private List<BasicReport> grading__List;

    public BasicReportController() {

        this.examList = pr.infoList("exmNm");

        this.classDetList = dao.yearClassDepartShiftSection();
    }

    public void Sc_Cnf_ID(BasicReport sq) {

        this.scCnfID = dao.getScCnfID(sq);

        this.exCnfID = dao.getExCnfID(sq);
        
        this.subjectList = dao.subjectName(sq);
    }


    public void subjectList(BasicReport sq) {
        this.subjectList = dao.subjectName(sq);

    }

    public void details_report_List() {

        this.details_List = dao.DetailsMarkReport(this.exCnfID, this.scCnfID, this.basicReport.getSubjectName());
    }

    public void subject_report_List() {

        this.subject_report_List = dao.subjectMarkReport(this.exCnfID, this.scCnfID, this.basicReport.getSubjectName());
    }

    public void pass_fail_report_List(BasicReport sq) {
        
        this.scCnfID = dao.getScCnfID(sq);
        
        this.exCnfID = dao.getExCnfID(sq);
        
        this.exam_passfail_List = dao.ExamPassFailReport(this.exCnfID, this.scCnfID);

    }

    public void grading_List(BasicReport sq) {
        
        this.scCnfID = dao.getScCnfID(sq);
        
        this.exCnfID = dao.getExCnfID(sq);
        
        this.grading__List = dao.GradingReport(this.exCnfID, this.scCnfID);
    }

    public BasicReport getBasicReport() {
        if (this.basicReport == null) {
            this.basicReport = new BasicReport();
        }
        return basicReport;
    }

    public void setBasicReport(BasicReport basicReport) {
        this.basicReport = basicReport;
    }

    public List<BasicReport> getClassDetList() {
        return classDetList;
    }

    public void setClassDetList(List<BasicReport> classDetList) {
        this.classDetList = classDetList;
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

    public List<String> getExamList() {
        return examList;
    }

    public void setExamList(List<String> examList) {
        this.examList = examList;
    }

    public List<String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }

    public SubjectConfig getSbjConfig() {
        if (this.sbjConfig == null) {
            this.sbjConfig = new SubjectConfig();
        }
        return this.sbjConfig;
    }

    public void setSbjConfig(SubjectConfig sbjConfig) {
        this.sbjConfig = sbjConfig;
    }

    public List<BasicReport> getSubject_report_List() {
        return subject_report_List;
    }

    public void setSubject_report_List(List<BasicReport> subject_report_List) {
        this.subject_report_List = subject_report_List;
    }

    public List<BasicReport> getDetails_List() {
        return details_List;
    }

    public void setDetails_List(List<BasicReport> Details_List) {
        this.details_List = Details_List;
    }

    public List<BasicReport> getExam_passfail_List() {
        return exam_passfail_List;
    }

    public void setExam_passfail_List(List<BasicReport> exam_passfail_List) {
        this.exam_passfail_List = exam_passfail_List;
    }

    public List<BasicReport> getGrading__List() {
        return grading__List;
    }

    public void setGrading__List(List<BasicReport> grading__List) {
        this.grading__List = grading__List;
    }

}
