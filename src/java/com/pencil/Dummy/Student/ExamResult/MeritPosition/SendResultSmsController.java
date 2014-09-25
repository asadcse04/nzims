/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Dummy.Student.ExamResult.MeritPosition;

import com.pencil.Dummy.Student.ExamResult.ExamResult;
import com.pencil.Dummy.Student.ExamResult.ResultServiceImpl;
import com.pencil.Dummy.Student.ExamResult.StudentExamResultService;
import com.pencil.Dummy.Student.ExamResult.StudentMeritList;
import com.pencil.Presentation.Presentation;
import com.pencil.SMS.SMS_Service;
import com.pencil.SMS.SMS_ServiceImpl;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author apple
 */
@ManagedBean
@ViewScoped
public class SendResultSmsController implements Serializable
{
    private int exCnfID;
    
    private StudentMeritList student_merit_obj;
    
    private ExamResult examResultObj;
    
    private List<StudentMeritList> studentMerit_List;
    
    
    private List<String> acyrList;
    
    private List<String> classList;
    
    private List<String> examList;
    
    
    Presentation pr=new Presentation();
    
    StudentExamResultService resultService=new ResultServiceImpl();
    
    Sc_ClassConfigService sc_service_dao=new Sc_ClassCofigService_Impl();
    
    MeritPositionService serviceMrt=new MeritPositionServiceImpl();
    
    SMS_Service smsService=new SMS_ServiceImpl();

    /**
     * Creates a new instance of SendResultSmsController
     */
    public SendResultSmsController() 
    {
        this.acyrList=pr.infoList("acyr");
        
        this.examList=pr.infoList("exmNm");
    }
    
    public void acyr_ClassList()
    {
        this.classList=sc_service_dao.listScClass(this.examResultObj.getAcyr());
    }
    
    public void get_ExCnf_ID()
    {
        this.setExCnfID(resultService.getExCnfID(this.examResultObj.getAcyr(),this.examResultObj.getClassName(),this.examResultObj.getExamName()));
    }
    
    public void get_Student_List()
    {
        this.studentMerit_List=serviceMrt.prepareStudent_list_to_send_result_sms(this.exCnfID);
    }
    
    public void send_Student_Result_to_Parent()
    {
        /*List<StudentMeritList> sml=new ArrayList<StudentMeritList>();
        
        sml.add(new StudentMeritList("1455",5,"01720426406" ,818.4,4.59,"A","Pass",9,7,5));
        
        //sml.add(new StudentMeritList("1455",5,"01612223602" ,818.4,4.59,"A","Pass",9,7,5));
        
        sml.add(new StudentMeritList("1455",5,"01966184517" ,818.4,4.59,"A","Pass",9,7,5));*/
        
        if(serviceMrt.send_Student_result_Sms(this.studentMerit_List,smsService))
        {
            System.out.println("Student Result Send SMS Successfully...........");
        }
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
     * @return the student_merit_obj
     */
    public StudentMeritList getStudent_merit_obj()
    {
        if(this.student_merit_obj==null)
        {
            this.student_merit_obj=new StudentMeritList();
        }
        return this.student_merit_obj;
    }

    /**
     * @param student_merit_obj the student_merit_obj to set
     */
    public void setStudent_merit_obj(StudentMeritList student_merit_obj) {
        this.student_merit_obj = student_merit_obj;
    }

    /**
     * @return the examResultObj
     */
    public ExamResult getExamResultObj() 
    {
        if(this.examResultObj==null)
        {
            this.examResultObj=new ExamResult();
        }
        return this.examResultObj;
    }

    /**
     * @param examResultObj the examResultObj to set
     */
    public void setExamResultObj(ExamResult examResultObj) {
        this.examResultObj = examResultObj;
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
    
}
