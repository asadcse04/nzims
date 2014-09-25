/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.ScClassConfig.Routine;

import com.pencil.Dummy.Teacher.Teacher;
import com.pencil.Dummy.Teacher.TeacherConverter;
import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mahfuj
 */
@ManagedBean
@ViewScoped
public class ClassRoutineUpdate_Controller implements Serializable
{
    
    private ClassRoutineUpdate routine_update;
    
    private List<ClassRoutineUpdate> routine_List;
    
    
    private List<String> subjectList;
    
    private String dayName;
    
    private List<String> dayList;
    
    
    private Teacher selectedTeacher;
    
    private List<Teacher> teachers;
    
    TeacherConverter tc=new TeacherConverter();
    
    
    ClassRoutineService crtnserviceDao=new ClassRoutineServiceImpl();
    
    Presentation pr=new Presentation();
    
    Sc_ClassConfigService cnfserviceDao=new Sc_ClassCofigService_Impl();

    /**
     * Creates a new instance of ClassRoutineUpdate_Controller
     */
    public ClassRoutineUpdate_Controller()
    {
        this.dayList=pr.infoList("w.day");
    }
    
    /**
     *
     * @param cnfid
     * @param shift
     */
    public void viewRoutine(int cnfid,String shift)
    { 
        this.routine_List=crtnserviceDao.viewRoutine(cnfid,this.dayName,shift);
        
        this.subjectList=cnfserviceDao.viewSubjectList(cnfid);
        
        this.teachers=tc.getTeacherList();
    }
    
    /**
     *
     */
    public void editRoutine()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        boolean flag=false;
        
        if(this.routine_update.getTeacherID()==this.selectedTeacher.getTeacherID())
        {
            flag=true;
        }
        
        this.routine_update.setTeacherID(this.selectedTeacher.getTeacherID());
        
        if(crtnserviceDao.updateRoutine(this.routine_update,flag))
        {
            this.routine_List=crtnserviceDao.viewRoutine(this.routine_update.getSc_cnf_id(),this.routine_update.getDay(),this.routine_update.getShiftName());
        
            this.routine_update=null;
            
            context.addMessage(null, new FacesMessage("Successful","Routine is updated...."));
        }
        else
        {
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update routine...Teacher is busy.. !",""));
        }
    }
    
    /**
     * @return the routine_update
     */
    public ClassRoutineUpdate getRoutine_update()
    {
        if(this.routine_update==null)
        {
            this.routine_update=new ClassRoutineUpdate();
        }
        return this.routine_update;
    }

    /**
     * @param routine_update the routine_update to set
     */
    public void setRoutine_update(ClassRoutineUpdate routine_update) {
        this.routine_update = routine_update;
    }

    /**
     * @return the routine_List
     */
    public List<ClassRoutineUpdate> getRoutine_List() {
        return routine_List;
    }

    /**
     * @param routine_List the routine_List to set
     */
    public void setRoutine_List(List<ClassRoutineUpdate> routine_List) {
        this.routine_List = routine_List;
    }

    /**
     * @return the dayList
     */
    public List<String> getDayList() {
        return dayList;
    }

    /**
     * @param dayList the dayList to set
     */
    public void setDayList(List<String> dayList) {
        this.dayList = dayList;
    }
    /**
     * @return the dayName
     */
    public String getDayName() {
        return dayName;
    }

    /**
     * @param dayName the dayName to set
     */
    public void setDayName(String dayName) {
        this.dayName = dayName;
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
     * @return the selectedTeacher
     */
    public Teacher getSelectedTeacher() {
        return selectedTeacher;
    }

    /**
     * @param selectedTeacher the selectedTeacher to set
     */
    public void setSelectedTeacher(Teacher selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
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

}
