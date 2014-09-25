/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.MarkSheetPrint;

import com.pencil.Dummy.Student.ExamResult.ExamResult;
import com.pencil.Dummy.Student.ExamResult.ResultServiceImpl;
import com.pencil.Dummy.Student.ExamResult.StudentExamResultService;
import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
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
public class MarkSheetPrintController  implements Serializable
{
    private MarkSheetPrint markSheetPrint;
    
    private int exCnfID;

    private ExamResult examResultObj;

    private List<String> acyrList;

    private List<String> classList;

    private List<String> examList;
    
    Presentation pr=new Presentation();
    
    StudentExamResultService resultService = new ResultServiceImpl();
    
    Sc_ClassConfigService sc_service_dao = new Sc_ClassCofigService_Impl();
    
    MarkSheetPrintService markSheetService = new MarkSheetPrintServiceImpl();
    
    private List<MarkSheetPrint> mark_sheet_std_info_List;
    
     private List<MarkSheetPrint> mark_sheet_List;
     
      private List<MarkSheetPrint> total_GradeSheet_list;

    public MarkSheetPrintController() 
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
    
    public void student_Mark_Sheet_Info_List()
    {
        this.mark_sheet_std_info_List=markSheetService.student_Info_List(this.exCnfID);
    }

     
    public void total_grade(String stdID)
    { 
        
        this.mark_sheet_List = markSheetService.mark_sheet_List(stdID,this.exCnfID);
        
        
        this.total_GradeSheet_list = markSheetService.mark_sheet_finalGrade(stdID, this.exCnfID);
        
        this.markSheetPrint.setTotalMark(this.total_GradeSheet_list.get(0).getTotalMark());
        
        this.markSheetPrint.setCGPA(this.total_GradeSheet_list.get(0).getCGPA());
        
        this.markSheetPrint.setFinalGrade(this.total_GradeSheet_list.get(0).getFinalGrade());
        
        this.markSheetPrint.setStatus(this.total_GradeSheet_list.get(0).getStatus());
        
        this.markSheetPrint.setClassPosition(this.total_GradeSheet_list.get(0).getClassPosition());
        
        this.markSheetPrint.setShiftPosition(this.total_GradeSheet_list.get(0).getShiftPosition());
        
        this.markSheetPrint.setSectionPosition(this.total_GradeSheet_list.get(0).getSectionPosition());
     
    }
    
    public MarkSheetPrint getMarkSheetPrint() 
    {
        if(this.markSheetPrint==null)
        {
            this.markSheetPrint=new MarkSheetPrint();
        }
        return this.markSheetPrint;
    }

    public void setMarkSheetPrint(MarkSheetPrint markSheetPrint) {
        this.markSheetPrint = markSheetPrint;
    }
    
    
    public int getExCnfID() {
        return exCnfID;
    }

    public void setExCnfID(int exCnfID) {
        this.exCnfID = exCnfID;
    }

    public ExamResult getExamResultObj()
    {
         if(this.examResultObj==null)
        {
            this.examResultObj=new ExamResult();
        }
        return this.examResultObj;
    }

    public void setExamResultObj(ExamResult examResultObj) {
        this.examResultObj = examResultObj;
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

    public List<String> getExamList() {
        return examList;
    }

    public void setExamList(List<String> examList) {
        this.examList = examList;
    }

    public List<MarkSheetPrint> getMark_sheet_std_info_List() {
        return mark_sheet_std_info_List;
    }

    public void setMark_sheet_std_info_List(List<MarkSheetPrint> mark_sheet_std_info_List) {
        this.mark_sheet_std_info_List = mark_sheet_std_info_List;
    }

    public List<MarkSheetPrint> getMark_sheet_List() {
        return mark_sheet_List;
    }

    public void setMark_sheet_List(List<MarkSheetPrint> mark_sheet_List) {
        this.mark_sheet_List = mark_sheet_List;
    }
    
    
    

}
