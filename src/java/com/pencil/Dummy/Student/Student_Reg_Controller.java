/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Student;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.ScClassConfig;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 * 
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class Student_Reg_Controller implements Serializable {

    private Student_Registration student;

    private UploadedFile photoFile;

    private int scCnfID;

    private List<String> academicYearList;

    private List<String> schoolClassList;

    private List<String> departmentList;

    private List<String> shiftList;

    private List<String> sectionList;

    private List<String> elective_SbjList;
    
    private ScClassConfig scClassConfig;

    Student_Reg_Service serviceDao = new Student_Reg_Service_Impl();

    Sc_ClassConfigService sc_service_dao = new Sc_ClassCofigService_Impl();

    ImgUpLoad uploadService = new ImgUpload_Impl();

    Presentation pr = new Presentation();

    /**
     * Creates a new instance of Student_Reg_Controller
     */
    public Student_Reg_Controller() {
        this.academicYearList = pr.infoList("acyr");
       
    }

    public void student_update(){
        this.scClass_List();
         this.section_List();
         this.deptList();
         this.elective_Subject();
         
         }
    
    /**
     *
     */
    public void scClass_List() {
        this.schoolClassList = sc_service_dao.listScClass(this.student.getAcyr());
    
    }

    /**
     *
     */
    public void deptList() {
        this.departmentList = sc_service_dao.listScDept(this.student.getAcyr(), this.student.getClassName());
       
    }

    /**
     *
     */
    public void section_List() {
        this.sectionList = sc_service_dao.listScSection(this.student.getAcyr(), this.student.getDeptName(), this.student.getClassName(), this.student.getShiftName());
       
    }

    /**
     *
     */
    public void elective_Subject() {
        this.shiftList = sc_service_dao.listScShift(this.student.getAcyr(), this.student.getDeptName(), this.student.getClassName());

        this.elective_SbjList = serviceDao.elective_SubjectList(this.student.getAcyr(), this.student.getClassName(), this.student.getDeptName());
        this.Sc_Cnf_ID();
    }

    /**
     *
     */
    public void Sc_Cnf_ID() {
        this.scCnfID = sc_service_dao.getScCnfID(this.student.getAcyr(), this.student.getDeptName(), this.student.getClassName(), this.student.getShiftName(), this.student.getSectionName());
    }

    /**
     *
     * @return
     */
    public String saveStudent() {
        String institueID="";
        FacesContext context = FacesContext.getCurrentInstance();
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        if (photoFile != null) {
            this.student.setImgPath(photoFile.getFileName());

            if (serviceDao.completeStudentReg(this.student, this.scCnfID)) {
                
                uploadService.uploadImg("studentImages", institueID+"_"+this.student.getStudentID()+"_"+photoFile.getFileName(), photoFile);

                context.addMessage(null, new FacesMessage("Successful", "Student registration complete..."));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student registration failed...!", ""));
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select student image...!", ""));
        }

        this.student = null;

        return "index.xhtml";

    }

    public String updateStudent()
    {
        String institueID = "";
        FacesContext context = FacesContext.getCurrentInstance();
        institueID = context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        if (this.photoFile.getFileName().equals("")) 
        {
          if (serviceDao.completeStudentUpdate(this.student))
          {
             context.addMessage(null, new FacesMessage("Successful", "Student registration update complete..."));
          }
          else
          {
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student registration update failed...!", ""));
          }
        }
        else
        {
            this.student.setImgPath(photoFile.getFileName());

            if (serviceDao.completeStudentUpdate(this.student))
            {
                uploadService.uploadImg("studentImages",institueID+"_"+this.student.getStudentID()+"_"+photoFile.getFileName(), photoFile);

                context.addMessage(null, new FacesMessage("Successful", "Student registration update complete..."));
            }
            else 
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student registration update failed...!", ""));
            }
        }

        this.student = null;

        return "index.xhtml";

    }
    
    public String udtAcademicInfo()
    {
         FacesContext context = FacesContext.getCurrentInstance();
         
         if (serviceDao.updateAcademicInfo(this.student,this.scCnfID))
          {
             context.addMessage(null, new FacesMessage("Successful Student academic info update complete...",""));
          }
          else
          {
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student academic info update failed...!", ""));
          }
        return "index.xhtml";
    }

    public int checkInitAdditionalInfo(Student_Registration std) {

        if (serviceDao.additionalInfoChak(std).size() > 0) {

            return 1;
        } else {
            return 0;
        }

    }

    public String saveAdditionalInfo(String studentId) {
        FacesContext context = FacesContext.getCurrentInstance();

        if (serviceDao.additionalInfo(this.student, studentId)) {
            context.addMessage(null, new FacesMessage("Successful", "Add Student Additional Info complete..."));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student Additional Info failed...!", ""));
        }

        this.student = null;

        return "index.xhtml";

    }

    /**
     * @return the student
     */
    public Student_Registration getStudent() {
        if (this.student == null) {
            this.student = new Student_Registration();
        }
        return this.student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student_Registration student) {
        this.student = student;
    }

    /**
     * @return the academicYearList
     */
    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    /**
     * @param academicYearList the academicYearList to set
     */
    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }

    /**
     * @return the schoolClassList
     */
    public List<String> getSchoolClassList() {
        return schoolClassList;
    }

    /**
     * @param schoolClassList the schoolClassList to set
     */
    public void setSchoolClassList(List<String> schoolClassList) {
        this.schoolClassList = schoolClassList;
    }

    /**
     * @return the departmentList
     */
    public List<String> getDepartmentList() {
        return departmentList;
    }

    /**
     * @param departmentList the departmentList to set
     */
    public void setDepartmentList(List<String> departmentList) {
        this.departmentList = departmentList;
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
     * @return the photoFile
     */
    public UploadedFile getPhotoFile() {
        return photoFile;
    }

    /**
     * @param photoFile the photoFile to set
     */
    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
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

}
