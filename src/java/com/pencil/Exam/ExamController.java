/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Exam;

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
public class ExamController implements Serializable
{
    private Exam exam;
    
    private List<Exam> exam_list;
    
    ExamService serviceDao=new ExamServiceImpl();

    /**
     * Creates a new instance of ExamController
     */
    public ExamController()
    {
        FacesContext context = FacesContext.getCurrentInstance();
                  
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
       
        this.exam_list=serviceDao.examList(instituteID);
    }
    
    /**
     *
     */
    public void insertExam()
    {
       FacesContext context = FacesContext.getCurrentInstance();
                  
       String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
       
       this.exam.setInstituteID(instituteID);
        
        if(serviceDao.createExam(this.exam))
        {
            this.exam_list=serviceDao.examList(instituteID);
            
            this.exam=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert exam info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert exam info!",""));
        }
    }
    
    /**
     *
     */
    public void editExam()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        if(serviceDao.updateExam(this.exam))
        {
            this.exam_list=serviceDao.examList(instituteID);
            
            this.exam=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update exam info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update exam info!",""));
        } 
    }

    /**
     * @return the exam
     */
    public Exam getExam()
    {
        if(this.exam==null)
        {
            this.exam=new Exam();
        }
        return exam;
    }

    /**
     * @param exam the exam to set
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    /**
     * @return the exam_list
     */
    public List<Exam> getExam_list() {
        return exam_list;
    }

    /**
     * @param exam_list the exam_list to set
     */
    public void setExam_list(List<Exam> exam_list) {
        this.exam_list = exam_list;
    }
}
