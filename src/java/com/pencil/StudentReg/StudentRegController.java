/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.StudentReg;

import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author salim
 */
@ManagedBean
@ViewScoped
public class StudentRegController  implements Serializable
{

    private StudentReg studentReg;

    private int scCnfID;

    private List<String> academicYearList;

    private List<String> schoolClassList;

    private List<String> departmentList;

    private List<String> shiftList;

    private List<String> sectionList;
    
    private List<StudentReg> stdViewList;
    
    Presentation pr = new Presentation();
    
    Sc_ClassConfigService sc_service_dao = new Sc_ClassCofigService_Impl();
    
    StudentRegService std_Service = new StudentRegServiceImpl();
 
    public StudentRegController()
    {
        this.academicYearList = pr.infoList("acyr");
    }
    
    public void scClass_List() {
        this.schoolClassList = sc_service_dao.listScClass(this.studentReg.getAcyr());
    
    }

    public void deptList() {
        this.departmentList = sc_service_dao.listScDept(this.studentReg.getAcyr(), this.studentReg.getClassName());
       
    }
    
    public void shifList(){
         this.shiftList=sc_service_dao.listScShift(this.studentReg.getAcyr(),this.studentReg.getDeptName(),this.studentReg.getClassName());
        
    }

    public void section_List() {
        this.sectionList = sc_service_dao.listScSection(this.studentReg.getAcyr(), this.studentReg.getDeptName(), this.studentReg.getClassName(), this.studentReg.getShiftName());
       
    }
    
    public void Sc_Cnf_ID() {
        this.scCnfID = sc_service_dao.getScCnfID(this.studentReg.getAcyr(), this.studentReg.getDeptName(), this.studentReg.getClassName(), this.studentReg.getShiftName(), this.studentReg.getSectionName());
    }
    
    public void stdList(){
        this.stdViewList = std_Service.getStudent_insertList();

    }
    
  
    
    public void newID()
    {   
        StudentReg studeReg = new StudentReg();
 
        for(int i=0;i<this.stdViewList.size();i++)
        {      
               studeReg.setStudentId(this.stdViewList.get(i).getStudentId()+1);
           
        } 
        stdViewList.add(studeReg);
    
    }
    
    
    
    public void quickSaveStudent() 
    {
        FacesContext context = FacesContext.getCurrentInstance();
      
//        for (StudentReg stdreg : this.stdViewList) {
//            System.out.println("StudentId:" + stdreg.getStudentId());
//            System.out.println("StudentRoll:" + stdreg.getStudentRoll());
//            System.out.println("StudentName:" + stdreg.getStudentName());
//            System.out.println("StudentGender:" + stdreg.getGender());
//            System.out.println("FatherName:" + stdreg.getFatherName());
//            System.out.println("Mobile:" + stdreg.getGuardianContactNo());
//        }
        

        if (std_Service.quickStudentReg(this.scCnfID, this.stdViewList))
        {
            context.addMessage(null, new FacesMessage("Successful", "Student registration complete..."));
        }
        else 
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student registration failed...!", ""));
        }

//        return "index.xhtml";

    }

     public void onCellEdit(CellEditEvent event)
    {
        Object oldValue = event.getOldValue();
        
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue))
        {
            
            FacesMessage msg = new FacesMessage("Success","Student insertion complete..");
            
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public StudentReg getStudentReg()
    {
        if(this.studentReg == null)
        {
            this.studentReg = new StudentReg();
        }
        return studentReg;
    }
    

    public void setStudentReg(StudentReg studentReg) {
        this.studentReg = studentReg;
    }

    public List<StudentReg> getStdViewList() {
        return stdViewList;
    }

    public void setStdViewList(List<StudentReg> stdViewList) {
        this.stdViewList = stdViewList;
    }


    public int getScCnfID() {
        return scCnfID;
    }

    public void setScCnfID(int scCnfID) {
        this.scCnfID = scCnfID;
    }

    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }

    public List<String> getSchoolClassList() {
        return schoolClassList;
    }

    public void setSchoolClassList(List<String> schoolClassList) {
        this.schoolClassList = schoolClassList;
    }

    public List<String> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<String> departmentList) {
        this.departmentList = departmentList;
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
  
    
}
