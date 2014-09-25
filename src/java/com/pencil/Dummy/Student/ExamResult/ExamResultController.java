/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult;

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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author apple
 */
@ManagedBean
@ViewScoped
public class ExamResultController implements Serializable
{
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
    
    private List<String> subjectList;
    
    
    private List<StudentExamResult> student_subject_markList;
    
    private List<StudentMeritList> studentMerit_List;
    
    private List<ExamGrade> exmGrdList;
    
    
    Sc_ClassConfigService sc_service_dao=new Sc_ClassCofigService_Impl();
    
    SubjectConfigService sbjserviceDao=new SubjectConfigService_Impl();
    
    StudentExamResultService resultService=new ResultServiceImpl();
    
    
    private Teacher selectedTeacher;
    
    private List<Teacher> teachers;
    
    TeacherConverter tc=new TeacherConverter();
    
    
    private ViewStudentResult strs;
    
    private List<ViewStudentResult> student_result_complete_list;
            
    
    Presentation pr=new Presentation();

    /**
     * Creates a new instance of ExamResultController
     */
    public ExamResultController() 
    {
        this.acyrList=pr.infoList("acyr");
        
        this.examList=pr.infoList("exmNm");
        
        this.teachers=tc.getTeacherList();
        
        this.exmGrdList=resultService.examGradeList();
    }
    
    /**
     *
     */
    public void scClassList()
    {
        this.classList=sc_service_dao.listScClass(this.examResultOpt.getAcyr());
    }
    
    /**
     *
     */
    public void departmentList()
    {
        this.deptList=sc_service_dao.listScDept(this.examResultOpt.getAcyr(),this.examResultOpt.getClassName());
    }
    
    /**
     *
     */
    public void shiftNameList()
    {
        this.getSbjConfig().setAcyrID(this.examResultOpt.getAcyr());
        
        this.getSbjConfig().setSchoolClassName(this.examResultOpt.getClassName());
        
        this.getSbjConfig().setDeptName(this.examResultOpt.getDeptName());
        
        this.shiftList=sc_service_dao.listScShift(this.examResultOpt.getAcyr(),this.examResultOpt.getDeptName(),this.examResultOpt.getClassName());
        
        this.subjectList=sbjserviceDao.bookList(this.getSbjConfig());
    }
    
    /**
     *
     */
    public void section_List()
    {
        this.sectionList=sc_service_dao.listScSection(this.examResultOpt.getAcyr(),this.examResultOpt.getDeptName(),this.examResultOpt.getClassName(),this.examResultOpt.getShiftName());
    }
    
    /**
     *
     */
    public void Sc_Cnf_ID()
    {
        this.scCnfID=sc_service_dao.getScCnfID(this.examResultOpt.getAcyr(),this.examResultOpt.getDeptName(),this.examResultOpt.getClassName(),this.examResultOpt.getShiftName(),this.examResultOpt.getSectionName());
    }

    /**
     *
     */
    public void Ex_Cnf_ID()
    {
        this.setExCnfID(resultService.getExCnfID(this.examResultOpt.getAcyr(),this.examResultOpt.getClassName(),this.examResultOpt.getExamName()));
    }
    
    /**
     *
     */
    public void studentList()
    {
        this.student_subject_markList=resultService.getStudent_insertResult(this.scCnfID,this.examResultOpt.getSubjectName());
    }
    
    public void student_Complete_Result_List()
    {
        this.student_result_complete_list=resultService.studentExamResult(this.exCnfID,this.scCnfID,this.examResultOpt.getSubjectName());
    }
    
    /**
     *
     * @param event
     */
//    public void onEdit(RowEditEvent event)
//    { 
//        FacesMessage msg = new FacesMessage("Success","Mark insertion complete..");  
//        
//        FacesContext.getCurrentInstance().addMessage(null,msg);
//    }
    
   public void onCellEdit(CellEditEvent event)
    {
        Object oldValue = event.getOldValue();
        
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue))
        {
            FacesMessage msg = new FacesMessage("Success","Mark insertion complete..");
            
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
   
    public void updateStudentResult(RowEditEvent event)
    {
        if(resultService.editStudentResult(this.exCnfID,this.examResultOpt.getSubjectName(),(ViewStudentResult)event.getObject(),this.exmGrdList)==1)
        {
             System.out.println("Student result update successfully..........");
             
             FacesMessage msg = new FacesMessage("Student result update successfully....","");
             
             FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
             System.out.println("Student  result update failed.......");
            
             FacesMessage msg = new FacesMessage("Student  result update failed....","");
             
             FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     *
     * @return
     */
    public String saveStudent_Subject_Result()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(resultService.insertStudentExamScore(this.getExCnfID(),this.examResultOpt.getSubjectName(),this.selectedTeacher.getTeacherID(),this.student_subject_markList,this.exmGrdList))
        {
              context.addMessage(null, new FacesMessage("Successful","Insert subject mark..."));
        }
        else
        {
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Subject mark insertion failed...!",""));
        }
        
        return "index.xhtml";
    }

    /**
     *
     */
    public void finalResultProcessor()//generate merit list
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        resultService.generateMeritList(this.exCnfID,resultService.scCnfID(this.examResultOpt.getClassName()),this.exmGrdList);  
        
        this.studentMerit_List=resultService.StudentMeritList(this.exCnfID);
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
     * @return the examList
     */
    public List<String> getExamList() {
        return examList;
    }

    /**
     * @param examList the examList to set
     */
    public void setExamList(List<String> examList) {
        this.examList = examList;
    }

    /**
     * @return the subjectList
     */
    public List<String> getSubjectList() {
        return subjectList;
    }

    /**
     * @param subjectList the subjectList to set
     */
    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }

    /**
     * @return the examResultOpt
     */
    public ExamResult getExamResultOpt() 
    {
        if(this.examResultOpt==null)
        {
            this.examResultOpt=new ExamResult();
        }
        return this.examResultOpt;
    }

    /**
     * @param examResultOpt the examResultOpt to set
     */
    public void setExamResultOpt(ExamResult examResultOpt) {
        this.examResultOpt = examResultOpt;
    }

    /**
     * @return the sbjConfig
     */
    public SubjectConfig getSbjConfig()
    {
        if(this.sbjConfig==null)
        {
            this.sbjConfig=new SubjectConfig();
        }
        return this.sbjConfig;
    }

    /**
     * @param sbjConfig the sbjConfig to set
     */
    public void setSbjConfig(SubjectConfig sbjConfig) {
        this.sbjConfig = sbjConfig;
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
     * @return the student_subject_markList
     */
    public List<StudentExamResult> getStudent_subject_markList() {
        return student_subject_markList;
    }

    /**
     * @param student_subject_markList the student_subject_markList to set
     */
    public void setStudent_subject_markList(List<StudentExamResult> student_subject_markList) {
        this.student_subject_markList = student_subject_markList;
    }

    /**
     * @return the exCnfID
     */
    public int getExCnfID() {
        return exCnfID;
    }

    /**
     * @param exCnfID the exCnfID to set
     */
    public void setExCnfID(int exCnfID) {
        this.exCnfID = exCnfID;
    }

    /**
     * @return the teachers
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * @param teachers the teachers to set
     */
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * @return the selectedTeacher
     */
    public Teacher getSelectedTeacher()
    {
        if(this.selectedTeacher==null)
        {
            this.selectedTeacher=new Teacher();
        }
        return selectedTeacher;
    }

    /**
     * @param selectedTeacher the selectedTeacher to set
     */
    public void setSelectedTeacher(Teacher selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    /**
     * @return the studentMerit_List
     */
    public List<StudentMeritList> getStudentMerit_List() {
        return studentMerit_List;
    }

    /**
     * @param studentMerit_List the studentMerit_List to set
     */
    public void setStudentMerit_List(List<StudentMeritList> studentMerit_List) {
        this.studentMerit_List = studentMerit_List;
    }
    /**
     * @return the exmGrdList
     */
    public List<ExamGrade> getExmGrdList() {
        return exmGrdList;
    }

    /**
     * @param exmGrdList the exmGrdList to set
     */
    public void setExmGrdList(List<ExamGrade> exmGrdList) {
        this.exmGrdList = exmGrdList;
    }

    /**
     * @return the student_result_complete_list
     */
    public List<ViewStudentResult> getStudent_result_complete_list() {
        return student_result_complete_list;
    }

    /**
     * @param student_result_complete_list the student_result_complete_list to set
     */
    public void setStudent_result_complete_list(List<ViewStudentResult> student_result_complete_list) {
        this.student_result_complete_list = student_result_complete_list;
    }

    /**
     * @return the strs
     */
    public ViewStudentResult getStrs()
    {
        if(this.strs==null)
        {
            this.strs=new ViewStudentResult();
        }
        return this.strs;
    }

    /**
     * @param strs the strs to set
     */
    public void setStrs(ViewStudentResult strs) {
        this.strs = strs;
    }
    
    
    
}
