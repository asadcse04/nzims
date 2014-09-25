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
public class ClassRoutineController implements Serializable
{
    
    private ClassRoutine class_routine;
    
    
    private String day;
    
    private List<String> dayList;
    
    
    private Teacher selectedTeacher;
    
    private List<Teacher> teachers;
    
    TeacherConverter tc=new TeacherConverter();
    
    
    Presentation pr=new Presentation();
    
    Sc_ClassConfigService serviceDao=new Sc_ClassCofigService_Impl();
    
    ClassRoutineService crserviceDao=new ClassRoutineServiceImpl();
    
    /**
     * Creates a new instance of ClassRoutineController
     */
    public ClassRoutineController()
    {
        this.dayList=pr.infoList("w.day");
        
        this.teachers=tc.getTeacherList();
    }
    
    /**
     *
     * @param scClassCnfID
     * @param shiftName
     */
    public void periodList(int scClassCnfID,String shiftName)
    {
        this.class_routine.setScClassCnfID(scClassCnfID);
        
        this.class_routine.setShiftName(shiftName);
        
        this.class_routine.setPeriod_List(serviceDao.viewPeriodList(shiftName));
        
        this.class_routine.setSubject_List(serviceDao.viewSubjectList(scClassCnfID));
    }

    /**
     *
     * @param prdname
     */
    public void assign_SbjTchr(String prdname)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(this.day!=null)
        {
            if(crserviceDao.save_Assign_Subject_Tchr(this.class_routine,this.day,prdname,this.selectedTeacher.getTeacherID()))
            {
                context.addMessage(null, new FacesMessage("Successful","Assign subject & teacher...."));  
            }
            else
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to assign subject & teacher...Teacher is busy.. !",""));
            }
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Please select day... !",""));
        }
        
        this.class_routine.setSubject("");
                
        this.class_routine.setNote("");
                
        this.selectedTeacher.setTeacherID(0);
         
    }
    
    /**
     * @return the class_routine
     */
    public ClassRoutine getClass_routine()
    {
        if(this.class_routine==null)
        {
            this.class_routine=new ClassRoutine();
        }
        
        return this.class_routine;
    }

    /**
     * @param class_routine the class_routine to set
     */
    public void setClass_routine(ClassRoutine class_routine) {
        this.class_routine = class_routine;
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
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day)
    {
        this.day = day;
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
