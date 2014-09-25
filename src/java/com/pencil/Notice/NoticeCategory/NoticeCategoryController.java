

package com.pencil.Notice.NoticeCategory;

import java.io.Serializable;
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
public class NoticeCategoryController implements Serializable
{
    
    private NoticeCategory noticeCategory;
    
    private List<NoticeCategory> noticeCategoryList;
    
    
    private String [] displaycolor={"red","orange","green","blue","skyblue","pink","yellow"};

    /**
     * @return the noticeCategory
     */
    
    public NoticeCategoryService serviceDao=new NoticeCategoryServiceImpl();
    
    
    public void addNoticeCategory(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(serviceDao.addNoticeCategory(this.noticeCategory))
        {
            context.addMessage(null, new FacesMessage("Successful", "Notic Category Added"));
            
            this.noticeCategory=null;
        }
        
        else
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Notice Category is not added"));
        }
    }
    
    
    
    
    
    
    public NoticeCategory getNoticeCategory() {
        
        if(this.noticeCategory==null){
            
            this.noticeCategory=new NoticeCategory();
        }
        return noticeCategory;
    }

    /**
     * @param noticeCategory the noticeCategory to set
     */
    public void setNoticeCategory(NoticeCategory noticeCategory) {
        this.noticeCategory = noticeCategory;
    }

    /**
     * @return the noticeCategoryList
     */
    public List<NoticeCategory> getNoticeCategoryList() {
        
        this.noticeCategoryList=serviceDao.NoticeCategoryList();
        
        return this.noticeCategoryList;
    }

    /**
     * @param noticeCategoryList the noticeCategoryList to set
     */
    public void setNoticeCategoryList(List<NoticeCategory> noticeCategoryList) {
        
        this.noticeCategoryList = noticeCategoryList;
    }

    /**
     * @return the displaycolor
     */
    public String[] getDisplaycolor() {
        return displaycolor;
    }

    /**
     * @param displaycolor the displaycolor to set
     */
    public void setDisplaycolor(String[] displaycolor) {
        this.displaycolor = displaycolor;
    }
    
}
