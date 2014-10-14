/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Dummy.Teacher;

import com.pencil.PhotoUpload.ImgUpLoad;
import com.pencil.PhotoUpload.ImgUpload_Impl;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author user
 */
@ManagedBean
@ViewScoped

public class TeacherController implements Serializable
{

     private Teacher teacher;
     
     private List<Teacher> teacharList;
     
     private List<Teacher> teachar_Filter_List;
     
     private UploadedFile photoFile;
     
     
     TeacherService teacherDao = new TeacherServiceImpl();
     
     ImgUpLoad uploadService=new ImgUpload_Impl();
     
    /**
     * Creates a new instance of TeacherController
     */
    public TeacherController() 
    {
       this.teacharList=teacherDao.teacherList();
    }

    /**
     *
     */
    public void insertTeacher()
    {
        String institueID="";
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        if(this.photoFile!=null)
        {
            this.teacher.setImgPath(photoFile.getFileName());
            
            if(teacherDao.saveTeacher(this.teacher))
            {
                uploadService.uploadImg("teacherImages", institueID+"_"+this.teacher.getTeacherID()+"_"+photoFile.getFileName(),photoFile);
            
               context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully insert teacher info."));
            }
            else
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to insert teacher info."));
            }
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warnning", "Please select teacher image...!"));
        }
        
        this.teacher=null;
    }

    /**
     *
     */
    public String editTeacher()
    {
        String institueID="";
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        institueID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
       if(this.photoFile.getFileName().equals(""))
        {
            if(teacherDao.updateTeacher(teacher))               
            {        
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully updated teacher info."));
            }
            else
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update teacher info."));
            }
        }
       else 
        {
            this.teacher.setImgPath(this.teacher.getTeacherID()+"_"+photoFile.getFileName());
            
            if(teacherDao.updateTeacher(teacher))
            {        
                uploadService.uploadImg("teacherImages",this.teacher.getTeacherID()+"_"+photoFile.getFileName(),photoFile);
            
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Successfully updated teacher info."));
            }
            else
            {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update teacher info."));
            }
        }
       
       this.teacher=null;
       
       return "index.xhtml";
    }
    
   
    /**
     * @return the teacher
     */
    public Teacher getTeacher() 
    {
         if(this.teacher==null)
        {
            this.teacher=new Teacher();
        }
        return this.teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     *
     * @return
     */
    public List<Teacher> getTeacharList() 
    {
        return teacharList;
    }

    /**
     *
     * @param teacharList
     */
    public void setTeacharList(List<Teacher> teacharList) {
        this.teacharList = teacharList;
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
     * @return the teachar_Filter_List
     */
    public List<Teacher> getTeachar_Filter_List() {
        return teachar_Filter_List;
    }

    /**
     * @param teachar_Filter_List the teachar_Filter_List to set
     */
    public void setTeachar_Filter_List(List<Teacher> teachar_Filter_List) {
        this.teachar_Filter_List = teachar_Filter_List;
    }
 
}
