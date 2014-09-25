/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ExamWiseReport;

import com.pencil.Dummy.Student.ExamResult.ExamResult;
import com.pencil.Dummy.Student.ExamResult.ResultServiceImpl;
import com.pencil.Dummy.Student.ExamResult.StudentExamResultService;
import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;

import com.pencil.SubjectConfigure.SubjectConfig;
import com.pencil.SubjectConfigure.SubjectConfigService;
import com.pencil.SubjectConfigure.SubjectConfigService_Impl;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author salim
 */
@ManagedBean
@ViewScoped
public class ExamReportController implements Serializable {

    private int scCnfID;

    private int exCnfID;


    private ExamResult examResultOpt;

    private SubjectConfig sbjConfig;

    private List<String> acyrList;

    private List<String> classList;

    private List<String> deptList;

    private List<String> shiftList;

    private List<String> sectionList;

    private List<String> examList;


    Sc_ClassConfigService sc_service_dao = new Sc_ClassCofigService_Impl();

    SubjectConfigService sbjserviceDao = new SubjectConfigService_Impl();

    StudentExamResultService resultService = new ResultServiceImpl();

    Presentation pr = new Presentation();
    
    
    
    ExamReportService examReportService = new ExamReportServiceImpl();
    
    private List<ExamReport> exam_pass_fail_report_List;
    
    private List<ExamReport> grading_report_List;
    
    private List<ExamReport> sectionMerit_position_List;


    public ExamReportController() 
    {
        this.acyrList = pr.infoList("acyr");

        this.examList = pr.infoList("exmNm");
        
    }

    public void scClassList() {
        this.classList = sc_service_dao.listScClass(this.examResultOpt.getAcyr());
    }

    public void departmentList() {
        this.deptList = sc_service_dao.listScDept(this.examResultOpt.getAcyr(), this.examResultOpt.getClassName());
    }

    public void shiftNameList()
    {
        this.getSbjConfig().setAcyrID(this.examResultOpt.getAcyr());

        this.getSbjConfig().setSchoolClassName(this.examResultOpt.getClassName());

        this.getSbjConfig().setDeptName(this.examResultOpt.getDeptName());

        this.shiftList = sc_service_dao.listScShift(this.examResultOpt.getAcyr(), this.examResultOpt.getDeptName(), this.examResultOpt.getClassName());

    }

    public void section_List() {
        this.sectionList = sc_service_dao.listScSection(this.examResultOpt.getAcyr(), this.examResultOpt.getDeptName(), this.examResultOpt.getClassName(), this.examResultOpt.getShiftName());
    }

    public void Sc_Cnf_ID() {
        this.scCnfID = sc_service_dao.getScCnfID(this.examResultOpt.getAcyr(), this.examResultOpt.getDeptName(), this.examResultOpt.getClassName(), this.examResultOpt.getShiftName(), this.examResultOpt.getSectionName());
    }

    public void Ex_Cnf_ID() {
        this.setExCnfID(resultService.getExCnfID(this.examResultOpt.getAcyr(), this.examResultOpt.getClassName(), this.examResultOpt.getExamName()));
    }
    
    
   //--------------Subject Wise pass-fail----------------
    public void exam_pass_fail_report_List()
    {
        this.exam_pass_fail_report_List=examReportService.ExamPassFailReport(this.exCnfID,this.scCnfID);
        
    }
    
   //---------------Subject Wise grading-----------------
    public void grading_report_List()
    {
        this.grading_report_List=examReportService.GradingReport(this.exCnfID,this.scCnfID);
    }
    
    //------------section Wise merit List----------------
    public void sectionMerit_Position_List()
    {
        this.sectionMerit_position_List=examReportService.SectionWise_meritList(this.exCnfID,this.scCnfID);
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

    public SubjectConfig getSbjConfig() {
        if (this.sbjConfig == null) {
            this.sbjConfig = new SubjectConfig();
        }
        return this.sbjConfig;
    }

    public void setSbjConfig(SubjectConfig sbjConfig) {
        this.sbjConfig = sbjConfig;
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



    public ExamResult getExamResultOpt() {
        if (this.examResultOpt == null) {
            this.examResultOpt = new ExamResult();
        }
        return this.examResultOpt;
    }

    public void setExamResultOpt(ExamResult examResultOpt) {
        this.examResultOpt = examResultOpt;
    }

    public List<ExamReport> getExam_pass_fail_report_List() {
        return exam_pass_fail_report_List;
    }

    public void setExam_pass_fail_report_List(List<ExamReport> exam_pass_fail_report_List) {
        this.exam_pass_fail_report_List = exam_pass_fail_report_List;
    }

    public List<ExamReport> getGrading_report_List() {
        return grading_report_List;
    }

    public void setGrading_report_List(List<ExamReport> grading_report_List) {
        this.grading_report_List = grading_report_List;
    }

    public List<ExamReport> getSectionMerit_position_List() {
        return sectionMerit_position_List;
    }

    public void setSectionMerit_position_List(List<ExamReport> sectionMerit_position_List) {
        this.sectionMerit_position_List = sectionMerit_position_List;
    }


    
}
