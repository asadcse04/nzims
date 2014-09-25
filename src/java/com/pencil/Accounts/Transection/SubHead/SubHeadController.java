/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Accounts.Transection.SubHead;

import com.pencil.Accounts.Transection.MainHead.MainHeadService;
import com.pencil.Accounts.Transection.MainHead.MainHeadServiceImpl;
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
public class SubHeadController implements Serializable
{

    private SubHead subHead;
    
    private List<SubHead> sub_head_List;
    
    private List<String> categoryNameData;
    
    private List<String> main_headNameData;
    
    SubHeadService subHeadDao = new SubHeadServiceImpl();
    
    MainHeadService mainHeadDao = new MainHeadServiceImpl();
  
    public SubHeadController()
    {
      this.sub_head_List =  subHeadDao.subHeadList();
    }
    
    public void TransCatagory_List() 
    {
        this.categoryNameData = mainHeadDao.category_List(this.subHead.getTrType());
    }
     
     public void TransMainHead_List() 
    {
        this.main_headNameData = subHeadDao.mainHead_List(this.subHead.getTrCategoryName());
    }
     
    public void insertSubHead()
    {     
      FacesContext context = FacesContext.getCurrentInstance();
        
      if(subHeadDao.createSubHead(this.subHead))
      {
         this.sub_head_List = subHeadDao.subHeadList();
         
         context.addMessage(null, new FacesMessage("Successful Insert sub head info."));
      }
      else
      {
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to insert sub head info!",""));
      }
    }
    public void updateSubHead()
    {     
      FacesContext context = FacesContext.getCurrentInstance();
        
      if(subHeadDao.updateSubHead(this.subHead))
      {
         this.sub_head_List = subHeadDao.subHeadList();
         
         this.subHead=null;
         
         context.addMessage(null, new FacesMessage("Successful update sub head info."));
      }
      else
      {
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Failed to update sub head info!",""));
      }
    }
    
    public SubHead getSubHead()
    {
        if(this.subHead==null)
        {
            this.subHead= new SubHead();
        }
        return subHead;
    }

    public void setSubHead(SubHead subHead) {
        this.subHead = subHead;
    }

    public List<SubHead> getSub_head_List() {
        return sub_head_List;
    }

    public void setSub_head_List(List<SubHead> sub_head_List) {
        this.sub_head_List = sub_head_List;
    }

    public List<String> getMain_headNameData() {
        return main_headNameData;
    }

    public void setMain_headNameData(List<String> main_headNameData) {
        this.main_headNameData = main_headNameData;
    }

    public List<String> getCategoryNameData() {
        return categoryNameData;
    }

    public void setCategoryNameData(List<String> categoryNameData) {
        this.categoryNameData = categoryNameData;
    }
    
}
