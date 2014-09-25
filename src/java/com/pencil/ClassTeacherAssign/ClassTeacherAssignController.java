/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ClassTeacherAssign;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Riad
 */
@ManagedBean
@ViewScoped
public class ClassTeacherAssignController implements Serializable{
  
 private ClassTeacherAssign  classTeacherAssign;
 
 private List<Integer> classList;
 private List<ClassTeacherAssign> teacherList;
 private List<ClassTeacherAssign> classTeacherAssignList;

 private String classid;
 
 public ClassTeacherAssignService serviceDao=new ClassTeacherAssignServiceImpl();

   
 
 
 public ClassTeacherAssignController() {
    
  this.teacherList=serviceDao.teacherList();
  
  this.classTeacherAssignList=serviceDao.classteacherAssignList();
  
 
 
 }

   
 
 public void assignClassTeacher(){
     
     FacesContext context=FacesContext.getCurrentInstance();
     
 
      if(serviceDao.saveClassTeacherAssign(classTeacherAssign))
        {
            context.addMessage(null, new FacesMessage("Successful Class Teacher Assigned", ""));           
            
            this.classTeacherAssignList=serviceDao.classteacherAssignList();
            
            this.classTeacherAssign=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed Class Teacher not Assigned", ""));
        }
    
 }
 
 
   public void updateClassTeacher(){
     
     FacesContext context=FacesContext.getCurrentInstance();
     
      if(serviceDao.updateClassTeacheAssign(classTeacherAssign))
        {
            context.addMessage(null, new FacesMessage("Successful Class Teacher Updated", ""));           
            
            this.classTeacherAssignList=serviceDao.classteacherAssignList();
            
            this.classTeacherAssign=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed Class Teacher not Updated", ""));
        }
    
 }
 
  public void deleteClassTeacher(){
     
     FacesContext context=FacesContext.getCurrentInstance();
     
     
      if(serviceDao.deleteClassTeacheAssign(classTeacherAssign))
        {
            context.addMessage(null, new FacesMessage("Successful Class Teacher Deleted", ""));           
            
            this.classTeacherAssignList=serviceDao.classteacherAssignList();
            
            this.classTeacherAssign=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed Class Teacher not Deleted", ""));
        }
    
 }
    
 public ClassTeacherAssign getClassTeacherAssign() {
       
        if(this.classTeacherAssign==null){
            
            this.classTeacherAssign=new ClassTeacherAssign();
        }
        return classTeacherAssign;
    }

    public void setClassTeacherAssign(ClassTeacherAssign classTeacherAssign) {
        this.classTeacherAssign = classTeacherAssign;
    }



    public List<Integer> getClassList() {
        this.classList=new ArrayList<>();
        this.classList.clear();
        this.classList=serviceDao.classlist();
        return classList;
    }

    public void setClassList(List<Integer> classList) {
        this.classList = classList;
    }

    public List<ClassTeacherAssign> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<ClassTeacherAssign> teacherList) {
        this.teacherList = teacherList;
    }

    public List<ClassTeacherAssign> getClassTeacherAssignList() {
        return classTeacherAssignList;
    }

    public void setClassTeacherAssignList(List<ClassTeacherAssign> classTeacherAssignList) {
        this.classTeacherAssignList = classTeacherAssignList;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
 
 
 
 
    
}
