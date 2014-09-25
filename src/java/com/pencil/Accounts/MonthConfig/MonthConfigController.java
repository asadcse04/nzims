/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.MonthConfig;

import com.pencil.Presentation.Presentation;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

/**
 *
 * @author Mamun
 */
public class MonthConfigController {
    
    private List<String> academicYearList;
    
    private MonthConfig monthConfig;
    
    private List <MonthConfig> monthConfigList;
    
    private String [] monthList={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};;

    MonthConfigService serviceDao = new MonthConfigServiceImpl();
    
    Presentation pr = new Presentation();

    public MonthConfigController() 
    {
       this.academicYearList = pr.infoList("acyr"); 
    }
    
    
    public void saveMonth()
    {
    
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addMonth(this.monthConfig))
        {
            context.addMessage(null, new FacesMessage("Successful", "Month Configuration Added"));
            
            this.monthConfig=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Month Configuration is not added"));
        }
        
    }
    
    public void updateMonth()
    
    {
       
         FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.updateMonth(this.monthConfig))
        {
            context.addMessage(null, new FacesMessage("Successful", "Month Configuration updated"));
            
            this.monthConfig=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Month Configuration is not updated"));
        }
        
    }

    public List<MonthConfig> getMonthConfigList() {
        
        this.monthConfigList=serviceDao.getMonthConfigList();
        
        return this.monthConfigList;
    }

    public void setMonthConfigList(List<MonthConfig> monthConfigList) {
        this.monthConfigList = monthConfigList;
    }
    
    

    public List<String> getAcademicYearList() {
        return academicYearList;
    }

    public void setAcademicYearList(List<String> academicYearList) {
        this.academicYearList = academicYearList;
    }

    public String[] getMonthList() {
        
        return monthList;
    }

    public void setMonthList(String[] monthList) {
        this.monthList = monthList;
    }

    public MonthConfig getMonthConfig() {
        if(this.monthConfig==null){
            
            this.monthConfig = new MonthConfig();
        }
        return monthConfig;
    }

    public void setMonthConfig(MonthConfig monthConfig) {
        this.monthConfig = monthConfig;
    }

    

       
    
}
