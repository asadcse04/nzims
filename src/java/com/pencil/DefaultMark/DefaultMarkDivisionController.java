/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.DefaultMark;

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
public class DefaultMarkDivisionController implements Serializable
{
    
    private DefaultMarkDivision d_mark_division;
    
    private List<DefaultMarkDivision> dmd_list;
    
    MarkDivisionService serviceDao=new MarkDivisionService_Impl();

    /**
     * Creates a new instance of DefaultMarkDivisionController
     */
    public DefaultMarkDivisionController()
    {
        this.dmd_list=serviceDao.d_MarkDivisionList();
    }
    
    /**
     *
     */
    public void insert_d_mark_Division()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.create_d_MarkDivision(d_mark_division))
        {
            this.dmd_list=serviceDao.d_MarkDivisionList();
            
            this.d_mark_division=null;
            
            context.addMessage(null, new FacesMessage("Successful","Insert default mark division."));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert default mark division!",""));
        }
    }
    
    /**
     *
     */
    public void edit_d_mark_Division()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.update_d_MarkDivision(d_mark_division))
        {
            this.dmd_list=serviceDao.d_MarkDivisionList();
            
            this.d_mark_division=null;
            
            context.addMessage(null, new FacesMessage("Successful","Update default mark division"));
        }
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update default mark division!",""));
        } 
    }

    /**
     * @return the d_mark_division
     */
    public DefaultMarkDivision getD_mark_division()
    {
        if(d_mark_division==null)
        {
            this.d_mark_division=new DefaultMarkDivision();
        }
        return d_mark_division;
    }

    /**
     * @param d_mark_division the d_mark_division to set
     */
    public void setD_mark_division(DefaultMarkDivision d_mark_division) {
        this.d_mark_division = d_mark_division;
    }

    /**
     * @return the dmd_list
     */
    public List<DefaultMarkDivision> getDmd_list() {
        return dmd_list;
    }

    /**
     * @param dmd_list the dmd_list to set
     */
    public void setDmd_list(List<DefaultMarkDivision> dmd_list) {
        this.dmd_list = dmd_list;
    }
}
