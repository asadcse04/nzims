/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Section;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
@ViewScoped
public class SectionController implements Serializable
{
    private Section section;
    
    private List<Section> sectionData;
    
    SectionService sectionDao = new SectionServiceImpl();

    /**
     * Creates a new instance of SectionController
     */
    public SectionController()
    {
        this.sectionData=sectionDao.sectionList();
    }
    
    public void insertSection()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(sectionDao.createSection(this.section))
        {
            this.sectionData=sectionDao.sectionList();
            
            this.section=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert Section Info."));  
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert section info!",""));
        }
        
    }
    
    
    public void editSection()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(sectionDao.updateSection(this.section))
        {
            this.sectionData=sectionDao.sectionList();
            
            this.section=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update section info."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update section info!",""));
        } 
    }

    /**
     * @return the section
     */
    public Section getSection()
    {
        if(this.section==null)
        {
            this.section=new Section();
        }
        return this.section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(Section section) {
        this.section = section;
    }

    /**
     * @return the sectionData
     */
    public List<Section> getSectionData() {
        return sectionData;
    }

    /**
     * @param sectionData the sectionData to set
     */
    public void setSectionData(List<Section> sectionData) {
        this.sectionData = sectionData;
    }
}
