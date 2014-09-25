/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.MainHead;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mastermind
 */
@ManagedBean
@ViewScoped
public class MainHeadController implements Serializable
{

   private MainHead mainHead;
   
   private List<MainHead> mainHead_List;
   
   private List<String> categoryNameData;
   
   MainHeadService mainHeadDao = new MainHeadServiceImpl();
   
    public MainHeadController()
    {
       this.mainHead_List = mainHeadDao.mainHeadList();
    }
    
    public void TransCatagory_List() 
    {
        this.categoryNameData = mainHeadDao.category_List(this.mainHead.getTrType());
    }
    
    public void insertMainHead()
    {
      FacesContext context = FacesContext.getCurrentInstance();
      
      if(mainHeadDao.createMainHead(this.mainHead))
      {
          this.mainHead_List = mainHeadDao.mainHeadList();
          
          context.addMessage(null, new FacesMessage("Successful Insert main head info."));
      }
      else
      {
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert main head info!",""));
      }
        
    }
    
     public void updateMainHead()
    {
      FacesContext context = FacesContext.getCurrentInstance();
      
      if(mainHeadDao.updateMainHead(this.mainHead))
      {
          this.mainHead_List = mainHeadDao.mainHeadList();
          
          this.mainHead = null;
          
          context.addMessage(null, new FacesMessage("Successful update main head info."));
      }
      else
      {
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update main head info!",""));
      }
        
    }

    public MainHead getMainHead()
    {
        if(this.mainHead==null)
        {
          this.mainHead = new MainHead();
        }
        return mainHead;
    }

    public void setMainHead(MainHead mainHead) {
        this.mainHead = mainHead;
    }

    public List<MainHead> getMainHead_List() {
        return mainHead_List;
    }

    public void setMainHead_List(List<MainHead> mainHead_List) {
        this.mainHead_List = mainHead_List;
    }

    public List<String> getCategoryNameData() {
        return categoryNameData;
    }

    public void setCategoryNameData(List<String> categoryNameData) {
        this.categoryNameData = categoryNameData;
    }
    
    
}
