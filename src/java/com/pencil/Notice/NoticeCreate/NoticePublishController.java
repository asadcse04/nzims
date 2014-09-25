/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pencil.Notice.NoticeCreate;

import com.pencil.Notice.NoticeCategory.NoticeCategory;
import com.pencil.Notice.NoticeCategory.NoticeCategoryService;
import com.pencil.Notice.NoticeCategory.NoticeCategoryServiceImpl;
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
public class NoticePublishController {
    
    private NoticePublish noticePublish;
    
    private List<NoticeCategory> noticeCategoryList;
    
    private List<String> noticeIdCatList;
    
    private List<NoticePublish> noticePublishList;
    
    private String noticeCatIdName;
    
    private String [] noticeforlist={"All","Teacher","Student","Accountant"};
    
    
    public NoticeCategoryService notCatserviceDao=new NoticeCategoryServiceImpl();
    
    public NoticePublishService servicedao=new NoticePublishServiceImpl();
    
    
    public NoticePublishController(){
        
        this.noticeCategoryList=notCatserviceDao.NoticeCategoryList();
    
    }

    /**
     * @return the noticePublish
     */
    
    public void addNoticePublish(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        this.noticePublish.setAcdNoticeCategoryId(Integer.parseInt(this.noticeCatIdName.split("-")[0]));
        
        if(servicedao.addNoticePublish(this.noticePublish))
        {
            context.addMessage(null, new FacesMessage("Successful", "Notic Publish Added"));
            
            this.noticePublish=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Notice Publish is not added"));
        }
        
    }

    
    public void updateNoticePublish(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(servicedao.updateNoticePublish(this.noticePublish))
        {
            context.addMessage(null, new FacesMessage("Successful", "Notic  Updated"));
            
            this.noticePublish=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Notice is not updated"));
        }
        
    }

    
    
    public NoticePublish getNoticePublish() {
        
        if(this.noticePublish==null){
            
            this.noticePublish=new NoticePublish();
        }
        return this.noticePublish;
    }

    /**
     * @param noticePublish the noticePublish to set
     */
    public void setNoticePublish(NoticePublish noticePublish) {
        this.noticePublish = noticePublish;
    }

    /**
     * @return the noticeCategoryList
     */
    public List<NoticeCategory> getNoticeCategoryList() {
        return noticeCategoryList;
    }

    /**
     * @param noticeCategoryList the noticeCategoryList to set
     */
    public void setNoticeCategoryList(List<NoticeCategory> noticeCategoryList) {
        this.noticeCategoryList = noticeCategoryList;
    }

    /**
     * @return the noticeIdCatList
     */
    public List<String> getNoticeIdCatList() {
        
        this.noticeIdCatList=new ArrayList<String>();
        
        for(NoticeCategory a:this.noticeCategoryList){
          
            this.noticeIdCatList.add(a.getCategoryid()+"-"+a.getCategoryname());
        }
       return this.noticeIdCatList;
    
    }

    /**
     * @param noticeIdCatList the noticeIdCatList to set
     */
    public void setNoticeIdCatList(List<String> noticeIdCatList) {
        this.noticeIdCatList = noticeIdCatList;
    }

    /**
     * @return the noticePublishList
     */
    public List<NoticePublish> getNoticePublishList() {
        
        this.noticePublishList=servicedao.noticePublishList();
        
        return noticePublishList;
    }

    /**
     * @param noticePublishList the noticePublishList to set
     */
    public void setNoticePublishList(List<NoticePublish> noticePublishList) {
        this.noticePublishList = noticePublishList;
    }

    /**
     * @return the noticeCatIdName
     */
    public String getNoticeCatIdName() {
        return noticeCatIdName;
    }

    /**
     * @param noticeCatIdName the noticeCatIdName to set
     */
    public void setNoticeCatIdName(String noticeCatIdName) {
        this.noticeCatIdName = noticeCatIdName;
    }

    /**
     * @return the noticeforlist
     */
    public String[] getNoticeforlist() {
        return noticeforlist;
    }

    /**
     * @param noticeforlist the noticeforlist to set
     */
    public void setNoticeforlist(String[] noticeforlist) {
        this.noticeforlist = noticeforlist;
    }
    
}
