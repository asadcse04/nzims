/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Student.AttendanceReport;

import com.pencil.Dummy.Student.ExamResult.ExamResult;
import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author salim
 */
@ManagedBean
@ViewScoped
public class AttendanceReportController {

    private int scCnfID;
    
    private String status;
    
    

    private Date currentDate;

    private Date specificDate;

    private ExamResult examResultOpt;

    private List<String> acyrList;

    private List<AttendanceReport> classList;

    private List<String> deptList;

    private List<String> shiftList;

    private List<String> sectionList;

    Presentation pr = new Presentation();

    private AttendanceReport attendanceReport;

    private List<AttendanceReport> specificDateSectionAtd_List;

    private List<AttendanceReport> sectionWise_PsnAbs_List;

    Sc_ClassConfigService sc_service_dao = new Sc_ClassCofigService_Impl();

    AttendanceReportService AtndReportDao = new AttendanceReportServiceImpl();

    public AttendanceReportController() {
        this.acyrList = pr.infoList("acyr");

        this.classList = AtndReportDao.classList();
    }

    public void sectionWisePsnAbs() {
        this.sectionWise_PsnAbs_List = AtndReportDao.sectionWisePsnAbs_List(this.currentDate);
    }

//    //.................get ScCnfID .................
//    
//     public void scClassList() {
//        this.classList = sc_service_dao.listScClass(this.examResultOpt.getAcyr());
//    }
//
//    public void departmentList() {
//        this.deptList = sc_service_dao.listScDept(this.examResultOpt.getAcyr(), this.examResultOpt.getClassName());
//    }
//
//    public void shiftNameList()
//    {
//        this.shiftList = sc_service_dao.listScShift(this.examResultOpt.getAcyr(), this.examResultOpt.getDeptName(), this.examResultOpt.getClassName());
//    }
//
//    public void section_List() {
//        this.sectionList = sc_service_dao.listScSection(this.examResultOpt.getAcyr(), this.examResultOpt.getDeptName(), this.examResultOpt.getClassName(), this.examResultOpt.getShiftName());
//    }
//
    public void Sc_Cnf_ID(AttendanceReport sq) {
        this.scCnfID = AtndReportDao.getScCnfID(sq);
    }

    public void getSpecificSectionAttendance() {

        this.specificDateSectionAtd_List = AtndReportDao.specificSectionAttendance_List(scCnfID, specificDate, status);
    }

    public AttendanceReport getAttendanceReport() {
        if (this.attendanceReport == null) {
            this.attendanceReport = new AttendanceReport();
        }
        return attendanceReport;
    }

    public ExamResult getExamResultOpt() {
        if (this.examResultOpt == null) {
            this.examResultOpt = new ExamResult();
        }
        return examResultOpt;
    }

    public void setAttendanceReport(AttendanceReport attendanceReport) {
        this.attendanceReport = attendanceReport;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public List<AttendanceReport> getSectionWise_PsnAbs_List() {
        return sectionWise_PsnAbs_List;
    }

    public void setSectionWise_PsnAbs_List(List<AttendanceReport> sectionWise_PsnAbs_List) {
        this.sectionWise_PsnAbs_List = sectionWise_PsnAbs_List;
    }

    public int getScCnfID() {
        return scCnfID;
    }

    public void setScCnfID(int scCnfID) {
        this.scCnfID = scCnfID;
    }

    public void setExamResultOpt(ExamResult examResultOpt) {
        this.examResultOpt = examResultOpt;
    }

    public List<String> getAcyrList() {
        return acyrList;
    }

    public void setAcyrList(List<String> acyrList) {
        this.acyrList = acyrList;
    }

    public List<AttendanceReport> getClassList() {
        return classList;
    }

    public void setClassList(List<AttendanceReport> classList) {
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

    public Date getSpecificDate() {
        return specificDate;
    }

    public void setSpecificDate(Date specificDate) {
        this.specificDate = specificDate;
    }

    public List<AttendanceReport> getSpecificDateSectionAtd_List() {
        return specificDateSectionAtd_List;
    }

    public void setSpecificDateSectionAtd_List(List<AttendanceReport> specificDateSectionAtd_List) {
        this.specificDateSectionAtd_List = specificDateSectionAtd_List;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
