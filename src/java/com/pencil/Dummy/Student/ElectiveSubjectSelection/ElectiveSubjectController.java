/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ElectiveSubjectSelection;

import com.pencil.Dummy.Student.SMS.StudentDataModel;
import com.pencil.Dummy.Student.Student_Reg_Service;
import com.pencil.Dummy.Student.Student_Reg_Service_Impl;
import com.pencil.Dummy.Student.Student_Registration;
import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author INSPIRON 5421
 */
@ManagedBean
@ViewScoped
public class ElectiveSubjectController implements Serializable
{
    
    private ElectiveSubject elective_subject;
    
    private StudentDataModel student_data_model;
    
    
    private List <Student_Registration> studentList;
    
    private List<Student_Registration> student_Filter_List;
    
    private List<Student_Registration> selectedStudentList;
    
    
    private int scCnfID;
    
    private List<String> acyrList;
    
    private List<String> classList;
    
    private List<String> deptList;
    
    private List<String> shiftList;
    
    private List<String> sectionList;
    
    private List<String> elective_SbjList;
    
    
    Sc_ClassConfigService sc_service_dao=new Sc_ClassCofigService_Impl();
    
    Student_Reg_Service studentService=new Student_Reg_Service_Impl();
    
    ElectiveSubjectService sbjService=new ElectiveSubjectServiceImpl();
    
    Presentation pr=new Presentation();

    /**
     * Creates a new instance of ElectiveSubjectController
     */
    public ElectiveSubjectController()
    {
        acyrList=pr.infoList("acyr");
    }

    /**
     *
     */
    public void scClass_List()
    {
        this.classList=sc_service_dao.listScClass(this.elective_subject.getAcyr());
    }
    
    /**
     *
     */
    public void deptList()
    {
        this.deptList=sc_service_dao.listScDept(this.elective_subject.getAcyr(),this.elective_subject.getClassName());
    }
    
    /**
     *
     */
    public void section_List()
    {
        this.sectionList=sc_service_dao.listScSection(this.elective_subject.getAcyr(),this.elective_subject.getDeptName(),this.elective_subject.getClassName(),this.elective_subject.getShiftName());
    }
    
    /**
     *
     */
    public void elective_Subject()
    {
        this.shiftList=sc_service_dao.listScShift(this.elective_subject.getAcyr(),this.elective_subject.getDeptName(),this.elective_subject.getClassName());
        
        this.elective_SbjList=studentService.elective_SubjectList(this.elective_subject.getAcyr(),this.elective_subject.getClassName(),this.elective_subject.getDeptName());
    }
    
    /**
     *
     */
    public void studentList_4_Sbj_Selctn()
    {
        StringBuilder sb=new StringBuilder();
        
        this.setScCnfID(sc_service_dao.getScCnfID(this.elective_subject.getAcyr(),this.elective_subject.getDeptName(),this.elective_subject.getClassName(),this.elective_subject.getShiftName(),this.elective_subject.getSectionName()));
        
        sb.append(this.getScCnfID());
        
        this.studentList=sc_service_dao.studentList(sb);
        
        student_data_model = new StudentDataModel(this.studentList);
    }
    
    /**
     *
     */
    public void save4thSubject_Selection()
    {
        System.out.println(this.selectedStudentList.size());
        
        sbjService.saveElectiveSubject(this.selectedStudentList,this.elective_subject);
    }

    /**
     * @return the scCnfID
     */
    public int getScCnfID() {
        return scCnfID;
    }

    /**
     * @param scCnfID the scCnfID to set
     */
    public void setScCnfID(int scCnfID) {
        this.scCnfID = scCnfID;
    }

    /**
     * @return the acyrList
     */
    public List<String> getAcyrList() {
        return acyrList;
    }

    /**
     * @param acyrList the acyrList to set
     */
    public void setAcyrList(List<String> acyrList) {
        this.acyrList = acyrList;
    }

    /**
     * @return the classList
     */
    public List<String> getClassList() {
        return classList;
    }

    /**
     * @param classList the classList to set
     */
    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    /**
     * @return the deptList
     */
    public List<String> getDeptList() {
        return deptList;
    }

    /**
     * @param deptList the deptList to set
     */
    public void setDeptList(List<String> deptList) {
        this.deptList = deptList;
    }

    /**
     * @return the shiftList
     */
    public List<String> getShiftList() {
        return shiftList;
    }

    /**
     * @param shiftList the shiftList to set
     */
    public void setShiftList(List<String> shiftList) {
        this.shiftList = shiftList;
    }

    /**
     * @return the sectionList
     */
    public List<String> getSectionList() {
        return sectionList;
    }

    /**
     * @param sectionList the sectionList to set
     */
    public void setSectionList(List<String> sectionList) {
        this.sectionList = sectionList;
    }

    /**
     * @return the elective_SbjList
     */
    public List<String> getElective_SbjList() {
        return elective_SbjList;
    }

    /**
     * @param elective_SbjList the elective_SbjList to set
     */
    public void setElective_SbjList(List<String> elective_SbjList) {
        this.elective_SbjList = elective_SbjList;
    }

    /**
     * @return the elective_subject
     */
    public ElectiveSubject getElective_subject()
    {
        if(this.elective_subject==null)
        {
            this.elective_subject=new ElectiveSubject();
        }
        return this.elective_subject;
    }

    /**
     * @param elective_subject the elective_subject to set
     */
    public void setElective_subject(ElectiveSubject elective_subject) {
        this.elective_subject = elective_subject;
    }

    /**
     * @return the student_data_model
     */
    public StudentDataModel getStudent_data_model() {
        return student_data_model;
    }

    /**
     * @param student_data_model the student_data_model to set
     */
    public void setStudent_data_model(StudentDataModel student_data_model) {
        this.student_data_model = student_data_model;
    }

    /**
     * @return the studentList
     */
    public List <Student_Registration> getStudentList() {
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(List <Student_Registration> studentList) {
        this.studentList = studentList;
    }

    /**
     * @return the student_Filter_List
     */
    public List<Student_Registration> getStudent_Filter_List() {
        return student_Filter_List;
    }

    /**
     * @param student_Filter_List the student_Filter_List to set
     */
    public void setStudent_Filter_List(List<Student_Registration> student_Filter_List) {
        this.student_Filter_List = student_Filter_List;
    }

    /**
     * @return the selectedStudentList
     */
    public List<Student_Registration> getSelectedStudentList() {
        return selectedStudentList;
    }

    /**
     * @param selectedStudentList the selectedStudentList to set
     */
    public void setSelectedStudentList(List<Student_Registration> selectedStudentList) {
        this.selectedStudentList = selectedStudentList;
    }
    
}
