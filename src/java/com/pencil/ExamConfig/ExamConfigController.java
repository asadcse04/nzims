/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.ExamConfig;

import com.pencil.DefaultMark.DefaultMarkDivision;
import com.pencil.DefaultMark.MarkDivisionService;
import com.pencil.DefaultMark.MarkDivisionService_Impl;
import com.pencil.Dummy.Student.ExamResult.ResultServiceImpl;
import com.pencil.Dummy.Student.ExamResult.StudentExamResultService;
import com.pencil.Presentation.Presentation;
import com.pencil.ScClassConfig.Sc_ClassCofigService_Impl;
import com.pencil.ScClassConfig.Sc_ClassConfigService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author apple
 */
@ManagedBean
@ViewScoped
public class ExamConfigController implements Serializable
{
    private ExamConfig exam_config;
    
    private ExamSubject_Config exmSbjCnf;
    
    private List<ExamConfig> examConfig_List;
     
    private List<String> acYrList;
    
    private List<String> scList;
   
    private List<String> exmList;
    
    private List<String> sbjList;
    
    
    private List<DefaultMarkDivision> defaultMarkList;
    
    MarkDivisionService exmServiceDao=new MarkDivisionService_Impl();
    
    
    Sc_ClassConfigService sc_service_dao=new Sc_ClassCofigService_Impl();
    
    Presentation pr=new Presentation();
    
    
    ExamConfigService serviceDao=new ExamConfigService_Impl();

    /**
     * Creates a new instance of ExamSubjectConfigController
     */
    public ExamConfigController()
    {
        this.acYrList=pr.infoList("acyr");
        
        this.exmList=pr.infoList("exmNm");
        
        this.examConfig_List=serviceDao.examConfigList();
    }
    
    /**
     *
     */
    public void scClassList()
    {
        this.setScList(sc_service_dao.listScClass(this.exam_config.getAcyrID()));
    }
   

    /**
     *
     * @param excnf
     */
    public void subjectList(ExamConfig excnf)
    {
        this.setSbjList(serviceDao.examSubjectConfig(excnf.getAcyrID(),excnf.getClassName()));
        
        this.setDefaultMarkList(exmServiceDao.d_MarkDivisionList());
        
        this.setExam_config(excnf);
    }
    
    /**
     *
     * @param dmd
     */
    public void rmMarkList(DefaultMarkDivision dmd)
    {
        this.getDefaultMarkList().remove(dmd);
    }

    /**
     *
     * @param event
     */
    public void onEdit(RowEditEvent event)
    { 
        FacesMessage msg = new FacesMessage("Success","Mark Distribution Edited");  
  
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
    
    /**
     *
     * @return
     */
    public String saveExamConfig()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        exam_config.setInstituteID(instituteID);

        if (serviceDao.insertExamConfig(exam_config))
        {
            context.addMessage(null, new FacesMessage("Successful", "Configuration complete..."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Configuration failed...!", ""));
        }
        this.exam_config = null;

        return "index.xhtml";
    }

    /**
     *
     */
    public void save_Exam_Mark_Distribution()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        String instituteID=context.getExternalContext().getSessionMap().get("SchoolID").toString();
        
        StudentExamResultService resultService=new ResultServiceImpl();
        
        context.addMessage(null, new FacesMessage("Successful Configer Subject Mark Distribution", "..."));
        
        System.out.println(serviceDao.exam_Subject_Mark_distribution(this.exmSbjCnf.getSubject_list(),this.defaultMarkList,resultService.getExCnfID(this.exam_config.getAcyrID(), this.exam_config.getClassName(),this.exam_config.getExamName())));
    }

    /**
     * @return the exam_config
     */
    public ExamConfig getExam_config()
    {
        if(this.exam_config==null)
        {
            this.exam_config=new ExamConfig();
        }
        return this.exam_config;
    }

    /**
     * @param exam_config the exam_config to set
     */
    public void setExam_config(ExamConfig exam_config) {
        this.exam_config = exam_config;
    }

    /**
     * @return the acYrList
     */
    public List<String> getAcYrList() {
        return acYrList;
    }

    /**
     * @param acYrList the acYrList to set
     */
    public void setAcYrList(List<String> acYrList) {
        this.acYrList = acYrList;
    }

    /**
     * @return the scList
     */
    public List<String> getScList() {
        return scList;
    }

    /**
     * @param scList the scList to set
     */
    public void setScList(List<String> scList) {
        this.scList = scList;
    }

    /**
     * @return the exmList
     */
    public List<String> getExmList() {
        return exmList;
    }

    /**
     * @param exmList the exmList to set
     */
    public void setExmList(List<String> exmList) {
        this.exmList = exmList;
    }

    /**
     * @return the defaultMarkList
     */
    public List<DefaultMarkDivision> getDefaultMarkList() {
        return defaultMarkList;
    }

    /**
     * @param defaultMarkList the defaultMarkList to set
     */
    public void setDefaultMarkList(List<DefaultMarkDivision> defaultMarkList) {
        this.defaultMarkList = defaultMarkList;
    }

    /**
     * @return the examConfig_List
     */
    public List<ExamConfig> getExamConfig_List() {
        return examConfig_List;
    }

    /**
     * @param examConfig_List the examConfig_List to set
     */
    public void setExamConfig_List(List<ExamConfig> examConfig_List) {
        this.examConfig_List = examConfig_List;
    }

    /**
     * @return the sbjList
     */
    public List<String> getSbjList() {
        return sbjList;
    }

    /**
     * @param sbjList the sbjList to set
     */
    public void setSbjList(List<String> sbjList) {
        this.sbjList = sbjList;
    }

    /**
     * @return the exmSbjCnf
     */
    public ExamSubject_Config getExmSbjCnf()
    {
        if(this.exmSbjCnf==null)
        {
            this.exmSbjCnf=new ExamSubject_Config();
        }
        return this.exmSbjCnf;
    }

    /**
     * @param exmSbjCnf the exmSbjCnf to set
     */
    public void setExmSbjCnf(ExamSubject_Config exmSbjCnf)
    {     
        this.exmSbjCnf = exmSbjCnf;
    }
   
}
