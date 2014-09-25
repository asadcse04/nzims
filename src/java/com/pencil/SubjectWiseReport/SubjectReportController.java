/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.SubjectWiseReport;

import com.pencil.Dummy.Student.ExamResult.ExamResult;
import com.pencil.Dummy.Student.ExamResult.ResultServiceImpl;
import com.pencil.Dummy.Student.ExamResult.StudentExamResultService;
import com.pencil.Dummy.Teacher.Teacher;
import com.pencil.Dummy.Teacher.TeacherConverter;
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
public class SubjectReportController implements Serializable {

    private int scCnfID;

    private int exCnfID;
    
    private SubjectReport subjectReport;

    private ExamResult examResultOpt;

    private SubjectConfig sbjConfig;

    private List<String> acyrList;

    private List<String> classList;

    private List<String> deptList;

    private List<String> shiftList;

    private List<String> sectionList;

    private List<String> examList;

    private List<String> subjectList;

    Sc_ClassConfigService sc_service_dao = new Sc_ClassCofigService_Impl();

    SubjectConfigService sbjserviceDao = new SubjectConfigService_Impl();

    StudentExamResultService resultService = new ResultServiceImpl();
    
    SubjectReportService subjReportService = new SubjectReportServiceImpl();

    private Teacher selectedTeacher;

    private List<Teacher> teachers;

    TeacherConverter tc = new TeacherConverter();

    Presentation pr = new Presentation();
    
    private List<SubjectReport> subject_report_List;
    
    private List<SubjectReport> Details_report_List;

    public SubjectReportController() 
    {
        this.acyrList = pr.infoList("acyr");

        this.examList = pr.infoList("exmNm");

        this.teachers = tc.getTeacherList();
        
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

        this.subjectList = sbjserviceDao.bookList(this.getSbjConfig());
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

    public void subject_report_List()
    {
        this.subject_report_List=subjReportService.subjectMarkReport(this.exCnfID,this.scCnfID,this.examResultOpt.getSubjectName());
    }
     
    public void details_report_List()
    {
       
        this.Details_report_List=subjReportService.DetailsMarkReport(this.exCnfID,this.scCnfID,this.examResultOpt.getSubjectName());
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

    public List<String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Teacher getSelectedTeacher() {
        if (this.selectedTeacher == null) {
            this.selectedTeacher = new Teacher();
        }
        return selectedTeacher;
    }

    public void setSelectedTeacher(Teacher selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    public TeacherConverter getTc() {
        return tc;
    }

    public void setTc(TeacherConverter tc) {
        this.tc = tc;
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

    public SubjectReport getSubjectReport()
    {  
         if (this.subjectReport == null) {
            this.subjectReport = new SubjectReport();
        }
        return this.subjectReport;
    }

    public void setSubjectReport(SubjectReport subjectReport) {
        this.subjectReport = subjectReport;
    }

    public List<SubjectReport> getSubject_report_List() {
        return subject_report_List;
    }

    public void setSubject_report_List(List<SubjectReport> subject_report_List) {
        this.subject_report_List = subject_report_List;
    }

    public List<SubjectReport> getDetails_report_List() {
        return Details_report_List;
    }

    public void setDetails_report_List(List<SubjectReport> Details_report_List) {
        this.Details_report_List = Details_report_List;
    }
    
    
    

}
